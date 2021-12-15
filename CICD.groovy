import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import groovy.json.JsonBuilder 


node {
  def rootdir="/var/lib/jenkins"

  stage ('Preparing Code'){
            sh "ls -lh"
            sh "rm -rf spring-petclinic"
            sh "rm -rf /home/jenkins/.m2"
           sh "git clone https://github.com/spring-projects/spring-petclinic.git"
           
           // Do a ls -lart to view all the files are cloned. It will be clonned. This is just for you to be sure about it.
           sh "ls -lart ./*" 
           // List all branches in your repo. 
           sh "git branch -a"
           // Checkout to a specific branch in your repo.
           sh "git checkout main"
  }
  
         stage ('Building Code'){
           sh "cd spring-petclinic"
           sh "./mvnw package"
         }
  stage ('Deploy'){
    sh "ssh pet@ec2-3-108-67-31.ap-south-1.compute.amazonaws.com mkdir -p /var/app/deploy"
       sh "scp -r spring-petclinic pet@ec2-3-108-67-31.ap-south-1.compute.amazonaws.com:/var/app/deploy"
  }
         stage ('Hello Wprld'){
    sh "echo Hello World !"
  }
}
