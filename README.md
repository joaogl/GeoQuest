GeoQuest
========

What is GeoQuest?
GeoQuest is a program that I made to my school.
It was scored as a 90% from 0 to 100%.
This is a two team game where which team as to answer 10 questions in 15 minutes max.
Each questions we have 13 seconds.


How does the program work?
Its started by me.joaogl.data.RunMethod class witch results in the me.joaogl.launcher.Launcher form display.
There are two counters, me.joaogl.data.timer.QuestionTimer and me.joaogl.data.timer.TotalTimer.
In the me.joaogl.data.ProgramInfo class there's a bunch of settings like debugging option total time and question timer...
On the me.joaogl.launcher package there's all the forms that are not part of the game(example, Launcher, Resorces, Credits, etc.)
On the me.joaogl.game are Examples and the Conclusion of the game.
On the me.joaogl.game.question are all the question classes witch require me.joaogl.components classes.
me.joaogl.components contains the drawCredits, counterDisplay, drawMenu, drawTeams, drawTimers and close functions.
I think the name can explain by them selfs what they do so I'll move on...
On the me.joaogl.resolution are all the classes with the right answer for each question and its opened by the game after the questions been answered.
On the me.joaogl.data.points there are all the classes related to points.
ChangePoints a form class to change the points if something goes wrong.
Points is a class to check if the team got each question right or the total points of each.
PointsValidade is the class responsible to check if the answer is right or wrong.
SeePoints is a form just to see the points of each team.
