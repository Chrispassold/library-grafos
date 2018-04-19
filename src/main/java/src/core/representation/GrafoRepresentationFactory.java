package src.core.representation;

import src.core.representation.impl.MatrizAdjacencia;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class GrafoRepresentationFactory {

    //use getShape method to get object of type shape
    public static GrafoRepresentation create(EGrafoRepresentation representation) {
        switch (representation) {
            case MATRIZ_ADJACENCIA:
                return new MatrizAdjacencia();
            default:
                throw new NotImplementedException();
        }
    }

    public enum EGrafoRepresentation {
        MATRIZ_ADJACENCIA(1);

        private int id;

        EGrafoRepresentation(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

}
