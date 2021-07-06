package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieManagerTest {
    MovieManager manager = new MovieManager();
    private final MovieList firstMovie = new MovieList(1, "MovieTitle-1", "thriller");
    private final MovieList secondMovie = new MovieList(2, "MovieTitle-2", "cartoon");
    private final MovieList thirdMovie = new MovieList(3, "MovieTitle-3", "comedy");
    private final MovieList fourthMovie = new MovieList(4, "MovieTitle-4", "thriller");
    private final MovieList fifthMovie = new MovieList(5, "MovieTitle-5", "horrors");
    private final MovieList sixthMovie = new MovieList(6, "MovieTitle-6", "cartoon");
    private final MovieList seventhMovie = new MovieList(7, "MovieTitle-7", "comedy");
    private final MovieList eighthMovie = new MovieList(8, "MovieTitle-8", "comedy");
    private final MovieList ninthMovie = new MovieList(9, "MovieTitle-9", "comedy");
    private final MovieList tenthMovie = new MovieList(10, "MovieTitle-10", "comedy");


    // Выдать 10 фильмов в ленту;
    @Test
    public void shouldGetLimitMovies() {

        MovieManager manager = new MovieManager(10);
        manager.addMovies(firstMovie);
        manager.addMovies(secondMovie);
        manager.addMovies(thirdMovie);
        manager.addMovies(fourthMovie);
        manager.addMovies(fifthMovie);
        manager.addMovies(sixthMovie);
        manager.addMovies(seventhMovie);
        manager.addMovies(eighthMovie);
        manager.addMovies(ninthMovie);
        manager.addMovies(tenthMovie);

        MovieList[] expected = new MovieList[]{tenthMovie, ninthMovie, eighthMovie, seventhMovie,
                sixthMovie, fifthMovie, fourthMovie, thirdMovie, secondMovie, firstMovie};
        MovieList[] actual = manager.getMovies();

        assertArrayEquals(expected, actual);
    }

    // Выдать в ленту 9 фильмов;
    @Test
    public void shouldGetMoviesBelowLimitValue() {
        MovieManager manager = new MovieManager();

        manager.addMovies(firstMovie);
        manager.addMovies(secondMovie);
        manager.addMovies(thirdMovie);
        manager.addMovies(fourthMovie);
        manager.addMovies(fifthMovie);
        manager.addMovies(sixthMovie);
        manager.addMovies(seventhMovie);
        manager.addMovies(eighthMovie);
        manager.addMovies(ninthMovie);

        MovieList[] expected = new MovieList[]{ninthMovie, eighthMovie, seventhMovie,
                sixthMovie, fifthMovie, fourthMovie, thirdMovie, secondMovie, firstMovie};
        MovieList[] actual = manager.getMovies();

        assertArrayEquals(expected, actual);
    }

    // Выдать фильмы в ленту выше граничного значения;
    @Test
    public void shouldGetMoviesAboveLimitValue() {

        MovieManager manager = new MovieManager(11);
        manager.addMovies(firstMovie);
        manager.addMovies(secondMovie);
        manager.addMovies(thirdMovie);
        manager.addMovies(fourthMovie);
        manager.addMovies(fifthMovie);
        manager.addMovies(sixthMovie);
        manager.addMovies(seventhMovie);
        manager.addMovies(eighthMovie);
        manager.addMovies(ninthMovie);
        manager.addMovies(tenthMovie);

        MovieList[] expected = new MovieList[]{tenthMovie, ninthMovie, eighthMovie, seventhMovie,
                sixthMovie, fifthMovie, fourthMovie, thirdMovie, secondMovie, firstMovie};
        MovieList[] actual = manager.getMovies();

        assertArrayEquals(expected, actual);
    }

    // Выдать 0 фильмов в ленту;
    @Test
    public void shouldGetZeroMovies() {

        MovieManager manager = new MovieManager(0);
        manager.addMovies(firstMovie);
        manager.addMovies(secondMovie);
        manager.addMovies(thirdMovie);
        manager.addMovies(fourthMovie);
        manager.addMovies(fifthMovie);
        manager.addMovies(sixthMovie);
        manager.addMovies(seventhMovie);
        manager.addMovies(eighthMovie);
        manager.addMovies(ninthMovie);
        manager.addMovies(tenthMovie);

        MovieList[] expected = new MovieList[]{};
        MovieList[] actual = manager.getMovies();

        assertArrayEquals(expected, actual);

    }
    // Выдать фильмы в ленту ниже граничного значения;
    @Test
    public void shouldGetMoviesBelowMinimum() {

        MovieManager manager = new MovieManager();
        int quantityMovies = -1;

        manager.setQuantityMovies(quantityMovies);

        int expected = 10;
        int actual = manager.getQuantityMovies();

        assertEquals(expected, actual);

    }
}