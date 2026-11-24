
import java.util.Stack;

public class PilaDevoluciones {

    private Stack<ObjEstudiantes> devoluciones;

    public PilaDevoluciones() {
        devoluciones = new Stack<>();
    }

    public boolean registrarDevolucion(ObjEstudiantes estudiante) {

        if (estudiante == null) {
            return false;
        }

        devoluciones.push(estudiante);
        return true;
    }

    public ObjEstudiantes consultarUltimaDevolucion() {

        if (devoluciones.isEmpty()) {
            return null;
        }

        return devoluciones.peek();
    }

    public ObjEstudiantes retirarUltimaDevolucion() {

        if (devoluciones.isEmpty()) {
            return null;
        }

        return devoluciones.pop();
    }

    public boolean estaVacia() {
        return devoluciones.isEmpty();
    }

    public int cantidadDevoluciones() {
        return devoluciones.size();
    }
}
