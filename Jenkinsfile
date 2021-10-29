pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                bat  './gradlew clean build'
                //bat './gradlew war'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                bat './gradlew test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                bat "copy \\build\\libs\\*.war C:\\Program^ Files\\Apache^ Software^ Foundation\\Tomcat^ 8.5\\webapps\\"
                bat 'start cmd.exe /c C:\\Program^ Files\\Apache^ Software^ Foundation\\Tomcat^ 8.5\\bin\\startup.bat'
            }
        }
    }
}