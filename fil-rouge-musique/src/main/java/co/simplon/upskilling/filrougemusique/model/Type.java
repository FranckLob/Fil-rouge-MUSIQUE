package co.simplon.upskilling.filrougemusique.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Type {

    @Id
    @SequenceGenerator(name = "type_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_seq_id")
    private Long id;

    @Column(nullable = false)
    private String type;

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private List<Title> titleList=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public List<Title> getTitleList() {
        return titleList;
    }
}
