/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

/**
 *
 * @author Juan Mangones
 */
public class Utilidades {

    private static Utilidades instance;

  
    private Utilidades() {
      
    }

    public static Utilidades getInstance() {
      
        if (instance == null) {
            instance = new Utilidades();
        }
        return instance;
    }

}
