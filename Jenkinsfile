pipeline {
    agent any

    // Use Maven installed via Jenkins "Manage Jenkins → Tools"
    tools {
        maven 'Maven_3'
    }

    environment {
        IMAGE_NAME = "ashokch11/todo-java"   // <-- CHANGE THIS
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                dir('todo-app') {   // Go into your Java project folder
                    sh "mvn clean package"
                }
            }
        }

        stage('Test') {
            steps {
                dir('todo-app') {
                    sh "mvn test"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                dir('todo-app') {
                    sh """
                    docker build -t $IMAGE_NAME:$BUILD_NUMBER .
                    docker tag $IMAGE_NAME:$BUILD_NUMBER $IMAGE_NAME:latest
                    """
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                        credentialsId: 'dockerhub-creds',
                        usernameVariable: 'USER',
                        passwordVariable: 'PASS'
                )]) {
                    sh """
                    echo $PASS | docker login -u $USER --password-stdin
                    docker push $IMAGE_NAME:$BUILD_NUMBER
                    docker push $IMAGE_NAME:latest
                    docker logout
                    """
                }
            }
        }
    }
}
