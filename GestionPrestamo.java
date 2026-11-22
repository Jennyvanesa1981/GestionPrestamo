
import java.util.Scanner;
import java.util.ArrayList;

public class GestionPrestamo {

    private Scanner sc;
    private Validaciones validaciones;

    private ArrayList<ObjEstudiantesIngenieria> estudiantesIngenieria;
    private ArrayList<ObjEstudianteDiseno> estudiantesDiseno;
    private ArrayList<ObjEquipos> inventarioEquipos;

    public GestionPrestamo() {

        this.sc = new Scanner(System.in);
        this.validaciones = new Validaciones(sc);

        estudiantesIngenieria = new ArrayList<>();
        estudiantesDiseno = new ArrayList<>();
        inventarioEquipos = new ArrayList<>();
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

            opcion = validaciones.leerEntero(
                "Seleccione una opcion: ", 1, 4
            );

            switch (opcion) {

                case 1:
                    menuIngenieria();
                    break;

                case 2:
                    menuDiseno();
                    break;

                case 3:
                    imprimirInventario();
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

            opcion = validaciones.leerEntero(
                "Seleccione una opcion: ", 1, 5
            );

            switch (opcion) {

                case 1:
                    ingresarEstudianteIngenieria();
                    break;

                case 2:
                    System.out.println("Modificar prestamo Ingenieria");
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

            opcion = validaciones.leerEntero(
                "Seleccione una opcion: ", 1, 5
            );

            switch (opcion) {

                case 1:
                    ingresarEstudianteDiseno();
                    break;

                case 2:
                    System.out.println("Modificar prestamo Diseno");
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

    public boolean ingresarEstudianteIngenieria() {

        System.out.println("\nREGISTRO DE ESTUDIANTE DE INGENIERIA");

        String cedula = validaciones.leerCedula(
            "Ingrese cedula: "
        );

        String nombre = validaciones.leerNombreApellido(
            "Ingrese nombre: "
        );

        String apellido = validaciones.leerNombreApellido(
            "Ingrese apellido: "
        );

        String telefono = validaciones.leerTelefono(
            "Ingrese telefono: "
        );

        int semestre = validaciones.leerEntero(
            "Ingrese numero de semestre: ", 1, 20
        );

        float promedio = validaciones.leerDecimal(
            "Ingrese promedio acumulado (0 a 5): ", 0, 5
        );

        String serial = validaciones.leerTexto(
            "Ingrese serial del equipo: "
        );

        ObjEstudiantesIngenieria estudiante =
            new ObjEstudiantesIngenieria(
                cedula,
                nombre,
                apellido,
                telefono,
                semestre,
                promedio,
                serial
            );

        return registrarEstudianteIngenieria(estudiante);
    }

    public boolean ingresarEstudianteDiseno() {

        System.out.println("\nREGISTRO DE ESTUDIANTE DE DISENO");

        String cedula = validaciones.leerCedula(
            "Ingrese cedula: "
        );

        String nombre = validaciones.leerNombreApellido(
            "Ingrese nombre: "
        );

        String apellido = validaciones.leerNombreApellido(
            "Ingrese apellido: "
        );

        String telefono = validaciones.leerTelefono(
            "Ingrese telefono: "
        );

        System.out.println("\nMODALIDAD DE ESTUDIO");
        System.out.println("1. Virtual");
        System.out.println("2. Presencial");

        int opcionModalidad = validaciones.leerEntero(
            "Seleccione modalidad: ", 1, 2
        );

        String modalidad;

        if (opcionModalidad == 1) {
            modalidad = "Virtual";
        } else {
            modalidad = "Presencial";
        }

        int asignaturas = validaciones.leerEntero(
            "Ingrese cantidad de asignaturas: ", 1, 20
        );

        int serial = validaciones.leerEntero(
            "Ingrese serial numerico del equipo: ",
            1,
            Integer.MAX_VALUE
        );

        ObjEstudianteDiseno estudiante =
            new ObjEstudianteDiseno(
                cedula,
                nombre,
                apellido,
                telefono,
                modalidad,
                asignaturas,
                serial
            );

        return registrarEstudianteDiseno(estudiante);
    }

    public boolean registrarEstudianteIngenieria(
            ObjEstudiantesIngenieria estudiante) {

        if (estudiante == null || !estudiante.datosValidos()) {

            System.out.println(
                "Datos invalidos del estudiante de Ingenieria"
            );

            return false;
        }

        if (cedulaRegistrada(estudiante.getCedula())) {

            System.out.println("La cedula ya esta registrada");
            return false;
        }

        estudiantesIngenieria.add(estudiante);

        System.out.println(
            "Estudiante de Ingenieria registrado correctamente"
        );

        return true;
    }

    public boolean registrarEstudianteDiseno(
            ObjEstudianteDiseno estudiante) {

        if (estudiante == null || !estudiante.datosValidos()) {

            System.out.println(
                "Datos invalidos del estudiante de Diseno"
            );

            return false;
        }

        if (cedulaRegistrada(estudiante.getCedula())) {

            System.out.println("La cedula ya esta registrada");
            return false;
        }

        estudiantesDiseno.add(estudiante);

        System.out.println(
            "Estudiante de Diseno registrado correctamente"
        );

        return true;
    }

    public boolean cedulaRegistrada(String cedula) {

        if (cedula == null) {
            return false;
        }

        for (ObjEstudiantesIngenieria estudiante :
                estudiantesIngenieria) {

            if (estudiante.getCedula().equals(cedula)) {
                return true;
            }
        }

        for (ObjEstudianteDiseno estudiante :
                estudiantesDiseno) {

            if (estudiante.getCedula().equals(cedula)) {
                return true;
            }
        }

        return false;
    }

    public boolean registrarEquipoInventario(ObjEquipos equipo) {

        if (equipo == null || !equipo.datosValidos()) {

            System.out.println(
                "No se puede registrar un equipo con datos invalidos"
            );

            return false;
        }

        for (ObjEquipos registrado : inventarioEquipos) {

            if (registrado.getSerial().equalsIgnoreCase(
                    equipo.getSerial())) {

                System.out.println(
                    "Ya existe un equipo con ese serial"
                );

                return false;
            }
        }

        inventarioEquipos.add(equipo);

        System.out.println("Equipo agregado al inventario");

        return true;
    }

    public boolean imprimirInventario() {

        System.out.println("\nINVENTARIO TOTAL");

        if (inventarioEquipos.isEmpty()) {

            System.out.println("No hay equipos registrados");

            return false;
        }

        for (ObjEquipos equipo : inventarioEquipos) {

            System.out.println("-------------------------");
            System.out.println("Tipo: " + equipo.getTipoEquipo());
            System.out.println("Serial: " + equipo.getSerial());
            System.out.println("Marca: " + equipo.getMarca());
            System.out.println("Tamano: " + equipo.getTamano());
            System.out.println("Precio: " + equipo.getPrecio());
        }

        System.out.println("-------------------------");

        System.out.println(
            "Total de equipos: " + inventarioEquipos.size()
        );

        return true;
    }
}
