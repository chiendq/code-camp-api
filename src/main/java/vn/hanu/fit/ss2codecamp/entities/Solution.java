package vn.hanu.fit.ss2codecamp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Table(name = "solutions")
@Entity
@Getter
@Setter
public class Solution implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 9000)
    private String details;

    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "tutorial_id")
    @JsonIgnore
    private Tutorial tutorial;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,mappedBy = "tutorial")
    @JsonIgnore
    private List<Comment> comments;
}


