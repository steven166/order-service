pipeline {
    agent {
        label 'maven'
    }
    stages {
        stage('Build and publish') {
            steps {
                checkout scm
                sh 'chmod 777 ./gradlew'
                sh 'git commit -a -m "update permissions gradlew"'
                sh './gradlew build microdocs final publish -Prelease.scope=${SEM_VERSION}'
            }
        }
    }
}