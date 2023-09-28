package patterns.example.commands;

import patterns.example.Customer;
import patterns.example.Movie;
import patterns.example.Rental;
import patterns.example.template_method.HtmlStatementFormatter;
import patterns.example.template_method.PlainTextStatementFormatter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateCustomerWithOrdersCommand implements Command {
    private final Catalog catalog;

    public CreateCustomerWithOrdersCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть ім'я покупця: ");
        String customerName = scanner.nextLine();

        List<Rental> rentals = new ArrayList<>();
        List<Movie> availableMovies = catalog.getMovies();

        System.out.println("Доступні фільми:");

        for (int i = 0; i < availableMovies.size(); i++) {
            Movie movie = availableMovies.get(i);
            System.out.println(i + ": " + movie.getTitle());
        }

        while (true) {
            System.out.print("Виберіть індекс фільму для оренди (-1 для завершення): ");
            int movieIndex = scanner.nextInt();
            if (movieIndex == -1) {
                break; // Вихід з циклу, якщо користувач завершив вибір
            }

            if (movieIndex >= 0 && movieIndex < availableMovies.size()) {
                Movie selectedMovie = availableMovies.get(movieIndex);

                System.out.print("Введіть тривалість оренди для фільму '" + selectedMovie.getTitle() + "': ");
                int rentalDays = scanner.nextInt();

                Rental rental = new Rental(selectedMovie, rentalDays);
                rentals.add(rental);
                System.out.println("Фільм '" + selectedMovie.getTitle() + "' було додано до замовлення.");
            } else {
                System.out.println("Невірний індекс фільму. Будь ласка, введіть дійсний індекс.");
            }
        }
        System.out.print("Введіть тип форматування чеку (1 - String, 2 - HTML) ");
        int typeFormatting = scanner.nextInt();

        Customer customer = new Customer(customerName, rentals, typeFormatting == 1 ? new PlainTextStatementFormatter() : new HtmlStatementFormatter());
        System.out.println(customer.statement());
        writeStatementInTxt(customer.statement());
    }
    private void writeStatementInTxt(String content) {

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(content);
            System.out.println("Рядок було успішно записано в файл 'output.txt'.");
        } catch (IOException e) {
            System.err.println("Помилка при записі у файл: " + e.getMessage());
        }
    }
}
