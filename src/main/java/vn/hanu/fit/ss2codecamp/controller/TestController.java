package vn.hanu.fit.ss2codecamp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.hanu.fit.ss2codecamp.utils.FileUtils;

import java.io.IOException;

@RestController

public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    private static final String PATH = "src/main/java/vn/hanu/fit/ss2codecamp/Code.txt";

    @PostMapping("/test")
    public String testAPI(@RequestBody  String code) throws IOException {
        LOGGER.info("/test: " + code);
        FileUtils.init(code, PATH);
        return "OK";
    }


}
