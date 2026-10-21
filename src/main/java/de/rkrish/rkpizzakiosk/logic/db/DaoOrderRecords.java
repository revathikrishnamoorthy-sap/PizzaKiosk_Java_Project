package de.rkrish.rkpizzakiosk.logic.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.plaf.synth.Region.TABLE;

class DaoOrderRecords {


    private static final String TABLE = "orders";
    private static final String COL_ID = "id";
    private static final String COL_NAME = "customerName";
    private static final String COL_NUMBER = "customerNumber";
    private static final String COL_TOTAL = "totalPrice";


    // INSERT one order
    public void insertRecord(Connection conn, OrderRecord order) {
        try {
            Statement stmt = conn.createStatement();
            String sql = String.format(
                    "INSERT INTO %s (%s, %s, %s) VALUES ('%s', '%s', %d)",
                    TABLE,
                    COL_NAME,
                    COL_NUMBER,
                    COL_TOTAL,
                    order.getCustomerName(),
                    order.getCustomerNumber(),
                    order.getTotalPrice()
            );
            System.out.println("SQL Insert: " + sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception ignored) {
            }
        }
    }

    // SELECT all
    public List<OrderRecord> getAllRecords(Connection conn) {
        List<OrderRecord> list = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM " + TABLE;
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                list.add(new OrderRecord(
                        rs.getInt(COL_ID),
                        rs.getString(COL_NAME),
                        rs.getString(COL_NUMBER),
                        rs.getInt(COL_TOTAL)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception ignored) {
            }
        }
        return list;
    }


    // SELECT by ID
    public OrderRecord getRecordById(Connection conn, int id) {
        OrderRecord order = null;
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM " + TABLE + " WHERE " + COL_ID + " = " + id;
            ResultSet rs = stmt.executeQuery(sql);


            if (rs.next()) {
                order = new OrderRecord(
                        rs.getInt(COL_ID),
                        rs.getString(COL_NAME),
                        rs.getString(COL_NUMBER),
                        rs.getInt(COL_TOTAL)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception ignored) {
            }
        }
        return order;
    }

    // UPDATE
    public void updateRecord(Connection conn, OrderRecord order) {
        try {
            Statement stmt = conn.createStatement();
            String sql = String.format(
                    "UPDATE %s SET %s='%s', %s='%s', %s=%d WHERE %s=%d",
                    TABLE,
                    COL_NAME, order.getCustomerName(),
                    COL_NUMBER, order.getCustomerNumber(),
                    COL_TOTAL, order.getTotalPrice(),
                    COL_ID, order.getId()
            );
            System.out.println("SQL Update: " + sql);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception ignored) {
            }
        }
    }

    // Delete
    public void deleteRecord(Connection conn, int id) {
        try {
            Statement stmt = conn.createStatement();
            String sql = "DELETE FROM orders WHERE id = " + id;
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception ignored) {
            }
        }
    }
}
