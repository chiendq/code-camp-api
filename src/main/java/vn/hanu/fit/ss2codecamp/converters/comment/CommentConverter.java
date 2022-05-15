package vn.hanu.fit.ss2codecamp.converters.comment;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import vn.hanu.fit.ss2codecamp.dtos.Comment.CmtResponseDto;
import vn.hanu.fit.ss2codecamp.entities.Comment;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentConverter {

    public CmtResponseDto rawToDto(Comment comment){
        CmtResponseDto cmtResponseDto = new CmtResponseDto();

        cmtResponseDto.setId(comment.getId());
        cmtResponseDto.setContent(comment.getContent());
        cmtResponseDto.setCreatedAt(comment.getCreatedAt());
        cmtResponseDto.setUsername(comment.getUser().getUsername());
        return cmtResponseDto;
    }

    public List<CmtResponseDto> rawsToDtos(List<Comment> comments){
        List<CmtResponseDto> cmtResponseDtos = new ArrayList<>();
        for (Comment c : comments) {
            cmtResponseDtos.add(rawToDto(c));
        }
        return  cmtResponseDtos;
    }
}
