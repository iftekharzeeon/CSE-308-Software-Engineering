package problem_2.drinks;

import problem_2.MealDecorator;
import problem_2.burgers.MealItem;

public class Coke extends MealDecorator {
    private int numberOfCoke;
    private final int price = 30;

    public Coke(MealItem newMealItem, int numberOfCoke) {
        super(newMealItem);
        this.numberOfCoke = numberOfCoke;
    }

    @Override
    public String mealType() {
        return super.mealType() + numberOfCoke + " Coke -> Price: " + numberOfCoke + "x" + price + "\n";
    }

    @Override
    public double mealPrice() {
        return super.mealPrice() + numberOfCoke*price;
    }
}
