package de.rkrish.rkpizzakiosk.gui.dashboard;

import de.rkrish.rkpizzakiosk.gui.controller.GuiController;
import de.rkrish.rkpizzakiosk.logic.data.DummyData;
import de.rkrish.rkpizzakiosk.model.Extra;
import de.rkrish.rkpizzakiosk.model.Extras;
import de.rkrish.rkpizzakiosk.model.OrderData;
import de.rkrish.rkpizzakiosk.model.Pizza;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PizzaChoice implements Initializable {

    //attributes
    @FXML
    private ComboBox<String> pizzaComboBox;

    @FXML
    private TextField pizzaQtyTextField;

    @FXML
    private Button pizzaAddButton;

    @FXML
    private ComboBox<String> extrasComboBox;

    @FXML
    private TextField extraQtyTextField;

    @FXML
    private Button extraAddButton;

    @FXML
    private Button updateProduct;

    @FXML
    private Button cancelButton;


    //region 2. Konstruktor / Initializer
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initPizzaList();
        initExtrasList();

    }

    private void initPizzaList(){
        this.pizzaComboBox.setItems(
                FXCollections.observableArrayList(DummyData.getNames())
        );

    }

    private void initExtrasList(){
        this.extrasComboBox.setItems(
                FXCollections.observableArrayList(DummyData.getDummyExtras().getName())
        );
    }

    //Pizza
    @FXML
    private void onAddPizzaClicked() {
        String pizzaName = pizzaComboBox.getValue();
        String qtyString = pizzaQtyTextField.getText();

        Pizza pizza = (Pizza) DummyData.getPizzaByName(pizzaName);

        if (pizza != null) {
            int qty = Integer.parseInt(qtyString);

            Pizza ordered = new Pizza(
                    pizza.getId(),
                    pizza.getName(),
                    qty,
                    pizza.getPrice()
            );

            OrderData.pizzaOrder.add(ordered);

            System.out.println("Added pizza: " + ordered.getName() + " x " + qty);
        }
    }

    //Extras
    @FXML
    private void onAddExtrasClicked() {
        String extrasName = extrasComboBox.getValue();
        String qtyString = extraQtyTextField.getText();

        Extra extra = DummyData.getExtraByName(extrasName);

        if (extra != null) {
            int qty = Integer.parseInt(qtyString);

            Extra ordered = new Extra(
                    extra.id(),
                    extra.name(),
                    qty,
                    extra.basePrice()
            );

            OrderData.extrasOrder.add(ordered);

            System.out.println("Added Extras: " + ordered.name() + " x " + qty);
        }
    }

    //Next to CustomerDetails
    @FXML
    private void onNextClicked(){
        GuiController.getInstance().openCustomerDetails();
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
