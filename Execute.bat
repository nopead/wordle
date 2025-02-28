del out\* /s /q
del sources.txt

cmd /c dir /b /s *.java > sources.txt

cmd /c javac -d ./out/ -cp .;./lib/gson-2.12.1.jar @sources.txt && java -cp ./out/;./lib/gson-2.12.1.jar Main

timeout /T -1