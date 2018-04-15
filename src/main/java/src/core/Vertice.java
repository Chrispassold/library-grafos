package src.core;

import java.util.ArrayList;

/**
 * Classe que representa um vértice do grafo.
 *
 * @author matheus
 */
public class Vertice {
    static public ArrayList<Vertice> verticesGrafo = null;
    public char valor = 0;
    public boolean visitado = false;

    /**
     * Cria um vértice com várias arestas.
     */
    public Vertice(char valor) {
        this.valor = valor;

        if (verticesGrafo == null)
            verticesGrafo = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        return this.hashCode() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return valor;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}