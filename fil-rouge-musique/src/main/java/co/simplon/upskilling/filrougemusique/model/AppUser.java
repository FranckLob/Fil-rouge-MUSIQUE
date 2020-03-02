package co.simplon.upskilling.filrougemusique.model;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AppUser {

    @Id
    @SequenceGenerator(name = "appuser_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_seq_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String nickName;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "appuser-authority",
            joinColumns = @JoinColumn(name = "appuser-id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorities;

    @OneToMany(mappedBy = "appUser")
    @JsonIgnore
    private List<Publication> publicationList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public List<Publication> getPublicationList() {
        return publicationList;
    }
}
