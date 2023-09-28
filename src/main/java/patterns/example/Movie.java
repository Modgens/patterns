package patterns.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

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

    /*  P.S.
        Таки повернувся назад до звичайного типу в енамах, як на мене,
        стало виглядати краще (все в одному місці і типи і їх ціноутворення)
        Проте мене досі турбує вивід та ввід де тип фільму при створенні варто
        обирати номером, його потрібно буде так само редагувати кожного разу коли
        створюється новий тип фільму. Є ідея зробити тип фільму класом, і потім створювати
        на старті програми по 1 екземпляру, додати всі в список та будувати запит
        додавання типу фільму в консолі через цей список. Але залишу її ідеєю

        P.S.S.
        Хоч і здається що виконав завдання не найкращим шляхом, але рівень знань в області
        патернів до завдання та після відчутно змінився від "щось там чув про 2,3" до "знаю майже всі"
        поки перебрав їх всі, шукав як в пазлах відповідний патерн до тої чи іншої ситуації, майже всі завчив)

     */
    private final FilmType filmType;
    private final String countryOfOrigin;
    private final String description;
    private final String director;
    private final List<String> actors;

    // Тут просто делегуємо ініціалізовану стратегію по розрахунку вартості прокату
    public double calculatePrice(int daysRented) {
        return filmType.calculatePrice(daysRented);
    }

}
