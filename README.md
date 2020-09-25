# take-away-assessment

This repository meant for take-away test automation code challenge.

**Note**: Project has some additional unused dictionaries and script files. These are added to give the skeleton view of the automation framework.

## Short summary
- Dear take-away team, 
  As asked, I have designed an automation framework for API, keeping scalability in mind.
  It is developed using Groovy-gradle. Please find the run instructions mentioned below.
  I have detailed my thought process, as follows.

## Framework Approach
- Followed the Industry standard layout for design
- Framework designed to easily accommodate new API and GUI test cases
- Common API function calls (POST/PUT/GET/...)  are kept independent, so different API's can share them
- Implementation methods on api request and responses maintained separately
- API endpoints maintained in separate class file
- API files maintained with version number
- Test run groups declared in a separate class, so we can manage them effectively
- Test execution managed using XML files. This can be passed as an environment variable or default should run all test cases (full.xml)
- Used data providers classes to maintain test data. This way, we just need to add additional test data values instead of writing a new test.
- 'Allure' is used for a documentation and reporting


## Test cases automated:
   1. Validate the API response schema
   2. Verify success code and message with different valid inputs
   3. Verify error code with different invalid inputs [covered 404 error codes in add,update,remove item test cases]

## Technical details

- Automation          : API
- Tool                : Rest assured
- Scripting language  : Groovy
- Build tool          : Gradle

## Implementation included

- TDD (TestNG)
- Docker configuration
- Logging (Allure)
- HTML reporting (Allure)
- Version control (git)

## Prerequisites

- Project has been developed using groovy. Java has to be installed on the machine.
- java (jdk 1.8+ recommended)
- gradle (required if you want to run from gradle clean test. 6.5+ recommended)
- git (optional)

## Running the tests

- To download run from command line:
  1. Download the project from git
  2. Unzip the downloaded file
  3. CD to project folder (take-away-assessment)
  4. run the command `gradle clean Test` on cmd
  
- To clone and run the build from an IDE:
  1. `git clone https://github.com/rajnavakoti/take-away-assessment.git`
  2. open the project in any IDE
  3. run gradle clean test
  4. or run build.gradle
  5. or run full.xml/api.xml (/test/resources/suites)
  
- Project is ready to run on jenkins and docker


### Project Structure:

    - Root\
       - src\
         - main\
            - groovy
               - api
                  - basic
                  - themoviedb.v2
                     - request
                     - response
               - gui
               - utils             
            - resources\
               - schemas
              - confifuration file
         - test\
            - groovy\
               - yaddress\
                  - api
                  - gui
                  - usecases
            - resources\
               - suites
                  - full.xml
                  - api.xml
                  
## paths
 - Test cases       : `/src/test/groovy/`
 - Test suites      : `/src/test/resources/suites/`
 - Test screenshots : `/screenshots`
 - Test reports     : `/build/test-results/test/*.xml`

###### Scripting best practices implemented in the framework:
    - Class names: camel cassing
    - method,variable names: pascal cassing
	- Documentation: @story, @step
	- Logging & Reporting: Allure html test report
	- 1 liner indentation
	- Suite setup and teardown mandatory for every test file
	- Config/variable/data files usage