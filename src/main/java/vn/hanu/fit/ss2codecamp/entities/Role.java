package vn.hanu.fit.ss2codecamp.entities;

import lombok.Data;
import vn.hanu.fit.ss2codecamp.models.ERole;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ERole name;


}
