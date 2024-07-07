/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.listas;

import java.util.ArrayList;
import modelos.Libro;

/**
 *
 * @author Juan Mangones
 */
public class ListaLibrosBiblioteca {

    private ArrayList<Libro> listLibros;

    public ListaLibrosBiblioteca() {
        listLibros = new ArrayList<>();
        Libro libro1 = new Libro("MÉTODOS NUMÉRICOS PARA INGENIERÍA", "ALPHA",
                "Libro", "Tapa blanda", "ENRIQUE VILCHEZ QUESADA",
                "Matemáticas", "9789587788914", 150000, 12);
        
        Libro libro2 = new Libro("INTRODUCCIÓN A LA INGENIERÍA ESPACIAL", "ALPHA",
                "Libro", "Tapa blanda", "DANIEL PORTNOY",
                "Ingeniería", "9789587788792", 100000, 10);
        
        Libro libro3 = new Libro("MITOS Y LEYENDAS ANTIGUO EGIPTO", "ALMA",
                "Libro", "Tapa dura", "IAN STEWART",
                "Mitologia", "9788419599339", 120000, 8);
        
        Libro libro4 = new Libro("EVA MORDIO LA MANZANA", "SIN FRONTERAS",
                "Libro", "Tapa blanda", "FLAVIA DOS SANTOS",
                "Matemáticas", "9786287667723", 150000, 12);
        listLibros.add(libro1);
        listLibros.add(libro2);
        listLibros.add(libro3);
        listLibros.add(libro4);
    }

    public ArrayList<Libro> getListLibros() {
        return listLibros;
    }

    public void setListLibros(ArrayList<Libro> listLibros) {
        this.listLibros = listLibros;
    }
}
