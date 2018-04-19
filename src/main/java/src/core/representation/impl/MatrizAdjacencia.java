package src.core.representation.impl;

import src.core.Vertice;
import src.core.representation.BaseGrafoRepresentation;
import src.exception.InvalidFormatFileException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatrizAdjacencia extends BaseGrafoRepresentation {

    private int _quantidadeVertices = 0;
    private Map<Vertice, List<Vertice>> _matrizAdjacencia;

    MatrizAdjacencia() {
        _matrizAdjacencia = new HashMap<>();
    }

    public void mount(String arquivo) throws IOException {
        File file = new File(arquivo);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("Arquivo inválido");
        }
        try (BufferedReader leitor = new BufferedReader(new FileReader(file))) {

            String line;
            boolean firstLine = true;
            while ((line = leitor.readLine()) != null) {

                String[] lineValues = line.split("[^\\d.]");

                if (firstLine) {

                    if (lineValues.length != 1) {
                        throw new InvalidFormatFileException(lineValues.length);
                    }

                    this._quantidadeVertices = Integer.valueOf(lineValues[0]);

                    firstLine = false;
                    continue;
                }

                if (lineValues.length != 2) {
                    throw new InvalidFormatFileException(lineValues.length);
                }

                Vertice verticeA = new Vertice(lineValues[0]);
                Vertice verticeB = new Vertice(lineValues[1]);

                // Grafo nao dirigido
                inserirAresta(verticeA, verticeB);
                inserirAresta(verticeB, verticeA);
            }
        }

    }


    public int getQuantidadeVertices() {
        return _quantidadeVertices;
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

    protected void updateGrau(Vertice vertice) {
        if (_matrizAdjacencia.containsKey(vertice)) {
            final List<Vertice> adjacentes = _matrizAdjacencia.get(vertice);
            addGrau(vertice, adjacentes.size());
        }
    }
}
