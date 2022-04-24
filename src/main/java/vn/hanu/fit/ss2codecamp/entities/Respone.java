package vn.hanu.fit.ss2codecamp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Respone implements Serializable {

    private String message;

    private String expected;

    private String actual;

    private String error;

}
