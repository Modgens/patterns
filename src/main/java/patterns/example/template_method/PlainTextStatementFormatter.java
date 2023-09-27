package patterns.example.template_method;

import patterns.example.Customer;
import patterns.example.Rental;

public class PlainTextStatementFormatter extends StatementFormatter {
    @Override
    public String formatHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    @Override
    public String formatRental(Rental rental, double rentalAmount) {
        return "\t" + rental.getMovie().getTitle() + "\t" + rentalAmount + "\n";
    }

    @Override
    public String formatFooter(Customer customer, double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + totalAmount + "\nYou earned " + frequentRenterPoints + " frequent renter points\n";
    }
}