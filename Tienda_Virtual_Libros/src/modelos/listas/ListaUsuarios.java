/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.listas;

import java.util.ArrayList;
import java.util.Iterator;
import modelos.Usuario;

public class ListaUsuarios {

  private ArrayList<Usuario> listUsuarios;

    public ListaUsuarios() {
        listUsuarios = new ArrayList<>();
        Usuario usuario = new Usuario("Pedro", "Montes", 
                "prueba@correo.com", "cedula", "123", 1063158246);
        listUsuarios.add(usuario);
        System.out.println(""+usuario.getCorreo());
    }
    
    public boolean existeUsuario(String correo, String contra){
        for (Usuario us : listUsuarios) {
            if(us.getCorreo().equals(correo)&&us.getPass().equals(contra)){
                return true;
            }
        }
        return false;
    }
    
    public Usuario ObtenerUsuario(String correo, String contra){
        for(Usuario aux: listUsuarios){
          if(aux.getCorreo().equals(correo)&&aux.getPass().equals(contra)){
              return aux; 
            }   
        }
        return null;
    }
}
