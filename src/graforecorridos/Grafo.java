/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graforecorridos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author cga
 */
public class Grafo {

    public LinkedList<Nodo> nodos = new LinkedList<>();
    public LinkedList<Arista> aristas = new LinkedList<>();
    String rutaMasCorta; // distancia mas corta
    int longitudMasCorta = Integer.MAX_VALUE; // ruta mas corta
    List<Nodo> listos = null;

    public LinkedList<Boolean> visitadosProfundidad = new LinkedList<>();
    public LinkedList<Nodo> recorridoProfundidad = new LinkedList<>();
    LinkedList<Nodo> listaAux = new LinkedList<>();

    public Grafo() {

    }

    public void agregarNodo(String identificador) {
        Nodo nodoAux = new Nodo(identificador);
        this.nodos.add(nodoAux);

    }

    public void agregarArista(String origen, String destino, int peso) {
        Arista NuevaArista = new Arista(origen, destino, peso);
        this.aristas.add(NuevaArista);
        Nodo nodoAux = devolverNodo(origen);
        Nodo nodoTemp = devolverNodo(destino);
        if (nodoAux != null && nodoTemp != null) {
            nodoAux.getAdyacentes().add(nodoTemp);
        }
    }

    public Nodo devolverNodo(String nodoBusq) {
        for (int i = 0; i < this.nodos.size(); i++) {
            if (this.nodos.get(i).getIdentificador().equals(nodoBusq)) {
                return this.nodos.get(i);
            }

        }
        return null;
    }

    public Arista buscarArista(String origenB, String destinoB) {
        for (int i = 0; i < this.aristas.size(); i++) {
            if (this.aristas.get(i).getOrigen().equals(origenB)
                    && this.aristas.get(i).getDestino().equals(destinoB)) {
                return this.aristas.get(i);
            }
        }
        return null;

    }

    public void devolverAdyacencia() {
        for (int k = 0; k < aristas.size(); k++) {
            System.out.println("Arista: " + aristas.get(k).getOrigen() + "-" + aristas.get(k).getDestino() + " --> " + aristas.get(k).getPeso());
        }

        Arista aristaBusqueda;
        int[][] matrizDeAdyacencia = new int[this.nodos.size()][this.nodos.size()];
        for (int i = 0; i < this.nodos.size(); i++) {
            for (int j = 0; j < this.nodos.size(); j++) {

                aristaBusqueda = buscarArista(this.nodos.get(i).getIdentificador(), this.nodos.get(j).getIdentificador());

                if (aristaBusqueda != null) {

                    matrizDeAdyacencia[i][j] = aristaBusqueda.getPeso();
                } else {
                    matrizDeAdyacencia[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < matrizDeAdyacencia.length; i++) {
            for (int j = 0; j < matrizDeAdyacencia[0].length; j++) {
                System.out.print(matrizDeAdyacencia[i][j] + " ");
            }

            System.out.println();
        }

    }

    public boolean esVisitado(int posicion, LinkedList visitados) {
        if (true) {

        }
        return false;
    }

    public int devolverPosicion(Nodo nodoB) {
        for (int i = 0; i < this.nodos.size(); i++) {

            if (this.nodos.get(i).getIdentificador().equals(nodoB.getIdentificador())) {

                return i;
            }
        }
        return 20;
    }

    public boolean contieneElemento(Nodo nodoBus, LinkedList<Nodo> estructura) {
        for (int i = 0; i < estructura.size(); i++) {
            if (estructura.get(i).getIdentificador().equals(nodoBus.getIdentificador())) {
                return true;
            }
        }
        return false;
    }

    public void busquedaAnchura(String inicio) {
        Nodo inicial = devolverNodo(inicio);
        LinkedList<Nodo> cola = new LinkedList<>();
        LinkedList<Nodo> camino = new LinkedList();
        LinkedList<Boolean> visitados = new LinkedList();

        /* 
         metodos utilizados para la cola
         .offer agrega un elemento en la primera posicion
         .poll saca el primer elemento de la cola
        
         */
        for (int i = 0; i < this.nodos.size(); i++) {
            visitados.add(false);
        }

        //agrego a la cola el nodo por el que empezarè el recorrido
        cola.offer(inicial);
       

        //mientras que la cola no este vacia
        while (cola.peek() != null) {
            Nodo nodoTemp = cola.poll();
            //verifico si el camino no tiene el nodo   
            if (!contieneElemento(nodoTemp, camino)) {
                camino.add(nodoTemp);
            }
            //marco el nodo como visitado
            visitados.add(devolverPosicion(nodoTemp), true);
            for (int j = 0; j < nodoTemp.getAdyacentes().size(); j++) {
                //verificar si ya no están visitados
                //una vez miro la lista de adyacencia del nodo miro cada uno en la lista de nodos para verificar si estan o no visitados

                if (!visitados.get(devolverPosicion(nodoTemp.getAdyacentes().get(j)))) {

                    cola.offer(nodoTemp.getAdyacentes().get(j)); //agrego el adyacente a la cola 

                }
            }
        }

        //imprimir recorrido
        System.out.print("Recorrido en anchura-->  ");
        for (int i = 0; i < camino.size(); i++) {
            System.out.print(" " + camino.get(i).getIdentificador() + " - ");
        }
        System.out.println("");
    }

    public void llamadoProfundidad(String inicio) {
        Nodo incial = devolverNodo(inicio);

        for (int i = 0; i < this.nodos.size(); i++) { //llena la lista de visitados con false para despues hacer las comparaciones
            visitadosProfundidad.add(false);
        }
        listaAux.add(incial);
        while (!listaAux.isEmpty()) { //mientras que la lista (cola) no estè vacia

            if (!contieneElemento(listaAux.getFirst(), recorridoProfundidad)) {
                profundidad(this.nodos.get(devolverPosicion(listaAux.poll())));
                //First para poder ver si el elemento esta o no esta
                //poll saca el primer elemento de la cola
            } else {
                //Si el elemento esta entonces lo saco para seguir evaluando el resto de la cola
                listaAux.poll();
            }

        }

        System.out.print("Recorrido proundidad--> ");
        for (int i = 0; i < this.recorridoProfundidad.size(); i++) {
            System.out.print(this.recorridoProfundidad.get(i).getIdentificador() + " - ");
        }

    }

    public void profundidad(Nodo nodoTemp) {

       
        recorridoProfundidad.add(nodoTemp);
        visitadosProfundidad.add(devolverPosicion(nodoTemp), true);

        for (int i = 0; i < nodoTemp.getAdyacentes().size(); i++) {
            listaAux.add(nodoTemp.getAdyacentes().get(i)); //agrego el nodo temporal a la cola
            if (!visitadosProfundidad.get(devolverPosicion(nodoTemp.getAdyacentes().get(i)))) { //verifico que el nodo que estoy evaluando no esta marcado como visitado
                profundidad(nodoTemp.getAdyacentes().get(i)); //Hago el llamado recursivo empezando con los adyacentes de mi nodo temporal                
                visitadosProfundidad.add(devolverPosicion(nodoTemp.getAdyacentes().get(i)), true); //marco como visitado
            }

        }

    }

}
