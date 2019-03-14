package data;

import uI.Message;
import java.util.Scanner;
import java.util.ArrayList;
import data.Cliente;
import java.util.Collections;                                                       
import java.util.TreeMap;

public abstract class Funciones implements Banco {

    public abstract void modificarSaldos(double saldo);

    public void actualizarNombre(TreeMap<String, Cliente> archivoClientes, ArrayList<Cliente> archivoSaldos, String identificacion, String nombre, Scanner lector) {
        System.out.print("Su nombre actual es: ");
        System.out.println(archivoClientes.get(identificacion).getNombre());
        System.out.println("Recuerde ingresar un nombre y un apellido solamente, de lo contrario su registro sera defectuoso.");
        System.out.print("Ingrese el nombre y apellido nuevo: ");
        nombre = lector.next() + " " + lector.next();
        lector.nextLine();
        Cliente cliente = new Cliente(nombre, archivoClientes.get(identificacion).getIdentificacion(), archivoClientes.get(identificacion).getContraseña(), archivoClientes.get(identificacion).getSaldo());
        archivoClientes.put(identificacion, cliente);
        GuardarDatos.añadirArchivo(archivoClientes);
        archivoSaldos.add(cliente);
        GuardarDatos.añadirArchivoSaldos(archivoSaldos);
        System.out.println("El cambio se ha hecho satisfactoriamente.");
        Message.retornandoMenu();
    }

    public void actualizarContraseña(TreeMap<String, Cliente> archivoClientes, ArrayList<Cliente> archivoSaldos, String identificacion, String contraseña, Scanner lector) {
        System.out.print("Su contraseña actual es: ");
        System.out.println(archivoClientes.get(identificacion).getContraseña());
        System.out.print("Ingrese la contraseña nueva: ");
        contraseña = lector.next();
        Cliente cliente = new Cliente(archivoClientes.get(identificacion).getNombre(), archivoClientes.get(identificacion).getIdentificacion(), contraseña, archivoClientes.get(identificacion).getSaldo());
        archivoClientes.put(identificacion, cliente);
        GuardarDatos.añadirArchivo(archivoClientes);
        archivoSaldos.add(cliente);
        GuardarDatos.añadirArchivoSaldos(archivoSaldos);
        System.out.println("El cambio se ha hecho satisfactoriamente.");
        Message.retornandoMenu();
    }

    public void actualizarNombreContraseña(TreeMap<String, Cliente> archivoClientes, ArrayList<Cliente> archivoSaldos, String nombre, String identificacion, String contraseña, Scanner lector) {
        System.out.print("Su nombre actual es: ");
        System.out.println(archivoClientes.get(identificacion).getNombre());
        System.out.println("Recuerde ingresar un nombre y un apellido solamente, de lo contrario su registro sera defectuoso.");
        System.out.print("Ingrese el nombre y apellido nuevo: ");
        nombre = lector.next() + " " + lector.next();
        lector.nextLine();
        System.out.print("\nSu contraseña actual es: ");
        System.out.println(archivoClientes.get(identificacion).getContraseña());
        System.out.print("Ingrese la contraseña nueva: ");
        contraseña = lector.next();

        Cliente cliente = new Cliente(nombre, archivoClientes.get(identificacion).getIdentificacion(), contraseña, archivoClientes.get(identificacion).getSaldo());
        archivoClientes.put(identificacion, cliente);
        GuardarDatos.añadirArchivo(archivoClientes);
        archivoSaldos.add(cliente);
        GuardarDatos.añadirArchivoSaldos(archivoSaldos);
        System.out.println("El cambio se ha hecho satisfactoriamente.");
        Message.retornandoMenu();
    }

    public void informe(ArrayList<Cliente> archivoSaldos) {

        System.out.println("INFORME DE 5 SALDOS MAS ALTOS");
        Collections.sort(archivoSaldos, new CompararSaldos());

        Message.cabeceraTabla();

        System.out.println("|        |  NOMBRE CLIENTE: " + archivoSaldos.get(0).getNombre());
        System.out.println("|   1.   |  IDENTIFICACION: " + archivoSaldos.get(0).getIdentificacion());
        System.out.println("|        |  SALDO CUENTA:  $" + archivoSaldos.get(0).getSaldo());

        System.out.println("|---------------------------------------------------|");
        System.out.println("|        |  NOMBRE CLIENTE: " + archivoSaldos.get(1).getNombre());
        System.out.println("|   2.   |  IDENTIFICACION: " + archivoSaldos.get(1).getIdentificacion());
        System.out.println("|        |  SALDO CUENTA:  $" + archivoSaldos.get(1).getSaldo());

        System.out.println("|---------------------------------------------------|");
        System.out.println("|        |  NOMBRE CLIENTE: " + archivoSaldos.get(2).getNombre());
        System.out.println("|   3.   |  IDENTIFICACION: " + archivoSaldos.get(2).getIdentificacion());
        System.out.println("|        |  SALDO CUENTA:  $" + archivoSaldos.get(2).getSaldo());

        System.out.println("|---------------------------------------------------|");
        System.out.println("|        |  NOMBRE CLIENTE: " + archivoSaldos.get(3).getNombre());
        System.out.println("|   4.   |  IDENTIFICACION: " + archivoSaldos.get(3).getIdentificacion());
        System.out.println("|        |  SALDO CUENTA:  $" + archivoSaldos.get(3).getSaldo());

        System.out.println("|---------------------------------------------------|");
        System.out.println("|        |  NOMBRE CLIENTE: " + archivoSaldos.get(4).getNombre());
        System.out.println("|   5.   |  IDENTIFICACION: " + archivoSaldos.get(4).getIdentificacion());
        System.out.println("|        |  SALDO CUENTA:  $" + archivoSaldos.get(4).getSaldo());
        System.out.println("|---------------------------------------------------|");

    }

    public void Consignar(TreeMap<String, Cliente> archivoClientes, ArrayList<Cliente> archivoSaldos, String identificacion, double saldo, double consignar, Scanner lector) {
        System.out.println("\nCONSIGNACION- Ingrese la cantidad que desea consignar");
        System.out.print("Cantidad a Consignar: ");
        consignar = lector.nextDouble();
        saldo = (archivoClientes.get(identificacion).getSaldo() + consignar);
        Cliente cliente = new Cliente(archivoClientes.get(identificacion).getNombre(), identificacion, archivoClientes.get(identificacion).getContraseña(), saldo);
        archivoClientes.put(identificacion, cliente);
        GuardarDatos.añadirArchivo(archivoClientes);
        archivoSaldos.add(cliente);
        GuardarDatos.añadirArchivoSaldos(archivoSaldos);
        System.out.println("Su consignacion se ha realizado con exito.");
        Message.retornandoMenu();
    }

    public void Retirar(TreeMap<String, Cliente> archivoClientes, ArrayList<Cliente> archivoSaldos, String identificacion, double saldo, double retirar, Scanner lector) {
        System.out.println("\nRETIRAR- Ingrese la cantidad que desea consignar");
        System.out.println("Cantidad actual de Saldo: " + archivoClientes.get(identificacion).getSaldo());

        do {
            System.out.println("\nRecuerde que la cantidad a retirar debe ser menor a lo que cuenta en su saldo.");
            System.out.print("Cantidad a Retirar: ");
            retirar = lector.nextDouble();
        } while (retirar > archivoClientes.get(identificacion).getSaldo());

        saldo = (archivoClientes.get(identificacion).getSaldo() - retirar);
        Cliente cliente = new Cliente(archivoClientes.get(identificacion).getNombre(), identificacion, archivoClientes.get(identificacion).getContraseña(), saldo);
        archivoClientes.put(identificacion, cliente);
        GuardarDatos.añadirArchivo(archivoClientes);
        archivoSaldos.add(cliente);
        GuardarDatos.añadirArchivoSaldos(archivoSaldos);
        System.out.println("Se ha terminado correctamente el proceso.");
        System.out.println("Cantidad De Saldo Restante: " + saldo);
        Message.retornandoMenu();
    }

}
