package com.schoolofnet.SpringMongoDB;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMongoDbApplication implements CommandLineRunner {

	@Autowired
	private TaskRepository taskRepository;
	private Scanner reader;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMongoDbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.reader = new Scanner(System.in);
		
		Integer op = 0;

		do {
			System.out.println("Choose option below");
			System.out.println("----------------------\n");
			System.out.println("1 - Create task");
			System.out.println("2 - List tasks");
			System.out.println("3 - Delete task by name");
			System.out.println("4 - Update task by name");
			System.out.println("0 - Exit");
			
			op = this.reader.nextInt();
			
			this.reader.nextLine();
			
			switch(op) {
				case 1: create(); break;
				case 2: list(); break;
				case 3: delete(); break;
				case 4: update(); break;
			}
		} while(op != 0);
		String name = reader.nextLine();
		
		System.out.println(name);
	}

	private void update() {
		System.out.println("Task name : ");
		
		String name = this.reader.nextLine();
		
		Task task = taskRepository.findByName(name);
		
		System.out.println("New name (" + name + "): ");
		
		String newName = this.reader.nextLine();
		
		task.setName(newName);
		
		taskRepository.save(task);
		
		System.out.println("Updated!!");
	}

	private void delete() {
		System.out.println("Task name: ");
		
		String name = this.reader.nextLine();
		
		Task task = taskRepository.findByName(name);
		
		taskRepository.delete(task);
		
		System.out.println("Deleted !");
	}

	private void list() {
		List<Task> list = taskRepository.findAll();
		
		for(int i = 0; i <  list.size(); i++) {
			Task task = list.get(i);
			
			System.out.println(task.toString());
		}
	}

	private void create() {
		System.out.println("Task name : ");
		
		String name = this.reader.nextLine();
		
		taskRepository.insert(new Task(name));
	}
}
