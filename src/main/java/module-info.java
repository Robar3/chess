module com.robar3.chess {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.robar3.chess to javafx.fxml;
    exports com.robar3.chess;
}