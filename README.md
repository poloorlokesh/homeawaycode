# homeawaycode

There are two projects in the repository implemented by Java.

1) HomeAwayAPIAssignment
2) HomeAwayUIAssignment

Please follow the operating instructions below,

For ease of use I have created the both as maven projects.

Please have eclipse with TestNG installed.




HomeAwayAPIAssignment

In order to execute the code/tests follow the below instructions,

Import the project into eclipse as file system.

1) You can find the homeawayapiassignmentsuite.xml in the suites folder.
2) Just run the suite as TestNG.

Frameworks used: 

1) HttpClient
2) TestNG
3) Json Library
4) Log4j 
5) Maven

Notes/Issues: N/A




HomeAwayUIAssignment

In order to execute the code/tests follow the below instructions,

Import the project into eclipse as file system.

1) You can find the homeawayuiassignmentsuite.xml in the suites folder.
2) Just run the suite as TestNG.

Frameworks used: 

1) TestNG
2) Log4j 
3) Maven
4) Selenium Webdriver

Notes/Issues:

By default the browser is firefox. if you want to use the different browser we need to have driver.exe in drivers folder.
I have driver for mac in the same driver folder, rest of the OS please download the drivers.

For ordering the item in http://store.demoqa.com, created the user.
Username : homeawayuser
Password : homeaway@12
You can change the user credentials in the config.properties file.

Problems faced: 
Update user Profile details page doesn’t work properly.
Always some details not getting saved while updating. Checked manually with different browsers as well.
I have created the testcase validations based on the mandatory files in the user profile page.
So testcase validation might fail as per website behavior.


For code analysis and specification attached two files with observations.

