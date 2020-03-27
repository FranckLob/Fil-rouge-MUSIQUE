package co.simplon.upskilling.filrougemusique.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
public class Authority {

    @Id
    @SequenceGenerator(name = "authority_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_seq_id")
    private Long id;

    @Column(name="authority")
    @Enumerated(EnumType.STRING)
    private AuthorityLevel authority;

    @JsonIgnore
    @ManyToMany(mappedBy = "authorities")
    private List<AppUser> appUsers;

    public Long getId() {
        return id;
    }

    public AuthorityLevel getAuthority() {
        return authority;
    }

    public List<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthority(AuthorityLevel authority) {
        this.authority = authority;
    }

    public void setAppUsers(List<AppUser> appUsers) {
        this.appUsers = appUsers;
    }

}
