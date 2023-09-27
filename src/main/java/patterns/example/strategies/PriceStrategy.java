package patterns.example.strategies;


public interface PriceStrategy {
    double calculatePrice(int daysRented);
    String getTypeOfFilm();
}