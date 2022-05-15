package vn.hanu.fit.ss2codecamp.services.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import vn.hanu.fit.ss2codecamp.dtos.Comment.CmtResponseDto;
import vn.hanu.fit.ss2codecamp.entities.Comment;
import vn.hanu.fit.ss2codecamp.entities.Solution;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;
import vn.hanu.fit.ss2codecamp.entities.User;
import vn.hanu.fit.ss2codecamp.repositories.CommentRepository;
import vn.hanu.fit.ss2codecamp.services.CommentService;
import vn.hanu.fit.ss2codecamp.services.SolutionService;
import vn.hanu.fit.ss2codecamp.services.TutorialService;
import vn.hanu.fit.ss2codecamp.services.UserService;
import vn.hanu.fit.ss2codecamp.user.dtos.RequestComment;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    private UserService userService;

    private SolutionService solutionService;

    private TutorialService tutorialService;

    public CommentServiceImpl(CommentRepository commentRepository,
                              UserService userService,
                              @Lazy  SolutionService solutionService,
                              TutorialService tutorialService) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.solutionService = solutionService;
        this.tutorialService = tutorialService;
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
        RequestComment requestComment = (RequestComment) comment;
        User user;
        Solution solution;
        Tutorial tutorial;
        try {
            user = (User) userService.getById(requestComment.getUserId());
            solution = (Solution) solutionService.getById(requestComment.getSolutionId());
            tutorial = tutorialService.getById(requestComment.getTutorialId());
        }catch (Exception e){
            throw new RuntimeException("NOT FOUND");
        }
        Comment saveComment = new Comment();
        saveComment.setContent(requestComment.getContent());
        saveComment.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        saveComment.setTutorial(tutorial);
        saveComment.setSolution(solution);
        saveComment.setUser(user);
        return commentRepository.save(saveComment);
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
