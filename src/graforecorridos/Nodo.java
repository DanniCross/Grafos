/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graforecorridos;

import java.util.LinkedList;

/**
 *
 * @author cga
 */
public class Nodo {
    private String identificador;
    private LinkedList<Nodo> adyacentes;

    public Nodo() {
    }

    public Nodo(String identificador) {
        this.identificador = identificador;
        this.adyacentes = new LinkedList<>();
    }

    /**
     * @return the identificador
     */
    public String getIdentificador() {
        return identificador;
    }
    


    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the adyacentes
     */
    public LinkedList<Nodo> getAdyacentes() {
        return adyacentes;
    }

    /**
     * @param adyacentes the adyacentes to set
     */
    public void setAdyacentes(LinkedList<Nodo> adyacentes) {
        this.adyacentes = adyacentes;
    }
    
    
    
    
   
    
}
