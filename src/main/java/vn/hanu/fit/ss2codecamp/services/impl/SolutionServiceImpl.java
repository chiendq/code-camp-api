package vn.hanu.fit.ss2codecamp.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.hanu.fit.ss2codecamp.converters.comment.CommentConverter;
import vn.hanu.fit.ss2codecamp.entities.Comment;
import vn.hanu.fit.ss2codecamp.entities.Solution;
import vn.hanu.fit.ss2codecamp.entities.User;
import vn.hanu.fit.ss2codecamp.repositories.SolutionRepository;
import vn.hanu.fit.ss2codecamp.services.*;
import vn.hanu.fit.ss2codecamp.user.converters.solution.SolutionConverter;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionRequest;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionResponseDto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SolutionServiceImpl implements SolutionService {
    private SolutionRepository solutionRepository;

    private TutorialService tutorialService;

    private UserService userService;

    private SolutionConverter solutionConverter;

    private CommentService commentService;

    private CommentConverter commentConverter;

    @Override
    public List getAll() {
        return solutionRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public Solution getById(int id) {
        return solutionRepository.getById(id);
    }

    @Override
    public void deleteById(int id) {
        if(!solutionRepository.existsById(id)) throw new RuntimeException("NOT FOUND");
        solutionRepository.deleteById(id);
    }

    /**
     * Not done yet
     */
    @Override
    public Solution updateById(int id, Object o) {
        if(!solutionRepository.existsById(id)) throw new RuntimeException("NOT FOUND");

        return null;
    }

    @Override
    public Solution save(Object solution) {
        return solutionRepository.save((Solution) solution);
    }

    @Override
    public List<SolutionResponseDto> getAllByTutorialIdOrderByTimestamp(int tutorialId) {
        List<SolutionResponseDto> solutionResponseDtos = new ArrayList<>();
        List<Solution> solutions = solutionRepository.findAllByTutorial_Id(tutorialId);
        for (Solution solution: solutions
             ) {
            List<Comment> comments = commentService.getAllByTutorialIdAndSolutionId(tutorialId, solution.getId());
            SolutionResponseDto solutionResponseDto = solutionConverter.entityToResponseDto(solution);
            solutionResponseDto.setComments( commentConverter.rawsToDtos(comments));
            solutionResponseDtos.add(solutionResponseDto);
        }

        return solutionResponseDtos;
    }

    @Override
    public Solution save(SolutionRequest solutionRequest) {
        Solution solution = new Solution();
        solution.setDetails(solutionRequest.getSolutionDetails());
        solution.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        solution.setTutorial(tutorialService.getById(solutionRequest.getTutorialId()));
        solution.setUser((User) userService.getById(solutionRequest.getUserId()));

        return solutionRepository.save(solution);
    }
}
