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
            task deployToTomcat(type: Copy) {
                from "build/libs"
                into "C:\Program Files\Apache Software Foundation\Tomcat 8.5\webapps"
                include "*.war"
            }
            steps {
                bat './gradlew war'
                bat './gradlew deploy'
                echo 'Deploying....'
            }
        }
    }
}