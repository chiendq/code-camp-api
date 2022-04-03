package vn.hanu.fit.ss2codecamp.controllers;

//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import vn.hanu.fit.ss2codecamp.Exceptions.TutorialNotFoundException;
//import vn.hanu.fit.ss2codecamp.entities.Respone;
//import vn.hanu.fit.ss2codecamp.entities.Tutorial;
//import vn.hanu.fit.ss2codecamp.repositories.TutorialRepository;
//import vn.hanu.fit.ss2codecamp.services.TutorialService;
//import vn.hanu.fit.ss2codecamp.utils.FileUtils;
//import vn.hanu.fit.ss2codecamp.utils.JavaExecutor;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("testAPI")
//public class TestController {
//    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
//
//    private static final String PATH = "TestClass.java";
//
//    @Autowired
//    TutorialService tutorialService;
//
//    @CrossOrigin
//    @PostMapping("/test")
//    @JsonFormat
//    public Respone testAPI(@RequestBody  String code) throws IOException, TutorialNotFoundException {
//        FileUtils.init(code, PATH);
//
//        JavaExecutor exec = new JavaExecutor();
//
//        String actual = exec.getStandardOutput();
//        String errorString = exec.getErrorOutput();
//
//        Tutorial tutorial = tutorialService.getById(2l);
//        final String expected = tutorial.getExpected();
//
//        Respone respone = new Respone("",expected,actual,"");
//        respone.setError(errorString);
//        respone.setActual(actual);
//
//        LOGGER.info("Expected: " + expected + ", actual: " + actual);
//        if(expected.equals(actual)){
//            respone.setMessage("Correct");
//            return respone;
//        }else if(exec.isError()){
//            respone.setMessage("Error");
//            return respone;
//        }
//
//        respone.setMessage("Incorrect");
//
//        return respone;
//
//    }
//}

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}