import graphs.DirectedGraph;
import graphs.UndirectedGraph;
import graphs.Vertex;
import recipeexercise.RecipeGraph;
import recipeexercise.Ingredient;

import java.util.Map;

public class Main {
    private static void testDirectedGraph() {
        DirectedGraph<Integer> directedGraph = new DirectedGraph<>();
        directedGraph.addVertex(5);
        directedGraph.addVertex(2);
        directedGraph.addVertex(4);
        directedGraph.addVertex(7);
        directedGraph.addVertex(1);

        directedGraph.addNeighbour(5, 2);
        directedGraph.addNeighbour(5, 4);
        directedGraph.addNeighbour(2, 7);
        directedGraph.addNeighbour(4, 7);
        directedGraph.addNeighbour(7, 1);

        System.out.println(directedGraph);
    }

    private static void testRecipeGraph() {
        RecipeGraph<Ingredient> recipeGraph = new RecipeGraph<>(new Ingredient("Pasta"));

        // Ingredients
        Ingredient pasta = new Ingredient("Pasta");
        Ingredient tomato = new Ingredient("Tomato");
        Ingredient cheese = new Ingredient("Cheese");
        Ingredient basil = new Ingredient("Basil");
        Ingredient garlic = new Ingredient("Garlic");
        Ingredient oliveOil = new Ingredient("Olive oil");
        Ingredient salt = new Ingredient("Salt");
        Ingredient pepper = new Ingredient("Pepper");

        // Add ingredients to the graph
        recipeGraph.addVertex(pasta);
        recipeGraph.addVertex(tomato);
        recipeGraph.addVertex(cheese);
        recipeGraph.addVertex(basil);
        recipeGraph.addVertex(garlic);
        recipeGraph.addVertex(oliveOil);
        recipeGraph.addVertex(salt);
        recipeGraph.addVertex(pepper);

        // Add connections between ingredients
        recipeGraph.addNeighbour(pasta, tomato);
        recipeGraph.addNeighbour(pasta, cheese);
        recipeGraph.addNeighbour(tomato, basil);
        recipeGraph.addNeighbour(tomato, garlic);
        recipeGraph.addNeighbour(tomato, oliveOil);
        recipeGraph.addNeighbour(oliveOil, salt);
        recipeGraph.addNeighbour(oliveOil, pepper);


        System.out.println(recipeGraph);
    }

    private static void testBFS() {
        UndirectedGraph<Integer> graph = new UndirectedGraph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(0);

        graph.addNeighbour(0, 1);
        graph.addNeighbour(0, 2);
        graph.addNeighbour(1, 3);
        graph.addNeighbour(3, 4);

        Map<Vertex<Integer>, Integer> distanceMap = graph.breadthFirstTraversal(0);
        for (Map.Entry<Vertex<Integer>, Integer> entry : distanceMap.entrySet()) {
            System.out.println(entry.getKey() + " is at distance " + entry.getValue());
        }
    }

    public static void main(String[] args) {
//        testDirectedGraph();
//        testRecipeGraph();
        testBFS();
    }
}