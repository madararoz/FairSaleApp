package controller;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import model.AppData;
import model.Order;
import repository.DBHandler;
import repository.Queries;
import service.ReportDBService;

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

public class PrintDayOrderedReportController {
    private Connection connection = DBHandler.getConnection();
    ReportDBService reportDBService = new ReportDBService();


    public void printDocument() throws IOException, DocumentException, SQLException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Report.pdf"));
        document.setPageSize(PageSize.A4.rotate());
        document.open();


        Paragraph paragraph = new Paragraph();
        Font f = new Font(Font.FontFamily.TIMES_ROMAN, 25.0f, Font.BOLD, BaseColor.BLACK);
        paragraph.setFont(f);
        paragraph.add("Report of ordered items of selected day");


        document.add(paragraph);

        Paragraph paragraph1 = new Paragraph(new Date().toString());
        paragraph1.setAlignment(Element.ALIGN_RIGHT);
        document.add(paragraph1);


        PdfPTable table = new PdfPTable(12);
        Stream.of("Product Type", "Price", "Count", "Gender", "Produce Type", "Size", "Colour", "Type name", "Customer Name",
                "Customer Email", "Customer Phone", "Delivery Method").forEach(table::addCell);
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f);

        float[] columnWidths = {1.2f, 1f, 1f, 1f, 2f, 0.7f, 1f, 1f, 1f, 1f, 1f, 1f};
        table.setWidths(columnWidths);

        PdfPCell table_cell;
        PreparedStatement statement = connection.prepareStatement(Queries.SEARCH_ORDERS_BY_DATE);
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

            String customer_name = result.getString("customer_name");
            table_cell = new PdfPCell(new Phrase(customer_name));
            table.addCell(table_cell);

            String customer_email = result.getString("customer_email");
            table_cell = new PdfPCell(new Phrase(customer_email));
            table.addCell(table_cell);

            String customer_phone = result.getString("customer_phone");
            table_cell = new PdfPCell(new Phrase(customer_phone));
            table.addCell(table_cell);

            String delivery_method = result.getString("delivery_method");
            table_cell = new PdfPCell(new Phrase(delivery_method));
            table.addCell(table_cell);
        }
        document.add(table);

        Paragraph paragraph2 = new Paragraph();
        Font totalFont = new Font(Font.FontFamily.TIMES_ROMAN, 16.0f, Font.BOLDITALIC, BaseColor.BLACK);
        paragraph2.setFont(totalFont);
        paragraph2.add("Total revenues of selected day  - ");
        paragraph2.add(String.valueOf(showTotalReport()));
        paragraph2.add(" Eur");
        document.add(paragraph2);

        openReport();

        document.close();
        writer.close();
    }

    public double showTotalReport() throws SQLException {
        double total = 0;
        for (Order orderDay : reportDBService.getOrderedItemsByDate(AppData.getInstance().getSoldDate()))  {
            total = total + (orderDay.getCount() * (orderDay.getPrice()));
        }
        return total;
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


}
