package patterns.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import patterns.example.template_method.StatementFormatter;

import java.util.List;

@AllArgsConstructor
public class Customer {
    @Getter
    private final String name;
    @Getter
    private final List<Rental> rentals;
    private StatementFormatter statementFormatter;
    public String statement() {
        return statementFormatter.formatStatement(this);
    }
}