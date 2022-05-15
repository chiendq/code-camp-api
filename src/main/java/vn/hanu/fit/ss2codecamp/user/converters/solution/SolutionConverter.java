package vn.hanu.fit.ss2codecamp.user.converters.solution;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import vn.hanu.fit.ss2codecamp.dtos.Comment.CmtResponseDto;
import vn.hanu.fit.ss2codecamp.entities.Solution;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionResponseDto;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class SolutionConverter {

    public List<SolutionResponseDto> entityToResponseDto(List<Solution> solutions, List<CmtResponseDto> cmtResponseDtoList){
        List<SolutionResponseDto> responseDtos = new ArrayList<>();
        for (Solution solution: solutions
             ) {
            SolutionResponseDto responseDto = new SolutionResponseDto();

            responseDto.setId(solution.getId());
            responseDto.setDetails(solution.getDetails());
            responseDto.setCreatedAt(solution.getCreatedAt());

            responseDto.setComments(cmtResponseDtoList);

            responseDtos.add(responseDto);
        }

        return responseDtos;
    }

    public SolutionResponseDto entityToResponseDto(Solution solution){
        SolutionResponseDto responseDto = new SolutionResponseDto();

        responseDto.setId(solution.getId());
        responseDto.setDetails(solution.getDetails());
        responseDto.setUsername(solution.getUser().getUsername());
        responseDto.setCreatedAt(solution.getCreatedAt());
        return responseDto;
    }

}
