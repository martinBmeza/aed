package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    private Nodo _raiz;
    private int _cardinal;
    private int _altura;
    private T _minimo;

    private class Nodo {
        // Agregar atributos privados del Nodo
        T valor;
        Nodo izq;
        Nodo der;
        Nodo padre;
        // Crear Constructor del nodo
        Nodo(T v){
            valor = v;
            izq = null;
            der = null;
            padre = null;
        }
    }
    public ABB() {
        _raiz = null;
        _cardinal = 0;
        _altura = 0;
        //throw new UnsupportedOperationException("No implementada aun");
    }

    public int cardinal() {
        //throw new UnsupportedOperationException("No implementada aun");
        return _cardinal;
    }

    public T minimo(){
        //throw new UnsupportedOperationException("No implementada aun");
        Nodo actual = _raiz;
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual.valor;
    }

    public Nodo minimo_nodo(Nodo actual){
        if (actual == null) {
            return null;
        }
        while (actual.izq != null) {
            actual = actual.izq;
        }
        return actual;
    }

    public T maximo(){
        //throw new UnsupportedOperationException("No implementada aun");
        Nodo actual = _raiz;
        while (actual.der != null) {
            actual = actual.der;
        } 
        return actual.valor;
    }

    public Nodo buscar_nodo(Nodo actual, T elem){
        if (actual == null) {
            return _raiz;
        }
        if (actual.valor.compareTo(elem) == 0) {
            return actual;
        }
        if (actual.valor.compareTo(elem) > 0) {
            if(actual.izq!=null){
                return buscar_nodo(actual.izq, elem);
            }
            else{
                return actual;
            }
        } else {
            if (actual.der != null) {
                return buscar_nodo(actual.der, elem);
            }
            else{
                return actual;
            }
        }
    }

    public void insertar(T elem){
        Nodo actual = buscar_nodo(_raiz, elem);
        if (actual == null) {
            _raiz = new Nodo(elem);
            _raiz.valor = elem;
            _cardinal++;
            return;
        }
        if (actual.valor.compareTo(elem) == 0) {
            return;
        }
        if (actual.valor.compareTo(elem) > 0) {
            actual.izq = new Nodo(elem);
            actual.izq.padre = actual;
            actual.izq.valor = elem;
            _cardinal++;
            return;
        }else{
            actual.der = new Nodo(elem);
            actual.der.padre = actual;
            actual.der.valor = elem;
            _cardinal++;
            return;
        }
    }

    // public boolean busqueda_recursiva(Nodo actual, T elem){
    //     if (actual == null) {
    //         return false;
    //     }
    //     if (actual.valor.compareTo(elem) == 0) {
    //         return true;
    //     }
    //     if (actual.valor.compareTo(elem) > 0) {
    //         return busqueda_recursiva(actual.izq, elem);
    //     } else {
    //         return busqueda_recursiva(actual.der, elem);
    //     }
    // }

    // public boolean pertenece(T elem){
    //     return busqueda_recursiva(_raiz, elem);
    // }

    public boolean pertenece(T elem){
        Nodo actual = _raiz;
        while (actual != null) {
            if(actual.valor.compareTo(elem) == 0){
                return true;
            }
            else if(actual.valor.compareTo(elem) > 0){
                actual = actual.izq;
            }else{
                actual = actual.der;
            }
        }
        return false;
    }

    public Nodo sucesor(Nodo actual){   
        if (actual.der != null) {
            return minimo_nodo(actual.der);
        }
        Nodo padre = actual.padre;
        while (padre != null && actual == padre.der) {
            actual = padre;
            padre = actual.padre;
        }
        return padre;
    }

    public void eliminar(T elem){
        //si no esta, no hacemos nada
        if (!pertenece(elem)) {
            return;
        }else{
            // y no tiene descendencia, lo borramos
            Nodo actual = buscar_nodo(_raiz, elem);
            if (actual.izq == null && actual.der == null){
                // si es la raiz (no tiene padre)
                if (actual.padre == null) {
                    _raiz = null;
                    _cardinal--;
                    return;
                }
                // si es un hijo izq
                if (actual.padre.izq == actual) {
                    actual.padre.izq = null;
                    _cardinal--;
                    return;
                } else {
                // si es hijo der    
                    actual.padre.der = null;
                    _cardinal--;
                    return;
                }
            }
            // si tiene un solo hijo, el hijo ocupa su lugar 
            if (actual.izq == null || actual.der == null) {
                // si es la raiz
                if (actual.padre == null) {
                    if (actual.izq != null) {
                        _raiz = actual.izq;
                        _raiz.padre = null;
                        _cardinal--;
                        return;
                    } else {
                        _raiz = actual.der;
                        _raiz.padre = null;
                        _cardinal--;
                        return;
                    }
                }
                // si es hijo izq
                if (actual.padre.izq == actual) {
                    if (actual.izq != null) {
                        actual.padre.izq = actual.izq;
                        actual.izq.padre = actual.padre;
                        _cardinal--;
                        return;
                    } else {
                        actual.padre.izq = actual.der;
                        actual.der.padre = actual.padre;
                        _cardinal--;
                        return;
                    }
                } else {
                // si es hijo der    
                    if (actual.izq != null) {
                        actual.padre.der = actual.izq;
                        actual.izq.padre = actual.padre;
                        _cardinal--;
                        return;
                    } else {
                        actual.padre.der = actual.der;
                        actual.der.padre = actual.padre;
                        _cardinal--;
                        return;
                    }
                }
            }else{
            // si tiene dos hijos (consultar rebalanceo? para avl)
            // reemplazo por el inmediato sucesor o predecesor
            // (mayor de los menores o menor de los mayores) 
                Nodo aux = actual.der; // de los mayores
                while (aux.izq != null) {
                    aux = aux.izq; // el menor
                }
                T valor = aux.valor;
                eliminar(valor);
                //aux.padre.izq = aux.der;

                actual.valor = valor;
                //_cardinal--;

            }
        }
    }

    public String toString(){
        String msj = "{";
        Iterador<T> it = iterador();
        while (it.haySiguiente()) {
            msj += it.siguiente();
            if (it.haySiguiente()) {
                msj += ",";
            }
        }
        msj += "}";
        return msj;
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual = minimo_nodo(_raiz);

        public boolean haySiguiente() {            
            return _actual != null;
            
        }
    
        public T siguiente() {
            T valor = _actual.valor;
            _actual = sucesor(_actual);
            return valor;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
