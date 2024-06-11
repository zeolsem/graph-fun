package recipeexercise;

public class Ingredient {
    private final String name;
    public Ingredient(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
