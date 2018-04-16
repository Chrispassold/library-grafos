package src.core;

import src.exception.InvalidFormatFileException;

import java.io.*;

public class Grafo {

    private MatrizAdjacencia _matrizAdjacencia;
    private String _arquivo;
    private int _numeroDeVertices = 0;

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

    private int getNumeroDeVertices() {
        return _numeroDeVertices;
    }

    private void setNumeroDeVertices(int numeroDeVertices) {
        this._numeroDeVertices = numeroDeVertices;
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

                this.setNumeroDeVertices(Integer.valueOf(lineValues[0]));
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

    public void imprimirMatrizAdjacencia() {
        if (_matrizAdjacencia != null) {
            _matrizAdjacencia.imprimir();
        }
    }

}
