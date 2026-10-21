package de.rkrish.rkpizzakiosk.gui.dashboard;

import de.rkrish.rkpizzakiosk.logic.db.DbManager;
import de.rkrish.rkpizzakiosk.logic.db.OrderRecord;
import de.rkrish.rkpizzakiosk.model.Extra;
import de.rkrish.rkpizzakiosk.model.OrderData;
import de.rkrish.rkpizzakiosk.model.Pizza;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderDetails implements Initializable {

    @FXML
    private ListView<String> ordersList;

    @FXML
    private TextField totalPriceText;

    @FXML
    private TextField customerAmount;

    @FXML
    private Button amountToPay;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadOrders();
        calculateTotalPrice();
    }

    private void loadOrders() {
        ObservableList<String> items = FXCollections.observableArrayList();

        for (Pizza p : OrderData.pizzaOrder) {
            String line = p.getName() + " x " + p.getQty();
            items.add(line);
        }

        for (Extra e : OrderData.extrasOrder) {
            String line = e.name() + " x " + e.qty();
            items.add(line);
        }

        ordersList.setItems(items);
    }

    private int calculateTotalPrice() {
        int total = 0;

        for (Pizza p : OrderData.pizzaOrder) {
            total += p.getPrice() * p.getQty();
        }

        for (Extra e : OrderData.extrasOrder) {
            total += e.basePrice() * e.qty();
        }

        totalPriceText.setText(total + " €");

        return total;
    }

    @FXML
    private void onPayClicked() {
        //Get Name and Number From OderData
        String name = OrderData.customerName;
        String number = OrderData.customerNumber;

        //Get TotalPrice
        int total = calculateTotalPrice();

        //OrderRecord Object
        OrderRecord record = new OrderRecord(name, number, total);
        DbManager.getInstance().insertOrder(record);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Completed");
            alert.setHeaderText("Thank you! , Your order has been placed successfully.");
            alert.setContentText("Please Pay and Collect at the Counter");
            alert.showAndWait();
            Platform.exit();
        }

    @FXML
    private void cancelClicked() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Order Cancelled");
        alert.setHeaderText("You have cancelled your Order");
        alert.setContentText("The App will Close Now");
        alert.showAndWait();
        Platform.exit();
    }



}
