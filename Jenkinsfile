pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {

        stage('clean') {
            steps {
                echo 'Start Clean'
                bat 'mvn clean'
            }
        }

        stage('test') {
            steps {
                echo 'Start Test'
                bat 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    bat 'mvn sonar:sonar -Dsonar.projectKey=project2'
                }
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }
    }
}