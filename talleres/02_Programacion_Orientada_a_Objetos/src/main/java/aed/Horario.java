package aed;

public class Horario {
    private int hora;
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public Horario(Horario horario) {
        hora = horario.hora();
        minutos = horario.minutos();
    }

    public int hora() {
        return hora;
    }

    public int minutos() {
        return minutos;
    }

    @Override
    public String toString() {
        return Integer.toString(hora) + ":" + Integer.toString(minutos);
    }

    @Override
    public boolean equals(Object otro) {
        boolean otroEsNull = (otro == null);
        boolean claseDistinta = otro.getClass() != this.getClass();
        if (otroEsNull || claseDistinta) {
            return false;
        }
        //casteo
        Horario otroHorario = (Horario) otro;
        boolean res = (otroHorario.hora() == hora && otroHorario.minutos() == minutos);
        return res;
    }

}
