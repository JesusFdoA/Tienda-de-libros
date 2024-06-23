/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import Utils.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelos.Usuario;

public class LoginController implements Initializable {

    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtContra;
    @FXML
    private Button btnLogin;
    @FXML
    private Label labelRegister;
    @FXML
    private ImageView btnSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void salir(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
        } catch (Exception e) {

        }
    }

    @FXML
    private void hoverIniciarSesion(MouseEvent event) {
        Button capturarBotonIniciar = (Button) event.getSource();
        capturarBotonIniciar.setStyle("-fx-text-fill: #1D6E34;");
    }

    @FXML
    private void hoverIniciarSesion2(MouseEvent event) {
        Button capturarBoton = (Button) event.getSource();

        capturarBoton.setStyle("-fx-background-color:  #30b956");
    }

    @FXML
    private void iniciarSesion(MouseEvent event) {
        String us = txtUsuario.getText(), pass = txtContra.getText();

        if (Utilidades.getInstance().getListaUsuarios().existeUsuario(us, pass)) {
            Platform.runLater(() -> {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Credenciales correctas");
                alert.setContentText("Perfecto, te has logeado correctamente");
                alert.showAndWait();
                Usuario usuarioLogeado = Utilidades.getInstance().getListaUsuarios().ObtenerUsuario(us, pass);
                Utilidades.getInstance().setUsuario(usuarioLogeado);
                Utilidades.getInstance().mostrarOtraVista(event, "/vistas/MenuPrincipal.fxml");
            });
        } else {
            Platform.runLater(() -> {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Credenciales incorrectas");
                alert.setContentText("El usuario no esta registrado o sus credenciales estan mal");
                alert.showAndWait();
            });
        }
    }

    @FXML
    private void hoverResgristro(MouseEvent event) {
        Label etiqueta = (Label) event.getSource();
        etiqueta.setStyle("-fx-text-fill: #ffffff;");

    }

    @FXML
    private void hover2(MouseEvent event) {
        Label etiqueta = (Label) event.getSource();
        etiqueta.setStyle(null);
    }

    @FXML
    private void lanzar_vista_de_registro(MouseEvent event) {
        Utilidades.getInstance().mostrarOtraVista(event, "/vistas/Registro.fxml");
    }

}
