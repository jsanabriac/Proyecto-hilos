package uI;

public class Message {

    public static void imprimirMensajeBienvenida() {
        System.out.println("\t\t\t-------------------------------");
        System.out.println("\t\t\t****BIENVENIDO AL BANCO POO****");
        System.out.println("\t\t\t-------------------------------");
    }

    public static void imprimirMenu() {
        System.out.println("\n\t\t\t\tMENU DE OPCIONES");
        System.out.println("\n|1| Crear un usuario.");
        System.out.println("|2| Acceder a los datos de su cuenta.");
        System.out.println("|3| Modificar datos de su cuenta.");
        System.out.println("|4| Consignar o retirar dinero.");
        System.out.println("|5| Aumento o retencion de fuente.");
        System.out.println("|6| Reporte con los 5 saldos mas altos.");
        System.out.println("|7| Eliminar su cuenta.");
        System.out.println("|8| Salir.");
    }

    public static void imprimirOpcion1() {
        System.out.println("\nCREAR CUENTA");
        System.out.println("Para crear un usuario debemos confirmar que usted no tiene una cuenta existente\npara esto por favor ingrese su identificacion");
        System.out.print("\nIdentificacion: ");
    }

    public static void imprimirOpcion2() {
        System.out.println("\nACCEDE A DATOS DE LA CUENTA");
        System.out.println("Para acceder a su cuenta, por favor ingrese su identificacion.");
        System.out.print("\nIdentificacion: ");
    }

    public static void imprimirOpcion3() {
        System.out.println("\nACTUALIZAR CUENTA");
        System.out.println("Para modificar su cuenta, por favor ingrese su identificacion.");
        System.out.print("\nIdentificacion: ");
    }

    public static void imprimirOpcion4() {
        System.out.println("\nCONSIGNAR O RETIRAR DINERO");
        System.out.println("Para entrar a su cuenta ingrese su identificacion...");
        System.out.print("\nIdentificacion: ");
    }

    public static void imprimirOpcion5() {
        System.out.println("\nAUMENTO O RETENCION DE FUENTE");
        System.out.println("Por favor ingrese su identificacion, para saber si se le debe retener la fuente\n(de un 2.75%), hacer un aumento del 3% o si su saldo permanece igual.");
        System.out.print("Identificacion: ");
    }

    public static void imprimirOpcion6() {
        System.out.println("INFORME DE LOS 5 MAYORES SALDOS EN EL BANCO POO");
        System.out.println("Cargando informe...\n");
    }

    public static void imprimirOpcion7() {
        System.out.println("\nELIMINAR CUENTA");
        System.out.println("Para eliminar su cuenta, por favor ingrese su identificacion.");
        System.out.print("\nIdentificacion: ");
    }

    public static void primerConsignacion() {
        System.out.println("Abonando $100000...");
    }

    public static void cabeceraTabla() {
        System.out.println("|----------------------------------------------------");
        System.out.println("|               INFORME DE SALDOS MAS ALTOS         ");
        System.out.println("|----------------------------------------------------");
        System.out.println("| Numero |              INFO. CLIENTE                ");
        System.out.println("|----------------------------------------------------");
    }
    
    
    public static void retornandoMenu() {
        System.out.println("\nRetornando al menu principal\n\n");
    }

    public static void menuActualizar() {
        System.out.println("\nMENU ACTUALIZAR DATOS");
        System.out.println("\n|1| Actualizar Nombre \t\t\t|2| Actualizar Contraseña\n|3| Actualizar Nombre y Contraseña\t|4| Cancelar y volver al menu principal\n");
        System.out.print("Ingrese el *numero* de la accion que desea realizar ");
    }

    public static void menuConsignarRetirar() {
        System.out.println("\n¿QUE ACCION DESEA REALIZAR?");
        System.out.println("\n|1| Retirar dinero \t\t\t|2| Consignar dinero\n|3| Cancelar y volver al menu principal\n");
        System.out.print("Ingrese el *numero* de la accion que desea realizar ");
    }
}
