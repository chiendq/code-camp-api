package vn.hanu.fit.ss2codecamp.services;

import vn.hanu.fit.ss2codecamp.entities.Solution;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionRequest;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionResponseDto;

import java.util.List;

public interface SolutionService extends CRUDService {

    List<SolutionResponseDto> getAllByTutorialIdOrderByTimestamp(int tutorialId);

    Solution save(SolutionRequest solutionRequest);
}
