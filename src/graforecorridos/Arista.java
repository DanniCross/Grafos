/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graforecorridos;

/**
 *
 * @author cga
 */
public class Arista {
    
    private String origen;
    private String destino;
    private int peso;

    public Arista() {
    }

    public Arista(String origen, String destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }
    
   

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the destiono
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destiono the destiono to set
     */
    public void setDestino(String destiono) {
        this.destino = destiono;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
}
