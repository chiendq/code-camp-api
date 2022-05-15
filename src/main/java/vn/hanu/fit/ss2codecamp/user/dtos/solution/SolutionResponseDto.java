package vn.hanu.fit.ss2codecamp.user.dtos.solution;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.hanu.fit.ss2codecamp.dtos.Comment.CmtResponseDto;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolutionResponseDto {
    private int id;
    private String details;
    private Timestamp createdAt;
    private List<CmtResponseDto> comments;
}
