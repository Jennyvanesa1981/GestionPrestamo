
public class ObjEstudianteDiseno extends ObjEstudiantes {

    private String ModalidadEstudio;
    private int CantidadAsignaturas;
    private int SerialEquipo;

    public ObjEstudianteDiseno(String cedula, String nombre,
            String apellido, String telefono, String modalidadEstudio,
            int cantidadAsignaturas, int serialEquipo) {

        super(cedula, nombre, apellido, telefono);
        ModalidadEstudio = modalidadEstudio;
        CantidadAsignaturas = cantidadAsignaturas;
        SerialEquipo = serialEquipo;
    }

    public String getModalidadEstudio() {
        return ModalidadEstudio;
    }

    public void setModalidadEstudio(String modalidadEstudio) {
        ModalidadEstudio = modalidadEstudio;
    }

    public int getCantidadAsignaturas() {
        return CantidadAsignaturas;
    }

    public void setCantidadAsignaturas(int cantidadAsignaturas) {
        CantidadAsignaturas = cantidadAsignaturas;
    }

    public int getSerialEquipo() {
        return SerialEquipo;
    }

    public void setSerialEquipo(int serialEquipo) {
        SerialEquipo = serialEquipo;
    }

    @Override
    public boolean datosValidos() {

        if (!super.datosValidos()) {
            return false;
        }

        if (ModalidadEstudio == null ||
                (!ModalidadEstudio.trim().equalsIgnoreCase("Virtual")
                && !ModalidadEstudio.trim().equalsIgnoreCase("Presencial"))) {
            return false;
        }

        if (CantidadAsignaturas <= 0) {
            return false;
        }

        if (SerialEquipo <= 0) {
            return false;
        }

        return true;
    }
}
