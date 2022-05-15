package vn.hanu.fit.ss2codecamp.services;

import vn.hanu.fit.ss2codecamp.entities.Tutorial;

import java.util.List;

public interface TutorialService {
    Tutorial getById(int id);

    List<Tutorial> getAll();
}
