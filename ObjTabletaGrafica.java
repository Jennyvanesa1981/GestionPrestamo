
public class ObjTabletaGrafica extends ObjEquipos {

    private String Almacenamiento;
    private float Peso;

    public ObjTabletaGrafica(String serial, String marca, float tamano,
            float precio, String almacenamiento, float peso) {

        super(serial, marca, tamano, precio);
        Almacenamiento = almacenamiento;
        Peso = peso;
    }

    public String getAlmacenamiento() {
        return Almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        Almacenamiento = almacenamiento;
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float peso) {
        Peso = peso;
    }

    @Override
    public String getTipoEquipo() {
        return "Tableta Grafica";
    }
}
