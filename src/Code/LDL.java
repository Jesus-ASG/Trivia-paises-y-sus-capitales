
package Code;

public class LDL {
    private Nodo raiz;
    public Nodo nodoMastil;
    public Nodo raizAux;
    boolean vacio;

    public LDL(){
        raiz=null;
    }
    public boolean estaVacia(){
        return raiz==null;
    }
    
    public boolean unDato(){    //Devuelve verdadero si hay un dato en la lista
        Nodo aux;
        int numDatos = 0;
        for(aux = raiz; aux!=null; aux = aux.sig){
            numDatos++;
        }
        return numDatos == 1;
    }
    
    public void insertar(String nPais, String nCapital){
        Nodo nuevo=new Nodo(nPais, nCapital);
    
        if(raiz!=null){
            raiz.ant=nuevo;
        nuevo.sig=raiz;
        }
        raiz=nuevo;
        
        raizAux = raiz;
    
    }
    public void eliminar(String nPais){
        Nodo actual;
        for(actual=raiz; actual!=null && actual.nPais != nPais; actual=actual.sig);
            if(actual!=null){
                if(actual==raiz){
                    if(actual.sig!=null)
                        actual.sig.ant=null;
                    raiz=actual.sig;            
                }else{
                    if(actual.sig!=null)
                        actual.sig.ant=actual.ant;
                    actual.ant.sig = actual.sig;
                }
            }
    }
    
    public void pushNodoMastil(){ //Empuja mastil y actualiza raiz aux
        if(raizAux.sig!=null){
            nodoMastil = raizAux.sig;
            raizAux = raizAux.sig;
        } else {
            nodoMastil = resetRaiz();
            
        }
    }
    
    public Nodo getNodoMastil(){ //Devuelve información del nodo
        return nodoMastil;
    }
    
    public Nodo resetRaiz(){ //Devuelve la raiz inicial actualizada
        raizAux = raiz;
        return raizAux;
    }
    
    public Nodo getRaiz(){
        return raiz;
    }


    public String toString(){
        Nodo actual;
        String total ="";

        for(actual=raiz; actual!=null; actual=actual.sig)
            total+= actual.nPais +" " +actual.nCapital+'\n';
            return total;
    }


}
