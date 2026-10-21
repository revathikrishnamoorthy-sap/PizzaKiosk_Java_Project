module de.rkrish.rkpizzakiosk {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;
    requires java.sql;


    opens de.rkrish.rkpizzakiosk to javafx.fxml;
    exports de.rkrish.rkpizzakiosk;

    exports de.rkrish.rkpizzakiosk.gui.dashboard;
    opens de.rkrish.rkpizzakiosk.gui.dashboard to javafx.fxml;

}