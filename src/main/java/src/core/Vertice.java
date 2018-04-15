package src.core;

/**
 * Classe que representa um vértice do grafo.
 *
 * @author matheus
 */
public class Vertice {
    public int valor;

    /**
     * Cria um vértice com várias arestas.
     */
    public Vertice(int valor) {
        this.valor = valor;
    }

    public Vertice(String valor) {
        this(Integer.valueOf(valor));
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