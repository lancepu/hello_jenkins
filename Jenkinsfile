pipeline {
    agent any

    stages {

        stage('build') {
            steps {
              sh '''
                 cd ./rsvp-service
                 ./mvnw -DskipTests clean compile
              '''
            }
        }

        stage('test') {
            steps {
              sh '''
                 cd rsvp-service
                     ./mvnw test
              '''
            }
        }

        stage('deliver') {
            steps {
              sh '''
                 cd rsvp-service
                     ./mvnw -DskipTests install
              '''
            }
        }

    }
}