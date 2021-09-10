package repository;

public class Queries {

    public static final String INSERT_ITEMS = "INSERT INTO items (id, product_type, price, count, gender, produce_type, size, colour, type_name) VALUES (?,?,?,?,?,?,?,?,?)";
    public static final String INSERT_ORDERS = "INSERT INTO orders(product_type, price, count, gender, produce_type, size, colour, type_name, customer_name, " +
            "customer_email, customer_phone, delivery_method) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String SELECT_ITEMS = "SELECT product_type, price, count, gender, produce_type, size, colour, type_name from items;";
    public static final String SELECT_ORDERS = "SELECT product_type, price, count, gender, produce_type, size, colour, type_name, customer_name, customer_email, customer_phone, delivery_method from orders;";

    public static final String SEARCH_BY_PRODUCT_TYPE = "SELECT product_type, price, count, gender, produce_type, size, colour, type_name from items WHERE product_type = ?;";
}
