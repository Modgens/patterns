package patterns.example.template_method;

import patterns.example.Customer;
import patterns.example.Rental;

public class HtmlStatementFormatter extends StatementFormatter {
    @Override
    public String formatHeader(Customer customer) {
        return "<h1>Rental Record for " + customer.getName() + "</h1>\n<table>\n";
    }

    @Override
    public String formatRental(Rental rental, double rentalAmount) {
        return "\t<tr><td>" + rental.getMovie().getTitle() + "</td><td>" + rentalAmount + "</td></tr>\n";
    }

    @Override
    public String formatFooter(Customer customer, double totalAmount, int frequentRenterPoints) {
        return "</table>\n<p>Amount owed is " + totalAmount + "</p>\n<p>You earned " + frequentRenterPoints + " frequent renter points</p>\n";
    }
}