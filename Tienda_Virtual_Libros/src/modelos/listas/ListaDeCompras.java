/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.listas;

import java.util.ArrayList;
import modelos.Libro;


public class ListaDeCompras {
    private ArrayList<Libro> listCompras;

    public ListaDeCompras() {
        listCompras = new ArrayList<>();
    }

    public ArrayList<Libro> getListCompras() {
        return listCompras;
    }

    public void setListCompras(ArrayList<Libro> listCompras) {
        this.listCompras = listCompras;
    }
    
}
