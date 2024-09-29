package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }

    public Horario horario() {
        return horario;
    }

    public Fecha fecha() {
        return new Fecha(fecha);
    }

    public String mensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return mensaje + " @ " + Integer.toString(fecha.dia()) +
        "/" + Integer.toString(fecha.mes()) +" "+ 
        Integer.toString(horario.hora()) + ":" + Integer.toString(horario.minutos());
    }

    @Override
    public boolean equals(Object otro) {
        // Implementar
        return true;
    }

}
