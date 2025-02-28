del out\* /s /q

cmd /c javac -sourcepath .;./src/ -cp ./out/;./lib/gson-2.12.1.jar -d ./out/ Main.java && java -cp ./out/;./lib/gson-2.12.1.jar Main

timeout /T -1