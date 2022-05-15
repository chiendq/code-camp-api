package vn.hanu.fit.ss2codecamp.user.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.ss2codecamp.models.Respone;
import vn.hanu.fit.ss2codecamp.entities.Solution;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;
import vn.hanu.fit.ss2codecamp.services.SolutionService;
import vn.hanu.fit.ss2codecamp.services.impl.TutorialServiceImpl;
import vn.hanu.fit.ss2codecamp.user.converters.solution.SolutionConverter;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionRequest;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionResponseDto;
import vn.hanu.fit.ss2codecamp.utils.FileUtils;
import vn.hanu.fit.ss2codecamp.utils.JavaExecutor;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@JsonFormat
@RequestMapping("api/v1/solutions")
@RestController
@Slf4j
public class SolutionController {

    private static final String PATH = "TestClass.java";

    private SolutionService solutionService;

    private TutorialServiceImpl tutorialService;

    private SolutionConverter solutionConverter;

    public SolutionController(SolutionService solutionService, TutorialServiceImpl tutorialService) {
        this.solutionService = solutionService;
        this.tutorialService = tutorialService;
    }

    @GetMapping("/tutorials/{tutorialId}")
    public List<SolutionResponseDto> getSolutionOfTutorialID(@PathVariable("tutorialId") int tutorialId){
        return solutionService.getAllByTutorialIdOrderByTimestamp(tutorialId);
    }

    @PostMapping("/save")
    public Solution saveSolution(@RequestBody SolutionRequest solutionRequest){
        return solutionService.save(solutionRequest);
    }

    @PostMapping("/check")
    public Respone checkSolution(@RequestBody SolutionRequest solutionRequest) throws IOException {
        FileUtils.init(solutionRequest.getSolutionDetails(), PATH);

        JavaExecutor exec = new JavaExecutor();

        String actual = exec.getStandardOutput();
        String errorString = exec.getErrorOutput();

        Tutorial tutorial = tutorialService.getById(solutionRequest.getTutorialId());
        String expected = tutorial.getExpected();

        Respone respone = new Respone("",expected,actual,errorString);
//        respone.setError(errorString);
//        respone.setActual(actual);

        if(expected.equals(actual)){
            respone.setMessage("Correct");
            solutionService.save(solutionRequest);
            return respone;
        }else if(exec.isError()){
            respone.setMessage("Error");
            return respone;
        }

        respone.setMessage("Incorrect");
        return respone;
    }
}
