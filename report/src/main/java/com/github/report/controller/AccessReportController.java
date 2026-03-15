package com.github.report.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.report.service.GithubService;

@RestController
public class AccessReportController {

    private final GithubService githubService;

    public AccessReportController(GithubService githubService) {
        this.githubService = githubService;
    }

    @GetMapping("/api/access-report")
    public Map<String, List<String>> getAccessReport(
            @RequestParam String org) {

        return githubService.generateAccessReport(org);
    }
}