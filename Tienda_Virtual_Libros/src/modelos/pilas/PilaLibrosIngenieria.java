/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.pilas;

import java.util.Stack;
import modelos.Libro;

public class PilaLibrosIngenieria {
     private Stack<Libro> pilaLibros;
    
     
     public PilaLibrosIngenieria(){
         
     }
     public Libro guardarLibro(Libro nuevo){
       return pilaLibros.push(nuevo);
    }
    
    public void restarLibro(int cantComprar){
        Libro libroAux = pilaLibros.peek();
        
       if(libroAux.getStock()>=cantComprar){
           int resta = libroAux.getStock()-cantComprar;
           pilaLibros.peek().setStock(resta);
       }
    }
}
