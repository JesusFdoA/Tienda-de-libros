/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package modelos;

import Utils.Utilidades;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import modelos.listas.ListaDeDeseos;
import modelos.listas.ListaUsuarios;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        try {
            ListaUsuarios listaUsuarios = new ListaUsuarios();
            ListaDeDeseos listaDeDeseos = new ListaDeDeseos();
            Usuario usuario = new Usuario();
            
            Utilidades.getInstance().setUsuario(usuario);
            Utilidades.getInstance().setListaUsuarios(listaUsuarios);
            Utilidades.getInstance().setListaDeDeseos(listaDeDeseos);
            
            Parent root = FXMLLoader.load(getClass().getResource("/vistas/Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (IOException e) {
            e.getStackTrace();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }

}
