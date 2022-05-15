package vn.hanu.fit.ss2codecamp.services.impl;

import org.springframework.stereotype.Service;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;
import vn.hanu.fit.ss2codecamp.models.Respone;
import vn.hanu.fit.ss2codecamp.services.SolutionService;
import vn.hanu.fit.ss2codecamp.services.TutorialService;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionRequest;
import vn.hanu.fit.ss2codecamp.utils.FileUtils;
import vn.hanu.fit.ss2codecamp.utils.JavaExecutor;

import java.io.IOException;

@Service
public class JudgmentService {
    private static final String PATH = "TestClass.java";

    private TutorialService tutorialService;

    private SolutionService solutionService;

    public JudgmentService(TutorialService tutorialService, SolutionService solutionService) {
        this.tutorialService = tutorialService;
        this.solutionService = solutionService;
    }

    public Respone judgment(SolutionRequest solutionRequest){
        try {
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

        } catch (IOException e) {
            e.printStackTrace();
        }


        return  null;
    }
}
