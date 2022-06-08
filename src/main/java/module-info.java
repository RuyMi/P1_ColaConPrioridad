module es.ruben.p1_colaconprioridad {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ruben.p1_colaconprioridad to javafx.fxml;
    exports es.ruben.p1_colaconprioridad;
    exports es.ruben.p1_colaconprioridad.controller;
    opens es.ruben.p1_colaconprioridad.controller to javafx.fxml;
    exports es.ruben.p1_colaconprioridad.repositories to javafx.fxml;
    exports es.ruben.p1_colaconprioridad.models to javafx.fxml;
    exports es.ruben.p1_colaconprioridad.exceptions to javafx.fxml;
}