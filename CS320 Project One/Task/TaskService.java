
import java.util.ArrayList;

public class TaskService {
	
		public ArrayList<Task> List = new ArrayList<Task>();
		
		public Task getTask(String ID) {
			Task task = new Task(null, null);
			for (int counter = 0; counter < List.size(); counter++) {
				if (List.get(counter).getID().contentEquals(ID)) {
					task = List.get(counter);
				}
			}
			return task;
		}

		public void addTask(String Name, String Desc) {
			Task task = new Task(Name, Desc);
			List.add(task);
		}

		public void deleteTask(String ID) {
			for (int counter = 0; counter < List.size(); counter++) {
				if (List.get(counter).getID().equals(ID)) {
					List.remove(counter);
					break;
				}
				if (counter == List.size() - 1) {
					System.out.println("Task ID: " + ID + " not found.");
				}
			}
		}

		public void updateName(String updatedString, String ID) {
			for (int counter = 0; counter < List.size(); counter++) {
				if (List.get(counter).getID().equals(ID)) {
					List.get(counter).setName(updatedString);
					break;
				}
				if (counter == List.size() - 1) {
					System.out.println("Task ID: " + ID + " not found.");
				}
			}
		}

		public void updateDesc(String updatedString, String ID) {
			for (int counter = 0; counter < List.size(); counter++) {
				if (List.get(counter).getID().equals(ID)) {
					List.get(counter).setDesc(updatedString);
					break;
				}
				if (counter == List.size() - 1) {
					System.out.println("Task ID: " + ID + " not found.");
				}
			}
		}
		
		public void displayList() {
			for (int counter = 0; counter < List.size(); counter++) {
				System.out.println("\t Task ID: " + List.get(counter).getID());
				System.out.println("\t Task Name: " + List.get(counter).getName());
				System.out.println("\t Task Description: " + List.get(counter).getDesc());
			}
		}
}
