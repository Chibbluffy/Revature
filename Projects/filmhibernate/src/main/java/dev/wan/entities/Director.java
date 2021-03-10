package dev.wan.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="director_id")
    private int directorId;

    @Column(name="fname")
    private String fname;

    @Column(name="lname")
    private String lname;

    // OneToMany
    // Cascade allows us to persist changes to movie through the director object
    @OneToMany(mappedBy = "directorId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Movie> movies = new HashSet<Movie>();

    public Director() {
    }

    public Director(int directorId, String fname, String lname) {
        this.directorId = directorId;
        this.fname = fname;
        this.lname = lname;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Director{" +
                "directorId=" + directorId +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
