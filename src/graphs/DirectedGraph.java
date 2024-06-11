package graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class DirectedGraph<T> extends AbstractGraph<T> {
    private static final String connectorString = " --> ";

    public DirectedGraph() {
        vertices = new ArrayList<>();
        vertexMap = new HashMap<>();
    }

    public void addNeighbour(Vertex<T> v, Vertex<T> w) {
        if (vertices.contains(v) && vertices.contains(w)) {
            v.addNeighbour(w);
            w.getPredecessors().add(v);
        }
        else if (vertices.contains(w)) {
            throw new IllegalArgumentException("The vertex you are trying to connect to is not a part of the graph");
        }
        else if (vertices.contains(v)) {
            throw new IllegalArgumentException("The neighbour vertex is not a part of the graph");
        }
        else {
            throw new IllegalArgumentException("Neither of these vertices is a part of the graph");
        }
    }

    public void disconnectNeighbour(Vertex<T> v, Vertex<T> w) {
        if (vertices.contains(v) && vertices.contains(w)) {
            v.getNeighbours().remove(w);
            w.getPredecessors().remove(v);
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
            for (Vertex<T> w : v.getPredecessors()) {
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
}
