package src2.core;

import java.util.Iterator;

public interface Grafo {
    public Iterator<Vertice> getVerticesAdjacentes(Vertice u);

    public Iterator<Vertice> getVertices();

    public Iterator<Aresta> getArestas();

    public Vertice getVertice(String idVertice);

    /**
     * Adiciona o vértice <code>verticeAdicionado</code> ajdacente
     * ao vértice <code>verticeNoGrafo</code> que já está no grafo.
     * Necessariamente, o vértice <code>verticeNoGrafo</code> precisa
     * estar no grafo
     *
     * @param verticeNoGrafo    Vértice que já está no grafo
     * @param verticeAdicionado Vértice sendo adicionado no grafo
     */
    public void adicionaVertice(Vertice verticeNoGrafo, Vertice verticeAdicionado);

    /**
     * Adiciona um vértice <code>verticeAdicionado</code> ao grafo.
     * O vértice ficará sem nenhum outro vértice adjacente.
     *
     * @param verticeAdicionado Vértice sendo adicionado ao grafo
     */
    public void adicionaVertice(Vertice verticeAdicionado);

    /**
     * Adiciona uma aresta ao grafo. Se algum dos vértices
     * da aresta adicionada já estiverem no grafo eles são
     * sobrepostos
     *
     * @param arestaAdicionada Aresta adicionada ao grafo
     */
    public void adicionaAresta(Aresta arestaAdicionada);
}
