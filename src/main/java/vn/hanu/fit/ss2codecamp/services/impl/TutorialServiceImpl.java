package vn.hanu.fit.ss2codecamp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.hanu.fit.ss2codecamp.Exceptions.TutorialNotFoundException;
import vn.hanu.fit.ss2codecamp.entities.Tutorial;
import vn.hanu.fit.ss2codecamp.repositories.TutorialRepository;
import vn.hanu.fit.ss2codecamp.services.TutorialService;

import java.util.List;

@Service
public class TutorialServiceImpl implements TutorialService {

    public TutorialServiceImpl(TutorialRepository tutorialRepository) {
        this.tutorialRepository = tutorialRepository;
    }

    TutorialRepository tutorialRepository;

    public Tutorial getById(int id) throws TutorialNotFoundException {
        Tutorial tutorial = tutorialRepository.findById(id)
                .orElseThrow(()->new TutorialNotFoundException("Tutorial not found - " + id));
        return tutorial;
    }

    public List<Tutorial> getAll(){
        return tutorialRepository.findAll();
    }
}
