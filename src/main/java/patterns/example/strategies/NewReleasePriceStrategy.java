package patterns.example.strategies;

public class NewReleasePriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public String getTypeOfFilm() {
        return "New Release";
    }
}