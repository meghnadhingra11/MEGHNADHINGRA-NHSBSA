****Pre-requisites:****
- Java JDK 1.8 or above, verify this installation executing 'java -version' in the command prompt
- Maven (Any version), set the Maven home path and confirm this configuration by executing 'mvn -v' in the command prompt

****UI Automation for the NHS Cost Checker Tool :****
- An Automated Solution that validates customer get a result of whether he/she can get help or not with their NHS costs.

****Framework Overview:****
- This is a Java/Maven based project that utilized Selenium WebDriver library for the UI navigation. Use Selenium-Java to navigate to url https://services.nhsbsa.nhs.uk/check-for-help-paying-nhs-costs/start and on basis of entered circumstances into the checker tool and fetched the help result.
- Cucumber is used for the Behavior Driven Development. Used Page object model approach and the assertions are made with the Junit.

****Local Execution Steps:****
1. Create a project folder in your local.
2. Navigate to project folder/dir and open cmd.
3. Run the command : git clone https://github.com/meghnadhingra11/MEGHNADHINGRA-NHSBSA.git 
4. After cloning the project successfully in the local, then navigate to project folder/dir where pom.xml is present and open cmd and Run the command :
- mvn clean
- mvn verify
5. You can see the different reports under the folder :
target -> reports.html
