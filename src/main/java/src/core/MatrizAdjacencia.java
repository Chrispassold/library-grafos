package src.core;

import java.util.*;

public class MatrizAdjacencia {

    private Map<Vertice, List<Vertice>> _matrizAdjacencia;

    public MatrizAdjacencia() {
        _matrizAdjacencia = new HashMap<>();
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
        System.out.println(String.format("Existe aresta de v%s à v%s?", verticeOrigem.getValor(), verticeDestino.getValor()));

        if (_matrizAdjacencia.containsKey(verticeOrigem)) {
            List<Vertice> adjacentes = _matrizAdjacencia.get(verticeOrigem);
            if (adjacentes.contains(verticeDestino)) {
                System.out.println("EXISTE");
                return true;
            }
        }
        System.out.println("NÃO EXISTE");
        return false;
    }

    public void imprimir() {

        Set<Vertice> verticesOrigem = _matrizAdjacencia.keySet();
        for (Vertice verticeColuna : verticesOrigem) {
            System.out.print("v" + verticeColuna.getValor() + " ");
            System.out.println();
            for (Vertice verticeLinha : verticesOrigem) {
                List<Vertice> adjacentes = _matrizAdjacencia.get(verticeLinha);
                System.out.print("v" + verticeLinha.getValor() + " [ ");
                for (Vertice adjacente : adjacentes) {
                    System.out.print(adjacente.getValor() + ", ");
                }
                System.out.print(" ]\n");
            }
        }


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
