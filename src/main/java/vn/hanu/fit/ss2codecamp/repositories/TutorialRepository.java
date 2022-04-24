package vn.hanu.fit.ss2codecamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
    Optional<Tutorial> findTutorialById(Long id);
}


