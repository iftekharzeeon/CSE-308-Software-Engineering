package problem_2.burgers;

import problem_2.MealItem;

public class VeggiBurger implements MealItem {

    private final int price = 180;

    @Override
    public String mealType() {
        return "1 Veggi Burger -> Price: 1x" + price + "\n";
    }

    @Override
    public double mealPrice() {
        return price;
    }
}
