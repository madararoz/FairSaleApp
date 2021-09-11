package model;

import java.util.Date;

public class Order extends Item {

    String customerName;
    String customerEmail;
    String customerPhone;
    String deliveryMethod;


    public Order(String productType, double price, int count, String gender, String produceType, String size, String colour, String typeName, String customerName, String customerEmail, String customerPhone, String deliveryMethod) {
        super(productType, price, count, gender, produceType, size, colour, typeName);
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.deliveryMethod = deliveryMethod;
    }


    public Order(int id, String productType, double price, int count, String gender, String produceType, String size, String colour, String typeName, String customerName, String customerEmail, String customerPhone, String deliveryMethod) {
        super(id, productType, price, count, gender, produceType, size, colour, typeName);
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.deliveryMethod = deliveryMethod;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}
