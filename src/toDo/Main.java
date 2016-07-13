package toDo;

public class Main {
	
	public static void main(String[] args) {
		TaskList list = new TaskList();
		
		ConsoleUI cons = new ConsoleUI(list);
		
		cons.run();
	}
}
