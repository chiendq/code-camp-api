package vn.hanu.fit.ss2codecamp.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.ss2codecamp.Exceptions.TutorialNotFoundException;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;
import vn.hanu.fit.ss2codecamp.repositories.TutorialRepository;
import vn.hanu.fit.ss2codecamp.services.TutorialService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/tutorials")
@CrossOrigin
@JsonFormat
public class TutorialController {

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
}
