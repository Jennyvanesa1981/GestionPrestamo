public class ObjTabletaGrafica extends ObjEquipos {

private String Almacenamiento; // 256 GB, 512 GB, 1 TB 
    private float Peso; // Kg


    public ObjTabletaGrafica(String serial, String marca, float tamano, float precio, String almacenamiento, float peso) {
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

    
    
}
