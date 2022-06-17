package problem_2.burgers;

public class ChickenBurger implements MealItem {

    private final int price = 160;

    @Override
    public String mealType() {
        return "1 Chicken Burger -> Price: 1x" + price + "\n";
    }

    @Override
    public double mealPrice() {
        return price;
    }
}
