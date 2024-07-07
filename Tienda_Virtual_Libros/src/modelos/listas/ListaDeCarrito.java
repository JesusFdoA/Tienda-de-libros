/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.listas;

import java.util.ArrayList;
import modelos.Libro;


public class ListaDeCarrito {
    private ArrayList<Libro> listCarrito;

    public ListaDeCarrito() {
        listCarrito = new ArrayList<>();
    }

    public ArrayList<Libro> getListCarrito() {
        return listCarrito;
    }

    public void setListCarrito(ArrayList<Libro> listCarrito) {
        this.listCarrito = listCarrito;
    }
    
}
