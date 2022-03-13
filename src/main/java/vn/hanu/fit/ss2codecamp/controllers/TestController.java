package vn.hanu.fit.ss2codecamp.controllers;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.hanu.fit.ss2codecamp.Exceptions.TutorialNotFoundException;
import vn.hanu.fit.ss2codecamp.entities.Respone;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;
import vn.hanu.fit.ss2codecamp.repositories.TutorialRepository;
import vn.hanu.fit.ss2codecamp.services.TutorialService;
import vn.hanu.fit.ss2codecamp.utils.FileUtils;
import vn.hanu.fit.ss2codecamp.utils.JavaExecutor;

import java.io.IOException;

@RestController
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    private static final String PATH = "TestClass.java";

    @Autowired
    TutorialService tutorialService;

    @CrossOrigin
    @PostMapping("/test")
    @JsonFormat
    public Respone testAPI(@RequestBody  String code) throws IOException, TutorialNotFoundException {
        FileUtils.init(code, PATH);

        JavaExecutor exec = new JavaExecutor();

        String actual = exec.getStandardOutput();
        String errorString = exec.getErrorOutput();

        Tutorial tutorial = tutorialService.getById(1l);
        final String expected = tutorial.getExpected();

        Respone respone = new Respone("",expected,actual,"");
        respone.setError(errorString);
        respone.setActual(actual);

        if(expected.equals(actual)){
            respone.setMessage("Correct");
            return respone;
        }else if(exec.isError()){
            respone.setMessage("Error");
            return respone;
        }

        respone.setMessage("Incorrect");

        return respone;

    }
}
