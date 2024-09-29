package aed;

public class Fecha {
    private int d;
    private int m;

    public Fecha(int dia, int mes) {
        d = dia;
        m = mes;
    }

    public Fecha(Fecha otro) {
        d = otro.dia();
        m = otro.mes();       
    }

    public Integer dia() {
        return d;
    }

    public Integer mes() {
        return m;
    }

    @Override
    public String toString() {
        // Implementar
        return Integer.toString(d) + "/" + Integer.toString(m);
    }

    @Override
    public boolean equals(Object otra) {
        boolean otraEsNull = (otra == null);
        boolean claseDistinta = otra.getClass() != this.getClass();
        if (otraEsNull || claseDistinta) {
            return false;
        }
        //casteo
        Fecha otraFecha = (Fecha) otra;
        boolean res = (otraFecha.dia() == d && otraFecha.mes() == m);
        return res;
    }

    public void incrementarDia() {
        if (d == diasEnMes(m)) {
            d = 1;
            m = (m++ % 12) + 1;
        } else {
            d++;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
