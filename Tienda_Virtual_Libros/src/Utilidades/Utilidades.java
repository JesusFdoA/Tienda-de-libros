/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import modelos.Administrador;
import modelos.Libro;
import modelos.Usuario;
import modelos.listas.ListaUsuarios;
import modelos.pilas.PilaLibrosFisica;
import modelos.pilas.PilaLibrosIngenieria;
import modelos.pilas.PilaLibrosMatematica;


public class Utilidades {

    private static Utilidades instance;
    private Administrador administrador;
    private Usuario usuario;
    private Libro libro;
    private ListaUsuarios listaUsuarios;
    private PilaLibrosFisica pilaLibrosFisica;
    private PilaLibrosIngenieria pilaLibrosIngenieria;
    private PilaLibrosMatematica pilaLibrosMatematica;
    
    private Utilidades() {
      
    }

    public Utilidades(Administrador administrador, Usuario usuario, Libro libro, ListaUsuarios listaUsuarios, PilaLibrosFisica pilaLibrosFisica, PilaLibrosIngenieria pilaLibrosIngenieria, PilaLibrosMatematica pilaLibrosMatematica) {
        this.administrador = administrador;
        this.usuario = usuario;
        this.libro = libro;
        this.listaUsuarios = listaUsuarios;
        this.pilaLibrosFisica = pilaLibrosFisica;
        this.pilaLibrosIngenieria = pilaLibrosIngenieria;
        this.pilaLibrosMatematica = pilaLibrosMatematica;
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

    public ListaUsuarios getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ListaUsuarios listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public PilaLibrosFisica getPilaLibrosFisica() {
        return pilaLibrosFisica;
    }

    public void setPilaLibrosFisica(PilaLibrosFisica pilaLibrosFisica) {
        this.pilaLibrosFisica = pilaLibrosFisica;
    }

    public PilaLibrosIngenieria getPilaLibrosIngenieria() {
        return pilaLibrosIngenieria;
    }

    public void setPilaLibrosIngenieria(PilaLibrosIngenieria pilaLibrosIngenieria) {
        this.pilaLibrosIngenieria = pilaLibrosIngenieria;
    }

    public PilaLibrosMatematica getPilaLibrosMatematica() {
        return pilaLibrosMatematica;
    }

    public void setPilaLibrosMatematica(PilaLibrosMatematica pilaLibrosMatematica) {
        this.pilaLibrosMatematica = pilaLibrosMatematica;
    }
    
    
    
}
