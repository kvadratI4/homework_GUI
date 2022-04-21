module com.example.hometask3_gui_javafx_start {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.hometask3_gui_javafx_start to javafx.fxml;
    exports com.example.hometask3_gui_javafx_start;
}