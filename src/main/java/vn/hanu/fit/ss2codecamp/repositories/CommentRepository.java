package vn.hanu.fit.ss2codecamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hanu.fit.ss2codecamp.entities.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> getAllByTutorial_Id(int id);

    List<Comment> getAllByTutorial_IdAndSolution_Id(int tutorialId, int solutionId);

}
