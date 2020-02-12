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
    private AppUser appUser;

    @ManyToMany
    @JoinTable(
            name = "publication-artist",
            joinColumns = @JoinColumn(name = "publication-id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private Set<Artist> artistSet = new HashSet<>();

    private Date date;

    @ManyToMany
    @JoinTable(
            name = "publication-artwork",
            joinColumns = @JoinColumn(name = "publication-id"),
            inverseJoinColumns = @JoinColumn(name = "artwork_id"))
    private Set<Artwork> artworkSet = new HashSet<>();


    @ManyToMany
    @JoinTable(
            name = "publication-title",
            joinColumns = @JoinColumn(name = "publication-id"),
            inverseJoinColumns = @JoinColumn(name = "title_id"))
    private Set<Title> titleSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public Set<Artist> getArtistSet() {
        return artistSet;
    }

    public Date getDate() {
        return date;
    }

    public Set<Artwork> getArtworkSet() {
        return artworkSet;
    }

    public Set<Title> getTitleSet() {
        return titleSet;
    }
}
