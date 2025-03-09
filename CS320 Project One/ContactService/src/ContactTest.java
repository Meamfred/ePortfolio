import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {
		// null ID
		@Test
		void testContactClassIdNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact(null, "John", "Doe", "1234567890", 
					"123 Main St. Nowhere, OK 12345");
			});
		}
		// class id over 10 characters
		@Test
		void testContactClassIdTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("10000000002", "John", "Doe", "1234567890", 
					"123 Main St. Nowhere, OK 12345");
			});
		}
		// null first name
		@Test
		void testContactClassFirstNameNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("10000", null, "Doe", "1234567890",
								"123 Main St. Nowhere, OK 12345");
			});
		}
		// first name over 10 characters
		@Test
		void testContactClassFirstNameTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("10000", "John123456789", "Doe", "1234567890", 
						"123 Main St. Nowhere, OK 12345");
			});
		}
		// null last name
		@Test
		void testContactClassLastNameNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("10000", "John", null, "1234567890", 
						"123 Main St. Nowhere, OK 12345");
			});
		}
		// last name over 10 characters
		@Test
		void testContactClassLastNameTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("10000", "John", "Doe123456789", "1234567890", 
						"123 Main St. Nowhere, OK 12345");
			});
		}
		// null phone
				@Test
		void testContactClassPhoneNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("10000", "John", "Doe", null, 
								"123 Main St. Nowhere, OK 12345");
			});
		}
		// phone number not 10 characters
		@Test
		void testContactClassPhoneNot10() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("10000", "John", "Doe", "123456789", 
						"123 Main St. Nowhere, OK 12345");
			});
		}
		// null phone
		@Test
		void testContactClassPhoneNumNull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("10000", "John", "Doe", null, 
						"123 Main St. Nowhere, OK 12345");
			});
		}
		// null address
				@Test
		void testContactClassAddressnull() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("10000", "John", "Doe", "1234567890", 
								null);
			});
		}
		// address over 30 characters
		@Test
		void testContactClassAddressTooLong() {
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				new Contact("10000", "John", "Doe", "1234567890", 
						"123 Main St. Nowhere, OK 12345 123456789");
			});
		}
	}
