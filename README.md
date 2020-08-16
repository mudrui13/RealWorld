# Environment settings

1. install Java [JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. install [Git](https://git-scm.com/downloads) 
3. install Intellij [IDE](https://www.jetbrains.com/idea/)
4. install Gradle (https://gradle.org/install/)
6. install Allure (for run Allure report from command line)
5. (*Java + TestNg + Gradle + Selenium + Allure*)

# To run tests
1. can run test from **test.class** (/test/java/tests/)
2. can run test from **.xml** file (test/java/testSuites)
3. can run test by **gradlew test** command (command line/git)

# Create allure report (allure-testNg)

* Create report:
1. the **.json** files are creating on /allure-results folder
2. for create report: in command **line/git** form project path need to send command:

    *allure serve "allure-results/"*

