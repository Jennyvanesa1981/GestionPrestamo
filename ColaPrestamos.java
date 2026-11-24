
import java.util.LinkedList;
import java.util.Queue;

public class ColaPrestamos {

    private Queue<ObjSolicitudPrestamo> solicitudes;

    public ColaPrestamos() {
        solicitudes = new LinkedList<>();
    }

    public boolean agregarSolicitud(ObjSolicitudPrestamo solicitud) {

        if (solicitud == null || !solicitud.datosValidos()) {
            return false;
        }

        for (ObjSolicitudPrestamo registrada : solicitudes) {

            if (registrada.getEstudiante().getCedula()
                    .equals(solicitud.getEstudiante().getCedula())) {
                return false;
            }
        }

        return solicitudes.offer(solicitud);
    }

    public ObjSolicitudPrestamo atenderSolicitud() {
        return solicitudes.poll();
    }

    public ObjSolicitudPrestamo consultarPrimero() {
        return solicitudes.peek();
    }

    public boolean estaVacia() {
        return solicitudes.isEmpty();
    }

    public int cantidadSolicitudes() {
        return solicitudes.size();
    }

    public String mostrarSolicitudes() {

        if (solicitudes.isEmpty()) {
            return "No hay solicitudes pendientes.";
        }

        String resultado = "SOLICITUDES PENDIENTES\n";

        for (ObjSolicitudPrestamo solicitud : solicitudes) {

            resultado += "Cedula: "
                    + solicitud.getEstudiante().getCedula()
                    + " | Nombre: "
                    + solicitud.getEstudiante().getNombre()
                    + " | Serial: "
                    + solicitud.getSerialEquipo()
                    + "\n";
        }

        return resultado;
    }

    public ObjSolicitudPrestamo atenderSolicitud(String serialEquipo) {

    if (serialEquipo == null || serialEquipo.trim().isEmpty()) {
        return null;
    }

    java.util.Iterator<ObjSolicitudPrestamo> iterador =
        solicitudes.iterator();

    while (iterador.hasNext()) {

        ObjSolicitudPrestamo solicitud = iterador.next();

        if (solicitud.getSerialEquipo().equalsIgnoreCase(serialEquipo)) {
            iterador.remove();
            return solicitud;
        }
    }

    return null;
    }
}
