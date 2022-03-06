Opening the project
  1. Open with IntelliJ
  2. On the welcome screen, select Open. Alternatively, from the main menu, select File | Open.
  3. In the dialog that opens, locate your project and if it is an sbt project, select the build.sbt file and click Open.
  4. In the dialog that opens, click Open as Project.


Running the project
  1. Create a new Run Configuration – From the main menu, select Run -> Edit Configurations
  2. Click on the + to add a new configuration
  3. From the list of configurations, choose “sbt Task”
  4. In the “tasks” input box, simply put “run”
  5. Apply changes and select OK.
  6. Now you can choose “Run” from the main Run menu and run your application
  
 To Test the Requirement
  1. Use an API tool like Postman, SOAPUI etc...
  2. Call the endpoint - POST http://localhost:9000/calculate
  3. Use a sample payload as shown to pass in the 2 arrays.
      {
        "firstArray":[1,2,3,4],
        "secondArray":[4,6,7,7]
      }
