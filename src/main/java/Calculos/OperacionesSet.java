
package Calculos;


public class OperacionesSet {
private String[] elementos;
public OperacionesSet(String a, String b, String c, String d){
    elementos = new String[4];
    elementos[0] = a;
    elementos[1] = b;
    elementos[2] = c;
    elementos[3] = d;
}
public OperacionesSet(String n, String b){
    elementos  = new String[2];
    elementos[0] = n;
    elementos[1] = b;
}

   

    public String[] getElementos() {
        return elementos;
    }
    @Override
    public boolean equals (Object other){
    
    OperacionesSet objeto = (OperacionesSet) other;
    return this.getElementos()[0].equals(objeto.getElementos()[0]);
    }

    @Override
    public String toString() {
        return elementos[0] + elementos[1];
    }

}