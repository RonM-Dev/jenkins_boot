pipeline {
    agent any

    stages {
        
        stage('Deploy') {
            steps {
                withMaven(maven : '3.8.1') {
                    bat "mvn install -DskipTests"
                }
            }
        }
    }
}