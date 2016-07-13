package toDo;

import java.util.Date;

public class Task {
	private boolean active;
	private String description;
	private Date dueDate;
	
	
	public Task(String description) {
		this(description, null);	
	}
	
	public Task(String description, Date dueDate) {
		this(true, description, dueDate);	
	}
	
	public Task(boolean active, String description, Date dueDate) {
		this.active = active;
		this.description = description;
		this.dueDate = dueDate;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if(isActive()) {
			sb.append("[(*) ");
		} else {
			sb.append("[  ");
		}
		sb.append(description);
		if(dueDate != null) {
			sb.append(" ( dueDate )");
		}
		sb.append(" ]");
		return sb.toString();
	}
	
	public boolean isActive() {
		if(active == true) {
			return true;
		} else {
			return false;
		}
	}
	
	public void toggleState() {
		active = !active;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
