pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                bat  './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                bat './gradlew clean test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                bat './gradlew deploy'
                start 'C:\Program Files\Apache Software Foundation\Tomcat 8.5\bin\startup.bat'

            }
        }
    }
}