package vn.hanu.fit.ss2codecamp.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tutorial")
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    private String expected;

}
