module mk.fx_customerbase {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens mk.fx_customerbase to javafx.fxml;
    exports mk.fx_customerbase;
    exports model; 
}
