package main.java.view.classes;

public class InputErrorPrinter implements IPrintable{
	
	public void print(){
		System.out.println("Input error!");
	}
	
	public void print(String message){
		System.out.println("Input error! \nDetails: " + message);
	}
}