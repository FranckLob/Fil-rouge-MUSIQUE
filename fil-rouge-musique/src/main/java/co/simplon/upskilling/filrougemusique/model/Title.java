package co.simplon.upskilling.filrougemusique.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Title {

    @Id
    @SequenceGenerator(name = "title_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "title_seq_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Style style;

    private String author;

    private String composer;

    @OneToMany(mappedBy = "title")
    @JsonIgnore
    private Set<Publication> publicationSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Style getStyle() {
        return style;
    }

    public String getAuthor() {
        return author;
    }

    public String getComposer() {
        return composer;
    }

    public Set<Publication> getPublicationSet() {
        return publicationSet;
    }
}
