package vn.hanu.fit.ss2codecamp.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.ss2codecamp.Exceptions.TutorialNotFoundException;
import vn.hanu.fit.ss2codecamp.models.Respone;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;
import vn.hanu.fit.ss2codecamp.services.TutorialService;
import vn.hanu.fit.ss2codecamp.services.impl.JudgmentService;
import vn.hanu.fit.ss2codecamp.services.impl.TutorialServiceImpl;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/tutorials")
@CrossOrigin
@JsonFormat
@Slf4j
public class TutorialController {
    private TutorialService tutorialService;

    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GetMapping
    public List<Tutorial> getAllTutorial(){
        return tutorialService.getAll();
    }

    @GetMapping("/{id}")
    public Tutorial getById(@PathVariable("id")int id) throws TutorialNotFoundException {
        return tutorialService.getById(id);
    }

}
