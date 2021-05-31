pipeline {
	agent any
	stages{
		stage('PreBuild'){
			steps {
				echo 'hi'
			}
		}
		
		stage('Build'){
			steps {
				bat "mvn clean"
			}
		}
		stage('Test'){
			steps {
				bat "mvn test"
			}
		}
		stage('Deploy'){
			steps {
				bat "mvn package"
			}
		}
	}
}
