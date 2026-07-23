pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {

        stage('Clean') {
            steps {
                echo 'Cleaning Maven project...'
                bat 'mvn clean'
            }
        }

        stage('Build & Unit Test') {
            steps {
                echo 'Compiling project, running JUnit tests and generating JaCoCo coverage...'
                bat 'mvn verify'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Running SonarQube static code analysis...'
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn sonar:sonar -Dsonar.projectKey=project2'
                }
            }
        }
    }

    post {
        always {
            echo 'Publishing JUnit test results...'

            junit allowEmptyResults: true,
                  testResults: '**/target/surefire-reports/*.xml'

            archiveArtifacts artifacts: 'target/site/jacoco/**/*',
                             fingerprint: true,
                             allowEmptyArchive: true
        }

        success {
            echo 'Pipeline completed successfully.'
        }

        failure {
            echo 'Pipeline failed. Please review the console output.'
        }
    }
}