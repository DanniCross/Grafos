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
public class GrafoRecorridos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Grafo grafoPrueba = new Grafo();
        grafoPrueba.agregarNodo("A");
        grafoPrueba.agregarNodo("B");
        grafoPrueba.agregarNodo("C");
        grafoPrueba.agregarNodo("D");
        grafoPrueba.agregarNodo("E");
        grafoPrueba.agregarNodo("F");
        
        
//        grafoPrueba.agregarArista("A", "D", 8);
//        grafoPrueba.agregarArista("A", "E", 3);
//        grafoPrueba.agregarArista("D", "B",5 );
//        grafoPrueba.agregarArista("B", "F", 3);
//        grafoPrueba.agregarArista("E", "F",2 );
//        grafoPrueba.agregarArista("E", "C",2 );
//        grafoPrueba.agregarArista("C", "B",2 );
        
        
        grafoPrueba.agregarArista("A", "B", 8);
        grafoPrueba.agregarArista("A", "C", 3);
        grafoPrueba.agregarArista("C", "B",5 );
        grafoPrueba.agregarArista("B", "E",2 );
        grafoPrueba.agregarArista("C", "D", 3);
        grafoPrueba.agregarArista("D", "F",2 );        
        grafoPrueba.agregarArista("E", "D",2 );        
        grafoPrueba.agregarArista("F", "E",2 );
        
        
        
        
       grafoPrueba.devolverAdyacencia();
       
       grafoPrueba.busquedaAnchura("A");
       
       grafoPrueba.llamadoProfundidad("A");
       

       
    }
    
}
