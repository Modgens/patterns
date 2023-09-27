package patterns.example.commands;

/*
    Вирішив спробувати команду та інкапсулювати конкретні дії з меню в об'єкти
    + при додаванні нових команд потрібно буде лише змінити вивід та ввід в консолі
 */

public interface Command {
    void execute();
}
