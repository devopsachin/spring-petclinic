import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import groovy.json.JsonBuilder 


node {
  def rootdir="/var/lib/jenkins"
  stage ('cleaning repos'){
    sh "rm -rf spring-petclinic"
  }
  stage ('Cloning repos'){
           
           sh "git clone https://github.com/devopsachin/spring-petclinic.git"
           // Do a ls -lart to view all the files are cloned. It will be clonned. This is just for you to be sure about it.
           sh "ls -lart ./*" 
           // List all branches in your repo. 
           sh "git branch -a"
           // Checkout to a specific branch in your repo.
           sh "git checkout main"
  }
  
  stage ('Validating repos using Maven'){
    sh "mvn validate "
  }
      
  stage ("Pulling repos"){
    sh "echo Hello World !"
  }
}
