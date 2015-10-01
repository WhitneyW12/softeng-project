cd acceptance
javac -cp .;..\build\classes\main ArgsParserKeywords.java
java -cp .;C:\RobotFramework\swinglibrary-1.9.4.jar;..\build\classes\main;C:\RobotFramework\robotframework-2.9.jar org.robotframework.RobotFramework ArgsParserTests.txt
cd ..