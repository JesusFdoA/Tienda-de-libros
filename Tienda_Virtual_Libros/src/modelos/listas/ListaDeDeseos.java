/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.listas;

import java.util.ArrayList;
import modelos.Libro;


public class ListaDeDeseos {
    private ArrayList<Libro> listDeseos;

    public ListaDeDeseos() {
        listDeseos = new ArrayList<>();
    }

    public ArrayList<Libro> getListDeseos() {
        return listDeseos;
    }

    public void setListDeseos(ArrayList<Libro> listDeseos) {
        this.listDeseos = listDeseos;
    }
    
}
