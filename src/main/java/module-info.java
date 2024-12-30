module com.example.assinment4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.json;

    opens com.example.workshop11 to javafx.fxml;
    exports com.example.workshop11;

}