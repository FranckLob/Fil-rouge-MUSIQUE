package co.simplon.upskilling.filrougemusique.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Artist {

    @Id
    @SequenceGenerator(name = "artist_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artist_seq_id")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "artist")
    @JsonIgnore
    private Set<Publication> publicationSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Publication> getPublicationSet() {
        return publicationSet;
    }
}
