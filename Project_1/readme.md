# 🚀 Automated CI/CD Pipeline for Java Application

## 📝 Overview
This project establishes a comprehensive Continuous Integration and Continuous Deployment (CI/CD) pipeline using Jenkins as the central orchestrator. It automates the entire software delivery lifecycle from code checkout to deployment, ensuring code quality and providing real-time team notifications.

## 🏗️ Architecture & Flow
1. **Source:** Jenkins pulls the latest Java source code from GitHub.
2. **Build & Test:** Maven compiles the code and executes JUnit tests.
3. **Quality Gate:** SonarQube analyzes the source code for bugs and vulnerabilities.
4. **Artifact Storage:** Maven packages the `.jar` and securely uploads the release version to a Nexus Repository.
5. **Deployment:** Ansible provisions the staging environment, safely stops the existing application, and starts the new version.
6. **Notification:** Jenkins sends success or failure alerts to a dedicated Slack channel.

## 💻 Tech Stack
* **CI/CD:** Jenkins
* **Build Tool:** Maven
* **Code Quality:** SonarQube
* **Artifact Repository:** Sonatype Nexus
* **Configuration Management:** Ansible
* **Communication:** Slack Webhooks

## ⚙️ Key Configurations
* **`pom.xml`**: Configured with a `<distributionManagement>` block to route versioned releases to Nexus.
* **`deployment.yaml`**: An idempotent Ansible playbook utilizing regex (`[j]ava`) to safely manage background processes.
* **`Jenkinsfile`**: A Declarative Pipeline script managing secure credentials, tool environments, and post-build Slack notifications.

## 📋 Prerequisites
To recreate this environment, you will need the following tools installed and configured:
* **Java & Maven:** Installed on the Jenkins build node.
* **Jenkins:** Running with the 'Slack Notification' plugin installed.
* **SonarQube Server:** Running and accessible by Jenkins.
* **Nexus Repository Manager:** Running with a `maven-releases` repository created.
* **Ansible:** Installed on the Jenkins node with an `inventory.ini` file pointing to your staging/production servers.
* **Slack App:** An Incoming Webhook configured in your workspace and added as a 'Secret text' credential in Jenkins (ID: `slack-webhook`).

## 🚀 How to Run
1. Clone this repository to your local machine.
2. Create a new Pipeline job in Jenkins.
3. In the Pipeline section, choose "Pipeline script from SCM", select Git, and provide the repository URL.
4. Ensure your Jenkins credentials (`nexus-creds` and `slack-webhook`) are properly configured.
5. Click **Build Now** to trigger the CI/CD flow.