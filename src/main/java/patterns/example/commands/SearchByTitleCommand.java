package patterns.example.commands;

import patterns.example.Movie;
import java.util.List;
import java.util.Scanner;

public class SearchByTitleCommand implements Command {
    private final Catalog catalog;

    public SearchByTitleCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву фільму для пошуку: ");
        String title = scanner.nextLine();
        List<Movie> result = catalog.searchMoviesByTitle(title);

        if (result.isEmpty()) {
            System.out.println("Фільми з назвою '" + title + "' не знайдено.");
        } else {
            System.out.println("Результати пошуку за назвою '" + title + "':");
            catalog.printFilmsFromList(result);
        }
    }
}

