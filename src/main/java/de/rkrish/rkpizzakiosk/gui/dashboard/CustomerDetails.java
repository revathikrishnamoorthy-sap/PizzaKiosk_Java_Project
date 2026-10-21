package de.rkrish.rkpizzakiosk.gui.dashboard;

import de.rkrish.rkpizzakiosk.gui.controller.GuiController;
import de.rkrish.rkpizzakiosk.model.OrderData;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CustomerDetails {
    @FXML
    private TextField customerNameText;

    @FXML
    private TextField customerNumberText;

    @FXML
    private Button updateProduct;

    @FXML
    private Button cancelCustomerDetails;

    @FXML
    private void onContinueClicked(){
        OrderData.customerName = customerNameText.getText();
        OrderData.customerNumber = customerNumberText.getText();

        GuiController.getInstance().openOrderDetails();
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
