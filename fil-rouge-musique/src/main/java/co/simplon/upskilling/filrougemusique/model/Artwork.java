package co.simplon.upskilling.filrougemusique.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artwork {

    @Id
    @SequenceGenerator(name = "artwork_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artwork_seq_id")
    private Long id;

    private String name;

    private String editor;

    private String producer;

    @ManyToMany(mappedBy = "artworkSet")
    private Set<Publication> publicationSet=new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEditor() {
        return editor;
    }

    public String getProducer() {
        return producer;
    }

    public Set<Publication> getPublicationSet() {
        return publicationSet;
    }
}
