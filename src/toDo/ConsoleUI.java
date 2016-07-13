package toDo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConsoleUI {
	private TaskList taskList;
	
	private BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in));
	
	private enum Option {
		ADD_TASK, REMOVE_TASK, CHANGE_TASK_STATE, REMOVE_COMPLETED_TASKS, PRINT_TASKS, EXIT
	}

	public ConsoleUI(TaskList taskList) {
		this.taskList = taskList;
	};
	
	public void run() {
		while (true) {
			switch (showMenu()) {
			case ADD_TASK:
				addTask();
				break;
			case REMOVE_TASK:
				removeTask();
				break;
			case CHANGE_TASK_STATE:
				changeTaskState();
				break;
			case REMOVE_COMPLETED_TASKS:
				removeCompletedTasks();
				break;
			case PRINT_TASKS:
				printTasks();
				break;
			case EXIT:
				return;
			
			}
		}
	}
	
	private void addTask() {
		System.out.println("Enter Task: ");
		String description = readLine();
		System.out.println("Due at (MMMM d, yyyy): ");
		String dueDate = readLine();
		
		if(dueDate.length() < 1) {
			System.out.println("Date not specified.");
			taskList.addTask(new Task(description));
		} else {
			try {
				DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
				Date date = null;
				date = format.parse(dueDate);
				taskList.addTask(new Task(description, date));
			} catch (ParseException e) {
				System.err.println("Error while parsing the date" + e);
			}
		}
	}
	
	private void removeTask() {
		System.out.println("Enter index: ");
		try {
			int index = Integer.parseInt(readLine());
			Task task = taskList.getTask(index);
			taskList.removeTask(task);
		} catch (NumberFormatException ex) {
			System.err.println("Only numbers are allowed");
		}
	}
	
	private void changeTaskState() {
		System.out.println("Enter index: ");
		try {
			int index = Integer.parseInt(readLine());
			Task task = taskList.getTask(index);
			task.toggleState();
		} catch (NumberFormatException ex) {
			System.err.println("Only numbers are allowed");
		}
	}

	private void removeCompletedTasks() {
		taskList.removeCompleted();
		System.out.println("Completed tasks have been removed");
	}

	private void printTasks() {
		if(taskList.getSize() != 0) {
			System.out.println(taskList.toString());
		} else {
			System.out.println("List is empty.");
		}
	}

	private Option showMenu() {
		System.out.println("Menu.");
		for (Option option : Option.values()) {
			System.out.printf("%d. %s%n", option.ordinal() + 1, option);
		}
		System.out.println("-----------------------------------------------");

		int selection = -1;
		do {
			System.out.println("Option: ");
			selection = Integer.parseInt(readLine());
		} while (selection <= 0 || selection > Option.values().length);

		return Option.values()[selection - 1];
	}

	private String readLine() {
		try {
			return input.readLine();
		} catch (IOException e) {
			return null;
		}
	}
}
