pipeline {
    agent any

    stages {
        
        stage('Compile') {
            steps {
                withMaven(maven : '3.8.1') {
                    bat "mvn clean compile -DskipTests"
                }
            }
        }
    }
}