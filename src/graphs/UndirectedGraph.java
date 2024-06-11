package graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class UndirectedGraph<T> extends AbstractGraph<T> {
    private static final String connectorString = " <--> ";

    public UndirectedGraph() {
        vertices = new ArrayList<>();
        vertexMap = new HashMap<>();
    }

    public void addNeighbour(Vertex<T> v, Vertex<T> w) {
        if (v.equals(w)) {
            throw new IllegalArgumentException("Vertex can't connect to itself in undirected graph.");
        }
        if (vertices.contains(v) && vertices.contains(w)) {
            v.addNeighbour(w);
            w.addNeighbour(v);
        }
        else if (vertices.contains(w)) {
            throw new IllegalArgumentException("The vertex you are trying to connect to is not a part of the graph");
        }
        else {
            throw new IllegalArgumentException("The neighbour vertex is not a part of the graph");
        }
    }

    public void disconnectNeighbour(Vertex<T> v, Vertex<T> w) {
        if (vertices.contains(v) && vertices.contains(w)) {
            v.getNeighbours().remove(w);
            w.getNeighbours().remove(v);
        }
        else if (vertices.contains(w)) {
            throw new IllegalArgumentException("The vertex you are trying to connect to is not a part of the graph");
        }
        else {
            throw new IllegalArgumentException("The neighbour vertex is not a part of the graph");
        }
    }

    public Vertex<T> removeVertex(Vertex<T> v) {
        if (vertices.remove(v)) {
            for (Vertex<T> w : v.getNeighbours()) {
                w.getNeighbours().remove(v);
            }
            return vertexMap.remove(v.getValue().hashCode());
        }
        throw new IllegalArgumentException("The vertex is not a part of the graph");
    }

    @Override
    protected String getConnectorString() {
        return connectorString;
    }

    @Override
    public void printNeighbours(T value) {
        super.printNeighbours(value);
    }
}
