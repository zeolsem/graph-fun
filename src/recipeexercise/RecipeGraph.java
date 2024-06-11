package recipeexercise;

import graphs.DirectedGraph;
import graphs.Vertex;

public class RecipeGraph<T> extends DirectedGraph<T> {
    private final Vertex<T> dish;
    public RecipeGraph(T dish) {
        super();
        this.dish = new Vertex<>(dish);
    }
}
