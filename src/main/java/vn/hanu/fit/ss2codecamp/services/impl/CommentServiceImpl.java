package vn.hanu.fit.ss2codecamp.services.impl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.ss2codecamp.dtos.Comment.CmtResponseDto;
import vn.hanu.fit.ss2codecamp.entities.Comment;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;
import vn.hanu.fit.ss2codecamp.entities.User;
import vn.hanu.fit.ss2codecamp.repositories.CommentRepository;
import vn.hanu.fit.ss2codecamp.services.CommentService;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getById(int id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        if(!commentRepository.existsById(id)) throw new RuntimeException("Not exist");
        commentRepository.deleteById(id);
    }

    @Override
    public Comment updateById(int id, Object updateCmt) {
        return null;
    }

    @Override
    public Comment save(Object comment) {
        return commentRepository.save((Comment) comment);
    }

    @Override
    public List<Comment> getAllByTutorialId(int tutorialId) {

        return commentRepository.getAllByTutorial_Id(tutorialId);
    }

    @Override
    public List<Comment> getAllByTutorialIdAndSolutionId(int tutorialId, int solutionId) {
        return commentRepository.getAllByTutorial_IdAndSolution_Id(tutorialId, solutionId);
    }
}
