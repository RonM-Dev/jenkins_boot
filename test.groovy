pipeline {
    agent any

    stages {

        stage('Test') {
            steps {
                withMaven(maven : '3.8.1') {
                    bat "mvn test"
                }
            }
        }

        
    }
}