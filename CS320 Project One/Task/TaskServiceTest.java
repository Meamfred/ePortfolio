import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TaskServiceTest {

	@Test
	void testUpdateTaskName() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");
		service.updateName("Updated Task Name", "3");
		service.displayList();
		assertEquals("Updated Task Name", service.getTask("3").getName(), "Task name was not updated.");
	}

	@Test
	void testUpdateTaskDesc() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");
		service.updateDesc("Updated Description", "1");
		service.displayList();
		assertEquals("Updated Description", service.getTask("1").getDesc(), "Task description was not updated.");
	}


	@Test
	void testAddContact() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");
		service.displayList();
		assertNotNull(service.getTask("0"), "Task was not added correctly.");
	}
	
	@Test
	void testDeleteContact() {
		TaskService service = new TaskService();
		service.addTask("Task Name", "Description");
		service.deleteTask("0");
		// Ensure that the contactList is now empty by creating a new empty contactList to compare it with
		ArrayList<Task> taskListEmpty = new ArrayList<Task>();
		service.displayList();
		assertEquals(service.List, taskListEmpty, "The contact was not deleted.");
	}
}