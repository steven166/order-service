pipeline {
    agent 'maven'
    stages {
        stage('Build and publish') {
            steps {
                sh 'chmod 777 ./gradlew'
                sh './gradlew build microdocs final publish -Prelease.scope=${SEM_VERSION}'
            }
        }
    }
}