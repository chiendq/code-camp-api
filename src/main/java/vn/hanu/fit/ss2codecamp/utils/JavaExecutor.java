package vn.hanu.fit.ss2codecamp.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Getter
@Setter

public class JavaExecutor {
    private Process process ;

    private StringBuilder standardStringBuilder;

    private StringBuilder errorStringBuilder;

    private BufferedReader consoleBufferedReader ;

    private BufferedReader errorBufferedReader;

    public JavaExecutor() throws IOException {
        this.process = Runtime.getRuntime().exec("java TestClass.java");
        standardStringBuilder = new StringBuilder();
        errorStringBuilder = new StringBuilder();
        init();
    }

    private void init(){
        consoleBufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        consoleBufferedReader.lines().forEach(s -> standardStringBuilder.append(s));

        errorBufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        errorBufferedReader.lines().forEach(s -> errorStringBuilder.append(s + "\n"));
    }

    public String getStandardOutput(){
        return standardStringBuilder.toString();
    }
    public String getErrorOutput(){
        return errorStringBuilder.toString();
    }

    public boolean isError(){
        if(errorStringBuilder.length() != 0){
            return true;
        }
        return false;
    }
}
