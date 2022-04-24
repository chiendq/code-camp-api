package vn.hanu.fit.ss2codecamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.ss2codecamp.entities.Solution;

import java.util.List;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Integer> {
    List<Solution> findAllByOrderByCreatedAtDesc();

    List<Solution> findAllByTutorial_Id(int tutorialId);

}
