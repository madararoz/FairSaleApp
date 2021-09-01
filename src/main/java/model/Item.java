package model;

public class Item {

    int id;
    String markAsSold;
    int produceId;
    int productId;
    ProductType productType;
    double price;
    Gender gender;
    ProduceType produceType;
    String size;
    String colour;
    String typeName;
    int count;




    public Item(ProductType productType, double price, int count, Gender gender, ProduceType produceType, String size, String colour, String typeName) {
        this.productType = productType;
        this.price = price;
        this.count = count;
        this.gender = gender;
        this.produceType = produceType;
        this.size = size;
        this.colour = colour;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarkAsSold() {
        return markAsSold;
    }

    public void setMarkAsSold(String markAsSold) {
        this.markAsSold = markAsSold;
    }

    public int getProduceId() {
        return produceId;
    }

    public void setProduceId(int produceId) {
        this.produceId = produceId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

//    public ProductType getProductType() {
//        return productType;
//    }
    public ProductType getProductType() {
        return productType;
    }

//    public void setProductType(ProductType productType) {
//        this.productType = productType;
//    }
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public Gender getGender() {
//        return gender;
//    }
    public Gender getGender() {
        return gender;
    }

//    public void setGender(Gender gender) {
//        this.gender = gender;
//    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ProduceType getProduceType() {
        return produceType;
    }


    public void setProduceType(ProduceType produceType) {
        this.produceType = produceType;
    }
//    public void setProduceType(String produceType) {
//        this.produceType = produceType;
//    }


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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
