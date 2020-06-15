package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)

class AfishaManagerTest {
    @Mock
    AfishaRepository repository;
    @InjectMocks
    AfishaManager manager;

    Movie first = new  Movie(1, "Герой", "Боевик", "https://", "https://");
    Movie second = new Movie(2, "Горько", "Комедия", "https://", "https://");
    Movie third = new Movie(3, "Ну-Погоди!", "Мультфильм", "https://", "https://");
    Movie four = new Movie(4, "Армагедон", "Фантастика", "https://", "https://");

    @BeforeEach
    public void add () {
        manager.add (first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
    }

    @Test
    void shouldRemoveAll() {
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findAll();
        manager.removeAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
        verify(repository).removeAll();
        verify(repository).findAll();
    }

    @Test
    void shouldFindById() {
        int idToFind = 4;
        Movie[] returned = new Movie[]{four};
        doReturn(returned).when(repository).findAll();
        manager.findById(idToFind);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{four};
        assertArrayEquals(expected, actual);
        verify(repository).findById(idToFind);
    }

    @Test
    void shouldGetAll() {
        Movie[] returned = new Movie[]{};
        doReturn(returned).when(repository).findAll();
        manager.getAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    void addMovie() {
        Movie[] returned = new Movie[]{first};
        doReturn(returned).when(repository).findAll();
        manager.add(first);
        Movie[] expected = new Movie[]{first};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

}