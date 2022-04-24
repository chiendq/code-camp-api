package vn.hanu.fit.ss2codecamp.user.services;

import vn.hanu.fit.ss2codecamp.entities.Solution;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionSaveRequest;

import java.util.List;

public interface USolutionService {
    List<Solution> getAll();

    List<Solution> getByTutorialIdOrderByTimestamp(int tutorialId);

    Solution saveSolution(SolutionSaveRequest solutionSaveRequest);
}
