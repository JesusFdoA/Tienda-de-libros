/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import Utils.Utilidades;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class RegistroController implements Initializable {

    @FXML
    private ImageView btnBack;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCorreo;
    @FXML
    private ComboBox<String> comboDocumento;
    @FXML
    private TextField txtUsuario11;
    @FXML
    private Button btnRegistro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> opciones = FXCollections.observableArrayList(
                "Opción 1", "Opción 2", "Opción 3"
        );
        comboDocumento.setItems(opciones);
    }

    @FXML
    private void hacerHover(MouseEvent event) {
    }

    @FXML

    private void registrarUsuario(MouseEvent event) {
    }


    private void retorno_a_login(MouseEvent event) {
        Utilidades.getInstance().mostrarOtraVista(event, "/vistas/Login.fxml");
    }
    
}
