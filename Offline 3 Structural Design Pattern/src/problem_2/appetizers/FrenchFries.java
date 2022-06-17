package problem_2.appetizers;

import problem_2.MealDecorator;
import problem_2.burgers.MealItem;

public class FrenchFries extends MealDecorator {

    private final int price = 100;

    public FrenchFries(MealItem newMealItem) {
        super(newMealItem);
    }

    @Override
    public String mealType() {
        return super.mealType() + "1 French Fries -> Price: 1x" + price + "\n";
    }

    @Override
    public double mealPrice() {
        return super.mealPrice() + price;
    }
}
