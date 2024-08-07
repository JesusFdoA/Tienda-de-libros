/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

public class Libro {

    private String nombre, editorial, formato, presentacion, autores, categoria, isbn;
    private double precio;
    private int stock;
    private double total;

    public Libro() {

    }

    public Libro(String nombre, String editorial, String formato, String presentacion, String autores, String categoria, String isbn, double precio, int stock) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.formato = formato;
        this.presentacion = presentacion;
        this.autores = autores;
        this.categoria = categoria;
        this.isbn = isbn;
        this.precio = precio;
        this.stock = stock;
        this.total = stock * precio;
    }

    public Libro(String nombre, String autores, double precio) {
        this.nombre = nombre;
        this.autores = autores;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getTotal() {
        return stock * precio;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void actualizarStock(int resta){
        stock = stock-resta;
    }
}
