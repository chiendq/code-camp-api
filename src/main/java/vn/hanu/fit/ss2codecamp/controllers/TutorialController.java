package vn.hanu.fit.ss2codecamp.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.ss2codecamp.exceptions.TutorialNotFoundException;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;
import vn.hanu.fit.ss2codecamp.services.TutorialService;

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
