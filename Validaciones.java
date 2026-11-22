
import java.util.Scanner;

public class Validaciones {

    private final Scanner sc;

    public Validaciones(Scanner sc) {
        this.sc = sc;
    }

    
    public int leerEntero(String mensaje, int minimo, int maximo) {

        System.out.print(mensaje);
        String entrada = sc.nextLine().trim();

        try {
            int numero = Integer.parseInt(entrada);

            if (numero >= minimo && numero <= maximo) {
                return numero;
            }

        } catch (NumberFormatException e) {
            // Se solicita nuevamente el dato
        }

        System.out.println("Error: ingrese un numero valido.");
        return leerEntero(mensaje, minimo, maximo);
    }

    
    public float leerDecimal(String mensaje, float minimo, float maximo) {

        System.out.print(mensaje);
        String entrada = sc.nextLine().trim().replace(',', '.');

        try {
            float numero = Float.parseFloat(entrada);

            if (Float.isFinite(numero)
                    && numero >= minimo
                    && numero <= maximo) {

                return numero;
            }

        } catch (NumberFormatException e) {
            
        }

        System.out.println("Error: ingrese un valor decimal valido.");
        return leerDecimal(mensaje, minimo, maximo);
    }

    
    public String leerTexto(String mensaje) {

        System.out.print(mensaje);
        String texto = sc.nextLine().trim();

        if (!texto.isEmpty()) {
            return texto;
        }

        System.out.println("Error: el campo no puede estar vacio.");
        return leerTexto(mensaje);
    }

    
    public String leerCedula(String mensaje) {

        String cedula = leerTexto(mensaje);

        if (cedula.matches("[0-9]{6,10}")) {
            return cedula;
        }

        System.out.println("Error: la cedula debe tener entre 6 y 10 digitos.");
        return leerCedula(mensaje);
    }

    
    public String leerTelefono(String mensaje) {

        String telefono = leerTexto(mensaje);

        if (telefono.matches("[0-9]{7,10}")) {
            return telefono;
        }

        System.out.println("Error: el telefono debe tener entre 7 y 10 digitos.");
        return leerTelefono(mensaje);
    }
}
