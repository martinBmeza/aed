package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.horario = horario;
    }

    public Horario horario() {
        return horario;
    }

    public Fecha fecha() {
        Fecha f = new Fecha(fecha);
        return f;
    }

    public String mensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        // Implementar
        return "";
    }

    @Override
    public boolean equals(Object otro) {
        // Implementar
        return true;
    }

}
