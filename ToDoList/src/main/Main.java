package main;

import java.util.Scanner;

import TaskManager_Pack.TaskManager;
import Task_pack.Task;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();
        Task task;

        while (true) {
            System.out.println("Todo List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Display Tasks");
            System.out.println("4. Save&Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                     task = new Task(description);
                    taskManager.add_task(task);
                    System.out.println("Task added successfully.");
                    break;
                case 2:
                    System.out.print("Enter task index to mark as completed: ");
                    int index = scanner.nextInt();
                    taskManager.mark_task_as_complete(index - 1);
                    break;
                case 3:
                    System.out.println("Tasks:");
                    taskManager.display_tasks();
                    break;
                case 4:
                	System.out.print("Type file name: ");
                	String file_name=scanner.nextLine();
                	Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                        taskManager.save_tasks(file_name);
                    }));
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
	}

}
