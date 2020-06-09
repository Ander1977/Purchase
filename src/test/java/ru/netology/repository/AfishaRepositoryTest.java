package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();

    @Test
    void shouldSave() {
        Movie first = new  Movie(1, "Герой", "Боевик", "https://", "https://");
        Movie second = new Movie(2, "Горько", "Комедия", "https://", "https://");
        Movie third = new Movie(3, "Ну-Погоди!", "Мультфильм", "https://", "https://");

        repository.save(first);
        repository.save(second);
        repository.save(third);

        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second ,third};

        assertArrayEquals(expected, actual);

    }

}