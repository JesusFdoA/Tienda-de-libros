/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import Utils.Utilidades;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modelos.Libro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import modelos.Libro;

public class VistaAdminController implements Initializable {

    @FXML
    private TableView<Libro> tableLibreria;
    @FXML
    private TableColumn<Libro, String> colnombre;
    @FXML
    private TableColumn<Libro, String> coleditorial;
    @FXML
    private TableColumn<Libro, String> colformato;
    @FXML
    private TableColumn<Libro, String> colPresentacion;
    @FXML
    private TableColumn<Libro, String> colisbn;
    @FXML
    private TableColumn<Libro, String> colautores;
    @FXML
    private TableColumn<Libro, String> colcategoria;
    @FXML
    private TableColumn<Libro, Integer> colStock;
    @FXML
    private TextField txtStock;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnSalir;

    private ObservableList<Libro> listaLibros;

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
        configurarTabla();
        cargarDatosEnTabla();
        configurarSeleccionTabla();
    }

    private void configurarTabla() {
        colnombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        coleditorial.setCellValueFactory(new PropertyValueFactory<>("editorial"));
        colformato.setCellValueFactory(new PropertyValueFactory<>("formato"));
        colPresentacion.setCellValueFactory(new PropertyValueFactory<>("presentacion"));
        colisbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colautores.setCellValueFactory(new PropertyValueFactory<>("autores"));
        colcategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
    }

    private void cargarDatosEnTabla() {
        listaLibros = FXCollections.observableArrayList(Utilidades.getInstance().getListaLibrosBiblioteca().getListLibros());
        tableLibreria.setItems(listaLibros);
    }

    private void configurarSeleccionTabla() {
        tableLibreria.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Libro>() {
            @Override
            public void changed(ObservableValue<? extends Libro> observable, Libro oldValue, Libro newValue) {
                if (newValue != null) {
                    txtStock.setText(String.valueOf(newValue.getStock()));
                }
            }
        });
    }

    @FXML
    private void actualizarStock(MouseEvent event) {
        Libro libroSeleccionado = tableLibreria.getSelectionModel().getSelectedItem();
        if (libroSeleccionado != null) {
            try {
                int nuevoStock = Integer.parseInt(txtStock.getText());
                libroSeleccionado.setStock(nuevoStock);
                tableLibreria.refresh();
                Utilidades.getInstance().mostrarAlert(Alert.AlertType.INFORMATION, "Actualización Exitosa", "El stock del libro ha sido actualizado correctamente.");
            txtStock.setText("");
            } catch (NumberFormatException e) {
                Utilidades.getInstance().mostrarAlert(Alert.AlertType.ERROR, "Error de Formato", "Por favor ingrese un número válido.");
            }
        } else {
            Utilidades.getInstance().mostrarAlert(Alert.AlertType.WARNING, "Selección Vacía", "Por favor seleccione un libro de la tabla.");
        }
    }

    @FXML
    private void salir(MouseEvent event) {
        Utilidades.getInstance().mostrarOtraVista(event, "/vistas/Login.fxml");
    }
}
