package co.simplon.upskilling.filrougemusique.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.domain.Page;

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
    private Set<Publication> publicationSet;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Publication> getPublicationSet() {
        return publicationSet;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = false;
        if(!(obj==null) && obj instanceof Artist) {
            Artist artist = (Artist) obj;
            if (artist.name == ((Artist) obj).name) {
                res = true;
            } else {
                res = false;
            }
        }
        return res;
    }
}
