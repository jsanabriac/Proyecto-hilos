package data;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;
import uI.Message;

public class Cliente extends Funciones {

    private String nombre;
    private String identificacion;
    private String contraseña;
    private double saldo;

    public Cliente(double saldo) {
        this.saldo = saldo;
    }

    public Cliente(String nombre, String identificacion, String contraseña, double saldo) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.contraseña = contraseña;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Datos del Cliente..." + "\nNombre= " + nombre + "\t\t\t\t\tIdentificacion= " + identificacion
                + "\nContraseña= " + contraseña + "\t\t\t\t\tSaldo= " + saldo;
    }

    public void modificarSaldos(TreeMap<String, Cliente> archivoClientes, ArrayList<Cliente> archivoSaldos, String identificacion, double saldo, Scanner lector) {

        if (archivoClientes.get(identificacion).getSaldo() >= 50000000) {
            System.out.println("\nDebemos generar retencion de fuente en su cuenta...");
            saldo = (archivoClientes.get(identificacion).getSaldo() - (archivoClientes.get(identificacion).getSaldo() * 0.0275));
            System.out.println("Su nuevo saldo es de: " + saldo);
            Cliente cliente = new Cliente(archivoClientes.get(identificacion).getNombre(), identificacion, archivoClientes.get(identificacion).getContraseña(), saldo);
            archivoClientes.put(identificacion, cliente);
            GuardarDatos.añadirArchivo(archivoClientes);
            archivoSaldos.add(cliente);
            GuardarDatos.añadirArchivoSaldos(archivoSaldos);
        } else if (archivoClientes.get(identificacion).getSaldo() >= 1000000) {
            System.out.println("\nSu saldo sera aumentado en un 3%...");
            saldo = (archivoClientes.get(identificacion).getSaldo() * 0.03) + archivoClientes.get(identificacion).getSaldo();
            System.out.println("Su nuevo saldo es de: " + saldo);
            Cliente cliente = new Cliente(archivoClientes.get(identificacion).getNombre(), identificacion, archivoClientes.get(identificacion).getContraseña(), saldo);
            archivoClientes.put(identificacion, cliente);
            GuardarDatos.añadirArchivo(archivoClientes);
            archivoSaldos.add(cliente);
            GuardarDatos.añadirArchivoSaldos(archivoSaldos);

        } else if (archivoClientes.get(identificacion).getSaldo() < 1000000) {
            System.out.println("Su saldo permanecera intacto.");
            Message.retornandoMenu();
        }

    }

    @Override
    public void modificarSaldos(double saldo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actualizarNombre() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void actualizarContraseña() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void actualizarNombreContraseña() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void imprimirInforme() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void Consignar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Retirar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
