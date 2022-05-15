package vn.hanu.fit.ss2codecamp.user.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.ss2codecamp.models.Respone;
import vn.hanu.fit.ss2codecamp.services.impl.JudgmentService;
import vn.hanu.fit.ss2codecamp.user.dtos.solution.SolutionRequest;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/judgments")
@CrossOrigin
@Slf4j
public class JudgmentController{

    private JudgmentService judgmentService;

    public JudgmentController(JudgmentService judgmentService) {
        this.judgmentService = judgmentService;
    }

    @PostMapping("")
    public Respone codeJudgment(@RequestBody SolutionRequest solutionRequest) throws IOException {
        return judgmentService.judgment(solutionRequest);
    }
}
