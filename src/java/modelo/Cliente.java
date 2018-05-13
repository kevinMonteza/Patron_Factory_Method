/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LABO08
 */
public class Cliente extends Clientes{
    
    public Cliente(String nombre, String apellido, String direccion, String nombreCiudad){
        setNombre(nombre);
        setApellido(apellido);
        setDireccion(direccion);
        setNombreCiudad(nombreCiudad);
    }
    
}
