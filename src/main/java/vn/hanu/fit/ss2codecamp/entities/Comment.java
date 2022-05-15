package vn.hanu.fit.ss2codecamp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "comments")
@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp createdAt;

    private String content;

    @ManyToOne
    @JoinColumn(name = "tutorial_id")
    @JsonIgnore
    private Tutorial tutorial;

    @ManyToOne
    @JoinColumn(name = "solution_id")
    @JsonIgnore
    private Solution solution;

    @ManyToOne
    @JoinColumn(name = "user_id")
//    @JsonIgnore
    private User user;
}
