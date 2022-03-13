package vn.hanu.fit.ss2codecamp.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TutorialNotFoundException extends ResponseStatusException {

    public TutorialNotFoundException(String s) {
        super(HttpStatus.NOT_FOUND);
    }
}
