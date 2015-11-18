cd acceptance
javac -cp .;..\build\classes\main TicTacToe.java
java -cp .;..\build\classes\main;../../robotframework-2.9.jar org.robotframework.RobotFramework TicTacToeTests.txt
cd ..
