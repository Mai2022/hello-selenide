pipeline {
    agent any
    stages {
        stage('Clean') {
            steps {
                sh './gradlew clean'
            }
        }
        stage('Test') {
            // parallelize browser tests
            parallel {
                stage('test: chrome') {
                    steps {
                        sh './gradlew test'
                    }
                }
                stage('test: firefox') {
                    steps {
                        sh './gradlew testFirefox'
                    }
                }
            }
            post {
                always {
                    junit 'build/test-results/test/*.xml'
                }
            }
        }
    }
}