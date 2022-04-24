package vn.hanu.fit.ss2codecamp.user.dtos.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolutionRequest {
    private int userId;
    private int tutorialId;
    private String solutionDetails;
}
