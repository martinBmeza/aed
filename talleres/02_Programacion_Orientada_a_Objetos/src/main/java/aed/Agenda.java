package aed;

public class Agenda {
    private Fecha fecha;
    private ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        fecha = new Fecha(fechaActual);
        recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String res = fecha.toString() + "\n=====\n";
        for (int i = 0; i < recordatorios.longitud(); i++) {
            if (recordatorios.obtener(i).fecha().equals(fecha)) {
                res += recordatorios.obtener(i).toString() + "\n";
            }
        }
        return res;
    }

    public void incrementarDia() {
        fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        return new Fecha(fecha);
    }

}
