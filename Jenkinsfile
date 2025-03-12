pipeline {
    agent any

    environment {
        // Define environment variables if needed
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17' // Set your Java home path
        DOCKER_USERNAME = 'jabirep'
        DOCKER_PASSWORD = 'Subaida@415434'
        IMAGE_NAME = 'jabirep/hrms'
        TAG_NAME = 'latest'
        REGISTRY = "docker.io"
        TEST_REPO_URL = 'https://github.com/jabirep/CI-CD-TEST-REPOSITORY.git'
        TEST_REPO_BRANCH = 'main'
    }

    stages {
        // Stage 1: Checkout code from GitHub
        stage('Checkout') {
            steps {
                git branch: 'main', 
                url: 'https://github.com/jabirep/CI-CD-AUTOMATION-TEST.git',
                credentialsId: 'f6b4b94c-cf4b-4015-9ec0-3e7afbf90d05'
            }
        }

        // Stage 2: Build the project using Maven
        stage('Build jar file') {
            steps {
                script {
                    // Build the project using Maven to generate the JAR file
                    bat "mvn clean package"
                    // After Maven build, you should have the target/HRMS-0.0.1-SNAPSHOT.jar file
                }
            }
        }

        // Stage 2: Build the project using Maven
        stage('Build') {
            steps {
                script {
                    // Build the Docker image for your app
                    bat "docker build -t ${REGISTRY}/${IMAGE_NAME}:latest ."
                }
            }
        }

        stage('Deploy to Testing') {
            steps {
                script {
                    // Start the app, MySQL, and Selenium containers
                    bat "docker-compose -f docker-compose.test.yml up -d"
                }
            }
        }

        // Stage 5: Clone Selenium Test Repository
        stage('Clone Selenium Test Repo') {
            steps {
                script {
                    // Clone the Selenium test repository
                    git url: "${TEST_REPO_URL}", branch: "${TEST_REPO_BRANCH}",
                    credentialsId: 'f6b4b94c-cf4b-4015-9ec0-3e7afbf90d05'
                }
            }
        }

        // Stage 6: Run Selenium and TestNG Tests
        stage('Run Selenium and junit Tests') {
            steps {
                script {
                    // Assuming the tests are inside a directory like 'tests'
                    // and the pom.xml is located in your test repository.
                   dir('CI-CDTEST') {
                     bat 'mvn clean test'
}
                    // This assumes that the TestNG tests are configured in a testng.xml file
                    // If you have a different way of running the tests (e.g., using TestNG annotations directly), adjust accordingly.
                }
            }
        }
        // Stage 1: Checkout code from GitHub
        stage('Checkout for production') {
            steps {
                git branch: 'main',
                url: 'https://github.com/jabirep/CI-CD-AUTOMATION-TEST.git',
                credentialsId: 'f6b4b94c-cf4b-4015-9ec0-3e7afbf90d05'
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
                    /* echo "Pushing Docker image to registry..."
                    bat """
                        docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}
                        docker push ${IMAGE_NAME}:${TAG_NAME}
                    """ */
                    
                    // Step 3: Run Docker container (Deploy)
                    echo "Deploying Docker container..."
                    bat """
                        docker-compose up --build -d
                    """
                }
            }
        }
    }

}
