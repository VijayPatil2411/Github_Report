package com.github.report.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.github.report.client.GithubApiClient;
import com.github.report.model.Repository;
import com.github.report.model.User;

@Service
public class GithubService {

    private final GithubApiClient githubApiClient;

    public GithubService(GithubApiClient githubApiClient) {
        this.githubApiClient = githubApiClient;
    }

    public Map<String, List<String>> generateAccessReport(String org) {

        Map<String, List<String>> accessMap = new HashMap<>();

        // Fetch repositories of the organization
        List<Repository> repositories = githubApiClient.getRepositories(org);

        for (Repository repo : repositories) {

            // Fetch collaborators for each repository
            List<User> collaborators =
                    githubApiClient.getCollaborators(org, repo.getName());

            for (User user : collaborators) {

                accessMap
                        .computeIfAbsent(user.getLogin(), k -> new java.util.ArrayList<>())
                        .add(repo.getName());
            }
        }

        return accessMap;
    }
}