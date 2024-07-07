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
        Libro l = new  Libro("prueba", "editorial la prueba",
                "Libro", "Tapa dura", "el pepe",
                "no se", 432432432, 130000, 6);
        listDeseos.add(l);
        for (Libro listDeseo : listDeseos) {
            System.out.println(""+listDeseo.getNombre());
        }
    }

    public ArrayList<Libro> getListDeseos() {
        return listDeseos;
    }

    public void setListDeseos(ArrayList<Libro> listDeseos) {
        this.listDeseos = listDeseos;
    }
    
}
