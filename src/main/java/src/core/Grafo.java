package src.core;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {

    private Map<Vertice, List<Vertice>> _listaAdjacensia;
    private String _arquivo;
    private int _numeroVertices = 0;

    /**
     * Cria um novo grafo baseado na leitura de arquivo.
     *
     * @param arquivo Nome do arquivo para leitura.
     */
    public Grafo(String arquivo) throws IOException {
        _listaAdjacensia = new HashMap<>();
        _arquivo = arquivo;

        loadGrafo();
    }

    private void loadGrafo() throws IOException {

        Vertice verticeA = null;
        Vertice verticeB = null;

        File file = new File(_arquivo);
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException("Arquivo inválido");
        }

        BufferedReader leitor = new BufferedReader(new FileReader(file));

        String line;
        while ((line = leitor.readLine()) != null) {
            System.out.print(line);
        }

    }

}
