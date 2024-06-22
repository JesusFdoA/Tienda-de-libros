/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import modelos.Administrador;
import modelos.Libro;
import modelos.Usuario;

/**
 *
 * @author Juan Mangones
 */
public class Utilidades {

    private static Utilidades instance;
    private Administrador administrador;
    private Usuario usuario;
    private Libro libro;

    private Utilidades() {
      
    }

    public Utilidades(Administrador administrador, Usuario usuario, Libro libro) {
        this.administrador = administrador;
        this.usuario = usuario;
        this.libro = libro;
    }
    
    

    public static Utilidades getInstance() {
      
        if (instance == null) {
            instance = new Utilidades();
        }
        return instance;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    
}
