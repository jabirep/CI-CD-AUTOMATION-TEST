pipeline {
    agent any

    environment {
        // Define environment variables if needed
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17' // Set your Java home path
        DOCKER_USERNAME = 'jabirep'
        DOCKER_PASSWORD = 'Subaida@415434'
        IMAGE_NAME = 'jabirep/hrms'
        TAG_NAME = 'latest'
    }

    stages {
        // Stage 1: Checkout code from GitHub
        stage('Checkout') {
            steps {
                git branch: 'main', 
                url: 'https://github.com/jabirep/CI-CD-REPOSITORY.git',
                credentialsId: 'f6b4b94c-cf4b-4015-9ec0-3e7afbf90d05'
            
            }
        }

        // Stage 2: Build the project using Maven
        stage('Build') {
            steps {
                bat 'mvn clean package'
            }
        }

        // Stage 3: Run unit tests
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Test Docker') {
            steps {
                bat 'docker ps'
            }
        }
        stage('Deploy') {
            steps {
                script {
                    // Step 1: Build Docker image
                    echo "Building Docker image..."
                    bat """
                        docker build -t ${IMAGE_NAME}:${TAG_NAME} .
                    """
                    // Step 2: Push Docker image to Docker registry (optional)
                    echo "Pushing Docker image to registry..."
                    bat """
                        docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}
                        docker push ${IMAGE_NAME}:${TAG_NAME}
                    """
                    
                    // Step 3: Run Docker container (Deploy)
                    echo "Deploying Docker container..."
                    bat """
                        docker-compose up --build -d
                    """
                }
            }
    }
    }

    post {
    success {
        echo 'Build and tests completed successfully! and deployed'
    }
    failure {
        echo 'Build or tests failed!'
    }
}

}
