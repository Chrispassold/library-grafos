package src.core;

import src.exception.InvalidFormatFileException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MatrizAdjacencia {

    private int _quantidadeVertices = 0;
    private Map<Vertice, List<Vertice>> _matrizAdjacencia;
    private Map<Vertice, Integer> _grauVertice;

    private MatrizAdjacencia() {
        _matrizAdjacencia = new HashMap<>();
        _grauVertice = new HashMap<>();
    }

    public static MatrizAdjacencia mount(String arquivo) throws IOException {
        File file = new File(arquivo);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("Arquivo inválido");
        }

        MatrizAdjacencia matrizAdjacencia = new MatrizAdjacencia();
        BufferedReader leitor = new BufferedReader(new FileReader(file));

        String line;
        boolean firstLine = true;
        while ((line = leitor.readLine()) != null) {

            String[] lineValues = line.split("[^\\d.]");

            if (firstLine) {

                if (lineValues.length != 1) {
                    throw new InvalidFormatFileException(lineValues.length);
                }

                matrizAdjacencia.setQuantidadeVertices(Integer.valueOf(lineValues[0]));

                firstLine = false;
                continue;
            }

            if (lineValues.length != 2) {
                throw new InvalidFormatFileException(lineValues.length);
            }

            Vertice verticeA = new Vertice(lineValues[0]);
            Vertice verticeB = new Vertice(lineValues[1]);

            matrizAdjacencia.inserirAresta(verticeA, verticeB);
        }

        leitor.close();
        return matrizAdjacencia;
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

        updateGrau(verticeOrigem);
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

    private void updateGrau(Vertice vertice) {
        if (_matrizAdjacencia.containsKey(vertice)) {
            final List<Vertice> adjacentes = _matrizAdjacencia.get(vertice);
            _grauVertice.put(vertice, adjacentes.size());
        }
    }

    public Map<Vertice, Integer> getGrauVertices() {
        return _grauVertice;
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
