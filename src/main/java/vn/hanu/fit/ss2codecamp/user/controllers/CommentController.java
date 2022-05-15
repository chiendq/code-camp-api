package vn.hanu.fit.ss2codecamp.user.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.ss2codecamp.converters.comment.CommentConverter;
import vn.hanu.fit.ss2codecamp.dtos.Comment.CmtResponseDto;
import vn.hanu.fit.ss2codecamp.entities.Comment;
import vn.hanu.fit.ss2codecamp.services.CommentService;
import vn.hanu.fit.ss2codecamp.user.dtos.RequestComment;

import java.util.List;

@RestController
@RequestMapping("api/v1/comments")
@CrossOrigin
@Slf4j
public class CommentController {

    private CommentService commentService;

    private CommentConverter commentConverter;

    public CommentController(CommentService commentService, CommentConverter commentConverter) {
        this.commentService = commentService;
        this.commentConverter = commentConverter;
    }

    @GetMapping("")
    public ResponseEntity<List<CmtResponseDto>> getAll(){
        return ResponseEntity.ok(commentConverter.rawsToDtos(commentService.getAll()));
    }

    @GetMapping("/tutorial/{id}")
    public ResponseEntity<List<CmtResponseDto>> getAllByTutorialId(@PathVariable("id") Integer tutorialId){
        return ResponseEntity.ok(commentConverter.rawsToDtos(commentService.getAllByTutorialId(tutorialId)));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getById(@PathVariable("id") Integer id){
        return ResponseEntity.ok( (Comment) commentService.getById((id)));
    }

    @PostMapping("")
    public ResponseEntity saveComment(@RequestBody RequestComment requestComment){
        commentService.save(requestComment);
        return new ResponseEntity(HttpStatus.OK);
    }
}
