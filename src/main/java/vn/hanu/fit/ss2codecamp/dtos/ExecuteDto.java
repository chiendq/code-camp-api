package vn.hanu.fit.ss2codecamp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteDto {
    private int userId;
    private int tutorialId;
    private String solution;
}
