/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import Utils.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modelos.Libro;
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

    private List<Libro> libros = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Usuario usuarioLog = Utilidades.getInstance().getUsuario();
        txtNombreUs.setText(usuarioLog.getNombres());
        txtApellidos.setText(usuarioLog.getApellidos());
        panelPrincipal.setHgap(10); // Espacio horizontal entre columnas
        panelPrincipal.setVgap(50); // Espacio vertical entre filas
        actualizarGridPane();

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

    private List cargarLibrosIniciales() {
        libros.clear();
        libros.add(new Libro("Programacion 1", "Anonimo", 150000));
        libros.add(new Libro("Programacion 2", "Anonimo", 200000));
        libros.add(new Libro("Programacion 3", "Anonimo", 190000));
        libros.add(new Libro("Programacion 4", "Anonimo", 190000));
        libros.add(new Libro("Programacion 5", "Anonimo", 190000));
        libros.add(new Libro("Programacion 6", "Anonimo", 190000));
        return libros;

    }
    
    public void actualizarGridPane() {
    List<Libro> libros = cargarLibrosIniciales(); // Supongamos que tienes una lista de libros

    panelPrincipal.getChildren().clear(); // Limpia el GridPane antes de agregar nuevos elementos

    int column = 0;
    int row = 0;

    for (int i = 0; i < libros.size(); i++) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/vistas/item_libro.fxml"));
            HBox itemLibro = fxmlLoader.load();

            Item_libroController itemLibroController = fxmlLoader.getController();
            itemLibroController.setDatosLibro(libros.get(i)); // Asigna los datos del libro al controlador del item

            panelPrincipal.add(itemLibro, column, row);

            column++;
            if (column == 2) {
                column = 0;
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


    public void agregarLibro(Libro libro) {
        libros.add(libro);
        actualizarGridPane();
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
