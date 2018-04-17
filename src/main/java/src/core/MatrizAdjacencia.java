package src.core;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;

public class MatrizAdjacencia {

    private int _quantidadeVertices = 0;
    private Map<Vertice, List<Vertice>> _matrizAdjacencia;

    public MatrizAdjacencia() {
        _matrizAdjacencia = new HashMap<>();
    }

    public int getQuantidadeVertices() {
        return _quantidadeVertices;
    }

    public void setQuantidadeVertices(int quantidadeVertices) {
        this._quantidadeVertices = quantidadeVertices;
    }

    /**
     * Insere as relações na matriz de adjacencia, se o parametro {@code verticeDestino} for {@code null}
     * Ira adicionar um vértice de origem somente, com o vertices adjacentes vazio
     */
    public void inserirAresta(Vertice verticeOrigem, Vertice verticeDestino) {
        if (_matrizAdjacencia.containsKey(verticeOrigem)) {
            List<Vertice> adjacentes = _matrizAdjacencia.get(verticeOrigem);
            if (verticeDestino != null && !adjacentes.contains(verticeDestino)) {
                adjacentes.add(verticeDestino);
                _matrizAdjacencia.put(verticeOrigem, adjacentes);
            }
        } else {
            ArrayList<Vertice> vertices = new ArrayList<>();
            if (verticeDestino != null) {
                vertices.add(verticeDestino);
            }

            _matrizAdjacencia.put(verticeOrigem, vertices);
        }

    }

    /**
     * Remove a aresta entre o {@code verticeOrigem} e o {@code verticeDestino}
     */
    public void removerAresta(Vertice verticeOrigem, Vertice verticeDestino) {
        if (_matrizAdjacencia.containsKey(verticeOrigem)) {
            List<Vertice> adjacentes = _matrizAdjacencia.get(verticeOrigem);
            if (adjacentes.contains(verticeDestino)) {
                adjacentes.remove(verticeDestino);
                _matrizAdjacencia.put(verticeOrigem, adjacentes);
            }
        }
    }

    public boolean existeAresta(Vertice verticeOrigem, Vertice verticeDestino) {
        if (_matrizAdjacencia.containsKey(verticeOrigem)) {
            List<Vertice> adjacentes = _matrizAdjacencia.get(verticeOrigem);
            return adjacentes.contains(verticeDestino);
        }
        return false;
    }

    public List<GrauVertice> getGrauVertices() {
        Set<Map.Entry<Vertice, List<Vertice>>> entries = _matrizAdjacencia.entrySet();
        List<GrauVertice> grauVertices = new ArrayList<>();
        for (Map.Entry<Vertice, List<Vertice>> entry : entries) {

            GrauVertice grauVertice = new GrauVertice(entry.getKey());

            if (entry.getValue() != null) {
                grauVertice.setGrau(entry.getValue().size());
            }

            grauVertices.add(grauVertice);
        }

        return grauVertices;
    }


    public void imprimir() {

        throw new NotImplementedException();

//        System.out.print("    ");
//        for (int k = 0; k < numeroDeVertices; k++)
//            System.out.print("v" + (k + 1) + " ");
//        System.out.println();
//        for (int i = 0; i < matrizAdjacente.length; i++) {
//            System.out.print("v" + (i + 1) + " [ " + matrizAdjacente[i][0]);
//            for (int j = 1; j < matrizAdjacente[0].length; j++) {
//                System.out.print(", " + matrizAdjacente[i][j]);
//            }
//            System.out.print(" ]\n");
//        }
    }
}
