package es.ruben.p1_colaconprioridad.controller;

import es.ruben.p1_colaconprioridad.exceptions.ProcesoException;
import es.ruben.p1_colaconprioridad.models.Estado;
import es.ruben.p1_colaconprioridad.models.Proceso;
import es.ruben.p1_colaconprioridad.repositories.ProcesoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MenuPrincipalController {
    @FXML
    public TextField idText;
    @FXML
    public TextField nombreText;
    @FXML
    public TextField prioridadText;
    @FXML
    public TextField estadoText;
    @FXML
    public Button addButton;
    @FXML
    public Button eliminarButton;
    @FXML
    public Button listaButton;
    public ProcesoRepository repository = ProcesoRepository.getInstance();

    public void initialize() {
    addButton.setOnAction(event -> {
        try {
            add();
        } catch (ProcesoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al añadir un proceso");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    });
    eliminarButton.setOnAction(event -> {
        try {
            eliminar();
        } catch (ProcesoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al eliminar un proceso");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    });
    listaButton.setOnAction(event -> {
            lista();
        });
    }

    private void lista() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Lista de procesos");
        alert.setHeaderText("Lista de procesos");
        alert.setContentText(repository.toString());
        alert.showAndWait();
    }

    private void eliminar() throws ProcesoException {
        Proceso p = repository.remove();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Eliminar");
        alert.setHeaderText("Eliminar proceso");
        alert.setContentText("Se ha eliminado el proceso " + p.getNombre() + " con id " + p.getId());
        alert.showAndWait();
    }

    private void add() throws ProcesoException {
        Proceso proceso = new Proceso(Integer.parseInt(idText.getText()), nombreText.getText(), Integer.parseInt(prioridadText.getText()));
        repository.add(proceso);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Añadir");
        alert.setHeaderText("Añadir proceso");
        alert.setContentText("Se ha añadido el proceso " + proceso.getNombre() + " con id " + proceso.getId());
        alert.showAndWait();
    }


}