

public class ObjEstudiantes {

    private String Cedula;
    private String Nombre;
    private String Apellido;
    private String Telefono;

    public ObjEstudiantes(String cedula, String nombre,
            String apellido, String telefono) {

        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {

    if (cedula == null || !cedula.trim().matches("[0-9]{6,10}")) {
        System.out.println(
            "Error: la cedula debe tener entre 6 y 10 digitos."
        );
        return;
    }

    Cedula = cedula.trim();

    System.out.println("Cedula actualizada correctamente.");
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public boolean datosValidos() {

        if (Cedula == null
                || !Cedula.trim().matches("[0-9]{6,10}")) {
            return false;
        }

        if (Nombre == null
                || !Nombre.trim().matches("[\\p{L}]+( [\\p{L}]+)*")) {
            return false;
        }

        if (Apellido == null
                || !Apellido.trim().matches("[\\p{L}]+( [\\p{L}]+)*")) {
            return false;
        }

        if (Telefono == null
                || !Telefono.trim().matches("[0-9]{7,10}")) {
            return false;
        }

        return true;
    }
}
