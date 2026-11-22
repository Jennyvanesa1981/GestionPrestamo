
public class ObjEstudiantesIngenieria extends ObjEstudiantes {

    private int NumeroSemestre;
    private float PromedioAcumulado;
    private String SerialEquipo;

    public ObjEstudiantesIngenieria(String cedula, String nombre,
            String apellido, String telefono, int numeroSemestre,
            float promedioAcumulado, String serialEquipo) {

        super(cedula, nombre, apellido, telefono);
        NumeroSemestre = numeroSemestre;
        PromedioAcumulado = promedioAcumulado;
        SerialEquipo = serialEquipo;
    }

    public int getNumeroSemestre() {
        return NumeroSemestre;
    }

    public void setNumeroSemestre(int numeroSemestre) {
        NumeroSemestre = numeroSemestre;
    }

    public float getPromedioAcumulado() {
        return PromedioAcumulado;
    }

    public void setPromedioAcumulado(float promedioAcumulado) {
        PromedioAcumulado = promedioAcumulado;
    }

    public String getSerialEquipo() {
        return SerialEquipo;
    }

    public void setSerialEquipo(String serialEquipo) {
        SerialEquipo = serialEquipo;
    }

    @Override
    public boolean datosValidos() {

        if (!super.datosValidos()) {
            return false;
        }

        if (NumeroSemestre <= 0) {
            return false;
        }

        if (!Float.isFinite(PromedioAcumulado)
                || PromedioAcumulado < 0
                || PromedioAcumulado > 5) {
            return false;
        }

        if (SerialEquipo == null || SerialEquipo.trim().isEmpty()) {
            return false;
        }

        return true;
    }
}
