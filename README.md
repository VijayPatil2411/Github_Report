🌐 Live API (Test Directly)
This Task is deployed on render
You can test the deployed API directly in your browser.

live link 1:

https://github-report.onrender.com/api/access-report?org=spring-projects

live link 2:

https://github-report.onrender.com/api/access-report?org=github

These endpoints will return a JSON report showing GitHub users and the repositories they contribute to within the specified organization.

📥 Providing Input via Query Parameter

This application does not include a frontend interface.
The input is provided directly through the URL query parameter.


Format:

/api/access-report?org=<github-organization-name>

Example:

https://github-report.onrender.com/api/access-report?org=github

The org parameter represents the GitHub organization name.

🖼 Screenshot: Passing Organization as Query Parameter



📌 Project Overview

This project is a Spring Boot REST API that generates a report of GitHub users and the repositories they contribute to within a given organization.

The application performs the following steps:

Fetch all repositories of a GitHub organization.

Retrieve contributors for each repository.

Aggregate contributor data.

Return a structured report showing which user contributes to which repositories.

🛠 Tech Stack

Java 17

Spring Boot

Maven

GitHub REST API

Docker

Render (Cloud Deployment)

🔗 API Endpoint
GET /api/access-report
Query Parameter
Parameter	Description
org	GitHub organization name

Example request:

/api/access-report?org=github

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

-----------------------------------------------------------------------------

⚙ How It Works

1️⃣ User sends request:

/api/access-report?org=<organization>

2️⃣ Controller receives the request.

3️⃣ Service layer processes the business logic.

4️⃣ GitHub API Client fetches data from GitHub APIs:

https://api.github.com/orgs/{org}/repos

and

https://api.github.com/repos/{org}/{repo}/contributors

5️⃣ The data is aggregated and returned as a JSON response.

-------------------------------------------------------------------------

🖥 Running Locally

Clone the repository:

git clone https://github.com/VijayPatil2411/Github_Report.git

Navigate into the project directory:

cd Github_Report

Run the application:

mvn spring-boot:run

-----------------------------------------------------------------------------------------------

Test locally:

http://localhost:8080/api/access-report?org=spring-projects
🐳 Docker Support

Build Docker image:

docker build -t github-report .

Run container:

docker run -p 8080:8080 github-report
☁ Deployment

The application is deployed using:

Docker

Render Cloud Platform

Live deployment:

https://github-report.onrender.com
🔐 Security Note

GitHub Personal Access Token is stored securely using environment variables and is not exposed in the source code.

📄 Assignment Context

This project was developed as part of a Java Developer Internship Assignment to demonstrate:

API design

GitHub API integration

clean architecture

cloud deployment


