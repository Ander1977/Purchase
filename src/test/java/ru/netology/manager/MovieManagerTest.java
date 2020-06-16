package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    MovieManager movieManager = new MovieManager();

    @Test
    void MoviesNoAdd() {
        movieManager.getAll();
        Movie[] expected = new Movie[0];
        Movie[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void addMovie() {
        Movie one = new Movie(1, "Время первых", "История", "https://", "https://");
        movieManager.addMovie(one);
        movieManager.getAll();
        Movie[] expected = new Movie[]{one};
        Movie[] actual = movieManager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void addThenMovie() {
        Movie one = new Movie(1, "Время первых", "История", "https://", "https://");
        Movie two = new Movie(2, "О чём говорят мужчины", "Фильм", "https://", "https://");
        Movie three = new Movie(3, "Операция Ы", "комедия", "https://", "https://");
        Movie four = new Movie(4, "Падение Ангела", "боевик", "https://", "https://");
        Movie five = new Movie(5, "У холмов есть глаза", "ужасы", "https://", "https://");
        Movie six = new Movie(6, "Кун-Фу панда", "мультфильм", "https://", "https://");
        Movie seven = new Movie(7, "Выкрутасы", "комедия", "https://", "https://");
        Movie eight = new Movie(8, "Звездные войны", "фантастика", "https://", "https://");
        Movie nine = new Movie(9, "Интерны", "сериал", "https://", "https://");
        Movie then = new Movie(10, "Мадагаскар", "мультфильм", "https://", "https://");
        movieManager.addMovie(one);
        movieManager.addMovie(two);
        movieManager.addMovie(three);
        movieManager.addMovie(four);
        movieManager.addMovie(five);
        movieManager.addMovie(six);
        movieManager.addMovie(seven);
        movieManager.addMovie(eight);
        movieManager.addMovie(nine);
        movieManager.addMovie(then);
        movieManager.getAll();
        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{then, nine, eight, seven, six, five, four, three, two, one};
        assertArrayEquals(expected, actual);
    }


    @Test
    void addMoreThenMovie() {
        Movie one = new Movie(1, "Время первых", "История", "https://", "https://");
        Movie two = new Movie(2, "О чём говорят мужчины", "Фильм", "https://", "https://");
        Movie three = new Movie(3, "Операция Ы", "комедия", "https://", "https://");
        Movie four = new Movie(4, "Падение Ангела", "боевик", "https://", "https://");
        Movie five = new Movie(5, "У холмов есть глаза", "ужасы", "https://", "https://");
        Movie six = new Movie(6, "Кун-Фу панда", "мультфильм", "https://", "https://");
        Movie seven = new Movie(7, "Выкрутасы", "комедия", "https://", "https://");
        Movie eight = new Movie(8, "Звездные войны", "фантастика", "https://", "https://");
        Movie nine = new Movie(9, "Интерны", "сериал", "https://", "https://");
        Movie then = new Movie(10, "Мадагаскар", "мультфильм", "https://", "https://");
        Movie eleven = new Movie(11, "Форсаж", "боевик", "https://", "https://");
        movieManager.addMovie(one);
        movieManager.addMovie(two);
        movieManager.addMovie(three);
        movieManager.addMovie(four);
        movieManager.addMovie(five);
        movieManager.addMovie(six);
        movieManager.addMovie(seven);
        movieManager.addMovie(eight);
        movieManager.addMovie(nine);
        movieManager.addMovie(then);
        movieManager.addMovie(eleven);
        movieManager.getAll();
        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{eleven, then, nine, eight, seven, six, five, four, three, two};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldUseNoArgsConstructor() {
        movieManager.setCount(5);
        Movie one = new Movie(1, "Время первых", "История", "https://", "https://");
        Movie two = new Movie(2, "О чём говорят мужчины", "Фильм", "https://", "https://");
        Movie three = new Movie(3, "Операция Ы", "комедия", "https://", "https://");
        Movie four = new Movie(4, "Падение Ангела", "боевик", "https://", "https://");
        Movie five = new Movie(5, "У холмов есть глаза", "ужасы", "https://", "https://");
        Movie six = new Movie(6, "Кун-Фу панда", "мультфильм", "https://", "https://");
        Movie seven = new Movie(7, "Выкрутасы", "комедия", "https://", "https://");
        Movie eight = new Movie(8, "Звездные войны", "фантастика", "https://", "https://");
        Movie nine = new Movie(9, "Интерны", "сериал", "https://", "https://");
        Movie then = new Movie(10, "Мадагаскар", "мультфильм", "https://", "https://");
        Movie eleven = new Movie(11, "Форсаж", "боевик", "https://", "https://");
        movieManager.addMovie(one);
        movieManager.addMovie(two);
        movieManager.addMovie(three);
        movieManager.addMovie(four);
        movieManager.addMovie(five);
        movieManager.addMovie(six);
        movieManager.addMovie(seven);
        movieManager.addMovie(eight);
        movieManager.addMovie(nine);
        movieManager.addMovie(then);
        movieManager.addMovie(eleven);
        movieManager.getAll();
        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{eleven, then, nine, eight, seven};
        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldGetFiveMovie() {
        MovieManager movieManager = new MovieManager(5);
        Movie one = new Movie(1, "Время первых", "История", "https://", "https://");
        Movie two = new Movie(2, "О чём говорят мужчины", "Фильм", "https://", "https://");
        Movie three = new Movie(3, "Операция Ы", "комедия", "https://", "https://");
        Movie four = new Movie(4, "Падение Ангела", "боевик", "https://", "https://");
        Movie five = new Movie(5, "У холмов есть глаза", "ужасы", "https://", "https://");
        Movie six = new Movie(6, "Кун-Фу панда", "мультфильм", "https://", "https://");
        Movie seven = new Movie(7, "Выкрутасы", "комедия", "https://", "https://");
        Movie eight = new Movie(8, "Звездные войны", "фантастика", "https://", "https://");
        Movie nine = new Movie(9, "Интерны", "сериал", "https://", "https://");
        Movie then = new Movie(10, "Мадагаскар", "мультфильм", "https://", "http://");
        movieManager.addMovie(one);
        movieManager.addMovie(two);
        movieManager.addMovie(three);
        movieManager.addMovie(four);
        movieManager.addMovie(five);
        movieManager.addMovie(six);
        movieManager.addMovie(seven);
        movieManager.addMovie(eight);
        movieManager.addMovie(nine);
        movieManager.addMovie(then);
        movieManager.getAll();
        Movie[] actual = movieManager.getAll();
        Movie[] expected = new Movie[]{then,nine, eight, seven, six};
        assertArrayEquals(expected, actual);
    }
}
