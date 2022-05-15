package vn.hanu.fit.ss2codecamp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "tutorials")
public class Tutorial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    private String expected;

    @OneToMany(fetch = FetchType.LAZY,
    cascade = CascadeType.ALL,mappedBy = "tutorial")
    @JsonIgnore
    private List<Solution> solutions;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,mappedBy = "tutorial")
    @JsonIgnore
    private List<Comment> comments;
}
