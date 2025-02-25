del out\* /s /q

cmd /c javac -sourcepath .;./src/ -cp ./out/;src/main/lib/gson-2.12.1.jar -d ./out/ ./src/test/TestJsonReader.java

timeout /T -1