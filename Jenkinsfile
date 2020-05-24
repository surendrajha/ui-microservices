// Jenkinsfile (Scripted  Pipeline)
node {
    def app

    stage('Checkout') {
        checkout scm
    }

    stage('Build') {
        bat "mvn clean install -DskipTests"
    }
    
    stage('Build image') {
        app = docker.build("surendrajha/ui-ms")
    }

    stage('Test image') {
        app.inside {
            echo "Tests passed"
        }
    }

    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-creds-id') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
        echo "Trying to Push Docker Build to DockerHub"
    }
}
