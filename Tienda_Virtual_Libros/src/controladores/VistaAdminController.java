/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import Utils.Utilidades;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Juan Mangones
 */
public class VistaAdminController implements Initializable {

    @FXML
    private TextField txtStock;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Utilidades.getInstance().mostrarAlert(
                    Alert.AlertType.INFORMATION,
                    "Credenciales correctas",
                    "Bienvenido Admin");
    }    
    
}
