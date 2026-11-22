
public class ObjComputadorPortatil extends ObjEquipos {

    private String SistemaOperativo;
    private String Procesador;

    public ObjComputadorPortatil(String serial, String marca, float tamano,
            float precio, String sistemaOperativo, String procesador) {

        super(serial, marca, tamano, precio);
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

    @Override
    public String getTipoEquipo() {
        return "Computador Portatil";
    }
}
