package aed;

class Funciones {
    int cuadrado(int x) {
        int res = x*x;
        return res;
    }

    double cuadradoR(double x) {
        double res = x*x;
        return res;
    }

    double distancia(double x, double y) {
        double res = Math.sqrt(cuadradoR(x)+cuadradoR(y));
        return res;
    }

    boolean esPar(int n) {
        int resto2 = n % 2;
        if (resto2 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    boolean esBisiesto(int n) {
        int resto4 = n%4;
        int resto100 = n%100;
        int resto400 = n%400;
        if ((resto4==0 && resto100 !=0)||(resto400==0))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    int factorialIterativo(int n) {
        int res = 1;
        for (int i=n; i>0; i--){
            res *=i;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        if (n > 0){
            return n * factorialRecursivo(n-1);
        }
        else{
            return 1;
        }
    }

    boolean esPrimo(int n) {
        int ndiv = 0;
        for (int i=n; i>1; i--){
            if ((n%i)==0){
                ndiv += 1; 
            }
        }
        if (ndiv==1){
            return true;
        }
        else{
            return false;
        }
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i=0; i<numeros.length; i++){
            res += numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        for (int i=0; i<numeros.length; i++){
            if (numeros[i]==buscado){
                return i;
            }
        }
        return -1;
    }

    boolean tienePrimo(int[] numeros) {
        for (int i=0; i<numeros.length; i++){
            if(esPrimo(numeros[i])){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int i=0; i<numeros.length; i++){
            if(!esPar(numeros[i])){
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }else{
            for (int i=0; i<s1.length(); i++){
                if (s1.charAt(i)!=s2.charAt(i)){
                    return false;
                }
            }
            return true;
        }
    }

    String reverseString(String s){
        StringBuilder reversed = new StringBuilder();
        reversed.append(s);
        return reversed.reverse().toString();
    }

    boolean esSufijo(String s1, String s2) {
        s1 = reverseString(s1);
        s2 = reverseString(s2);
        return esPrefijo(s1, s2);
    }
}
