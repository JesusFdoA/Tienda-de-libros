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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import modelos.Usuario;

public class MenuPrincipalController implements Initializable {

    @FXML
    private Label txtNombreUs;
    @FXML
    private Label opcInicio;
    @FXML
    private Label opcListaDes;
    @FXML
    private Label opcCarrito;
    @FXML
    private Label opCompras;
    @FXML
    private Label opcSalir;
    @FXML
    private Label txtApellidos;
    @FXML
    private GridPane panelPrincipal;
    @FXML
    private Pane panelListDeseso;
    @FXML
    private Pane panelCarrito;
    @FXML
    private Pane panelCompras;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Usuario usuarioLog = Utilidades.getInstance().getUsuario();
        txtNombreUs.setText(usuarioLog.getNombres());
        txtApellidos.setText(usuarioLog.getApellidos());
    }

    public void CambiarColor1(Label principal, Label s1,
            Label s2, Label s3,
            Label s4) {
        principal.setStyle("-fx-text-fill: #212a65;");
        s1.setStyle("-fx-text-fill: #c2c2d1;");
        s2.setStyle("-fx-text-fill: #c2c2d1;");
        s3.setStyle("-fx-text-fill: #c2c2d1;");
        s4.setStyle("-fx-text-fill: #c2c2d1;");
    }

    @FXML
    private void mostrarLibros(MouseEvent event) {
        CambiarColor1(opcInicio, opcSalir, opCompras, opcCarrito, opcListaDes);
        panelListDeseso.setVisible(false);
        panelCarrito.setVisible(false);
        panelPrincipal.setVisible(true);
        panelCompras.setVisible(false);
    }

    @FXML
    private void mostrarListaD(MouseEvent event) {
        CambiarColor1(opcListaDes, opcInicio, opcSalir, opCompras, opcCarrito);
        panelListDeseso.setVisible(true);
        panelCarrito.setVisible(false);
        panelPrincipal.setVisible(false);
        panelCompras.setVisible(false);

    }

    @FXML
    private void mostrarCarrito(MouseEvent event) {
        CambiarColor1(opcCarrito, opcListaDes, opcInicio, opcSalir, opCompras);
        panelListDeseso.setVisible(false);
        panelCarrito.setVisible(true);
        panelPrincipal.setVisible(false);
        panelCompras.setVisible(false);
    }

    @FXML
    private void mostrarCompras(MouseEvent event) {
        CambiarColor1(opCompras, opcCarrito, opcListaDes, opcInicio, opcSalir);
        panelListDeseso.setVisible(false);
        panelCarrito.setVisible(false);
        panelPrincipal.setVisible(false);
        panelCompras.setVisible(true);
    }

    @FXML
    private void regresar(MouseEvent event) {
        Utilidades.getInstance().mostrarOtraVista(event, "/vistas/Login.fxml");
    }
}
