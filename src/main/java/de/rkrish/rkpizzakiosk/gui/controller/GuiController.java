package de.rkrish.rkpizzakiosk.gui.controller;

import de.rkrish.rkpizzakiosk.JfxApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiController {

    //Constructor
    private static final String APPLICATION_NAME = "RkJfxPizzaKiosk - ";

    private static final int DEFAULT_HEIGHT = 600;
    private static final int DEFAULT_WIDTH  = 600;

    private static final String PIZZA_CHOICE_FXML = "pizza-choice.fxml";
    private static final String PIZZA_CHOICE_TITLE        = APPLICATION_NAME + "List Of Pizza and Extras";

    private static final String CUSTOMER_DETAILS_FXML = "customer-details.fxml";
    private static final String CUSTOMER_DETAILS_TITLE        = APPLICATION_NAME + "Customer Details";

    private static final String ORDER_DETAILS_FXML  = "order-details.fxml";
    private static final String ORDER_DETAILS_TITLE = APPLICATION_NAME + "Order Details";
    //End

    //Attribute
    private static GuiController instance;
    private Stage mainStage;
    //End

    //Constructor
    private GuiController() {
    }
    //End

    //Get Instance
    public static synchronized GuiController getInstance() {
        if (instance == null) {
            instance = new GuiController();
        }

        return instance;
    }
    //End

    //Getter und Setter
    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
    //End


    public void openPizzaChoice() {
        this.openGui(PIZZA_CHOICE_FXML, PIZZA_CHOICE_TITLE);
    }

    public void openCustomerDetails() {
        this.openGui(CUSTOMER_DETAILS_FXML, CUSTOMER_DETAILS_TITLE);
    }

    public void openOrderDetails() {
        this.openGui(ORDER_DETAILS_FXML, ORDER_DETAILS_TITLE);
    }

    private void openGui(String layoutFileName, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(JfxApplication.class.getResource(layoutFileName));
            Scene scene      = new Scene(fxmlLoader.load(), DEFAULT_WIDTH, DEFAULT_HEIGHT);

            this.mainStage.setTitle(title);
            this.mainStage.setScene(scene);

            this.mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
