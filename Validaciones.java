
import java.util.Scanner;

public class Validaciones {

    private final Scanner sc;

    public Validaciones(Scanner sc) {
        this.sc = sc;
    }

    public int leerEntero(String mensaje, int minimo, int maximo) {

        System.out.println(mensaje);
        String entrada = sc.nextLine().trim();

        if (entrada.isEmpty()) {
            System.out.println("Error: el campo no puede estar vacio.");
            return leerEntero(mensaje, minimo, maximo);
        }

        int numero;

        try {
            numero = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un numero entero.");
            return leerEntero(mensaje, minimo, maximo);
        }

        if (numero < minimo || numero > maximo) {
            System.out.println("Error: ingrese un numero entre "
                    + minimo + " y " + maximo + ".");
            return leerEntero(mensaje, minimo, maximo);
        }

        return numero;
    }

    public float leerDecimal(String mensaje, float minimo, float maximo) {

        System.out.println(mensaje);

        String entrada = sc.nextLine().trim().replace(',', '.');

        if (entrada.isEmpty()) {
            System.out.println("Error: el campo no puede estar vacio.");
            return leerDecimal(mensaje, minimo, maximo);
        }

        float numero;

        try {
            numero = Float.parseFloat(entrada);
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un valor decimal.");
            return leerDecimal(mensaje, minimo, maximo);
        }

        if (!Float.isFinite(numero)) {
            System.out.println("Error: ingrese un numero valido.");
            return leerDecimal(mensaje, minimo, maximo);
        }

        if (numero < minimo || numero > maximo) {
            System.out.println("Error: el valor debe estar entre "
                    + minimo + " y " + maximo + ".");
            return leerDecimal(mensaje, minimo, maximo);
        }

        return numero;
    }

    public String leerTexto(String mensaje) {

        System.out.println(mensaje);

        String texto = sc.nextLine().trim();

        if (texto.isEmpty()) {
            System.out.println("Error: el campo es obligatorio.");
            return leerTexto(mensaje);
        }

        return texto;
    }

    public String leerSerial(String mensaje) {

        System.out.println(mensaje);

        String serial = sc.nextLine().trim();

        if (serial.isEmpty()) {
            System.out.println("Error: el serial es obligatorio.");
            return leerSerial(mensaje);
        }

        if (!serial.matches("[\\p{L}\\p{N}]+")) {
            System.out.println(
                    "Error: el serial solamente puede contener letras y numeros.");
            return leerSerial(mensaje);
        }

        return serial;
    }

    public String leerCedula(String mensaje) {

        String cedula = leerTexto(mensaje);

        if (cedula.matches("[0-9]{6,10}")) {
            return cedula;
        }

        System.out.println(
                "Error: la cedula debe tener entre 6 y 10 digitos.");

        return leerCedula(mensaje);
    }

    public String leerTelefono(String mensaje) {

        String telefono = leerTexto(mensaje);

        if (telefono.matches("[0-9]{7,10}")) {
            return telefono;
        }

        System.out.println(
                "Error: el telefono debe tener entre 7 y 10 digitos.");

        return leerTelefono(mensaje);
    }

    public String leerNombreApellido(String mensaje) {

        System.out.println(mensaje);

        String texto = sc.nextLine().trim();

        if (texto.isEmpty()) {
            System.out.println("Error: el campo es obligatorio.");
            return leerNombreApellido(mensaje);
        }

        if (!texto.matches("[\\p{L}]+( [\\p{L}]+)*")) {
            System.out.println(
                    "Error: solamente se permiten letras y espacios.");
            return leerNombreApellido(mensaje);
        }

        return texto;
    }
}
