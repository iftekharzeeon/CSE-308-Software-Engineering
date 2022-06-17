package problem_2.burgers;

public class BeefBurger implements MealItem {

    private final int price = 180;

    @Override
    public String mealType() {
        return "1 Beef Burger -> Price: 1x" + price + "\n";
    }

    @Override
    public double mealPrice() {
        return price;
    }
}
