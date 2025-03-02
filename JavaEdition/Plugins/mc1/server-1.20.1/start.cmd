@echo off
set paper=paper-1.20.1-196.jar
set folder=C:\Users\%username%\work\mc1\server-1.20.1
title mc-server-%paper%
cd \
cd "%folder%"
cls
java -jar %paper% --nogui
pause
