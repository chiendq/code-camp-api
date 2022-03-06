package vn.hanu.fit.ss2codecamp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.hanu.fit.ss2codecamp.controller.TestController;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class FileUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    public static void init(String code,String path) throws IOException {
        save(code, path);
    }
    static void save(String code, String path) throws IOException {
//        LOGGER.info("FileUtils.save(): ");
        BufferedWriter output = null;
        try {
            File file = new File(path);
            output = new BufferedWriter(new FileWriter(file));
            output.write(code);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                output.close();
            }
        }
    }


//    public static boolean changeExtension(File f, String oldExtension, String newExtension) { //, String newExtension
//        File file  = f;
//        String str = file.getPath().replace(oldExtension, newExtension); // replacing extension to another
//        boolean isChanged = file.renameTo(new File(str));
//        LOGGER.info("FILE "+file.getPath()+" CHANGED : " + isChanged);
//        return isChanged;
//    }
}
