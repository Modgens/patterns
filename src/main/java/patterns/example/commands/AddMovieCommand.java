package patterns.example.commands;

import patterns.example.Movie;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AddMovieCommand implements Command {
    private final Catalog catalog;

    public AddMovieCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть назву фільму: ");
        String title = scanner.nextLine();

        System.out.print("Введіть країну походження фільму: ");
        String countryOfOrigin = scanner.nextLine();

        System.out.print("Введіть короткий опис фільму: ");
        String description = scanner.nextLine();

        System.out.print("Введіть режисера фільму: ");
        String director = scanner.nextLine();

        System.out.print("Введіть акторів фільму (розділені комами): ");
        String actorsInput = scanner.nextLine();
        List<String> actors = Arrays.asList(actorsInput.split(","));

        // Створення об'єкта Movie і додавання його до каталогу
        Movie movie = Movie.builder()
                .title(title)
                .filmType(catalog.getStrategy(scanner))
                .countryOfOrigin(countryOfOrigin)
                .description(description)
                .director(director)
                .actors(actors)
                .build();
        catalog.addMovie(movie);

        System.out.println("Фільм " + title + " додано до каталогу.");
    }

}
