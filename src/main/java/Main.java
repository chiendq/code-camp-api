import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) throws IOException {

        Process process = Runtime.getRuntime().exec("java TestClass.java");

        BufferedReader lineReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        lineReader.lines().forEach(System.out::println);

        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        errorReader.lines().forEach(System.out::println);
    }
}
