package model;


import javafx.scene.control.DatePicker;

public class Item {

    int id;
    String productType;
    double price;
    int count;
    String gender;
    String produceType;
    String size;
    String colour;
    String typeName;
    DatePicker date;
    //for second scene
    //date = new datePicket();
    //date.setPromptText("Date of Sales");
    //date.setMaxWidth(300)



    public Item(String productType, double price, int count, String gender, String produceType, String size, String colour, String typeName) {
        this.productType = productType;
        this.price = price;
        this.count = count;
        this.gender = gender;
        this.produceType = produceType;
        this.size = size;
        this.colour = colour;
        this.typeName = typeName;
    }



    public Item(int id, String productType, double price, int count, String gender, String produceType, String size, String colour, String typeName) {
        this.id = id;
        this.productType = productType;
        this.price = price;
        this.count = count;
        this.gender = gender;
        this.produceType = produceType;
        this.size = size;
        this.colour = colour;
        this.typeName = typeName;
    }

    public Item(String productType) {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProduceType() {
        return produceType;
    }

    public void setProduceType(String produceType) {
        this.produceType = produceType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}


