package co.simplon.upskilling.filrougemusique.model;

import javax.persistence.*;
import java.net.URL;
import java.util.Date;

@Entity
public class Publication {
    @Id
    @SequenceGenerator(name = "publication_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "publication_seq_id")
    private Long id;

    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private Artist artist;

    private Date date;

    @ManyToOne
    private Artwork artwork;

    @ManyToOne
    private Title title;

    private String snippet;

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

    public String getSnippet() { return snippet; }
}

