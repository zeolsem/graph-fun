package graphs;

import java.util.ArrayList;

public class Vertex<T> {
    private T value;
    private final ArrayList<Vertex<T>> predecessors;
    private final ArrayList<Vertex<T>> neighbours;
    public Vertex(T value) {
        this.value = value;
        predecessors = new ArrayList<>();
        neighbours = new ArrayList<>();
    }

    public ArrayList<Vertex<T>> getPredecessors() {
        return predecessors;
    }

    public ArrayList<Vertex<T>> getNeighbours() {
        return neighbours;
    }

    public void addPredecessor(Vertex<T> vertex) {
        predecessors.add(vertex);
    }

    public void addNeighbour(Vertex<T> vertex) {
        neighbours.add(vertex);
    }

    public Vertex<T> removeNeighbour(Vertex<T> vertex) {
        neighbours.remove(vertex);
        return vertex;
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public T getValue() {
        return value;
    }
}