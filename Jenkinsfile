pipeline {
    agent {
        label 'maven'
    }
    stages {
        stage('Build and publish') {
            steps {
                sh 'chmod 777 ./gradlew'
                sh 'git config --global user.name "jenkins"'
                sh 'git config --global user.email  "jenkins@maxxton.com"'
                sh 'git commit -a -m "update permissions gradlew"'
                //sh './gradlew build microdocs final publish -Prelease.scope=${SEM_VERSION}'
            }
        }
    }
}