package vn.hanu.fit.ss2codecamp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.hanu.fit.ss2codecamp.TestClass;
import vn.hanu.fit.ss2codecamp.utils.FileUtils;

import javax.print.attribute.standard.PresentationDirection;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestController

public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    private static final String PATH = "src/main/java/vn/hanu/fit/ss2codecamp/TestClass.java";

    private static final String ABSOLUTE_PATH = "D:\\Y3S2\\Software Engineer 2\\project\\Sample\\SE2-Project-master\\se2-tut3-springboot-starter\\ss2-code-camp\\src\\main\\java\\vn\\hanu\\fit\\ss2codecamp\\TestClass.java";
    @PostMapping("/test")
    public ResponseEntity<?> testAPI(@RequestBody  String code) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FileUtils.init(code, PATH);


        Class<?> clazz = Class.forName("vn.hanu.fit.ss2codecamp.TestClass");
        Method main = clazz.getDeclaredMethod("main", String[].class);
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(out);
            main.invoke(main, new Object[]{new String[0]});
            System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    public void testTestTest(){
        String expect = "Hello World";
    }


}
