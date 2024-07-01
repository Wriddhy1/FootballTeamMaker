module com.oop.footballteammaker {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.oop.footballteammaker to javafx.fxml;
    exports com.oop.footballteammaker;
}