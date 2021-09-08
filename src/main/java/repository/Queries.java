package repository;

public class Queries {

    public static final String SELECT_ITEMS = "SELECT product_type, price, count, gender, produce_type, size, colour, type_name from items;";
    public static final String SELECT_ORDERS = "SELECT product_type, price, count, gender, produce_type, size, colour, type_name, customer_name, customer_email, customer_phone, delivery_method from orders;";

}
