
public class ObjSolicitudPrestamo {

    private ObjEstudiantes estudiante;
    private String serialEquipo;
    private boolean ingenieria;

    public ObjSolicitudPrestamo(
            ObjEstudiantes estudiante,
            String serialEquipo,
            boolean ingenieria) {

        this.estudiante = estudiante;
        this.serialEquipo = serialEquipo;
        this.ingenieria = ingenieria;
    }

    public ObjEstudiantes getEstudiante() {
        return estudiante;
    }

    public String getSerialEquipo() {
        return serialEquipo;
    }

    public boolean isIngenieria() {
        return ingenieria;
    }

    public boolean datosValidos() {
        return estudiante != null
                && estudiante.datosValidos()
                && serialEquipo != null
                && !serialEquipo.trim().isEmpty();
    }
}
