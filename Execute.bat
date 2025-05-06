del out\* /s /q
del sources.txt

cmd /c dir /b /s *.java > sources.txt

cmd /c javac -d ./out/ -cp ./lib/jackson-core-2.19.0.jar;./lib/jackson-databind-2.9.9.jar;./lib/jackson-annotations-2.12.7.jar @sources.txt ^
&& java -cp ./out/;./lib/jackson-core-2.19.0.jar;./lib/jackson-databind-2.9.9.jar;./lib/jackson-annotations-2.12.7.jar Main

timeout /T -1