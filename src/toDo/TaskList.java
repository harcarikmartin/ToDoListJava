package toDo;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
	private List<Task> list = new ArrayList<>();
	
	public List<Task> getList() {
		return list;
	}

	public void setList(List<Task> list) {
		this.list = list;
	}
	
	public void addTask(Task task) {
		list.add(task);
	}
	
	public void removeTask(Task task) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).equals(task)) {
				list.remove(i);
			}
		}
	}
	
	public Task getTask(int id) {
		if(id <= list.size()) {
			return list.get(id);
		} else {
			return null;
		}
	}
	
	public int getSize() {
		return list.size();
	}
	
	public void removeCompleted() {
		List<Task> completed = new ArrayList<>();
		for(Task task : list) {
			if(!task.isActive()) {
				completed.add(task);
			}
		}
		
		for(Task task : completed) {
			removeTask(task);
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Task task : list) {
			sb.append(task.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
}
