pipeline {
    agent any

    tools {
        jdk 'Java JDK 17'
        maven 'maven'
    }

    stages {

        stage('Clean') {
            steps {
                echo 'Cleaning project...'
                bat 'mvn clean'
            }
        }

        stage('Test') {
            steps {
                echo 'Running JUnit tests...'
                bat 'mvn test'
            }
        }

    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'
        }

        success {
            echo 'Build completed successfully.'
        }

        failure {
            echo 'Build failed.'
        }
    }
}