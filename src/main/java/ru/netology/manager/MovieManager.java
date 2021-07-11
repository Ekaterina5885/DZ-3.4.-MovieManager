package ru.netology.manager;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.MovieList;

@Data
@NoArgsConstructor
public class MovieManager {
    int quantityMovies = 10;
    private MovieList[] movies = new MovieList[0];

    public MovieManager(int quantityMovies) {
        this.quantityMovies = quantityMovies;
    }

// Добавить фильмы;

    public void addMovies(MovieList item) {
        int resultLength = movies.length + 1;

        MovieList[] tmp = new MovieList[resultLength];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        movies = tmp;
    }

//  Выдать фильмы в ленту;

    public MovieList[] getMovies() {
        int resultLength;
        if (movies.length < quantityMovies) {
            resultLength = quantityMovies;
        } else {
            resultLength = movies.length;
        }
        MovieList[] result = new MovieList[resultLength];
        for (int i = 0; i < resultLength; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}