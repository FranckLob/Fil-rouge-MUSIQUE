package co.simplon.upskilling.filrougemusique.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Style {

    @Id
    @SequenceGenerator(name = "style_seq_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "style_seq_id")
    private Long id;

    @Column(nullable = false)
    private String style;

    @OneToMany(mappedBy = "style")
    @JsonIgnore
    private List<Title> titleList=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getStyle() {
        return style;
    }

    public List<Title> getTitleList() {
        return titleList;
    }
}
