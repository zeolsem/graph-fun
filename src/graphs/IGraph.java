package graphs;

import java.util.ArrayList;

public interface IGraph<T> {
    void addVertex(Vertex<T> vertex);
    Vertex<T> removeVertex(Vertex<T> vertex);
    Vertex<T> removeVertex(T value);
    void addVertex(T value);
    ArrayList<Vertex<T>> getNeighbours(Vertex<T> vertex);
    Vertex<T> getVertex(T value);
    void addNeighbour(Vertex<T> v, Vertex<T> w);
    void addNeighbour(T val1, T val2);
    void disconnectNeighbour(Vertex<T> v, Vertex<T> w);
    void disconnectNeighbour(T val1, T val2);
}
