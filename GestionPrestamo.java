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
            System.out.println("\nSUBMENU DE DISEÑO");
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

    System.out.println(" REGISTRO DE ESTUDIANTE DE INGENIERIA");

    System.out.println("\n1. DATOS PERSONALES");

    System.out.println("Ingrese Cedula: entre 6 y 10 digitos.");
    String cedula = validaciones.leerCedula(
        "Ingreso cedula: "
    );

    System.out.println("\nNombre: utilice solamente letras.");
    String nombre = validaciones.leerNombreApellido(
        "Ingreso nombre: "
    );

    System.out.println("\nApellido: utilice solamente letras.");
    String apellido = validaciones.leerNombreApellido(
        "Ingreso apellido: "
    );

    System.out.println("\nTelefono: entre 7 y 10 digitos.");
    String telefono = validaciones.leerTelefono(
        "Ingreso telefono: "
    );

    System.out.println("\n2. DATOS ACADEMICOS");

    System.out.println("Semestre: ingrese un numero entre 1 y 20.");
    int semestre = validaciones.leerEntero(
        "Ingreso numero de semestre: ", 1, 20
    );

    System.out.println("Promedio: ingrese un valor entre 0 y 5.");
    float promedio = validaciones.leerDecimal(
        "Ingreso promedio acumulado: ", 0, 5
    );

    System.out.println("\n3. DATOS DEL EQUIPO");

    System.out.println("Ingrese el serial del equipo.");
    String serial = validaciones.leerSerial(
        "Ingreso serial: "
    );

    System.out.println("\n4. VERIFICANDO INFORMACION...");

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

    boolean registrado =
        registrarEstudianteIngenieria(estudiante);

    if (registrado) {

        System.out.println("ESTUDIANTE REGISTRADO CORRECTAMENTE");

    } else {
        System.out.println("\nNo fue posible registrar el prestamo.");
        System.out.println("Verifique los datos y la disponibilidad.");
    }

    return registrado;
    }



    public boolean ingresarEstudianteDiseno() {

    System.out.println(" REGISTRO DE ESTUDIANTE DE DISENO");

    System.out.println("\n1. DATOS PERSONALES");

    System.out.println("Cedula: ingrese entre 6 y 10 digitos.");
    String cedula = validaciones.leerCedula(
        "Ingreso cedula: ");


    System.out.println("\nNombre: utilice solamente letras.");
    String nombre = validaciones.leerNombreApellido(
        "Ingreso nombre: ");

    System.out.println("\nApellido: utilice solamente letras.");
    String apellido = validaciones.leerNombreApellido(
        "Ingreso apellido: ");


    System.out.println("\nTelefono: ingrese entre 7 y 10 digitos.");
    String telefono = validaciones.leerTelefono(
        "Ingreso telefono: ");


    System.out.println("\n2. MODALIDAD DE ESTUDIO");
    System.out.println("Seleccione una modalidad:");
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

    System.out.println("\nModalidad seleccionada: " + modalidad);

    System.out.println("\n3. DATOS ACADEMICOS");

    System.out.println("Cantidad de asignaturas: ingrese entre 1 y 20.");
    int asignaturas = validaciones.leerEntero(
        "Ingrese cantidad de asignaturas: ", 1, 20
    );

    System.out.println("\n4. DATOS DEL EQUIPO");

    System.out.println("Ingrese un numero de identificacion positivo.");
    int serial = validaciones.leerEntero(
        "Ingrese serial numerico del equipo: ",
        1, Integer.MAX_VALUE
    );

    System.out.println("\nIngrese el serial real del equipo.");
    String serialReal = validaciones.leerSerial(
        "Ingrese serial real: "
    );

    System.out.println("\n5. VERIFICANDO RELACION DE SERIALES...");

    if (!relacionarSerialDiseno(serial, serialReal)) {
        System.out.println("No fue posible relacionar los seriales.");
        return false;
    }

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

    boolean registrado = registrarEstudianteDiseno(estudiante);

    if (!registrado) {
        serialesDiseno.remove(serial);

        System.out.println("\nNo fue posible registrar el prestamo.");
        System.out.println("Verifique los datos y la disponibilidad del equipo.");

        return false;
    }

    System.out.println("ESTUDIANTE DE DISENO REGISTRADO");
    System.out.println("CORRECTAMENTE");


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
        System.out.println("El equipo ya se encuentra prestado");
        return false;
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

            System.out.println("El equipo ya se encuentra prestado");
            return false;
        }
    }

    for (ObjEstudianteDiseno registrado : estudiantesDiseno) {

        if (prestamosActivos.contains(registrado.getCedula())) {

            String otroSerial = serialesDiseno.get(
                registrado.getSerialEquipo()
            );

            if (otroSerial != null
                    && otroSerial.equalsIgnoreCase(serialReal)) {

                System.out.println("El equipo ya se encuentra prestado");
                return false;
            }
        }
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

    System.out.println(" REGISTRO DE COMPUTADOR PORTATIL");


    System.out.println("\n1. IDENTIFICACION DEL EQUIPO");

    System.out.println("Serial: utilice letras y numeros, sin espacios.");
    String serial = validaciones.leerSerial(
        "Ingreso serial del computador: "
    );

    System.out.println("\n2. CARACTERISTICAS DEL EQUIPO");

    System.out.println("Marca: ingrese el nombre de la marca.");
    String marca = validaciones.leerNombreApellido(
        "Ingreso marca: "
    );

    System.out.println("Tamano: ingrese un valor numerico mayor que cero.");
    float tamano = validaciones.leerDecimal(
        "Ingreso tamano en pulgadas: ", 0.1f, 100
    );

    System.out.println("Precio: ingrese un valor numerico mayor que cero.");
    float precio = validaciones.leerDecimal(
        "Ingreso precio: ", 0.1f, Float.MAX_VALUE
    );

    System.out.println("\n3. SISTEMA OPERATIVO");

    String sistemaOperativo = seleccionarSistemaOperativo();

    System.out.println("\n4. PROCESADOR");

    String procesador = seleccionarProcesador();

    System.out.println("\n5. VERIFICANDO INFORMACION...");

    ObjComputadorPortatil computador =
        new ObjComputadorPortatil(
            serial,
            marca,
            tamano,
            precio,
            sistemaOperativo,
            procesador
        );

    boolean registrado = registrarEquipoInventario(computador);

    if (registrado) {

        System.out.println("COMPUTADOR PORTATIL REGISTRADO");
        System.out.println("CORRECTAMENTE");

    } else {
        System.out.println("\nNo fue posible registrar el computador.");
        System.out.println("Verifique los datos y el serial.");
    }

    return registrado;
    }


public boolean ingresarTabletaGrafica() {
    System.out.println(" REGISTRO DE TABLETA GRAFICA");


    System.out.println("\n1. IDENTIFICACION DEL EQUIPO");

    System.out.println("Serial: utilice letras y numeros, sin espacios.");
    String serial = validaciones.leerSerial(
        "Ingrese serial de la tableta: "
    );

    System.out.println("\n2. CARACTERISTICAS DEL EQUIPO");

    System.out.println("Marca: ingrese el nombre de la marca.");
    String marca = validaciones.leerNombreApellido(
        "Ingrese marca: "
    );

    System.out.println("Tamano: ingrese un valor numerico mayor que cero.");
    float tamano = validaciones.leerDecimal(
        "Ingrese tamano en pulgadas: ", 0.1f, 100
    );

    System.out.println("Precio: ingrese un valor numerico mayor que cero.");
    float precio = validaciones.leerDecimal(
        "Ingrese precio: ", 0.1f, Float.MAX_VALUE
    );

    System.out.println("\n3. ALMACENAMIENTO");

    String almacenamiento = seleccionarAlmacenamiento();

    System.out.println("\n4. PESO");

    System.out.println("Ingrese el peso en kilogramos.");
    float peso = validaciones.leerDecimal(
        "Ingrese peso: ", 0.01f, 100
    );

    System.out.println("\n5. VERIFICANDO INFORMACION...");

    ObjTabletaGrafica tableta =
        new ObjTabletaGrafica(
            serial,
            marca,
            tamano,
            precio,
            almacenamiento,
            peso
        );

    boolean registrado = registrarEquipoInventario(tableta);

    if (registrado) {
        System.out.println("\n====================================");
        System.out.println("TABLETA GRAFICA REGISTRADA");
        System.out.println("CORRECTAMENTE");
        System.out.println("====================================");
    } else {
        System.out.println("\nNo fue posible registrar la tableta.");
        System.out.println("Verifique los datos y el serial.");
    }

    return registrado;
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

    boolean eliminado;

    if (ingenieria) {

        eliminado = estudiantesIngenieria.remove(
            (ObjEstudiantesIngenieria) estudiante
        );

    } else {

        ObjEstudianteDiseno estudianteDiseno =
            (ObjEstudianteDiseno) estudiante;

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

    System.out.println("Devolucion registrada correctamente");
    System.out.println("Cedula: " + cedula);
    System.out.println("El registro del prestamo fue eliminado");
    System.out.println("El equipo vuelve a estar disponible");

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


}
