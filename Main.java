import main.java.view.Wordle;

public class Main{
	
	public static void main(String[] args){
		try{
			Wordle wordle = new Wordle();
			wordle.run();
		} catch (Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
}