module org.kurtlike {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.kurtlike.controlers to javafx.fxml;
    exports org.kurtlike;
}