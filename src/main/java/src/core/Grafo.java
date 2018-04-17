package src.core;

import src.exception.InvalidFormatFileException;

import java.io.*;
import java.util.Map;

public class Grafo {

    private MatrizAdjacencia _matrizAdjacencia;
    private String _arquivo;

    /**
     * Cria um novo grafo baseado na leitura de arquivo.
     *
     * @param arquivo Nome do arquivo para leitura.
     */
    public Grafo(String arquivo) throws IOException {
        _arquivo = arquivo;
        _matrizAdjacencia = new MatrizAdjacencia();

        loadGrafo();
    }

    public int getQuantidadeVertices() {
        return _matrizAdjacencia.getQuantidadeVertices();
    }

    public Map<Vertice, Integer> getGrauVertices() {
        return _matrizAdjacencia.getGrauVertices();
    }

    private void loadGrafo() throws IOException {
        File file = new File(_arquivo);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("Arquivo inválido");
        }

        BufferedReader leitor = new BufferedReader(new FileReader(file));

        String line;
        boolean firstLine = true;
        while ((line = leitor.readLine()) != null) {

            String[] lineValues = line.split("[^\\d.]");

            if (firstLine) {

                if (lineValues.length != 1) {
                    throw new InvalidFormatFileException(lineValues.length);
                }

                _matrizAdjacencia.setQuantidadeVertices(Integer.valueOf(lineValues[0]));

                firstLine = false;
                continue;
            }

            if (lineValues.length != 2) {
                throw new InvalidFormatFileException(lineValues.length);
            }

            Vertice verticeA = new Vertice(lineValues[0]);
            Vertice verticeB = new Vertice(lineValues[1]);


            if (_matrizAdjacencia != null) {
                _matrizAdjacencia.inserirAresta(verticeA, verticeB);
            }

        }
    }

}
