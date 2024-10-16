package aed;

class ArregloRedimensionableDeRecordatorios {
    Recordatorio[] arreglo;

    public ArregloRedimensionableDeRecordatorios() {
        arreglo = new Recordatorio[0];
    }

    public int longitud() {
        return arreglo.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevoArreglo = new Recordatorio[arreglo.length + 1];
        for (int j = 0; j < arreglo.length; j++) {
            nuevoArreglo[j] = arreglo[j];
        }
        nuevoArreglo[nuevoArreglo.length-1] = i;
        arreglo = nuevoArreglo;
    }

    public Recordatorio obtener(int i) {
        return arreglo[i];
    }

    public void quitarAtras() {
        Recordatorio [] nuevoArreglo = new Recordatorio[arreglo.length - 1];
        for (int i = 0; i < nuevoArreglo.length; i++) {
            nuevoArreglo[i] = arreglo[i];
        }
        arreglo = nuevoArreglo;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        arreglo[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        arreglo = new Recordatorio[vector.arreglo.length];
        for (int i = 0; i < vector.arreglo.length; i++) {
            arreglo[i] = new Recordatorio(vector.arreglo[i]);
        }
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        return new ArregloRedimensionableDeRecordatorios(this);
    }
}
