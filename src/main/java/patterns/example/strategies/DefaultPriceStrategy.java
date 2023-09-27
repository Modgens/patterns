package patterns.example.strategies;

import patterns.example.strategies.PriceStrategy;

public class DefaultPriceStrategy implements PriceStrategy {
    @Override
    public double calculatePrice(int daysRented) {
        return 5*daysRented;
    }

    @Override
    public String getTypeOfFilm() {
        return "Common film";
    }
}
