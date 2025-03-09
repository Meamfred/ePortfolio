import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {


	@Test
	void testLongName() {
		Task task = new Task("TaskNameWithMoreThanTwentyCharacters", "Description");
		if (task.getName().length() > 20) {
			fail("Task Name has too many characters.");
		}
	}
	
	@Test
	void testLongID() {
		Task task = new Task("Name", "Description");
		if (task.getID().length() > 10) {
			fail("Task ID has too many characters.");
		}
	}

	@Test
	void testLongDesc() {
		Task task = new Task("Name", "TaskDescWithMoreThanAvailaleCharacters" 
				+ "TaskDescWithMoreThanAvailaleCharacters" 
				+ "TaskDescWithMoreThanAvailaleCharacters"
				+ "TaskDescWithMoreThanAvailaleCharacters");
		if (task.getDesc().length() > 50) {
			fail("Task Description has too many characters.");
		}
	}

	@Test
	void testNameNotNull() {
		Task task = new Task(null, "Description");
		assertNotNull(task.getName(), "Task Name cannot be null.");
	}
	
	@Test
	void testDescNotNull() {
		Task task = new Task("Name", null);
		assertNotNull(task.getDesc(), "Task Description cannot be null.");
	}

}
