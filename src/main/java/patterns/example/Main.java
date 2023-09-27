package patterns.example;

import patterns.example.commands.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        Client client = new Client();

        Command viewCatalogCommand = new ViewCatalogCommand(catalog);
        Command addMovieCommand = new AddMovieCommand(catalog);
        Command searchByTitleCommand = new SearchByTitleCommand(catalog);
        Command searchByTypeCommand = new SearchByTypeCommand(catalog);
        Command createCustomerWithOrdersCommand = new CreateCustomerWithOrdersCommand(catalog);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Переглянути каталог фільмів");
            System.out.println("2. Додати фільм");
            System.out.println("3. Пошук Фільмів за Назвою");
            System.out.println("4. Пошук Фільмів за Типом");
            System.out.println("5. Оформити замовлення");

            System.out.println("0. Вийти");
            System.out.print("Виберіть опцію: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    client.setCommand(viewCatalogCommand);
                    client.executeCommand();
                    break;
                case 2:
                    client.setCommand(addMovieCommand);
                    client.executeCommand();
                    break;
                case 3:
                    client.setCommand(searchByTitleCommand);
                    client.executeCommand();
                    break;
                case 4:
                    client.setCommand(searchByTypeCommand);
                    client.executeCommand();
                    break;
                case 5:
                    client.setCommand(createCustomerWithOrdersCommand);
                    client.executeCommand();
                    break;
                case 0:
                    System.out.println("Дякуємо за використання програми. До побачення!");
                    break;
                default:
                    System.out.println("Невірний вибір. Будь ласка, введіть коректний номер опції.");
                    break;
            }
        } while (choice != 0);
    }

}