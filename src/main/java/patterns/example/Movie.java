package patterns.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import patterns.example.strategies.PriceStrategy;

import java.util.List;

/*
    Білдер. Просто гарно.

    P.S. Спершу думав, що тут при розширенні полів класу варто використати якийсь патерн.
    Першим в голову прийшов Декоратор, але потім зрозумів що краще просто вписати нові поля
    ніж розширяти його Декоратором.
*/
@Getter
@Builder
@AllArgsConstructor
public class Movie {
    private final String title;
    // Спершу думав що патерн Стратегія принесе лише +,
    // проте зараз виникла проблема, оскільки я позбувся типу
    // у фільмах як такового, і тепер доводиться витягувати
    // тип фільму через Стратегію ціноутворення. Вже починаю жаліти
    // що його використав, можливо перероблю...
    private final PriceStrategy priceStrategy;
    private final String countryOfOrigin;
    private final String description;
    private final String director;
    private final List<String> actors;

    // Тут просто делегуємо ініціалізовану стратегію по розрахунку вартості прокату
    public double calculatePrice(int daysRented) {
        return priceStrategy.calculatePrice(daysRented);
    }

}
