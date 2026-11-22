import java.util.Scanner;
import java.util.ArrayList;

public class GestionPrestamo {

    private Scanner sc;
    private Validaciones validaciones;

    private ArrayList<ObjEstudiantesIngenieria> ingenieros;
    private ArrayList<ObjEstudianteDiseno> disenadores;
    private ArrayList<ObjComputadorPortatil> portatil;
    private ArrayList<ObjTabletaGrafica> tableta;

    public GestionPrestamo() {

        this.sc = new Scanner(System.in);
        this.validaciones = new Validaciones(sc);

        ingenieros = new ArrayList<>();
        disenadores = new ArrayList<>();
        portatil = new ArrayList<>();
        tableta = new ArrayList<>();
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

        if (serialAsignado(estudiante.getSerialEquipo())) {

            System.out.println("El serial ya esta asignado a otro estudiante");
            return false;
        }

        ingenieros.add(estudiante);

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

        if (serialAsignado(String.valueOf(estudiante.getSerialEquipo()))) {

            System.out.println("El serial ya esta asignado a otro estudiante");
            return false;
        }

        disenadores.add(estudiante);

        System.out.println(
            "Estudiante de Diseno registrado correctamente"
        );

        return true;
    }

    public boolean cedulaRegistrada(String cedula) {

        if (cedula == null) {
            return false;
        }

        for (ObjEstudiantesIngenieria estudiante : ingenieros) {

            if (estudiante.getCedula().equals(cedula)) {
                return true;
            }
        }

        for (ObjEstudianteDiseno estudiante : disenadores) {

            if (estudiante.getCedula().equals(cedula)) {
                return true;
            }
        }

        return false;
    }

    public boolean serialAsignado(String serial) {

        if (serial == null) {
            return false;
        }

        for (ObjEstudiantesIngenieria estudiante : ingenieros) {

            if (estudiante.getSerialEquipo().equalsIgnoreCase(serial)) {
                return true;
            }
        }

        for (ObjEstudianteDiseno estudiante : disenadores) {

            if (String.valueOf(estudiante.getSerialEquipo())
                    .equalsIgnoreCase(serial)) {
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

        for (ObjComputadorPortatil registrado : portatil) {

            if (registrado.getSerial().equalsIgnoreCase(
                    equipo.getSerial())) {

                System.out.println(
                    "Ya existe un equipo con ese serial"
                );

                return false;
            }
        }

        for (ObjTabletaGrafica registrado : tableta) {

            if (registrado.getSerial().equalsIgnoreCase(
                    equipo.getSerial())) {

                System.out.println(
                    "Ya existe un equipo con ese serial"
                );

                return false;
            }
        }

        if (equipo instanceof ObjComputadorPortatil) {

            portatil.add((ObjComputadorPortatil) equipo);
            System.out.println("Computador portatil agregado al inventario");
            return true;
        }

        if (equipo instanceof ObjTabletaGrafica) {

            tableta.add((ObjTabletaGrafica) equipo);
            System.out.println("Tableta grafica agregada al inventario");
            return true;
        }

        System.out.println("Tipo de equipo no soportado");
        return false;
    }

    public boolean eliminarEstudianteIngenieria(int posicion) {

        if (posicion < 0 || posicion >= ingenieros.size()) {
            return false;
        }

        String serial = ingenieros.get(posicion).getSerialEquipo();
        ingenieros.remove(posicion);

        for (int i = 0; i < portatil.size(); i++) {

            if (portatil.get(i).getSerial().equalsIgnoreCase(serial)) {
                portatil.remove(i);
                break;
            }
        }

        return true;
    }

    public boolean eliminarEstudianteDiseno(int posicion) {

        if (posicion < 0 || posicion >= disenadores.size()) {
            return false;
        }

        String serial = String.valueOf(
            disenadores.get(posicion).getSerialEquipo()
        );
        disenadores.remove(posicion);

        for (int i = 0; i < tableta.size(); i++) {

            if (tableta.get(i).getSerial().equalsIgnoreCase(serial)) {
                tableta.remove(i);
                break;
            }
        }

        return true;
    }

    public boolean imprimirInventario() {

        System.out.println("\nINVENTARIO TOTAL");

        if (ingenieros.isEmpty() && disenadores.isEmpty()
                && portatil.isEmpty() && tableta.isEmpty()) {

            System.out.println("No hay registros en el inventario");
            return false;
        }

        System.out.println("\nESTUDIANTES DE INGENIERIA");

        if (ingenieros.isEmpty()) {

            System.out.println("No hay estudiantes de Ingenieria registrados");
        } else {

            for (ObjEstudiantesIngenieria estudiante : ingenieros) {

                System.out.println("-------------------------");
                System.out.println("Cedula: " + estudiante.getCedula());
                System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
                System.out.println("Telefono: " + estudiante.getTelefono());
                System.out.println("Semestre: " + estudiante.getNumeroSemestre());
                System.out.println("Promedio: " + estudiante.getPromedioAcumulado());
                System.out.println("Serial equipo: " + estudiante.getSerialEquipo());
            }

            System.out.println("-------------------------");
            System.out.println("Total ingenieros: " + ingenieros.size());
        }

        System.out.println("\nESTUDIANTES DE DISENO");

        if (disenadores.isEmpty()) {

            System.out.println("No hay estudiantes de Diseno registrados");
        } else {

            for (ObjEstudianteDiseno estudiante : disenadores) {

                System.out.println("-------------------------");
                System.out.println("Cedula: " + estudiante.getCedula());
                System.out.println("Nombre: " + estudiante.getNombre() + " " + estudiante.getApellido());
                System.out.println("Telefono: " + estudiante.getTelefono());
                System.out.println("Modalidad: " + estudiante.getModalidadEstudio());
                System.out.println("Asignaturas: " + estudiante.getCantidadAsignaturas());
                System.out.println("Serial equipo: " + estudiante.getSerialEquipo());
            }

            System.out.println("-------------------------");
            System.out.println("Total disenadores: " + disenadores.size());
        }

        System.out.println("\nCOMPUTADORES PORTATILES");

        if (portatil.isEmpty()) {

            System.out.println("No hay computadores portatiles registrados");
        } else {

            for (ObjComputadorPortatil equipo : portatil) {

                System.out.println("-------------------------");
                System.out.println("Tipo: " + equipo.getTipoEquipo());
                System.out.println("Serial: " + equipo.getSerial());
                System.out.println("Marca: " + equipo.getMarca());
                System.out.println("Tamano: " + equipo.getTamano());
                System.out.println("Precio: " + equipo.getPrecio());
                System.out.println("Sistema operativo: " + equipo.getSistemaOperativo());
                System.out.println("Procesador: " + equipo.getProcesador());
            }

            System.out.println("-------------------------");
            System.out.println("Total portatiles: " + portatil.size());
        }

        System.out.println("\nTABLETAS GRAFICAS");

        if (tableta.isEmpty()) {

            System.out.println("No hay tabletas graficas registradas");
        } else {

            for (ObjTabletaGrafica equipo : tableta) {

                System.out.println("-------------------------");
                System.out.println("Tipo: " + equipo.getTipoEquipo());
                System.out.println("Serial: " + equipo.getSerial());
                System.out.println("Marca: " + equipo.getMarca());
                System.out.println("Tamano: " + equipo.getTamano());
                System.out.println("Precio: " + equipo.getPrecio());
                System.out.println("Almacenamiento: " + equipo.getAlmacenamiento());
                System.out.println("Peso: " + equipo.getPeso());
            }

            System.out.println("-------------------------");
            System.out.println("Total tabletas: " + tableta.size());
        }

        return true;
    }
}