import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

	@Test
	void testContactServiceClass() {
		ContactService.addContact("John", "Doe", "1234567890", 
				"123 Main St. Nowhere, OK 12345");
		//System.out.println(ContactService.contactList.get(0).getId());	used for debugging
		assertTrue(ContactService.contacts.get(0).getId().equals("1000000002"));
		assertTrue(ContactService.contacts.get(0).getFirstName().equals("John"));
		assertTrue(ContactService.contacts.get(0).getLastName().equals("Doe"));
		assertTrue(ContactService.contacts.get(0).getPhoneNum().equals("1234567890"));
		assertTrue(ContactService.contacts.get(0).getAddress().equals("123 Main St. Nowhere, OK 12345"));
	}
	// first name update
	@Test
	void testContactServiceUpdateFirstName() {
		ContactService.addContact("First", "Last", "1234567890", "Road St");
		int size = ContactService.contacts.size();
		System.out.println(ContactService.contacts.get(size - 1).getId());
		System.out.println(ContactService.contacts.get(size - 1).getFirstName());
		ContactService.updateFirstName("1000000001", "Juan");
		System.out.println(ContactService.contacts.get(size - 1).getFirstName());
		assertTrue(ContactService.contacts.get(size - 1).getFirstName().equals("Juan"));
	}
	// last name update
	@Test
	void testContactServiceUpdateLastName() {
		int size = ContactService.contacts.size();
		ContactService.updateLastName("1000000004", "Bob");
		assertTrue(ContactService.contacts.get(size - 1).getLastName().equals("Bob"));
	}
	// phone number update
	@Test
	void testContactServiceUpdatePhone() {
		int target = 0;
		target = ContactService.findIndex("1000000005");
		ContactService.updatePhoneNum("1000000005", "0987654321");
		assertTrue(ContactService.contacts.get(target).getPhoneNum().equals("0987654321"));
	}
	// address update
	@Test
	void testContactServiceUpdateAddress() {
		int target = 0;
		target = ContactService.findIndex("1000000001");
		ContactService.updateAddress("1000000001", "222 Two st. Two, NV 22222");
		assertTrue(ContactService.contacts.get(target).getAddress().equals("222 Two st. Two, NV 22222"));
	}
	
	// test to confirm unique ID
	@Test
	void testContactServiceUniqueId() {
		Contact newContact = new Contact("12345", "John", "Doe", "1234567890", "Original Contact Address");
		ContactService.addContact(newContact);
		Contact duplicateId = new Contact("12345", "John", "Doe", "1234567890", "Duplicate Contact Address");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			ContactService.addContact(duplicateId);
		});
	}
	// confirm deletion of a contact
	@Test
	void testContactServiceDelete() {
		ContactService.addContact("John", "Doe", "1234567890", 
				"123 Main St. Nowhere, OK 12345");
		int size = ContactService.contacts.size();
		ContactService.deleteContact("1000000001");
		assertTrue(ContactService.searchContact("1000000001") == 2);
	}

}