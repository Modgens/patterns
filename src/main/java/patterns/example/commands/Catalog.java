package patterns.example.commands;

import lombok.Getter;
import patterns.example.FilmType;
import patterns.example.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
public class Catalog {
    private final List<Movie> movies;

    public Catalog() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void viewCatalog() {
        if (movies.isEmpty()) {
            System.out.println("Каталог фільмів порожній.");
        } else {
            System.out.println("Каталог фільмів:");
            printFilmsFromList(movies);
        }
    }

    void printFilmsFromList(List<Movie> movies) {
        int index = 0;
        for (Movie movie : movies) {
            System.out.println("ID: " + index++);
            System.out.println("Назва: " + movie.getTitle());
            System.out.println("Тип фільму: " + movie.getFilmType());
            System.out.println("Країна походження: " + movie.getCountryOfOrigin());
            System.out.println("Короткий опис: " + movie.getDescription());
            System.out.println("Режисер: " + movie.getDirector());
            System.out.println("Актори: " + String.join(", ", movie.getActors()));
            System.out.println("------------");
        }
    }
    FilmType getStrategy(Scanner scanner) {
        System.out.print("Введіть тип фільму (1 - Регулярний, 2 - Новий реліз, 3 - Дитячий): ");
        int strategyChoice = scanner.nextInt();

        return switch (strategyChoice) {
            case 1 -> FilmType.REGULAR;
            case 2 -> FilmType.NEW_RELEASE;
            case 3 -> FilmType.CHILDRENS;
            default -> {
                System.out.println("Невірний вибір стратегії. Використано стратегію за замовчуванням.");
                yield FilmType.DEFAULT;
            }
        };
    }

    public List<Movie> searchMoviesByTitle(String title) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                result.add(movie);
            }
        }
        return result;
    }
    public List<Movie> searchMoviesByType(FilmType type) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getFilmType().equals(type)) {
                result.add(movie);
            }
        }
        return result;
    }

}