package graphs;

import java.util.*;

public abstract class AbstractGraph<T> implements IGraph<T> {
    protected ArrayList<Vertex<T>> vertices;
    protected Map<Integer, Vertex<T>> vertexMap;
    private static final String connectorString = "defaultConnectorStringForTextRepresentation";

    public AbstractGraph() {
        vertices = new ArrayList<>();
        vertexMap = new HashMap<>();
    }

    public void addVertex(Vertex<T> v) {
        vertices.add(v);
        vertexMap.put(v.getValue().hashCode(), v);
    }

    public void addVertex(T value) {
        Vertex<T> v = new Vertex<>(value);
        addVertex(v);
    }

    public ArrayList<Vertex<T>> getNeighbours(Vertex<T> v) {
        if (vertices.contains(v)) {
            return v.getNeighbours();
        }
        throw new IllegalArgumentException("Vertex " + v.getValue() + " does not exist in this graph");
    }

    public Vertex<T> getVertex(T value) {
        if (!vertexMap.containsKey(value.hashCode())) {
            throw new IllegalArgumentException("Vertex " + value + " does not exist in this graph");
        }
        return vertexMap.get(value.hashCode());
    }

    public abstract void addNeighbour(Vertex<T> v, Vertex<T> w);

    public void addNeighbour(T value1, T value2) {
        addNeighbour(getVertex(value1), getVertex(value2));
    }

    public abstract void disconnectNeighbour(Vertex<T> v, Vertex<T> w);

    public void disconnectNeighbour(T value1, T value2) {
        disconnectNeighbour(getVertex(value1), getVertex(value2));
    }

    public abstract Vertex<T> removeVertex(Vertex<T> v);

    public Vertex<T> removeVertex(T value) {
        return removeVertex(getVertex(value));
    }

    protected abstract String getConnectorString();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex<T> vertex : vertices) {
            sb.append(vertex.toString()).append(getConnectorString()).append('{');
            for (Vertex<T> neighbor : vertex.getNeighbours()) {
                sb.append(neighbor.toString()).append(", ");
            }
            if (sb.charAt(sb.length() - 1) != '{') {
                sb.delete(sb.length() - 2, sb.length());
//                sb.append('\n');
            }
            sb.append('}');
            sb.append('\n');
        }
        return sb.toString();
    }

    public void printNeighbours(T value) {
        Vertex<T> v = getVertex(value);
        StringBuilder sb = new StringBuilder();
        sb.append('\n').append(v.toString()).append(" <--> {");
        for (Vertex<T> w : v.getNeighbours()) {
            sb.append(w.toString()).append(", ");
        }
        if (!v.getNeighbours().isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}\n");
        System.out.println(sb);
    }

    // TODO: move this to GraphTraversal class
    public Map<Vertex<T>, Integer> breadthFirstTraversal(T value) {
        Queue<Vertex<T>> queue = new LinkedList<>();
        HashMap<Vertex<T>, Integer> distanceMap = new HashMap<>();
        HashSet<Vertex<T>> visited = new HashSet<>();

        queue.offer(getVertex(value));
        distanceMap.put(getVertex(value), 0);
        visited.add(getVertex(value));

        while (!queue.isEmpty()) {
            Vertex<T> v = queue.poll();
            int distance = distanceMap.get(v);

            for (Vertex<T> neighbour : v.getNeighbours()) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(neighbour);
                    distanceMap.put(neighbour, distance + 1);
                }
            }
        }
        return distanceMap;
    }
}
