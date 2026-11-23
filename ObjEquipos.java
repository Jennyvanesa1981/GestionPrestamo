
public abstract class ObjEquipos {

    private String Serial;
    private String Marca;
    private float Tamano;
    private float Precio;
    
    public ObjEquipos(String serial, String marca, float tamano, float precio) {
        Serial = serial;
        Marca = marca;
        Tamano = tamano;
        Precio = precio;
    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
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

        if (Serial == null ||
                !Serial.trim().matches("[\\p{L}]+")) {
            return false;
        }

        if (Marca == null ||
                !Marca.trim().matches("[\\p{L}]+( [\\p{L}]+)*")) {
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
