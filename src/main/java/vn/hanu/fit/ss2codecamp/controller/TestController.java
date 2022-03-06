package vn.hanu.fit.ss2codecamp.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.aspectj.weaver.bcel.ClassPathManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.hanu.fit.ss2codecamp.entity.Respone;
import vn.hanu.fit.ss2codecamp.utils.FileUtils;

import javax.print.attribute.standard.PresentationDirection;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@RestController

public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    private static final String PATH = "src/main/java/vn/hanu/fit/ss2codecamp/TestClass.java";

    private static final String ABSOLUTE_PATH = "D:\\Y3S2\\Software Engineer 2\\project\\Sample\\SE2-Project-master\\se2-tut3-springboot-starter\\ss2-code-camp\\TestClass.java";

    @CrossOrigin
    @PostMapping("/test")
    @JsonFormat
    public Respone testAPI(@RequestBody  String code) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FileUtils.init(code, ABSOLUTE_PATH);

        Process process = Runtime.getRuntime().exec("java TestClass.java");

        StringBuilder stdStringBuilder = new StringBuilder();
        // standard out put
        BufferedReader lineReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        lineReader.lines().forEach(s -> stdStringBuilder.append(s + "\n"));

        // error here
        StringBuilder errorStringBuilder = new StringBuilder();
        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        errorReader.lines().forEach(s -> errorStringBuilder.append(s + "\n"));

        System.out.println("Standard : " + stdStringBuilder);
        System.out.println("ERROR : " + errorStringBuilder);

        Respone respone = new Respone();
        respone.setError(errorStringBuilder.toString());
        respone.setContent(stdStringBuilder.toString());

        return respone;
    }
}
