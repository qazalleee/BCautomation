// node {
// 	stage ('SCM checkout'){
// 		git "https://github.com/qazalleee/BCautomation.git"
// 		}
// 	stage ('Build'){
//     	dir("BCautomation") {
// 	   sh "mvn clean install"
//        }
//        	dir("comtest/target") {
// 	   sh "java -jar com.test-1.0-SNAPSHOT.jar"
//        }
// 		}
// }


pipeline {
	agent any
	stages{
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
