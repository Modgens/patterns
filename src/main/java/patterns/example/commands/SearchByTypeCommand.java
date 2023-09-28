package patterns.example.commands;

import patterns.example.FilmType;
import patterns.example.Movie;
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
        FilmType filmType = catalog.getStrategy(scanner);
        List<Movie> result = catalog.searchMoviesByType(filmType);

        if (result.isEmpty()) {
            System.out.println("Фільми типу '" + filmType + "' не знайдено.");
        } else {
            System.out.println("Результати пошуку за типом '" + filmType + "':");
            catalog.printFilmsFromList(result);
        }
    }
}
