package com.github.report.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.github.report.model.Repository;
import com.github.report.model.User;

@Component
public class GithubApiClient {

    private static final String GITHUB_API = "https://api.github.com";

    // Replace with your GitHub Personal Access Token
    private static final String TOKEN = "YOUR_GITHUB_TOKEN";

    private RestTemplate restTemplate = new RestTemplate();

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + TOKEN);
        headers.set("Accept", "application/vnd.github+json");
        return headers;
    }

    public List<Repository> getRepositories(String org) {

        String url = GITHUB_API + "/orgs/" + org + "/repos";

        HttpEntity<String> entity = new HttpEntity<>(getHeaders());

        ResponseEntity<Repository[]> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, Repository[].class);

        return Arrays.asList(response.getBody());
    }

    public List<User> getCollaborators(String org, String repo) {

        String url = GITHUB_API + "/repos/" + org + "/" + repo + "/collaborators";

        HttpEntity<String> entity = new HttpEntity<>(getHeaders());

        ResponseEntity<User[]> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, User[].class);

        return Arrays.asList(response.getBody());
    }
}