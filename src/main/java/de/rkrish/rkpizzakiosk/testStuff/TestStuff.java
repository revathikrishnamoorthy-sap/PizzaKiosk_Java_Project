package de.rkrish.rkpizzakiosk.testStuff;

import de.rkrish.rkpizzakiosk.logic.db.DbManager;
import de.rkrish.rkpizzakiosk.logic.db.OrderRecord;

import java.util.List;

public class TestStuff {
    static void main() {

//		System.out.println("--- Insert Order ---");
//		DbManager.getInstance().insertOrder(new OrderRecord(
//				"Revathi",
//				"9894384652",
//                20)
//		);


        System.out.println("--- Get All Orders ---");
        List<OrderRecord> orders = DbManager.getInstance().getAllOrders();
        for (OrderRecord order : orders) {
            System.out.println("orders = " + order);
        }

    }
}
