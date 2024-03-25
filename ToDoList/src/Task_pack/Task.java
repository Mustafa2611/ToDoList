package Task_pack;

public class Task {
	
	String description;
	boolean completed;
	
	public Task(String description ) {
		this.description=description;
		this.completed=false;
	}
	
	public String getDescription() {
		return description;
	}
		
	public boolean iscompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed= completed;
	}
	

}
