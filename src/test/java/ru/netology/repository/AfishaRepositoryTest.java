package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class AfishaRepositoryTest {
    private AfishaRepository repository = new AfishaRepository();
    Movie first = new  Movie(1, "Герой", "Боевик", "https://", "https://");
    Movie second = new Movie(2, "Горько", "Комедия", "https://", "https://");
    Movie third = new Movie(3, "Ну-Погоди!", "Мультфильм", "https://", "https://");

    @BeforeEach
    public void setUp(){
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    void shouldSave() {
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second ,third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 2;
        repository.removeById(idToRemove);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        repository.findAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{first, second, third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll();
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        int id = 2;
        repository.findById(id);
        Movie[] actual = repository.findAll();
        Movie[] expected = new Movie[]{second};
        assertArrayEquals(expected, actual);
    }


}


