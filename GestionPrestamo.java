import java.util.Scanner;

public class GestionPrestamo {
    private Scanner sc;

    public GestionPrestamo() {
        this.sc = new Scanner(System.in);
    }

    public boolean mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\nGESTOR DE PRESTAMOS");
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Estudiantes de Ingenieria");
            System.out.println("2. Estudiantes de Diseno");
            System.out.println("3. Imprimir inventario total");
            System.out.println("4. Salir del programa");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    menuIngenieria();
                    break;
                case 2:
                    menuDiseno();
                    break;
                case 3:
                    System.out.println("Imprimir inventario total");
                    break;
                case 4:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 4);
        return true;
    }

    public boolean menuIngenieria() {
        int opcion;
        do {
            System.out.println("\nSUBMENU DE INGENIERIA");
            System.out.println("1. Registrar prestamo");
            System.out.println("2. Modificar prestamo por serial o cedula");
            System.out.println("3. Devolucion de equipo");
            System.out.println("4. Buscar equipo");
            System.out.println("5. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Registrar prestamo Ingenieria");
                    break;
                case 2:
                    System.out.println("Modificar prestamo por serial o cedula Ingenieria");
                    break;
                case 3:
                    System.out.println("Devolucion de equipo Ingenieria");
                    break;
                case 4:
                    System.out.println("Buscar equipo Ingenieria");
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 5);
        return true;
    }

    public boolean menuDiseno() {
        int opcion;
        do {
            System.out.println("\nSUBMENU DE DISENO");
            System.out.println("1. Registrar prestamo");
            System.out.println("2. Modificar prestamo por serial o cedula");
            System.out.println("3. Devolucion de equipo");
            System.out.println("4. Buscar equipo");
            System.out.println("5. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Registrar prestamo Diseno");
                    break;
                case 2:
                    System.out.println("Modificar prestamo por serial o cedula Diseno");
                    break;
                case 3:
                    System.out.println("Devolucion de equipo Diseno");
                    break;
                case 4:
                    System.out.println("Buscar equipo Diseno");
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (opcion != 5);
        return true;
    }
}
