package model;

public class Item {

    int id;
    ProductType productType;
    double price;
    Gender gender;
    ProduceType produceType;
    Size size;
    String colour;
    String typeName;
    int count;

    //ko darīt ar ProductId? un ProduceId?

    public Item(int id, ProductType productType, double price, Gender gender, ProduceType produceType, Size size, String colour, String typeName, int count) {
        this.id = id;
        this.productType = productType;
        this.price = price;
        this.gender = gender;
        this.produceType = produceType;
        this.size = size;
        this.colour = colour;
        this.typeName = typeName;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ProduceType getProduceType() {
        return produceType;
    }

    public void setProduceType(ProduceType produceType) {
        this.produceType = produceType;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

/*
    public Item( int id, double price, String gender, int size, String colour, String typeName, String markAsSold, int produceId, int productId ) {
       this.id = id;
       this.price = price;
       this.gender = gender;
       this.size = size;
       this.colour = colour;
       this.typeName = typeName;
       this.markAsSold = markAsSold;
       this.produceId = produceId;
       this.productId = productId;
    }

 */

}

