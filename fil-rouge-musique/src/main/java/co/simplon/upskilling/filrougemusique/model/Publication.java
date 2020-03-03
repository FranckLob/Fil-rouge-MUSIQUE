package co.simplon.upskilling.filrougemusique.model;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publication {
    @Id
    @SequenceGenerator(name = "publication_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publication_seq_id")
    private Long id;

    @Column(nullable = false)
    @ManyToOne
    @ManyToOne
    private AppUser appUser;

    private Artist artist;

    private Date date;

    @ManyToOne
    private Artwork artwork;

    @ManyToOne
    private Title title;

    private URL snippet;

    public Long getId() {
        return id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public Artist getArtist() {
        return artist;
    }

    public Date getDate() {
        return date;
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public Title getTitle() {
        return title;
    }

    public URL getSnippet() { return snippet; }
}

