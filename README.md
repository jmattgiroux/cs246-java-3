# module-java-3

Program Description: 

A rock paper scissors game that records the player's winning streak.\
After losing or quitting, the player is prompted to input their name.\
Upon starting the program, the player can choose to either play or view the top ten high scores.

Records of all recorded scores are recorded in a file called save.txt\
Upon playing, recording your score, restarting the program, and choosing to view the high scores, you will see the score you recorded (provided it's within the top 10 high scores, of course).

The purpose of creating this program is to gain familiarity with the following
programming elements within Java:

- Done: Variables 
- Done: Expressions 
- Done: Conditionals 
- Done: Loops 
- Done: Functions
- Done: Classes 

Stretch goal for this project: 

- Done: Create or modify a program that reads and writes files. 


Development Environment: 

Ubuntu (Ubuntu 20.04.1 LTS) 

openjdk version "14.0.2" 2020-07-14\
OpenJDK Runtime Environment (build 14.0.2+12-Ubuntu-120.04)\ 
OpenJDK 64-Bit Server VM (build 14.0.2+12-Ubuntu-120.04, mixed mode, sharing)

Visual Studio Code\
Version: 1.50.1\
Commit: d2e414d9e4239a252d1ab117bd7067f125afd80a\
Date: 2020-10-13T14:44:48.716Z\
Electron: 9.2.1\
Chrome: 83.0.4103.122\
Node.js: 12.14.1\
V8: 8.3.110.13-electron.0\
OS: Linux x64 5.4.0-52-generic

Visual Studio Code Extensions\
Java Extension Pack by Microsoft, version 0.10.0, from 8/13/2020\
    Java Extension Pack is a collection of popular extensions that can help write, test\
    and debug Java applications in Visual Studio Code. Check out Java in VS Code to get started.


Build and Execution Instructions:

See first screenshot

Screenshots:

These 8 screenshots were taken in sequential order

- Screenshot of compilation and execution of program, as well as the scores that were loaded from the save.txt file.

![First screenshot of Rock Paper Scissors program](https://github.com/jmattgiroux/cs246-java-3/blob/master/s1_compile_run_seeScores.png)

- Screenshot of game being played

![2nd screenshot of Rock Paper Scissors program](https://github.com/jmattgiroux/cs246-java-3/blob/master/s2_play.png)

- Screenshot of score being recorded for New_Player (note that there's no whitespace in the name)

![3rd screenshot of Rock Paper Scissors program](https://github.com/jmattgiroux/cs246-java-3/blob/master/s3_Record_Score.png)

- Screenshot of another score being recorded, though in this case since there's a whitespace in the name the second part of the string has been cut off. This is deliberate, in order to preserve the structure of our save file when this record is written into the file.

![4th screenshot of Rock Paper Scissors program](https://github.com/jmattgiroux/cs246-java-3/blob/master/s4_record_score_again.png)

- This is a screenshot of invalid input being handled in the main menu

![5th screenshot of Rock Paper Scissors program](https://github.com/jmattgiroux/cs246-java-3/blob/master/s5_invalid_input_main_menu.png)

- This is a screenshot of invalid input being handled during gameplay

![6th screenshot of Rock Paper Scissors program](https://github.com/jmattgiroux/cs246-java-3/blob/master/s6_invalid_input_while_playing.png)

- This is a screenshot of finishing and quitting the program

![7th screenshot of Rock Paper Scissors program](https://github.com/jmattgiroux/cs246-java-3/blob/master/s7_finish_and_quit.png)

- This is a screenshot of the program being started again, as well as of the scores being displayed again. Note that our two new entries, New_Player and Second, which were recorded in the previous session, are now present.

![8th screenshot of Rock Paper Scissors program](https://github.com/jmattgiroux/cs246-java-3/blob/master/s8_restart_and_load_file.png)





List of Useful Websites:

- https://en.wikipedia.org/wiki/Java_(programming_language)
- https://www.w3schools.com/java/default.asp
- https://docs.oracle.com/en/java/javase/index.html
- https://beginnersbook.com/java-collections-tutorials/

