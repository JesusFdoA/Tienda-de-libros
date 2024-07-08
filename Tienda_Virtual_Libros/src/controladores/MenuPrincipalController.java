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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import modelos.Libro;
import modelos.Usuario;

public class MenuPrincipalController implements Initializable {

    private Usuario usuario;
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
    //Configuracion de la tabla deseo
    private ObservableList<Libro> listLibroDeseos;
    @FXML
    private TableView<Libro> tableDeseo;
    @FXML
    private TableColumn<Libro, String> colNombreDeseo;

    @FXML
    private TableColumn<Libro, Double> colPrecioDeseo;

    //Configuracion de la tabla carrito
    private ObservableList<Libro> listaLibroCarrito;
    @FXML
    private TableView<Libro> tableCar;
    @FXML
    private TableColumn colISBNCar;
    @FXML
    private TableColumn colNombreCar;
    @FXML
    private TableColumn colCantidadCar;
    @FXML
    private TableColumn colUnitCar;
    @FXML
    private TableColumn colTotalCar;

    @FXML
    private Button btnBuyCar;
    @FXML
    private Button BTNDelCar;
    //Configuracion de la tabla de historial de compras
    private ObservableList<Libro> listHisCompra;
    @FXML
    private TableView<Libro> tableBuy;
    @FXML
    private TableColumn colISBNBuy;
    @FXML
    private TableColumn colNameBuy;
    @FXML
    private TableColumn colCantBuy;
    @FXML
    private TableColumn colValBuy;
    @FXML
    private TableColumn colTalBuy;
    @FXML
    private Label txtPrecioBuy;
    @FXML
    private ImageView imgLibro;
    @FXML
    private Label txtNombre;
    @FXML
    private Label txtEditorial;
    @FXML
    private Label txtFormato;
    @FXML
    private Label txtPresentacion;
    @FXML
    private Label txtIsbn;
    @FXML
    private Label txtCategoria;
    @FXML
    private Label txtStock;
    @FXML
    private Button btnCarrito;
    @FXML
    private Button btnDeseos;
    @FXML
    private Spinner<Integer> spingCant;
    @FXML
    private ImageView img1;
    @FXML
    private Label txt1;
    @FXML
    private Pane vistaLateral;
    @FXML
    private ImageView img2;
    @FXML
    private Label txt2;
    @FXML
    private ImageView img3;
    @FXML
    private Label txt3;
    @FXML
    private ImageView img4;
    @FXML
    private Label txt4;
    @FXML
    private Label txtPrecioE;
    @FXML
    private Label txtPrecioM;
    @FXML
    private Label txtPrecioNum;
    @FXML
    private Label txtPrecioInge;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.usuario = Utilidades.getInstance().getUsuario();
        Utilidades.getInstance().mostrarAlert(Alert.AlertType.INFORMATION,
                "usuario", usuario.getNombres());
        cargarLibros();
        configurarTablaDeseos();
        configurarTablaCarrito();
        configurarTablaCompras();

    }

    public void cargarSpinner(int rango1, int rango2, int cambios) {
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(rango1, rango2, cambios);
        spingCant.setValueFactory(valueFactory);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void cargarLibros() {
        txtPrecioE.setText("" + Utilidades.getInstance().
                getListaLibrosBiblioteca().buscarPorISBN("9788419599339").getPrecio());
        txtPrecioM.setText("" + Utilidades.getInstance().
                getListaLibrosBiblioteca().buscarPorISBN("9786287667723").getPrecio());
        txtPrecioNum.setText("" + Utilidades.getInstance().
                getListaLibrosBiblioteca().buscarPorISBN("9789587788914").getPrecio());
        txtPrecioInge.setText("" + Utilidades.getInstance().
                getListaLibrosBiblioteca().buscarPorISBN("9789587788792").getPrecio());
    }

    public void CapturarUsuario() {
        Usuario usuarioLog = Utilidades.getInstance().getUsuario();
        txtNombreUs.setText(usuarioLog.getNombres());
        txtApellidos.setText(usuarioLog.getApellidos());
        panelPrincipal.setHgap(10); // Espacio horizontal entre columnas
        panelPrincipal.setVgap(50); // Espacio vertical entre filas
    }

    public void configurarTablaDeseos() {
        try {

            // Inicializar la lista observable
            listLibroDeseos = FXCollections.observableArrayList();

            // Obtener la lista de deseos desde Utilidades
            listLibroDeseos.addAll(Utilidades.getInstance().getUsuario().getListaDeDeseos().getListDeseos());

            // Configurar las columnas
            colNombreDeseo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colPrecioDeseo.setCellValueFactory(new PropertyValueFactory<>("precio"));

        } catch (Exception e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Error al cargar la tabla");
//            alert.setContentText("Este es un cuadro de diálogo de alerta");
//
//            alert.showAndWait();
        }
    }

    public void configurarTablaCarrito() {
        try {

            // Inicializar la lista observable
            listaLibroCarrito = FXCollections.observableArrayList();

            // Obtener la lista de deseos desde Utilidades
            listaLibroCarrito.addAll(Utilidades.getInstance().getUsuario().getListaDeCarrito().getListCarrito());

            // Configurar las columnas
            colNombreCar.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colISBNCar.setCellValueFactory(new PropertyValueFactory<>("isbn"));
            colCantidadCar.setCellValueFactory(new PropertyValueFactory<>("stock"));
            colUnitCar.setCellValueFactory(new PropertyValueFactory<>("precio"));
            colTotalCar.setCellValueFactory(new PropertyValueFactory<>("total"));

        } catch (Exception e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setTitle("Error");
//            alert.setHeaderText("Error al cargar la tabla");
//            alert.setContentText("Este es un cuadro de diálogo de alerta");
//
//            alert.showAndWait();
        }
    }

    public void configurarTablaCompras() {
        try {
            // Inicializar la lista observable
            listHisCompra = FXCollections.observableArrayList();

            // Obtener la lista de deseos desde Utilidades
            listHisCompra.addAll(Utilidades.getInstance().getUsuario().getListaDeCompras().getListCompras());

            // Configurar las columnas
            colNameBuy.setCellValueFactory(new PropertyValueFactory<>("nombre"));
            colISBNBuy.setCellValueFactory(new PropertyValueFactory<>("isbn"));
            colCantBuy.setCellValueFactory(new PropertyValueFactory<>("stock"));
            colValBuy.setCellValueFactory(new PropertyValueFactory<>("precio"));
            colTalBuy.setCellValueFactory(new PropertyValueFactory<>("total"));

         
        } catch (Exception e) {
            e.printStackTrace();
            // Alertas o manejo de errores
        }
    }

    public void CambiarColor1(Label principal, Label s1,
            Label s2, Label s3,
            Label s4) {
        principal.setStyle("-fx-text-fill: #212a65;");
        s1.setStyle("-fx-text-fill: #c2c2d1;");
        s2.setStyle("-fx-text-fill: #c2c2d1;");
        s3.setStyle("-fx-text-fill: #c2c2d1;");
        s4.setStyle("-fx-text-fill: #c2c2d1;");
        vistaLateral.setVisible(false);
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

    public void seleccionarLibro(String isbn) {

        switch (isbn) {
            case "9788419599339":
                cargarDetalles(Utilidades.getInstance()
                        .getListaLibrosBiblioteca().buscarPorISBN(isbn),
                        "/img/menuPrincipal/libros/egipto.png");
                break;
            case "9786287667723":
                cargarDetalles(Utilidades.getInstance()
                        .getListaLibrosBiblioteca().buscarPorISBN(isbn),
                        "/img/menuPrincipal/libros/manzana.png");
                break;
            case "9789587788792":
                cargarDetalles(Utilidades.getInstance()
                        .getListaLibrosBiblioteca().buscarPorISBN(isbn),
                        "/img/menuPrincipal/libros/intro_inge.png");
                break;
            case "9789587788914":
                cargarDetalles(Utilidades.getInstance()
                        .getListaLibrosBiblioteca().buscarPorISBN(isbn),
                        "/img/menuPrincipal/libros/metodos.png");
                break;
            default:
                Utilidades.getInstance().mostrarAlert(Alert.AlertType.ERROR, "Error", "No se encontro isbn");
        }
    }

    public void cargarDetalles(Libro libro, String ruta) {
        vistaLateral.setVisible(true);
        Image imagenInicial = new Image(ruta);
        imgLibro.setImage(imagenInicial);
        txtNombre.setText(libro.getNombre());
        txtEditorial.setText(libro.getEditorial());
        txtPresentacion.setText(libro.getPresentacion());
        txtIsbn.setText(libro.getIsbn());
        txtCategoria.setText(libro.getCategoria());
        txtStock.setText("" + libro.getStock());
        cargarSpinner(0, libro.getStock(), 1);
    }

    @FXML
    private void clickEgito(MouseEvent event) {
        seleccionarLibro("9788419599339");
    }

    @FXML
    private void clickText1(MouseEvent event) {
        seleccionarLibro("9788419599339");
    }

    @FXML
    private void clickImg2(MouseEvent event) {
        seleccionarLibro("9786287667723");
    }

    @FXML
    private void txtClick2(MouseEvent event) {
        seleccionarLibro("9786287667723 ");
    }

    @FXML
    private void clickimg3(MouseEvent event) {
        seleccionarLibro("9789587788914");
    }

    @FXML
    private void clickTxt3(MouseEvent event) {
        seleccionarLibro("9789587788914");
    }

    @FXML
    private void clickImg4(MouseEvent event) {
        seleccionarLibro("9789587788792");
    }

    @FXML
    private void clicktxt4(MouseEvent event) {
        seleccionarLibro("9789587788792");
    }

    @FXML
    private void anadirCarrito(MouseEvent event) {

        // Obtener el libro basado en el ISBN
        Libro libro = Utilidades.getInstance()
                .getListaLibrosBiblioteca().buscarPorISBN(txtIsbn.getText());

        // Obtener la cantidad seleccionada en el Spinner
        int cantidadSeleccionada = spingCant.getValue().intValue();

        // Verificar si hay suficiente stock
        if (libro.getStock() >= cantidadSeleccionada) {
            // Crear una copia del libro para el carrito
            Libro libroCarrito = new Libro(libro.getNombre(), libro.getEditorial(),
                    libro.getFormato(), libro.getPresentacion(), libro.getAutores(),
                    libro.getCategoria(), libro.getIsbn(), libro.getPrecio(), cantidadSeleccionada);

            // Agregar el libro al carrito del usuario
            usuario.getListaDeCarrito().getListCarrito().add(libroCarrito);

            // Actualizar la lista de libros en el carrito
            this.listaLibroCarrito.add(libroCarrito);

            // Actualizar el stock del libro original
            libro.setStock(libro.getStock() - cantidadSeleccionada);

            // Actualizar el stock del libro en la biblioteca
            for (int i = 0; i < Utilidades.getInstance().getListaLibrosBiblioteca().getListLibros().size(); i++) {
                if (Utilidades.getInstance().getListaLibrosBiblioteca().getListLibros().get(i).getIsbn().equals(libro.getIsbn())) {
                    Utilidades.getInstance().getListaLibrosBiblioteca().getListLibros().set(i, libro);
                    txtStock.setText("" + libro.getStock());
                    break;
                }
            }

            // Actualizar la lista de usuarios
            for (int i = 0; i < Utilidades.getInstance().getListaUsuarios().getListUsuarios().size(); i++) {
                if (usuario.getCorreo().equals(Utilidades.getInstance().getListaUsuarios().getListUsuarios().get(i).getCorreo())) {
                    Utilidades.getInstance().getListaUsuarios().getListUsuarios().set(i, usuario);
                    Utilidades.getInstance().mostrarAlert(Alert.AlertType.INFORMATION, "Correcto", "Libro agregado correctamente");
                    break;
                }
            }

            // Actualizar la tabla del carrito
            configurarTablaCarrito();
            this.tableCar.setItems(listaLibroCarrito);
        } else {
            Utilidades.getInstance().mostrarAlert(Alert.AlertType.ERROR, "Stock insuficiente", "No hay suficiente stock para agregar esta cantidad al carrito.");
        }

    }

    @FXML
    private void anadirDeseos(MouseEvent event) {
        Libro libro = Utilidades.getInstance()
                .getListaLibrosBiblioteca().buscarPorISBN(txtIsbn.getText());

        usuario.getListaDeDeseos().getListDeseos().add(libro);

        for (int i = 0; i < Utilidades.getInstance().getListaUsuarios().getListUsuarios().size(); i++) {
            this.listLibroDeseos.addAll(usuario.getListaDeDeseos().getListDeseos());

            if (usuario.getCorreo().equals(Utilidades.getInstance().getListaUsuarios().getListUsuarios().get(i).getCorreo())) {
                Utilidades.getInstance().getListaUsuarios().getListUsuarios().set(i, usuario);
                Utilidades.getInstance().mostrarAlert(Alert.AlertType.INFORMATION,
                        "Correcto", "Libro agregado correctamente");
            } else {
                Utilidades.getInstance().mostrarAlert(Alert.AlertType.ERROR, "", "Erros al cargar");
            }

        }
        configurarTablaDeseos();
        this.tableDeseo.setItems(listLibroDeseos);

    }

    @FXML
    private void eliminarCarrito(MouseEvent event) {
        // Obtén el libro seleccionado en la tabla
        Libro libroSeleccionado = tableCar.getSelectionModel().getSelectedItem();

        if (libroSeleccionado != null) {
            // Elimina el libro de la lista del carrito del usuario
            usuario.getListaDeCarrito().getListCarrito().remove(libroSeleccionado);

            // Actualiza la tabla
            listaLibroCarrito.remove(libroSeleccionado);

            // Restaura el stock del libro en la biblioteca
            for (Libro libro : Utilidades.getInstance().getListaLibrosBiblioteca().getListLibros()) {
                if (libro.getIsbn().equals(libroSeleccionado.getIsbn())) {
                    libro.setStock(libro.getStock() + libroSeleccionado.getStock());
                    txtStock.setText("" + libro.getStock());
                    break;
                }
            }

            // Actualiza la lista de usuarios
            for (int i = 0; i < Utilidades.getInstance().getListaUsuarios().getListUsuarios().size(); i++) {
                if (usuario.getCorreo().equals(Utilidades.getInstance().getListaUsuarios().getListUsuarios().get(i).getCorreo())) {
                    Utilidades.getInstance().getListaUsuarios().getListUsuarios().set(i, usuario);
                    break;
                }
            }

            Utilidades.getInstance().mostrarAlert(Alert.AlertType.INFORMATION, "Correcto", "Libro eliminado del carrito correctamente.");
        } else {
            Utilidades.getInstance().mostrarAlert(Alert.AlertType.ERROR, "Error", "No se ha seleccionado ningún libro.");
        }
    }

    @FXML
    private void terminarCompra(MouseEvent event) {
        // Obtener la lista de libros del carrito del usuario
        ArrayList<Libro> librosCarrito = new ArrayList<>(usuario.getListaDeCarrito().getListCarrito());

        // Mover los libros del carrito al historial de compras
        usuario.getListaDeCompras().getListCompras().addAll(librosCarrito);

        // Vaciar el carrito del usuario
        usuario.getListaDeCarrito().getListCarrito().clear();

        // Actualizar la lista de usuarios
        for (int i = 0; i < Utilidades.getInstance().getListaUsuarios().getListUsuarios().size(); i++) {
            if (usuario.getCorreo().equals(Utilidades.getInstance().getListaUsuarios().getListUsuarios().get(i).getCorreo())) {
                Utilidades.getInstance().getListaUsuarios().getListUsuarios().set(i, usuario);
            }
        }

        // Actualizar la TableView del carrito
        listaLibroCarrito.clear();
        configurarTablaCarrito();
        tableCar.setItems(listaLibroCarrito);

        // Actualizar la TableView del historial de compras
        listHisCompra = FXCollections.observableArrayList(usuario.getListaDeCompras().getListCompras());
        configurarTablaCompras();
        tableBuy.setItems(listHisCompra);
        
        txtPrecioBuy.setText(""+Utilidades.getInstance().getUsuario().getListaDeCompras().calcularTotalCompras());
        // Mostrar un mensaje de confirmación
        Utilidades.getInstance().mostrarAlert(Alert.AlertType.INFORMATION, "Compra realizada", "Los libros han sido movidos al historial de compras.");

    }
}
