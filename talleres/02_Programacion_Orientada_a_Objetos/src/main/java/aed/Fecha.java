    package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha otro) {
        dia = otro.dia();
        mes = otro.mes();       
    }

    public Integer dia() {
        return dia;
    }

    public Integer mes() {
        return mes;
    }

    @Override
    public String toString() {
        // Implementar
        return Integer.toString(dia) + "/" + Integer.toString(mes);
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
        boolean res = (otraFecha.dia() == dia && otraFecha.mes() == mes);
        return res;
    }

    public void incrementarDia() {
        if (dia == diasEnMes(mes)) {
            dia = 1;
            mes = (mes++ % 12) + 1;
        } else {
            dia++;
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
