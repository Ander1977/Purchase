package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


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
    Movie five = new Movie(5, "У холмов есть глаза", "ужасы", "https://", "https://");
    Movie six = new Movie(6, "Кун-Фу панда", "мультфильм", "https://", "https://");
    Movie seven = new Movie(7, "Выкрутасы", "комедия", "https://", "https://");
    Movie eight = new Movie(8, "Звездные войны", "фантастика", "https://", "https://");
    Movie nine = new Movie(9, "Интерны", "сериал", "https://", "https://");
    Movie then = new Movie(10, "Мадагаскар", "мультфильм", "https://", "https://");
    Movie eleven = new Movie(11, "Форсаж", "боевик", "https://", "https://");

    @Test
    void addThenMovie() {
        Movie[] returned = new Movie[]{first, second, third, four, five, six, seven, eight, nine, then};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{then, nine, eight, seven, six, five, four, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void addMoreThenMovie() {
        Movie[] returned = new Movie[]{first, second, third, four, five, six, seven, eight, nine, then, eleven};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{eleven, then, nine, eight, seven, six, five, four, third, second};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();

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
        doReturn(returned).when(repository).findById(idToFind);
        Movie[] actual = manager.findById(idToFind);
        Movie[] expected = new Movie[]{four};
        assertArrayEquals(expected, actual);
        verify(repository).findById(idToFind);
    }

    @Test
    void shouldRemoveById() {
        int idToRemove = 4;
        Movie[] returned = new Movie[]{first, second, third, five};
        doReturn(returned).when(repository).findAll();
        manager.removeById(idToRemove);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{five, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
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
    @Test
    void MoviesNoAdd() {
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findAll();
        Movie[] expected = new Movie[0];
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldGetNumberFilms() {
        manager.setCount(5);
        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldIdNotFind() {
        int idToFind = 8;
        Movie[] returned = new Movie[0];
        doReturn(returned).when(repository).findById(idToFind);
        Movie[] actual = manager.findById(idToFind);
        Movie[] expected = new Movie[0];
        assertArrayEquals(expected, actual);
        verify(repository).findById(idToFind);
    }

    @Test
    void shouldRemoveIdNotFind() {
        int idToRemove = 3;
        Movie[] returned = new Movie[]{first, second, four};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{four, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    void shouldGetAll() {
        Movie[] returned = new Movie[]{first, second, third, four, five, six, seven, eight, nine,then};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{then, nine, eight, seven, six, five, four, third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldNotRemoveIfNotExists (){
        int idToRemove = 4;
        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);
        manager.removeById(idToRemove);
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{third, second, first};
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    void showCountLow() {
        manager.setCount(2);
        Movie[] returned = new Movie[]{first, second, third, four, five, six};
        doReturn(returned).when(repository).findAll();
        Movie[] actual = manager.getAll();
        Movie[] expected = new Movie[]{six, five};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }


}