package vn.hanu.fit.ss2codecamp.user.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestComment {
    private int solutionId;
    private int tutorialId;
    private int userId;
    private String content;
}
