package controller;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.javafx.font.FontConstants;
import model.Item;
import repository.DBHandler;
import repository.Queries;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.stream.Stream;

public class PrintReportController  {

    private Connection connection = DBHandler.getConnection();
    TableViewController tableViewController = new TableViewController();


    public void printDocument() throws IOException, DocumentException, SQLException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Report.pdf"));
        document.open();


        Paragraph paragraph = new Paragraph("Report of sold items");
        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 25.0f, Font.BOLD, BaseColor.BLACK);
        paragraph.setFont(f);



        document.add(paragraph);

        Paragraph paragraph1 = new Paragraph(new Date().toString());
        paragraph1.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph1);
        paragraph1.setSpacingAfter(20f);
        paragraph1.setSpacingBefore(20f);

        Font dateFont = new Font(Font.FontFamily.TIMES_ROMAN, 25.0f, Font.BOLD, BaseColor.BLACK);
        paragraph.setFont(dateFont);


        PdfPTable table = new PdfPTable(8);
        Stream.of("Product Type", "Price", "Count", "Gender", "Produce Type", "Size", "Colour", "Type name").forEach(table::addCell);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        float[] columnWidths = {1.2f, 1f, 1f, 1f, 2f, 0.7f, 1f, 1f};
        table.setWidths(columnWidths);

        PdfPCell table_cell;
        PreparedStatement statement = connection.prepareStatement(Queries.SELECT_ITEMS);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            String product_type = result.getString("product_type");
            table_cell = new PdfPCell(new Phrase(product_type));
            table.addCell(table_cell);
            Double price = result.getDouble("price");
            table_cell = new PdfPCell(new Phrase(String.valueOf(price)));
            table.addCell(table_cell);

            int count = result.getInt("count");
            table_cell = new PdfPCell(new Phrase(String.valueOf(count)));
            table.addCell(table_cell);

            String gender = result.getString("gender");
            table_cell = new PdfPCell(new Phrase(gender));
            table.addCell(table_cell);

            String produce_type = result.getString("produce_type");
            table_cell = new PdfPCell(new Phrase(produce_type));
            table.addCell(table_cell);

            String size = result.getString("size");
            table_cell = new PdfPCell(new Phrase(size));
            table.addCell(table_cell);

            String colour = result.getString("colour");
            table_cell = new PdfPCell(new Phrase(colour));
            table.addCell(table_cell);

            String type_name = result.getString("type_name");
            table_cell = new PdfPCell(new Phrase(type_name));
            table.addCell(table_cell);

        }
        document.add(table);

        Paragraph paragraph2 = new Paragraph("Total revenue of today - " + showTotal());
        document.add(paragraph2);


            openReport();

        document.close();
        writer.close();
    }

    public void openReport() throws IOException {
        File file = new File("Report.pdf");
        if (file.toString().endsWith(".pdf"))
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
        else {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(file);
        }
    }

    public String showTotal(){
        TableViewController tableViewController = new TableViewController();
        int total = 0 ;
        for (Item item : tableViewController.tableView.getItems()) {
            total = (int) (total + (item.getCount()* item.getPrice()));

        }
        tableViewController.sumTotalLabel.setText(String.valueOf(total));

        return String.valueOf(total);
    }




}
