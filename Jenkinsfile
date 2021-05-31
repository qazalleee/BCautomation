node {
	stage ('SCM checkout'){
		git "https://github.com/qazalleee/BCautomation.git"
		}
	stage ('Build'){
    	dir("BCautomation") {
	   sh "mvn clean install"
       }
       	dir("comtest/target") {
	   sh "java -jar com.test-1.0-SNAPSHOT.jar"
       }
		}
}
