package main.java.view.classes;

class ConsoleCleaner implements IClearable{
	public void clear(){
		/*Имитация очистки -- вывод множества пустых строк*/
		for (int i = 0; i < 100; i++){
			System.out.println();
		}
	}
}