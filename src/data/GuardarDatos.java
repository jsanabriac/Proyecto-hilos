package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import data.Cliente;
import logicBusiness.TestBanco;
import java.io.*;

public class GuardarDatos {         //El archivo busqueda sirve para encontrar la ubicacion de los archivos dentro de la carpeta del proyecto

    //crea el archivo 
    public static void crearArchivo(TreeMap<String, Cliente> listaClientes) {   //EL metodo se usa en caso de que el archivo haya sido eliminado de la carpeta del proyecto
        FileWriter escribirArchivo = null;
        try {
            //crea el flujo para escribir en el archivo
            File busqueda = new File("clientes.txt");
            escribirArchivo = new FileWriter(busqueda.getAbsolutePath());
            BufferedWriter bufferEscribir = new BufferedWriter(escribirArchivo);
            for (Cliente cliente : listaClientes.values()) {  //escribe los datos en el archivo
                bufferEscribir.write(cliente.getSaldo() + "," + cliente.getIdentificacion() + "," + cliente.getContraseña()
                        + "," + cliente.getNombre() + "," + "\r\n");
            }
            bufferEscribir.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (escribirArchivo != null) {
                try {//cierra el flujo 
                    escribirArchivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void crearArchivoSaldos(ArrayList<Cliente> listaSaldos) {
        FileWriter escribirArchivo = null;
        try {
            //crea el flujo para escribir en el archivo
            File busqueda = new File("saldos.txt");
            escribirArchivo = new FileWriter(busqueda.getAbsolutePath());
            BufferedWriter bufferEscribir = new BufferedWriter(escribirArchivo);
            for (Cliente cliente : listaSaldos) {  //escribe los datos en el archivo
                bufferEscribir.write(cliente.getSaldo() + "," + cliente.getIdentificacion() + "," + cliente.getContraseña()
                        + "," + cliente.getNombre() + "," + "\r\n");
            }
            bufferEscribir.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (escribirArchivo != null) {
                try {//cierra el flujo 
                    escribirArchivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //lee los objetos del archivo
    public static TreeMap<String, Cliente> leerArchivo() {
        // crea el flujo para leer desde el archivo
        File busqueda = new File("clientes.txt");
        File archivo = new File(busqueda.getAbsolutePath());
        TreeMap<String, Cliente> clientesTotal = new TreeMap<>();
        Scanner lector;
        try {
            lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                Scanner delimitar = new Scanner(linea);
                delimitar.useDelimiter("\\s*,\\s*");
                double saldo = Double.parseDouble(delimitar.next());
                Cliente cliente = new Cliente(saldo);

                cliente.setIdentificacion(delimitar.next());
                cliente.setContraseña(delimitar.next());
                cliente.setNombre(delimitar.next());

                clientesTotal.put(cliente.getIdentificacion(), cliente);
            }
            lector.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return clientesTotal;
    }

    public static ArrayList<Cliente> leerArchivoSaldos() {
        // crea el flujo para leer desde el archivo
        File busqueda = new File("saldos.txt");
        File archivo = new File(busqueda.getAbsolutePath());
        ArrayList<Cliente> saldosTotal = new ArrayList<>();
        Scanner lector;
        try {
            lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                Scanner delimitar = new Scanner(linea);
                delimitar.useDelimiter("\\s*,\\s*");
                double saldo = Double.parseDouble(delimitar.next());
                Cliente cliente = new Cliente(saldo);

                cliente.setIdentificacion(delimitar.next());
                cliente.setContraseña(delimitar.next());
                cliente.setNombre(delimitar.next());

                saldosTotal.add(cliente);
            }
            lector.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return saldosTotal;
    }

    //añadir más objetos al archivo
    public static void añadirArchivo(TreeMap<String, Cliente> listaClientes) {
        FileWriter escribirArchivo = null;
        try {
            File busqueda = new File("clientes.txt");
            escribirArchivo = new FileWriter(busqueda.getAbsolutePath(), true);
            BufferedWriter bufferEscribir = new BufferedWriter(escribirArchivo);
            for (Cliente cliente : listaClientes.values()) {
                bufferEscribir.write(cliente.getSaldo() + "," + cliente.getIdentificacion() + "," + cliente.getContraseña()
                        + "," + cliente.getNombre() + "," + "\n");
            }
            bufferEscribir.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (escribirArchivo != null) {
                try {
                    escribirArchivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void añadirArchivoSaldos(ArrayList<Cliente> listaSaldos) {
        FileWriter escribirArchivo = null;
        try {
            File busqueda = new File("saldos.txt");
            escribirArchivo = new FileWriter(busqueda.getAbsolutePath(), true);
            BufferedWriter bufferEscribir = new BufferedWriter(escribirArchivo);
            for (Cliente cliente : listaSaldos) {
                bufferEscribir.write(cliente.getSaldo() + "," + cliente.getIdentificacion() + "," + cliente.getContraseña()
                        + "," + cliente.getNombre() + "," + "\n");
            }
            bufferEscribir.close();
            System.out.println("\nBase de datos actualizada...");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (escribirArchivo != null) {
                try {
                    escribirArchivo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
