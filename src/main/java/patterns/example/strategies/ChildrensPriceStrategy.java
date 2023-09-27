package patterns.example.strategies;

public class ChildrensPriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(int daysRented) {
        double price = 1.5;
        if (daysRented > 3) {
            price += (daysRented - 3) * 1.5;
        }
        return price;
    }

    @Override
    public String getTypeOfFilm() {
        return "Childrens";
    }
}