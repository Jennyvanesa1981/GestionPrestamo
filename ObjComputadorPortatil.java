
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

    @Override
    public boolean datosValidos() {

        if (!super.datosValidos()) {
            return false;
        }

        if (SistemaOperativo == null) {
            return false;
        }

        String sistema = SistemaOperativo.trim();

        if (!sistema.equalsIgnoreCase("Windows 7")
                && !sistema.equalsIgnoreCase("Windows 10")
                && !sistema.equalsIgnoreCase("Windows 11")) {
            return false;
        }

        if (Procesador == null) {
            return false;
        }

        String procesador = Procesador.trim();

        if (!procesador.equalsIgnoreCase("AMD Ryzen")
                && !procesador.equalsIgnoreCase("Intel Core i5")) {
            return false;
        }

        return true;
    }
}
