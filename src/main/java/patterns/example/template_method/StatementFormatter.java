package patterns.example.template_method;

import patterns.example.Customer;
import patterns.example.FilmType;
import patterns.example.Rental;


/*
    Спершу писав як Стратегію, (досі вважаю що це теж непоганий шлях для розв'язання цієї проблеми)
    але при написанні методу для виводу замовлення в html форматі зрозумів, що метод є дуже схожим на
    початковий. Через що вирішив спробувати написати код через патерн "Шаблонний метод", код працює
    чудово, не виглядає заплутаним і при цьому вдалося уникнути дублювання коду(хоча і не значного)
    який був при виконанні Стратегії, а також залишається можливість додавати нові формати виводу,
    такі як Json чи XML в майбутньому, не перелопачуючи весь уже написаний код.
 */

public abstract class StatementFormatter {
    public abstract String formatHeader(Customer customer);
    public abstract String formatRental(Rental rental, double thisAmount);
    public abstract String formatFooter(Customer customer, double totalAmount, int frequentRenterPoints);

    // Шаблонний метод
    public String formatStatement(Customer customer) {
        StringBuilder result = new StringBuilder(formatHeader(customer));

        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental rental : customer.getRentals()) {
            double thisAmount = rental.getMovie().calculatePrice(rental.getDaysRented());

            // Додавання бонусних балів
            frequentRenterPoints++;
            if (rental.getMovie().getFilmType().equals(FilmType.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            // Форматування даних по оренді
            result.append(formatRental(rental, thisAmount));
            totalAmount += thisAmount;
        }

        // Додавання підсумків
        result.append(formatFooter(customer, totalAmount, frequentRenterPoints));

        return result.toString();
    }
}
