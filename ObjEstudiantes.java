
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

    public ObjEstudiantes() {
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
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

        if (Cedula == null || !Cedula.matches("[0-9]{6,10}")) {
            return false;
        }

        if (Nombre == null || Nombre.trim().isEmpty()) {
            return false;
        }

        if (Apellido == null || Apellido.trim().isEmpty()) {
            return false;
        }

        if (Telefono == null || !Telefono.matches("[0-9]{7,10}")) {
            return false;
        }

        return true;
    }
}
