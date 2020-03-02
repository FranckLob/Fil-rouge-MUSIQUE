package co.simplon.upskilling.filrougemusique.model;

import javax.persistence.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Title {

    @Id
    @SequenceGenerator(name = "title_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "title_seq_id")
    private Long id;

    private String name;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Style style;

    private String author;

    private String composer;

//    private URL snippet;

    @OneToMany(mappedBy = "title")
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

//    public URL getSnippet() {
//        return snippet;
//    }

    public Set<Publication> getPublicationSet() {
        return publicationSet;
    }
}
