package TaskManager_Pack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Task_pack.Task;

public class TaskManager {

	public List<Task> tasks;
	
	public TaskManager() {
		tasks= new ArrayList<>();
	}
	
	public void add_task(Task task) {
		tasks.add(task);
	}
	
	public void mark_task_as_complete(int task_number) {
		if( task_number>=0 && task_number<tasks.size()) {
			tasks.get(task_number).setCompleted(true);
		}
		else {
			System.out.println("Invalid Task Number. ");
		}
	}
	
	public void display_tasks() {
		if (tasks.isEmpty()) {
			System.out.println("There is no tasks. ");
		}
		else {
			for(int i=0;i<tasks.size();i++) {
				System.out.println((i+1)+". ["+(tasks.get(i).iscompleted()?"Done":"X")+"]"+tasks.get(i).getDescription());
			}
		}
	}
	
	public void save_tasks(String file_name) {
	      File file = new File(file_name+".txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            for (Task task : tasks) {
                writer.println(task.getDescription() + "," + task.iscompleted());
            }
            System.out.println("Tasks saved to " + file);
        } catch (IOException e) {
            System.out.println("Error saving tasks to file: " + e.getMessage());
        }
    }
}
