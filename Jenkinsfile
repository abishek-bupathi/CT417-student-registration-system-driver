pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                bat  './gradlew clean'
                bat  './gradlew build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
               // bat './gradlew test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}