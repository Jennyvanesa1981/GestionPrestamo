
public abstract class ObjEquipos {

    private String Serial;
    private String Marca;
    private float Tamano;
    private float Precio;

    public ObjEquipos(String serial, String marca,
            float tamano, float precio) {

        Serial = serial;
        Marca = marca;
        Tamano = tamano;
        Precio = precio;
    }

    public String getSerial() {
        return Serial;
    }


    public void setSerial(String serial) {

    if (serial == null || serial.trim().isEmpty()) {
        System.out.println("Error: el serial no puede estar vacio.");
        return;
    }

    if (!serial.trim().matches("[\\p{L}\\p{N}]+")) {
        System.out.println(
            "Error: el serial solo permite letras y numeros."
        );
        return;
    }

    Serial = serial.trim();

    System.out.println("Serial actualizado correctamente.");
    }


    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public float getTamano() {
        return Tamano;
    }

    public void setTamano(float tamano) {
        Tamano = tamano;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public abstract String getTipoEquipo();

    public boolean datosValidos() {

        if (Serial == null
        || !Serial.trim().matches("[\\p{L}\\p{N}]+")) {
            return false;
        }

        if (Marca == null
                || !Marca.trim().matches("[\\p{L}]+( [\\p{L}]+)*")) {
            return false;
        }

        if (!Float.isFinite(Tamano) || Tamano <= 0) {
            return false;
        }

        if (!Float.isFinite(Precio) || Precio <= 0) {
            return false;
        }

        return true;
    }
}
