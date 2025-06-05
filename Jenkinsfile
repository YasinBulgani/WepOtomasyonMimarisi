pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn -B test'
            }
        }
        stage('Archive Reports') {
            steps {
                archiveArtifacts artifacts: 'target/**/*.html', allowEmptyArchive: true
            }
        }
    }
}
