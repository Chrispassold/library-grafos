package src.core;

public class MatrizAdjacencia {

    private int numeroDeVertices;

    private int matrizAdjacente[][];

    public MatrizAdjacencia(int numeroDeVertices) {
        this.numeroDeVertices = numeroDeVertices;
        matrizAdjacente = new int[numeroDeVertices][numeroDeVertices];
    }

    public void inserirAresta(Vertice verticeOrigem, Vertice verticeDestino) {
        matrizAdjacente[verticeOrigem.valor - 1][verticeDestino.valor - 1] = 1;
    }

    public void removerAresta(Vertice verticeOrigem, Vertice verticeDestino) {
        matrizAdjacente[verticeOrigem.valor - 1][verticeDestino.valor - 1] = 0;
    }

    public boolean existeAresta(int verticeOrigem, int verticeDestino) {
        System.out.println("Existe aresta de v" + verticeOrigem + " à v" + verticeDestino + "?");
        if (matrizAdjacente[verticeOrigem - 1][verticeDestino - 1] == 1) {
            System.out.println("EXISTE ARESTA DE v" + verticeOrigem + " à v" + verticeDestino);
            return true;
        } else {
            System.out.println("NÃO EXISTE ARESTA DE v" + verticeOrigem + " à v" + verticeDestino);
            return false;
        }
    }

    public void imprimirGrafo() {
        System.out.print("    ");
        for (int k = 0; k < numeroDeVertices; k++)
            System.out.print("v" + (k + 1) + " ");
        System.out.println();
        for (int i = 0; i < matrizAdjacente.length; i++) {
            System.out.print("v" + (i + 1) + " [ " + matrizAdjacente[i][0]);
            for (int j = 1; j < matrizAdjacente[0].length; j++) {
                System.out.print(", " + matrizAdjacente[i][j]);
            }
            System.out.print(" ]\n");
        }
    }
}
