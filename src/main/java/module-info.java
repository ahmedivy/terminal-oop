module com.example.terminaloop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.terminaloop to javafx.fxml;
    exports com.example.terminaloop;
}