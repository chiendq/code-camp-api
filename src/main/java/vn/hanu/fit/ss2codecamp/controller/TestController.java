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
//        save(code);
//        boolean changeExtension = changeExtension(new File(PATH),"java");
//        LOGGER.info("changeExtension(): " + changeExtension);
        FileUtils.init(code, PATH);
        return "OK";
    }

//    static void save(String code) throws IOException {
//        LOGGER.info("save(): " + code);
//        BufferedWriter output = null;
//        try {
//            File file = new File(PATH);
//            output = new BufferedWriter(new FileWriter(file));
////            output.write("package vn.hanu.fit.ss2codecamp;");
//            output.append(code);
//        } catch ( IOException e ) {
//            e.printStackTrace();
//        } finally {
//            if ( output != null ) {
//                output.close();
//            }
//        }
//    }
//
//    public static boolean changeExtension(File f, String newExtension) {
//        File file  = f;
//        String str = file.getPath().replace(".txt", ".java"); // replacing extension to another
//        return file.renameTo(new File(str));
//    }

}
