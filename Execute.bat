del out\* /s /q
del sources.txt

cmd /c dir /b /s *.java > sources.txt

cmd /c javac -d ./out/ -cp .;./lib/jackson-core-2.9.9.jar @sources.txt && java -cp ./out/;./lib/jackson-core-2.9.9.jar Main

timeout /T -1