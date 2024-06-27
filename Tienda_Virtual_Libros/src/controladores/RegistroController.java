/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import Utils.Utilidades;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import modelos.Usuario;

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
    private Button btnRegistro;
    @FXML
    private TextField txtNDocumento;
    @FXML
    private PasswordField txtPass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> opciones = FXCollections.observableArrayList(
                "Cedula", "Pasaporte", "Cedula de extranjeria"
        );
        comboDocumento.setItems(opciones);
    }

    @FXML
    private void hacerHover(MouseEvent event) {
    }

    @FXML

    private void registrarUsuario(MouseEvent event) {
        Utilidades.getInstance().getUsuario().setNombres(txtNombre.getText());
        Utilidades.getInstance().getUsuario().setApellidos(txtApellido.getText());
        Utilidades.getInstance().getUsuario().setCorreo(txtCorreo.getText());
        Utilidades.getInstance().getUsuario().setTipo_Documento(comboDocumento.getValue());
        Utilidades.getInstance().getUsuario().setNumero_Documento(Long.parseLong(txtNDocumento.getText()));
        Utilidades.getInstance().getUsuario().setPass(txtPass.getText());
        
        Usuario aux = Utilidades.getInstance().getUsuario();
        
        if(Utilidades.getInstance().getListaUsuarios().existeUsuario(aux.getCorreo(), aux.getNumero_Documento()))
        {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("El usuario ya se encuentra registrado en el sistema");
                alert.showAndWait();
                
            });
            limpiarCajas();
            
        }
        else{
             Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Felicitaciones");
                alert.setContentText("El usuario ha sido registrado en el sistema");
                alert.showAndWait();
                Utilidades.getInstance().mostrarOtraVista(event, "/vistas/Login.fxml");
                
            });
             Utilidades.getInstance().getListaUsuarios().getListUsuarios().add(aux);
             limpiarCajas();
        }
    }

    @FXML
    private void retorno_a_login(MouseEvent event) {
        Utilidades.getInstance().mostrarOtraVista(event, "/vistas/Login.fxml");
    }
    
    public void limpiarCajas(){
        txtApellido.setText("");
        txtCorreo.setText("");
        txtNDocumento.setText("");
        txtNombre.setText("");
        txtPass.setText("");
    }
}
