package vn.hanu.fit.ss2codecamp.user.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.ss2codecamp.entities.Respone;
import vn.hanu.fit.ss2codecamp.entities.Solution;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;
import vn.hanu.fit.ss2codecamp.services.impl.TutorialServiceImpl;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionRequest;
import vn.hanu.fit.ss2codecamp.user.services.USolutionService;
import vn.hanu.fit.ss2codecamp.utils.FileUtils;
import vn.hanu.fit.ss2codecamp.utils.JavaExecutor;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@JsonFormat
@RequestMapping("api/v1/solutions")
@RestController
public class USolutionController {
    private static final Logger logger = LoggerFactory.getLogger(USolutionController.class);

    private static final String PATH = "TestClass.java";

    private USolutionService solutionService;

    private TutorialServiceImpl tutorialService;

    public USolutionController(USolutionService solutionService, TutorialServiceImpl tutorialService) {
        this.solutionService = solutionService;
        this.tutorialService = tutorialService;
    }

    @GetMapping("/tutorials/{tutorialId}")
    public List<Solution> getSolutionOfTutorialID(@PathVariable("tutorialId") int tutorialId){
        return solutionService.getByTutorialIdOrderByTimestamp(tutorialId);
    }

    @PostMapping("/save")
    public Solution saveSolution(@RequestBody SolutionRequest solutionRequest){
        return solutionService.saveSolution(solutionRequest);
    }

    @PostMapping("/check")
    public Respone checkSolution(@RequestBody SolutionRequest solutionRequest) throws IOException {
        FileUtils.init(solutionRequest.getSolutionDetails(), PATH);

        JavaExecutor exec = new JavaExecutor();

        String actual = exec.getStandardOutput();
        String errorString = exec.getErrorOutput();

        Tutorial tutorial = tutorialService.getById(solutionRequest.getTutorialId());
        String expected = tutorial.getExpected();

        Respone respone = new Respone("",expected,actual,"");
        respone.setError(errorString);
        respone.setActual(actual);

        if(expected.equals(actual)){
            respone.setMessage("Correct");
            solutionService.saveSolution(solutionRequest);
            return respone;
        }else if(exec.isError()){
            respone.setMessage("Error");
            return respone;
        }

        respone.setMessage("Incorrect");
        return respone;
    }
}
