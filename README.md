🌐 Live API (Test Directly)

This Task is deployed on render
You can test the deployed API directly in your browser.


live link 1:

https://github-report.onrender.com/api/access-report?org=spring-projects

live link 2:

https://github-report.onrender.com/api/access-report?org=github

These endpoints will return a JSON report showing GitHub users and the repositories they contribute to within the specified organization.

Note : Due to inactivity server may take 2-5 minutes to rebuild please wait till render rebuilds and then you can test API.

------------------------------------------------------------------------------------------------------------------------------------------------


# Project Overview

This project is a **Spring Boot REST API** that generates a report of GitHub users and the repositories they contribute to within a specified GitHub organization.

The API:

1. Fetches all repositories of a GitHub organization
2. Retrieves contributors for each repository
3. Aggregates the contributor data
4. Returns a JSON report showing which users contribute to which repositories


------------------------------------------------------------------------------

📂 Project Structure


src/main/java/com/github/report
│
├── controller
│   └── AccessReportController.java
│
├── service
│   └── GithubService.java
│
├── client
│   └── GithubApiClient.java
│
├── model
│   ├── Repository.java
│   └── User.java
│
└── ReportApplication.java

----------------------------------------------------------------------------------------------------------------
# How Authentication is Configured

GitHub API requires authentication to avoid strict rate limits.

Authentication is configured using a **GitHub Personal Access Token** stored as an environment variable.

application.properties

github.token=${GITHUB_TOKEN}

The token is injected into the application using Spring:

@Value("${github.token}")

and added to API requests using:

Authorization: Bearer <token>

--------------------------------------------------------------------------------------------------------------

# How to Call the API Endpoint

Endpoint:

GET /api/access-report

Query Parameter:

org → GitHub organization name

Example:

/api/access-report?org=github

Example full request:

https://github-report.onrender.com/api/access-report?org=github

--------------------------------------------------------------------------------------------------------------

# Assumptions and Design Decisions

• Only public repositories of the organization are considered

• GitHub Contributors API is used to determine repository contributors

• A user contributing to multiple repositories is grouped under the same user

• Authentication is handled using a GitHub Personal Access Token

• The project focuses on backend API functionality and does not include a frontend

• Input is provided using query parameters

--------------------------------------------------------------------------------------------------------------


📥 Providing Input via Query Parameter

This application does not include a frontend interface.
The input is provided directly through the URL query parameter.


Format:

/api/access-report?org=<github-organization-name>

Example:

https://github-report.onrender.com/api/access-report?org=github

The org parameter represents the GitHub organization name.


--------------------------------------------------------------------------------------------------------------------------------

🛠 Tech Stack

Java 17

Spring Boot

Maven

GitHub REST API

Docker


