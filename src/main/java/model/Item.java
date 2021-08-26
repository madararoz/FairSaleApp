package model;

public class Item {

    ProductType productType;
    double price;
    Gender gender;
    ProduceType produceType;
    Size size;
    String colour;
    String typeName;
    int count;

    public Item(ProductType productType, double price, Gender gender, ProduceType produceType, Size size, String colour, String typeName, int count) {
        this.productType = productType;
        this.price = price;
        this.gender = gender;
        this.produceType = produceType;
        this.size = size;
        this.colour = colour;
        this.typeName = typeName;
        this.count = count;
    }

    public Item() {
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
}
