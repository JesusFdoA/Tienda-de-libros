/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author lagnu
 */
public class Usuario {
    private String nombres, apellidos, correo, tipo_Documento, contraseña;
    private long numero_Documento;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos, String correo, String tipo_Documento, String contraseña, long numero_Documento) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tipo_Documento = tipo_Documento;
        this.contraseña = contraseña;
        this.numero_Documento = numero_Documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipo_Documento() {
        return tipo_Documento;
    }

    public void setTipo_Documento(String tipo_Documento) {
        this.tipo_Documento = tipo_Documento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public long getNumero_Documento() {
        return numero_Documento;
    }

    public void setNumero_Documento(long numero_Documento) {
        this.numero_Documento = numero_Documento;
    }
    
}
