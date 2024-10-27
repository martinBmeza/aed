package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int longitud;

    private class Nodo {
        T valor;
        Nodo siguiente;
        Nodo anterior;
        Nodo(T v){valor = v;}
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        longitud = 0;
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero==null){
            primero = nuevo;
        }else{
            primero.anterior = nuevo;
            nuevo.siguiente = primero;
            nuevo.anterior = null;
            primero = nuevo;
        }
        longitud = longitud+1;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero==null){
            primero = nuevo;
        }else{
            Nodo actual = primero;
            while (actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
            nuevo.siguiente = null;
            ultimo = nuevo;
        }
        longitud = longitud+1;
    }

    public T obtener(int i) {
        int this_i = 0;
        Nodo actual = primero;
        while (this_i!=i){
            actual = actual.siguiente;
            this_i = this_i + 1;
        }
        return actual.valor;
    }

    private Nodo obtenerNodo(int i){
        Nodo actual = primero;
        int this_i = 0;
        while (this_i!=i){
            actual = actual.siguiente;
            this_i = this_i + 1;
        }
        return actual;
    }

    public void eliminar(int i) {
        if (i == 0){
            if(primero.siguiente != null){
                primero = primero.siguiente;
            }else{
                primero = null;
            }
        }else if (i == longitud-1){
            Nodo actual = obtenerNodo(i);
            ultimo = actual.anterior;
            ultimo.siguiente = null;
        }else{
            Nodo actual = obtenerNodo(i);
            actual.anterior.siguiente = actual.siguiente;
            actual.siguiente.anterior = actual.anterior;
        }
        longitud = longitud - 1;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = obtenerNodo(indice);
        actual.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        primero = null;
        ultimo = null;
        longitud = 0;
        Nodo este_nodo = lista.primero;
        while (este_nodo != null){ 
            this.agregarAtras(este_nodo.valor);
            este_nodo = este_nodo.siguiente;
        }
        
    }
    
    @Override
    public String toString() {
        String msj = "[";
        Iterador<T> it = this.iterador();
        while (it.haySiguiente()){
            msj = msj + it.siguiente() + ", ";
        }

        msj = msj.substring(0, msj.length()-2) + "]";
        return msj;
    }

    private class ListaIterador implements Iterador<T> {
    	int dedito;
        ListaIterador(){dedito=0;}
        
        public boolean haySiguiente() {
            return dedito != longitud;
        }
        
        public boolean hayAnterior() {
            return dedito>0;
        }

        public T siguiente() {
            int i = dedito;
            dedito = dedito + 1;
            return obtener(i);
        }

        public T anterior() {
            int i = dedito;
            dedito = dedito - 1;
            return obtener(i-1);
        }
    }

    public Iterador<T> iterador() {
        return new ListaIterador();
    }

}
