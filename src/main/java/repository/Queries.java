package repository;

public class Queries {

    public static final String INSERT_ITEMS = "INSERT INTO items(product_type, price, count, gender, produce_type, size, colour, type_name) VALUES (?,?,?,?,?,?,?,?)";
    public static final String INSERT_ORDERS = "INSERT INTO orders(product_type, price, count, gender, produce_type, size, colour, type_name, customer_name, " +
            "customer_email, customer_phone, delivery_method) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

    public static final String SELECT_ITEMS = "SELECT id, product_type, price, count, gender, produce_type, size, colour, type_name from items;";
    public static final String SELECT_ORDERS = "SELECT id, product_type, price, count, gender, produce_type, size, colour, type_name, customer_name, customer_email, customer_phone, delivery_method from orders;";

    public static final String SEARCH_BY_PRODUCT_TYPE = "SELECT id, product_type, price, count, gender, produce_type, size, colour, type_name from items WHERE product_type = ?;";
    public static final String SEARCH_ORDERS_BY_PRODUCT_TYPE = "SELECT id, product_type, price, count, gender, produce_type, size, colour, type_name, customer_name, customer_email, customer_phone, delivery_method from orders WHERE product_type = ?;";

    public static final String DELETE_ITEM = "DELETE from items WHERE id = ?;";
    public static final String DELETE_ORDER = "DELETE from orders WHERE id = ?;";


    public static final String UPDATE_PRODUCT_TYPE = "UPDATE items SET product_type = ? WHERE id = ?;";
    public static final String UPDATE_PRICE = "UPDATE items SET price = ? WHERE id = ?;";
    public static final String UPDATE_COUNT = "UPDATE items SET count = ? WHERE id = ?;";
    public static final String UPDATE_GENDER = "UPDATE items SET gender = ? WHERE id = ?;";
    public static final String UPDATE_PRODUCE_TYPE = "UPDATE items SET produce_type = ? WHERE id = ?;";
    public static final String UPDATE_SIZE = "UPDATE items SET size = ? WHERE id = ?;";
    public static final String UPDATE_TYPE_NAME = "UPDATE items SET size = ? WHERE id = ?;";

    public static final String UPDATE_ORDER_PRODUCT_TYPE = "UPDATE orders SET product_type = ? WHERE id = ?;";
    public static final String UPDATE_ORDER_PRICE = "UPDATE orders SET price = ? WHERE id = ?;";
    public static final String UPDATE_ORDER_COUNT = "UPDATE orders SET count = ? WHERE id = ?;";
    public static final String UPDATE_ORDER_GENDER = "UPDATE orders SET gender = ? WHERE id = ?;";
    public static final String UPDATE_ORDER_PRODUCE_TYPE = "UPDATE orders SET produce_type = ? WHERE id = ?;";
    public static final String UPDATE_ORDER_SIZE = "UPDATE orders SET size = ? WHERE id = ?;";
    public static final String UPDATE_ORDER_TYPE_NAME = "UPDATE orders SET size = ? WHERE id = ?;";
    public static final String UPDATE_ORDER_CUSTOMER_NAME = "UPDATE orders SET customer_name = ? WHERE id = ?;";
    public static final String UPDATE_ORDER_CUSTOMER_EMAIL = "UPDATE orders SET customer_email = ? WHERE id = ?;";
    public static final String UPDATE_ORDER_CUSTOMER_PHONE = "UPDATE orders SET customer_phone WHERE id = ?;";
    public static final String UPDATE_ORDER_DELIVERY_METHOD = "UPDATE orders SET delivery_method = ? WHERE id = ?;";
}
