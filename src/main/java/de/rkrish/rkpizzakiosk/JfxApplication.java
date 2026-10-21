package de.rkrish.rkpizzakiosk;

import de.rkrish.rkpizzakiosk.gui.controller.GuiController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JfxApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        GuiController.getInstance().setMainStage(stage);
        GuiController.getInstance().openPizzaChoice();
    }
}
