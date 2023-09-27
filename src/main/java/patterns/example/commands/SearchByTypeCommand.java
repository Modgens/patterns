package patterns.example.commands;

import patterns.example.Movie;
import patterns.example.strategies.PriceStrategy;

import java.util.List;
import java.util.Scanner;

public class SearchByTypeCommand implements Command {
    private final Catalog catalog;

    public SearchByTypeCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        PriceStrategy strategy = catalog.getStrategy(scanner);
        List<Movie> result = catalog.searchMoviesByType(strategy.getTypeOfFilm());

        if (result.isEmpty()) {
            System.out.println("Фільми типу '" + strategy + "' не знайдено.");
        } else {
            System.out.println("Результати пошуку за типом '" + strategy.getTypeOfFilm() + "':");
            catalog.printFilmsFromList(result);
        }
    }
}
