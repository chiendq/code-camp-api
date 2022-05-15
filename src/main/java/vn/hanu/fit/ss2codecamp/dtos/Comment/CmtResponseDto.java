package vn.hanu.fit.ss2codecamp.dtos.Comment;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;


@Setter
@Getter
public class CmtResponseDto implements Serializable {
    private Integer id;

    private Timestamp createdAt;

    private String content;

    private String username;
}
