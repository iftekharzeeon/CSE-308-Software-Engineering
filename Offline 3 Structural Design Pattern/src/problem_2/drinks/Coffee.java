package problem_2.drinks;

import problem_2.MealDecorator;
import problem_2.burgers.MealItem;

public class Coffee extends MealDecorator {

    private final int price = 40;

    private int numberOfCoffee;

    public Coffee(MealItem newMealItem, int numberOfCoffee) {
        super(newMealItem);
        this.numberOfCoffee = numberOfCoffee;
    }

    @Override
    public String mealType() {
        return super.mealType() + numberOfCoffee + " Coffee -> Price: " + numberOfCoffee + "x" + price + "\n";
    }

    @Override
    public double mealPrice() {
        return super.mealPrice() + numberOfCoffee*price;
    }
}
