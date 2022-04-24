package vn.hanu.fit.ss2codecamp.user.services.impl;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.hanu.fit.ss2codecamp.entities.Solution;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;
import vn.hanu.fit.ss2codecamp.entities.User;
import vn.hanu.fit.ss2codecamp.repositories.SolutionRepository;
import vn.hanu.fit.ss2codecamp.repositories.TutorialRepository;
import vn.hanu.fit.ss2codecamp.repositories.UserRepository;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionSaveRequest;
import vn.hanu.fit.ss2codecamp.user.services.USolutionService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class USolutionServiceImpl implements USolutionService {
    private SolutionRepository solutionRepository;

    private UserRepository userRepository;

    private TutorialRepository tutorialRepository;

    public USolutionServiceImpl(SolutionRepository solutionRepository, UserRepository userRepository, TutorialRepository tutorialRepository) {
        this.solutionRepository = solutionRepository;
        this.userRepository = userRepository;
        this.tutorialRepository = tutorialRepository;
    }

    @Override
    public List<Solution> getAll() {
        return solutionRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public List<Solution> getByTutorialIdOrderByTimestamp(int tutorialId) {
        return solutionRepository.findAllByTutorial_Id(tutorialId);
    }

    @Override
    public Solution saveSolution(SolutionSaveRequest solutionSaveRequest) {
        User user = userRepository.getById((long) solutionSaveRequest.getUserId());
        Tutorial tutorial = tutorialRepository.getById(solutionSaveRequest.getTutorialId());
        Solution solution = new Solution();
        solution.setDetails(solutionSaveRequest.getSolutionDetails());
        solution.setUser(user);
        solution.setTutorial(tutorial);
        solution.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        solutionRepository.save(solution);
        return solution;
    }


}
