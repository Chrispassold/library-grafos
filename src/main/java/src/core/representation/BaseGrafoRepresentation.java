package src.core.representation;

import src.core.Vertice;

import java.util.HashMap;
import java.util.Map;

abstract public class BaseGrafoRepresentation implements GrafoRepresentation {
    private Map<Vertice, Integer> _grauVertice;

    protected BaseGrafoRepresentation() {
        _grauVertice = new HashMap<>();
    }

    abstract protected void updateGrau(Vertice vertice);

    public Map<Vertice, Integer> getGrauVertices() {
        return _grauVertice;
    }

    public void addGrau(Vertice vertice, int grau) {
        this._grauVertice.put(vertice, grau);
    }
}
