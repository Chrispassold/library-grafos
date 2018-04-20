package src2.factory;

import src2.core.Aresta;
import src2.core.Grafo;
import src2.core.Vertice;

import java.util.*;

public class GrafoListaAdjacencia implements Grafo {
    Map<Vertice, List<Vertice>> grafo = new HashMap<>();


    @Override
    public Iterator<Vertice> getVerticesAdjacentes(Vertice u) {
        if (u != null && grafo.containsKey(u)) {
            return grafo.get(u).iterator();
        } else {
            return Collections.emptyIterator();
        }
    }

    @Override
    public Iterator<Vertice> getVertices() {
        return grafo.keySet().iterator();
    }

    @Override
    public Iterator<Aresta> getArestas() {
        Set<Aresta> i = new HashSet<>();
        for (Map.Entry<Vertice, List<Vertice>> adj : grafo.entrySet()) {
            for (Vertice u : adj.getValue()) {
                i.add(new Aresta(adj.getKey(), u));
            }
        }

        return i.iterator();
    }

    @Override
    public Vertice getVertice(String idVertice) {
        return null;
    }

    @Override
    public void adicionaVertice(Vertice verticeOrigem, Vertice verticeDestino) {

    }

    @Override
    public void adicionaVertice(Vertice vertice) {

    }

    @Override
    public void adicionaAresta(Aresta aresta) {

    }
}
