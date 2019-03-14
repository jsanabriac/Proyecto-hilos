package logicBusiness;

import data.Cliente;
import data.Funciones;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import uI.Message;
import java.util.Scanner;
import data.CompararSaldos;
import data.GuardarDatos;
import data.Banco;

public class TestBanco {

    public static void main(String[] args) throws Exception {

        int numero;
        String identificacion;
        String nombre;
        String contraseña;
        double saldoAux = 0;
        Scanner lector = new Scanner(System.in);

        
        Cliente cliente1 = new Cliente("Andres Lopez", "A10988", "asdsdf", 1230000);
        Cliente cliente2 = new Cliente("Oscar Melo", "A10232", "dsfgg", 83746460);
        Cliente cliente3 = new Cliente("Carlos Urrego", "A10048", "asdsdf", 1500000);
        Cliente cliente4 = new Cliente("Jeremias Ortiz", "A10088", "asdsdf", 400000);
        Cliente cliente5 = new Cliente("Pedro Miranda", "A10099", "asdsdf", 12300000);

        TreeMap<String, Cliente> listaClientes = new TreeMap<>();
        listaClientes.put(cliente1.getIdentificacion(), cliente1);
        listaClientes.put(cliente2.getIdentificacion(), cliente2);
        listaClientes.put(cliente3.getIdentificacion(), cliente3);
        listaClientes.put(cliente4.getIdentificacion(), cliente4);
        listaClientes.put(cliente5.getIdentificacion(), cliente5);

        
        ArrayList<Cliente> mayoresSaldos = new ArrayList<>();
        mayoresSaldos.add(cliente1);
        mayoresSaldos.add(cliente2);
        mayoresSaldos.add(cliente3);
        mayoresSaldos.add(cliente4);
        mayoresSaldos.add(cliente5);
        
       
        TreeMap<String, Cliente> clientesNuevos = new TreeMap<>();
        ArrayList<Cliente> saldosNuevos = new ArrayList<>();

        TreeMap<String, Cliente> archivoClientes = new TreeMap<>();
        archivoClientes = GuardarDatos.leerArchivo();
        
        ArrayList<Cliente> archivoSaldos = new ArrayList<>();
        archivoSaldos = GuardarDatos.leerArchivoSaldos();


        
        for (int i = 0; i <= 1; i++) {

            Message.imprimirMensajeBienvenida();
            Message.imprimirMenu();

            do {
                System.out.print("Seleccione la opcion que desea realizar, hagalo ingresando solamente el numero" + "\nde la opcion a realizar...");
                numero = lector.nextInt();
            } while (numero > 8);

            switch (numero) {

                case 1:
                    Message.imprimirOpcion1();
                    identificacion = lector.next();
                    if (archivoClientes.containsKey(identificacion) == false) {

                        System.out.println("Por favor ingrese los datos que seran solicitados a continuacion, recuerde que \nsi ingreso algun dato mal, debera corregirlo en el menu principal.");
                        System.out.print("\nNombre: ");
                        nombre = lector.next() + " " + lector.next();
                        System.out.print("Contraseña: ");
                        contraseña = lector.next();
                        System.out.println("\n¡¡¡AVISO!!!");
                        System.out.println("Recuerde que para poder crear una cuenta debera abonar $100000 que sera su \nsaldo inicial. Si quiere ingresar mas dinero hagalo desde el menu principal.");

                        Message.primerConsignacion();
                        Cliente cliente = new Cliente(nombre, identificacion, contraseña, 100000);
                        clientesNuevos.put(identificacion, cliente);
                        GuardarDatos.añadirArchivo(clientesNuevos);
                        saldosNuevos.add(cliente);
                        GuardarDatos.añadirArchivoSaldos(saldosNuevos);
                        System.out.println("La cuenta se ha creado correctamente, ya puede hacer uso de nuestros servicios.");
                        Message.retornandoMenu();

                    } else {
                        System.out.println("\nUsted ya tiene una cuenta en nuestro banco, lo retornaremos al menu principal...");
                    }

                    i = 0;
                    break;

                case 2:
                    Message.imprimirOpcion2();
                    identificacion = lector.next();
                    if (archivoClientes.containsKey(identificacion) == true) {
                        System.out.println("\n" + archivoClientes.get(identificacion));
                    } else {
                        System.out.println("Usted no tiene una cuenta en el banco, en el menu podra crear su cuenta.");
                        Message.retornandoMenu();
                    }
                    i = 0;
                    break;

                case 3:
                    Message.imprimirOpcion3();
                    identificacion = lector.next();

                    if (archivoClientes.containsKey(identificacion) == true) {
                        Message.menuActualizar();
                        do {
                            numero = lector.nextInt();
                        } while (numero > 4);

                        switch (numero) {
                            case 1:
                                archivoClientes.get(identificacion).actualizarNombre(archivoClientes, archivoSaldos, identificacion, archivoClientes.get(identificacion).getNombre(), lector);
                                break;
                            case 2:
                                archivoClientes.get(identificacion).actualizarContraseña(archivoClientes, archivoSaldos, identificacion, archivoClientes.get(identificacion).getContraseña(), lector);
                                break;
                            case 3:
                                archivoClientes.get(identificacion).actualizarNombreContraseña(archivoClientes, archivoSaldos, archivoClientes.get(identificacion).getNombre(), identificacion, archivoClientes.get(identificacion).getContraseña(), lector);
                                break;
                            case 4:
                                Message.retornandoMenu();
                                break;
                        }

                    } else {
                        System.out.println("Usted no tiene una cuenta en el banco, en el menu podra crear su cuenta.");
                        Message.retornandoMenu();
                    }

                    i = 0;
                    break;

                case 4:
                    Message.imprimirOpcion4();
                    identificacion = lector.next();

                    if (archivoClientes.containsKey(identificacion) == true) {
                        Message.menuConsignarRetirar();
                        do {
                            numero = lector.nextInt();
                        } while (numero > 3);

                        switch (numero) {
                            case 1:
                                archivoClientes.get(identificacion).Retirar(archivoClientes, archivoSaldos, identificacion, archivoClientes.get(identificacion).getSaldo(), saldoAux, lector);
                                break;
                            case 2:
                                archivoClientes.get(identificacion).Consignar(archivoClientes, archivoSaldos, identificacion, archivoClientes.get(identificacion).getSaldo(), saldoAux, lector);
                                break;
                            case 3:
                                Message.retornandoMenu();
                                break;
                        }

                    } else {
                        System.out.println("Usted no tiene una cuenta en el banco, en el menu podra crear su cuenta.");
                        Message.retornandoMenu();
                    }

                    i = 0;

                    break;

                case 5:
                    Message.imprimirOpcion5();
                    identificacion = lector.next();
                    archivoClientes.get(identificacion).modificarSaldos(archivoClientes, archivoSaldos, identificacion, archivoClientes.get(identificacion).getSaldo(), lector);
                    i = 0;
                    break;

                case 6:

                    Message.imprimirOpcion6();

                    mayoresSaldos.get(0).informe(archivoSaldos);

                    i = 0;

                    break;

                case 7:
                    Message.imprimirOpcion7();
                    identificacion = lector.next();
                    int elegir;
                    System.out.println("Para confirmar la eliminacion de su cuenta, seleccione aceptar de lo contrario seleccione \ncancelar, recuerde que para seleccionar la opcion debe ingresar el numero.");
                    System.out.println("|1| ACEPTAR\t\t\t|2|CANCELAR");
                    do {
                        System.out.print("Eleccion: ");
                        elegir = lector.nextInt();
                    } while (elegir > 2);

                    if (elegir == 1) {
                        Cliente borrar = archivoClientes.remove(identificacion);
                        System.out.println("\nSu cuenta ha sido eliminada satisfactoriamente");
                        Message.retornandoMenu();

                    } else if (elegir == 2) {
                        Message.retornandoMenu();
                    }
                    i = 0;
                    break;

                case 8:

                    System.exit(0);
                    break;

            }

        }

    }

}
