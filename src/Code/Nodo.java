/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

public class Nodo {
    String nPais, nCapital;
    Nodo ant,sig;
    
    public Nodo(String nPais, String nCapital){
        this.nPais=nPais;
        this.nCapital=nCapital;
        ant=sig=null;
    }
    public String ToSring(){
    return "<-" +nPais +"+" +nCapital +"->";
    }
    
}
