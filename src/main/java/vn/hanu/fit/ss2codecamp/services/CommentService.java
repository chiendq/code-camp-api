package vn.hanu.fit.ss2codecamp.services;


import vn.hanu.fit.ss2codecamp.entities.Comment;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;

import java.util.List;

public interface CommentService extends CRUDService{
    List<Comment> getAllByTutorialId(int tutorialId);

    List<Comment> getAllByTutorialIdAndSolutionId(int tutorialId, int solutionId);
}
