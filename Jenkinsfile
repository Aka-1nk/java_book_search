pipeline {
    agent any
    stages {
        stage('Clean') {
            steps {
                cleanWs() 
                sh 'git clean -fdx'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install' 
            }
        }
    }
}