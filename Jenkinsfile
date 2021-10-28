pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                bat  './gradlew clean build'
                bat './gradlew war'
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
                bat './gradlew tomcatRun'
                echo 'Deploying....'
            }
        }
    }
}