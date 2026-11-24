import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class GestionPrestamo {

    private Scanner sc;
    private Validaciones validaciones;


private ArrayList<ObjEstudiantesIngenieria> ingenieros;
private ArrayList<ObjEstudianteDiseno> disenadores;
private ArrayList<ObjComputadorPortatil> portatil;
private ArrayList<ObjTabletaGrafica> tableta;

private ArrayList<ObjEstudiantesIngenieria> estudiantesIngenieria;
private ArrayList<ObjEstudianteDiseno> estudiantesDiseno;
private ArrayList<ObjEquipos> inventarioEquipos;
private ArrayList<String> prestamosActivos;
private HashMap<Integer, String> serialesDiseno;
private ColaPrestamos colaPrestamos;
private PilaDevoluciones pilaDevoluciones;


public GestionPrestamo() {
    this.sc = new Scanner(System.in);
    this.validaciones = new Validaciones(sc);

    ingenieros = new ArrayList<>();
    disenadores = new ArrayList<>();
    portatil = new ArrayList<>();
    tableta = new ArrayList<>();

    estudiantesIngenieria = ingenieros;
    estudiantesDiseno = disenadores;
    inventarioEquipos = new ArrayList<>();
    prestamosActivos = new ArrayList<>();
    serialesDiseno = new HashMap<>();
    colaPrestamos = new ColaPrestamos();
    pilaDevoluciones = new PilaDevoluciones();
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
                    menuInventario();
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
                    modificarPrestamo(true);
                    break;

                case 3:
                    devolverEquipo(true);
                    break;

                case 4:
                    buscarEquipo();
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
                    modificarPrestamo(false);
                    break;

                case 3:
                    devolverEquipo(false);
                    break;

                case 4:
                    buscarEquipo();
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

        String serial = validaciones.leerSerial(
            "Ingrese serial del equipo: "
        );

        ObjEstudiantesIngenieria estudiante =
            new ObjEstudiantesIngenieria(
                cedula, nombre, apellido, telefono,
                semestre, promedio, serial
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
            1, Integer.MAX_VALUE);

        String serialReal = validaciones.leerSerial(
        "Ingrese serial real del equipo: ");


            if (!relacionarSerialDiseno(serial, serialReal)) {
        return false;
        }


        ObjEstudianteDiseno estudiante =
            new ObjEstudianteDiseno(
                cedula, nombre, apellido, telefono,
                modalidad, asignaturas, serial);

            boolean registrado = registrarEstudianteDiseno(estudiante);
            if (!registrado) {
                serialesDiseno.remove(serial);
        return false;
        }

    return true;

    }


    public boolean registrarEstudianteIngenieria(
        ObjEstudiantesIngenieria estudiante) {

    if (estudiante == null || !estudiante.datosValidos()) {
        System.out.println("Datos invalidos del estudiante de Ingenieria");
        return false;
    }

    if (cedulaRegistrada(estudiante.getCedula())) {
        System.out.println("La cedula ya esta registrada");
        return false;
    }

    boolean equipoExiste = false;
    boolean equipoPrestado = false;

    for (ObjEquipos equipo : inventarioEquipos) {

        if (equipo.getSerial().equalsIgnoreCase(
                estudiante.getSerialEquipo())) {

            equipoExiste = true;
            break;
        }
    }

    if (!equipoExiste) {
        System.out.println("El equipo no existe en el inventario");
        return false;
    }

    for (ObjEstudiantesIngenieria registrado : estudiantesIngenieria) {

        if (prestamosActivos.contains(registrado.getCedula())
                && registrado.getSerialEquipo().equalsIgnoreCase(
                    estudiante.getSerialEquipo())) {

            equipoPrestado = true;
            break;
        }
    }

    for (ObjEstudianteDiseno registrado : estudiantesDiseno) {

        String serialReal = serialesDiseno.get(
            registrado.getSerialEquipo()
        );

        if (prestamosActivos.contains(registrado.getCedula())
                && serialReal != null
                && serialReal.equalsIgnoreCase(
                    estudiante.getSerialEquipo())) {

            equipoPrestado = true;
            break;
        }
    }

    if (equipoPrestado) {

        ObjSolicitudPrestamo solicitud =
            new ObjSolicitudPrestamo(
                estudiante,
                estudiante.getSerialEquipo(),
                true
            );

        boolean agregado = colaPrestamos.agregarSolicitud(solicitud);

        if (agregado) {
            System.out.println("El equipo esta prestado");
            System.out.println("Solicitud agregada a la cola de espera");
        } else {
            System.out.println("No se pudo agregar la solicitud");
        }

        return agregado;
    }

    estudiantesIngenieria.add(estudiante);
    prestamosActivos.add(estudiante.getCedula());

    System.out.println("Prestamo de Ingenieria registrado correctamente");

    return true;
    }


    public boolean registrarEstudianteDiseno(
        ObjEstudianteDiseno estudiante) {

    if (estudiante == null || !estudiante.datosValidos()) {
        System.out.println("Datos invalidos del estudiante de Diseno");
        return false;
    }

    if (cedulaRegistrada(estudiante.getCedula())) {
        System.out.println("La cedula ya esta registrada");
        return false;
    }

    int serialNumerico = estudiante.getSerialEquipo();

    String serialReal = serialesDiseno.get(serialNumerico);

    if (serialReal == null) {
        System.out.println("El serial numerico no tiene un equipo relacionado");
        return false;
    }

    boolean equipoExiste = false;
    boolean equipoPrestado = false;

    for (ObjEquipos equipo : inventarioEquipos) {

        if (equipo.getSerial().equalsIgnoreCase(serialReal)) {
            equipoExiste = true;
            break;
        }
    }

    if (!equipoExiste) {
        System.out.println("El equipo no existe en el inventario");
        return false;
    }

    for (ObjEstudiantesIngenieria registrado : estudiantesIngenieria) {

        if (prestamosActivos.contains(registrado.getCedula())
                && registrado.getSerialEquipo().equalsIgnoreCase(serialReal)) {

            equipoPrestado = true;
            break;
        }
    }

    for (ObjEstudianteDiseno registrado : estudiantesDiseno) {

        if (prestamosActivos.contains(registrado.getCedula())) {

            String otroSerial = serialesDiseno.get(
                registrado.getSerialEquipo()
            );

            if (otroSerial != null
                    && otroSerial.equalsIgnoreCase(serialReal)) {

                equipoPrestado = true;
                break;
            }
        }
    }

    if (equipoPrestado) {

        ObjSolicitudPrestamo solicitud =
            new ObjSolicitudPrestamo(
                estudiante,
                serialReal,
                false
            );

        boolean agregado = colaPrestamos.agregarSolicitud(solicitud);

        if (agregado) {
            System.out.println("El equipo esta prestado");
            System.out.println("Solicitud agregada a la cola de espera");
        } else {
            System.out.println("No se pudo agregar la solicitud");
        }

        return agregado;
    }

    estudiantesDiseno.add(estudiante);
    prestamosActivos.add(estudiante.getCedula());

    System.out.println("Prestamo de Diseno registrado correctamente");

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
public boolean menuEquipos() {

        int opcion;

        do {
            System.out.println("\nMENU DE EQUIPOS ELECTRONICOS");
            System.out.println("1. Registrar Computador Portatil");
            System.out.println("2. Registrar Tableta Grafica");
            System.out.println("3. Imprimir inventario");
            System.out.println("4. Volver al menu principal");

            opcion = validaciones.leerEntero(
                "Seleccione una opcion: ", 1, 4
            );

            switch (opcion) {
                case 1:
                    ingresarComputadorPortatil();
                    break;

                case 2:
                    ingresarTabletaGrafica();
                    break;

                case 3:
                    imprimirInventario();
                    break;

                case 4:
                    System.out.println("Volviendo al menu principal");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        } while (opcion != 4);

        return true;
    }

    public String seleccionarSistemaOperativo() {

        System.out.println("\nSISTEMA OPERATIVO");
        System.out.println("1. Windows 7");
        System.out.println("2. Windows 10");
        System.out.println("3. Windows 11");

        int opcion = validaciones.leerEntero(
            "Seleccione sistema operativo: ", 1, 3
        );

        switch (opcion) {
            case 1:
                return "Windows 7";

            case 2:
                return "Windows 10";

            case 3:
                return "Windows 11";

            default:
                return "";
        }
    }

    public String seleccionarProcesador() {
        System.out.println("\nPROCESADOR");
        System.out.println("1. AMD Ryzen");
        System.out.println("2. Intel Core i5");

        int opcion = validaciones.leerEntero(
            "Seleccione procesador: ", 1, 2
        );

        switch (opcion) {
            case 1:
                return "AMD Ryzen";
            case 2:
                return "Intel Core i5";
            default:
                return "";
        }
    }

    public String seleccionarAlmacenamiento() {

        System.out.println("\nALMACENAMIENTO");
        System.out.println("1. 256 GB");
        System.out.println("2. 512 GB");
        System.out.println("3. 1 TB");

        int opcion = validaciones.leerEntero(
            "Seleccione almacenamiento: ", 1, 3
        );

        switch (opcion) {
            case 1:
                return "256 GB";

            case 2:
                return "512 GB";

            case 3:
                return "1 TB";

            default:
                return "";
        }
    }

    public boolean ingresarComputadorPortatil() {

        System.out.println("\nREGISTRO DE COMPUTADOR PORTATIL");

        String serial = validaciones.leerSerial(
            "Ingrese serial: "
        );

        String marca = validaciones.leerNombreApellido(
            "Ingrese marca: "
        );

        float tamano = validaciones.leerDecimal(
            "Ingrese tamano en pulgadas: ",
            0.01f, Float.MAX_VALUE
        );

        float precio = validaciones.leerDecimal(
            "Ingrese precio: ",
            0.01f, Float.MAX_VALUE
        );

        String sistemaOperativo = seleccionarSistemaOperativo();

        String procesador = seleccionarProcesador();

        ObjComputadorPortatil computador =
            new ObjComputadorPortatil(
                serial,
                marca,
                tamano,
                precio,
                sistemaOperativo,
                procesador
            );

        return registrarEquipoInventario(computador);
    }


    public boolean ingresarTabletaGrafica() {

        System.out.println("\nREGISTRO DE TABLETA GRAFICA");

        String serial = validaciones.leerSerial(
            "Ingrese serial solo con letras: "
        );

        String marca = validaciones.leerNombreApellido(
            "Ingrese marca: "
        );

        float tamano = validaciones.leerDecimal(
            "Ingrese tamano en pulgadas: ",
            0.01f, Float.MAX_VALUE
        );

        float precio = validaciones.leerDecimal(
            "Ingrese precio: ",
            0.01f, Float.MAX_VALUE
        );

        String almacenamiento = seleccionarAlmacenamiento();

        float peso = validaciones.leerDecimal(
            "Ingrese peso en kilogramos: ",
            0.01f, Float.MAX_VALUE
        );

        ObjTabletaGrafica tableta =
            new ObjTabletaGrafica(
                serial,
                marca,
                tamano,
                precio,
                almacenamiento,
                peso
            );

        return registrarEquipoInventario(tableta);
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
            inventarioEquipos.add(equipo);
            System.out.println("Computador portatil agregado al inventario");
            return true;
        }

        if (equipo instanceof ObjTabletaGrafica) {

            tableta.add((ObjTabletaGrafica) equipo);
            inventarioEquipos.add(equipo);
            System.out.println("Tableta grafica agregada al inventario");
            return true;
        }

        System.out.println("Tipo de equipo no soportado");
        return false;
    }


        public boolean eliminarEstudianteIngenieria(int posicion) {

        if (posicion < 0 || posicion >= ingenieros.size()) {
        System.out.println("Posicion de estudiante invalida");
        return false;
        }

        ObjEstudiantesIngenieria estudiante = ingenieros.get(posicion);

         prestamosActivos.remove(estudiante.getCedula());
        ingenieros.remove(posicion);

        System.out.println("Estudiante de Ingenieria eliminado correctamente");
        System.out.println("El equipo permanece disponible en el inventario");

                return true;
            }

        public boolean eliminarEstudianteDiseno(int posicion) {

        if (posicion < 0 || posicion >= disenadores.size()) {
        System.out.println("Posicion de estudiante invalida");
        return false;
        }

        ObjEstudianteDiseno estudiante = disenadores.get(posicion);

        prestamosActivos.remove(estudiante.getCedula());
        serialesDiseno.remove(estudiante.getSerialEquipo());
        disenadores.remove(posicion);

        System.out.println("Estudiante de Diseno eliminado correctamente");
        System.out.println("El equipo permanece disponible en el inventario");

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
            System.out.println("Nombre: " + estudiante.getNombre()
                    + " " + estudiante.getApellido());
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
            System.out.println("Nombre: " + estudiante.getNombre()
                    + " " + estudiante.getApellido());
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

        System.out.println("\nRESUMEN DEL INVENTARIO");
        System.out.println("Total estudiantes de Ingenieria: " + ingenieros.size());
        System.out.println("Total estudiantes de Diseno: " + disenadores.size());
        System.out.println("Total computadores portatiles: " + portatil.size());
        System.out.println("Total tabletas graficas: " + tableta.size());
        System.out.println("Total equipos: " + inventarioEquipos.size());

        return true;
    }

    public boolean menuInventario() {

    imprimirInventario();

    System.out.println("\nGESTION DE INVENTARIO");
    System.out.println("1. Registrar equipos");
    System.out.println("2. Volver al menu principal");

    int opcion = validaciones.leerEntero(
            "Seleccione una opcion: ", 1, 2);

    if (opcion == 1) {
        return menuEquipos();
    }

    return true;
    }

    public ObjEstudiantes buscarPrestamoActivo(
        String dato, boolean ingenieria) {

    if (dato == null || dato.trim().isEmpty()) {
        return null;
    }

    dato = dato.trim();

    if (ingenieria) {

        for (ObjEstudiantesIngenieria estudiante : estudiantesIngenieria) {

            if (prestamosActivos.contains(estudiante.getCedula())
                    && (estudiante.getCedula().equals(dato)
                    || estudiante.getSerialEquipo().equalsIgnoreCase(dato))) {

                return estudiante;
            }
        }

    } else {

        for (ObjEstudianteDiseno estudiante : estudiantesDiseno) {

            if (!prestamosActivos.contains(estudiante.getCedula())) {
                continue;
            }

            String serialNumerico = String.valueOf(
                estudiante.getSerialEquipo()
            );

            String serialReal = serialesDiseno.get(
                estudiante.getSerialEquipo()
            );

            if (estudiante.getCedula().equals(dato)
                    || serialNumerico.equals(dato)
                    || (serialReal != null
                    && serialReal.equalsIgnoreCase(dato))) {
                return estudiante;
            }
        }
    }

    return null;
}

public ObjEstudiantes buscarPrestamoActivo(String cedula) {

    ObjEstudiantes estudiante = buscarPrestamoActivo(cedula, true);

    if (estudiante != null) {
        return estudiante;
    }

    return buscarPrestamoActivo(cedula, false);
}




public boolean modificarPrestamo(boolean ingenieria) {

    System.out.println("\nMODIFICAR PRESTAMO");

    String dato = validaciones.leerTexto(
        "Ingrese cedula o serial del equipo: "
    );

    ObjEstudiantes estudiante = buscarPrestamoActivo(
        dato, ingenieria
    );

    if (estudiante == null) {
        System.out.println("No se encontro un prestamo activo");
        return false;
    }

    int opcion;

    do {
        System.out.println("\nDATOS QUE PUEDE MODIFICAR");
        System.out.println("1. Nombre");
        System.out.println("2. Apellido");
        System.out.println("3. Telefono");
        System.out.println("4. Volver");

        opcion = validaciones.leerEntero(
            "Seleccione una opcion: ", 1, 4
        );

        switch (opcion) {

            case 1:
                String nombre = validaciones.leerNombreApellido(
                    "Ingrese el nuevo nombre: "
                );

                estudiante.setNombre(nombre);
                System.out.println("Nombre actualizado correctamente");
                break;

            case 2:
                String apellido = validaciones.leerNombreApellido(
                    "Ingrese el nuevo apellido: "
                );

                estudiante.setApellido(apellido);
                System.out.println("Apellido actualizado correctamente");
                break;

            case 3:
                String telefono = validaciones.leerTelefono(
                    "Ingrese el nuevo telefono: "
                );

                estudiante.setTelefono(telefono);
                System.out.println("Telefono actualizado correctamente");
                break;

            case 4:
                System.out.println("Finalizando modificacion");
                break;
        }

    } while (opcion != 4);

    return true;
    }


    public boolean devolverEquipo(boolean ingenieria) {

    System.out.println("\nDEVOLUCION DE EQUIPO");

    String dato = validaciones.leerTexto(
        "Ingrese cedula o serial del equipo: "
    );

    ObjEstudiantes estudiante = buscarPrestamoActivo(
        dato, ingenieria
    );

    if (estudiante == null) {
        System.out.println("No se encontro un prestamo activo");
        return false;
    }

    String cedula = estudiante.getCedula();
    String serialEquipo;

    boolean eliminado;

    if (ingenieria) {

        ObjEstudiantesIngenieria estudianteIngenieria =
            (ObjEstudiantesIngenieria) estudiante;

        serialEquipo = estudianteIngenieria.getSerialEquipo();

        eliminado = estudiantesIngenieria.remove(
            estudianteIngenieria
        );

    } else {

        ObjEstudianteDiseno estudianteDiseno =
            (ObjEstudianteDiseno) estudiante;

        serialEquipo = serialesDiseno.get(
            estudianteDiseno.getSerialEquipo()
        );

        eliminado = estudiantesDiseno.remove(estudianteDiseno);

        if (eliminado) {
            serialesDiseno.remove(estudianteDiseno.getSerialEquipo());
        }
    }

    if (!eliminado) {
        System.out.println("No se pudo eliminar el registro del prestamo");
        return false;
    }

    prestamosActivos.remove(cedula);

    pilaDevoluciones.registrarDevolucion(estudiante);

    System.out.println("Devolucion registrada correctamente");
    System.out.println("Cedula: " + cedula);

    boolean atendido = atenderSolicitudPendiente(serialEquipo);

    if (atendido) {
        System.out.println("El equipo fue asignado al siguiente estudiante");
    } else {
        System.out.println("El equipo queda disponible");
    }

    return true;
    }


    public boolean buscarEquipo() {

    System.out.println("\nBUSCAR EQUIPO");

    String serial = validaciones.leerTexto(
        "Ingrese serial real o numerico del equipo: "
    );

    for (ObjEquipos equipo : inventarioEquipos) {

        boolean coincide = equipo.getSerial().equalsIgnoreCase(serial);

        if (!coincide) {
            for (Integer numero : serialesDiseno.keySet()) {
                String serialRelacionado = serialesDiseno.get(numero);

                if (String.valueOf(numero).equals(serial)
                        && serialRelacionado != null
                        && serialRelacionado.equalsIgnoreCase(equipo.getSerial())) {
                    coincide = true;
                    break;
                }
            }
        }

        if (!coincide) {
            continue;
        }

        System.out.println("\nEQUIPO ENCONTRADO");
        System.out.println("Serial: " + equipo.getSerial());
        System.out.println("Tipo: " + equipo.getTipoEquipo());
        System.out.println("Marca: " + equipo.getMarca());
        System.out.println("Tamano: " + equipo.getTamano() + " pulgadas");
        System.out.println("Precio: " + equipo.getPrecio());

        if (equipo instanceof ObjComputadorPortatil) {

            ObjComputadorPortatil computador =
                (ObjComputadorPortatil) equipo;

            System.out.println(
                "Sistema operativo: " + computador.getSistemaOperativo()
            );

            System.out.println(
                "Procesador: " + computador.getProcesador()
            );

        } else if (equipo instanceof ObjTabletaGrafica) {

            ObjTabletaGrafica tableta =
                (ObjTabletaGrafica) equipo;

            System.out.println(
                "Almacenamiento: " + tableta.getAlmacenamiento()
            );

            System.out.println(
                "Peso: " + tableta.getPeso() + " kg"
            );
        }

        boolean prestado = false;

        for (ObjEstudiantesIngenieria estudiante : estudiantesIngenieria) {

            if (prestamosActivos.contains(estudiante.getCedula())
                    && estudiante.getSerialEquipo().equalsIgnoreCase(
                        equipo.getSerial())) {

                prestado = true;

                System.out.println("Estado: Prestado");
                System.out.println("Cedula: " + estudiante.getCedula());
                System.out.println(
                    "Estudiante: " + estudiante.getNombre()
                    + " " + estudiante.getApellido()
                );

                break;
            }
        }

        if (!prestado) {

            for (ObjEstudianteDiseno estudiante : estudiantesDiseno) {

                String serialRelacionado = serialesDiseno.get(
                    estudiante.getSerialEquipo()
                );

                if (prestamosActivos.contains(estudiante.getCedula())
                        && serialRelacionado != null
                        && serialRelacionado.equalsIgnoreCase(
                            equipo.getSerial())) {

                    prestado = true;

                    System.out.println("Estado: Prestado");
                    System.out.println("Cedula: " + estudiante.getCedula());
                    System.out.println(
                        "Estudiante: " + estudiante.getNombre()
                        + " " + estudiante.getApellido()
                    );

                    break;
                }
            }
        }

        if (!prestado) {
            System.out.println("Estado: Disponible");
        }

        return true;
    }

    System.out.println("Equipo no encontrado en el inventario");
    return false;
    }


    public boolean relacionarSerialDiseno(
        int serialNumerico, String serialEquipo) {

    if (serialNumerico <= 0 || serialEquipo == null
            || serialEquipo.trim().isEmpty()) {
        System.out.println("Datos de serial invalidos");
        return false;
    }

    if (serialesDiseno.containsKey(serialNumerico)) {
        System.out.println("El serial numerico ya esta relacionado");
        return false;
    }

    ObjEquipos equipoEncontrado = null;

    for (ObjEquipos equipo : inventarioEquipos) {
        if (equipo.getSerial().equalsIgnoreCase(serialEquipo.trim())) {
            equipoEncontrado = equipo;
            break;
        }
    }

    if (equipoEncontrado == null) {
        System.out.println("El equipo no existe en el inventario");
        return false;
    }

    for (String serialRelacionado : serialesDiseno.values()) {
        if (serialRelacionado.equalsIgnoreCase(
                equipoEncontrado.getSerial())) {

            System.out.println(
                "El equipo ya tiene un serial numerico relacionado"
            );
            return false;
        }
    }

    serialesDiseno.put(
        serialNumerico, equipoEncontrado.getSerial()
    );

    System.out.println("Seriales relacionados correctamente");
    return true;
    }



    public boolean atenderSolicitudPendiente(String serialEquipo) {

    if (serialEquipo == null || serialEquipo.trim().isEmpty()) {
        return false;
    }

    ObjSolicitudPrestamo solicitud =
        colaPrestamos.atenderSolicitud(serialEquipo);

    if (solicitud == null) {
        return false;
    }

    ObjEstudiantes estudiante = solicitud.getEstudiante();

    if (estudiante == null || !estudiante.datosValidos()) {
        return false;
    }

    if (prestamosActivos.contains(estudiante.getCedula())) {
        return false;
    }

    if (solicitud.isIngenieria()) {

        if (!(estudiante instanceof ObjEstudiantesIngenieria)) {
            return false;
        }

        ObjEstudiantesIngenieria ingeniero =
            (ObjEstudiantesIngenieria) estudiante;

        if (!ingeniero.getSerialEquipo().equalsIgnoreCase(serialEquipo)) {
            return false;
        }

        estudiantesIngenieria.add(ingeniero);

    } else {

        if (!(estudiante instanceof ObjEstudianteDiseno)) {
            return false;
        }

        ObjEstudianteDiseno disenador =
            (ObjEstudianteDiseno) estudiante;

        if (disenador.getSerialEquipo() <= 0) {
            return false;
        }

        serialesDiseno.put(
            disenador.getSerialEquipo(), serialEquipo
        );

        estudiantesDiseno.add(disenador);
    }

    prestamosActivos.add(estudiante.getCedula());

    System.out.println("Solicitud pendiente atendida correctamente");
    System.out.println("Estudiante: " + estudiante.getNombre());
    System.out.println("Cedula: " + estudiante.getCedula());
    System.out.println("Equipo asignado: " + serialEquipo);

    return true;
}




}
