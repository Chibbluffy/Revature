package dev.wan.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="actor_movie",
    joinColumns = { // first join column is foreign key
            // points to actor (the entity you are actually in
            @JoinColumn(name="a_id")
    },
    inverseJoinColumns = { // the inverse join column is the foreign key that
            // points to movies (the entity you are trying to connect with)
            @JoinColumn(name="m_id")
    })
    private Set<Movie> movies = new HashSet<Movie>();

    public Actor() {
    }

    public Actor(int id, String firstName, String lastName, Set<Movie> movies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", movies=" + movies +
                '}';
    }
}
