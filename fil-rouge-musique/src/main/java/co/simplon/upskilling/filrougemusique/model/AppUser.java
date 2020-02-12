package co.simplon.upskilling.filrougemusique.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AppUser {

    @Id
    @SequenceGenerator(name = "appuser_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_seq_id")
    private Long id;

    @Column(nullable = false)
    private String nickname;

    private Boolean isAdmin;

    @OneToMany(mappedBy = "appUser")
    private List<Publication> publicationList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public List<Publication> getPublicationList() {
        return publicationList;
    }
}
