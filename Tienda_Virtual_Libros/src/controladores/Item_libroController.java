package controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelos.Libro;

public class Item_libroController {

    @FXML
    private Label txtTitulo;

    @FXML
    private Label txtAutor;

    @FXML
    private Label txtPrecio;

    @FXML
    private ImageView imgPortada;

    public void setTitulo(String titulo) {
        this.txtTitulo.setText(titulo);
    }

    public void setAutor(String autor) {
        this.txtAutor.setText(autor);
    }

    public void setPrecio(String precio) {
        this.txtPrecio.setText(precio);
    }

    public void setPortada(String urlImagen) {
        this.imgPortada.setImage(new Image(urlImagen));
    }

    void setDatosLibro(Libro libro) {
        setAutor(libro.getAutores());
        setPrecio(""+libro.getPrecio());
        setTitulo(libro.getNombre());
    }
}
