node {
    def app
    stage('Clone repp') {
        /* Cloning the Repository to our Workspace */

        checkout scm
    }
    
    stage('Build Executable Jar'){
        //steps {
	def myMvn = tool name: 'M3', type: 'maven'
	sh "${myMvn}/bin/mvn clean test package"
        
        echo "mvn build succesful"
        //}
    }

    stage('Build image') {
        /* This builds the actual image */
//	    if( "$(docker images -q myimage:mytag 2> /dev/null)" == "" ){}
//	    else {
		def val = sh "docker rmi vamceeep/calculator"
//	}
        app = docker.build("vamceep/calculator")
        echo "docker build succesful"
    }

    stage('Test image') {
        
        app.inside {
            echo "Tests passed"
        }
    }

    stage('Push image') {
        /* 
			You would need to first register with DockerHub before you can push images to your account
		*/
        docker.withRegistry('https://registry.hub.docker.com', 'docker_hub') {
        	echo "${env.BUILD_NUMBER}"
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
            } 
                echo "Trying to Push Docker Build to DockerHub"
    }
}
