package dev.wan.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private int movieId;

    @Column(name="title")
    private String title;

    @Column(name="runtime")
    private int runtime;

    @Column(name="d_id")
    @JoinColumn(name="d_id") // more specific annotation for foreign keys
    private int directorId; // foreign key column

//    @ManyToMany(mappedBy = "movie")
//    private Set<Actor> actors;

    public Movie() {
    }

    public Movie(int movieId, String title, int runtime, int directorId) {
        this.movieId = movieId;
        this.title = title;
        this.runtime = runtime;
        this.directorId = directorId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", title='" + title + '\'' +
                ", runtime=" + runtime +
                ", directorId=" + directorId +
                '}';
    }
}
