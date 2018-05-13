package modelo;

public class ClienteFactory {
    public Clientes hacerCliente(String nombre, String apellido, String direccion, String nombreCiudad){
        Clientes nuevoCliente = null; //linea feik
        return new Cliente(nombre, apellido, direccion, nombreCiudad);
    }
}
