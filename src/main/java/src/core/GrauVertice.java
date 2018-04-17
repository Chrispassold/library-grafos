package src.core;

public class GrauVertice {
    private Vertice vertice;
    private int grau = 0;

    public GrauVertice(Vertice vertice) {
        this.vertice = vertice;
    }

    public void setGrau(int grau) {
        this.grau = grau;
    }

    @Override
    public String toString() {
        return String.format("Vertice: %s é grau %d", this.vertice.getValor(), this.grau);
    }
}
