package de.rkrish.rkpizzakiosk.logic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLNonTransientConnectionException;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";

    private static final String LOCAL_DATABASE_SERVER_NAME = "localhost/";
    private static final String LOCAL_DATABASE_SERVER_IP   = "127.0.0.1/";
    private static final String DATABASE_NAME              = "pizzaKiosk";

    private static final String CONNECTION_URL =
            "jdbc:mariadb://" + LOCAL_DATABASE_SERVER_NAME + DATABASE_NAME;

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private static DbManager instance;

    private final DaoOrderRecords daoOrderRecords;

    private DbManager() {
        this.daoOrderRecords = new DaoOrderRecords();
    }

    public static synchronized DbManager getInstance() {
        if (instance == null)
            instance = new DbManager();
        return instance;
    }

    private Connection getRwConnection() throws Exception {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASSWORD);
        }
        catch (SQLNonTransientConnectionException ex) {
            throw new Exception("Database offline");
        }
        catch (ClassNotFoundException ex) {
            throw new Exception("MariaDB JDBC driver missing");
        }
    }

    public boolean isOnline() {
        try {
            getRwConnection().close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // -------- CRUD for Order Records --------
    public void insertOrder(OrderRecord orderRecord) {
        try {
            if (isOnline()) {
                this.daoOrderRecords.insertRecord(getRwConnection(), orderRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<OrderRecord> getAllOrders() {
        List<OrderRecord> orders = new ArrayList<>();
        try {
            if (isOnline()) {
                orders = this.daoOrderRecords.getAllRecords(getRwConnection());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }



    public OrderRecord getOrderById(int id) {
        OrderRecord order = null;
        try {
            if (isOnline()) {
                order = this.daoOrderRecords.getRecordById(getRwConnection(), id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }


    public void updateOrder(OrderRecord orderRecord) {
        try {
            if (isOnline()) {
                daoOrderRecords.updateRecord(getRwConnection(), orderRecord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(int id) {
        try {
            if (isOnline()) {
                daoOrderRecords.deleteRecord(getRwConnection(), id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




