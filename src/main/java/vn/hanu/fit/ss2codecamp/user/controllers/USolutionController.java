package vn.hanu.fit.ss2codecamp.user.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.ss2codecamp.entities.Solution;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionSaveRequest;
import vn.hanu.fit.ss2codecamp.user.services.USolutionService;

import java.util.List;

@CrossOrigin
@JsonFormat
@RequestMapping("api/v1/solutions")
@RestController
public class USolutionController {
    private static final Logger logger = LoggerFactory.getLogger(USolutionController.class);

    private USolutionService solutionService;

    public USolutionController(USolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping("/tutorials/{tutorialId}")
    public List<Solution> getSolutionOfTutorialID(@PathVariable("tutorialId") int tutorialId){
        return solutionService.getByTutorialIdOrderByTimestamp(tutorialId);
    }

    @PostMapping("")
    public Solution saveSolution(@RequestBody SolutionSaveRequest solutionSaveRequest){

        return solutionService.saveSolution(solutionSaveRequest);
    }
}
