/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import modelos.Libro;

/**
 * FXML Controller class
 *
 * @author Juan Mangones
 */
public class Item_libroController  {

    @FXML
    private Label txtTitulo;
    @FXML
    private Label txtAutor;
    @FXML
    private Label txtPrecio;
    
    public void setLibro(Libro libro){
        txtAutor.setText(libro.getAutores());
        txtPrecio.setText(""+libro.getPrecio());
        txtTitulo.setText(libro.getNombre());
    }
    
    
}
