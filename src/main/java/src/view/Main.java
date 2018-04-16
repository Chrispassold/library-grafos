package src.view;

import src.core.Grafo;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Grafo grafo = new Grafo("D:\\Documentos\\Arquivos\\Projetos\\FURB\\Grafos\\library-grafos\\test.tmp");
        grafo.imprimirMatrizAdjacencia();

    }
}
