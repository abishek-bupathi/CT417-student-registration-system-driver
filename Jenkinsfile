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
                bat './gradlew assemble'
                echo 'Deploying....'
            }
        }
    }
}