node('linux') {
   

   
   try{
       notifyBuild('STARTED')

       
       stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git url:'https://github.com/isaacguo/es-solution.git'
           
      
     
   }
   stage('Build') {
        sh "cd es-ui && npm install && cd .. && mvn clean package"
   }
   stage('Nuget Pack')
   {
         echo "Nuget Pack"
   }
   stage('Nuget Publish')
   {
         echo "Nuget Publish"
   }
   stage('KosiHub Updated')
   {
       echo "KosiHub Updated"
   }
   }
   catch (e)
   {
       currentBuild.result = "FAILED";
   }
   finally
   {
       notifyBuild(currentBuild.result)
   }
   
}

def notifyBuild(String buildStatus = 'STARTED') {
  // build status of null means successful
  buildStatus =  buildStatus ?: 'SUCCESSFUL'

  // Default values
  def colorName = 'RED'
  def colorCode = '#FF0000'
  def subject = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}] '"
  def summary = "${subject} (${env.BUILD_URL})"
  def details = """<p>STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
    <p>Check console output at &QUOT;<a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>&QUOT;</p>"""

  // Override default values based on build status
  if (buildStatus == 'STARTED') {
    color = 'YELLOW'
    colorCode = '#FFFF00'
  } else if (buildStatus == 'SUCCESSFUL') {
    color = 'GREEN'
    colorCode = '#00FF00'
  } else {
    color = 'RED'
    colorCode = '#FF0000'
  }

  // Send notifications
  slackSend (color: colorCode, message: summary)

 
}
