module com.genbrugsstation {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.genbrugsstation to javafx.fxml;
    exports com.genbrugsstation;
}