package patterns.example.strategies;

public class RegularPriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(int daysRented) {
        double price = 2;
        if (daysRented > 2) {
            price += (daysRented - 2) * 1.5;
        }
        return price;
    }

    @Override
    public String getTypeOfFilm() {
        return "Regular";
    }
}