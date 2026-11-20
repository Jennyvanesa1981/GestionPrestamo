public class ObjComputadorPortatil extends ObjEquipos {

    private String SistemaOperativo; // windows 7, Windows 10, Windows 11 
    private String Procesador;  //	AMD Ryzen, Intel Core i5

   
    public ObjComputadorPortatil(String serial, String marca, float tamaño, float precio, String sistemaOperativo,
            String procesador) {
        super(serial, marca, tamaño, precio);
        SistemaOperativo = sistemaOperativo;
        Procesador = procesador;
    }


    public String getSistemaOperativo() {
        return SistemaOperativo;
    }


    public void setSistemaOperativo(String sistemaOperativo) {
        SistemaOperativo = sistemaOperativo;
    }


    public String getProcesador() {
        return Procesador;
    }


    public void setProcesador(String procesador) {
        Procesador = procesador;
    }
    
}
