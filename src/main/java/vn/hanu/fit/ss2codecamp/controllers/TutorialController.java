package vn.hanu.fit.ss2codecamp.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.ss2codecamp.Exceptions.TutorialNotFoundException;
import vn.hanu.fit.ss2codecamp.entities.Respone;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;
import vn.hanu.fit.ss2codecamp.repositories.TutorialRepository;
import vn.hanu.fit.ss2codecamp.services.TutorialService;
import vn.hanu.fit.ss2codecamp.utils.FileUtils;
import vn.hanu.fit.ss2codecamp.utils.JavaExecutor;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/tutorials")
@CrossOrigin
@JsonFormat
public class TutorialController {
    private static final String PATH = "TestClass.java";

    private static final Logger LOGGER = LoggerFactory.getLogger(TutorialController.class);

    @Autowired
    TutorialService tutorialService;

    @GetMapping
    public List<Tutorial> getAllTutorial(){
        return tutorialService.getAll();
    }

    @GetMapping("/{id}")
    public Tutorial getById(@PathVariable("id")Long id) throws TutorialNotFoundException {
        return tutorialService.getById(id);
    }

    @PostMapping("/helloworld")
    public Respone tutorials1(@RequestBody String code) throws IOException {
        LOGGER.info(code);
        FileUtils.init(code, PATH);

        JavaExecutor exec = new JavaExecutor();

        String actual = exec.getStandardOutput();
        String errorString = exec.getErrorOutput();

        Respone respone = new Respone("",null,actual,"");
        respone.setError(errorString);
        respone.setActual(actual);
        return respone;
    }

}
