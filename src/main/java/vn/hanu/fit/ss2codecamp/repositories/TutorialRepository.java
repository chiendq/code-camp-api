package vn.hanu.fit.ss2codecamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    Optional<Tutorial> findTutorialById(Long id);
}


