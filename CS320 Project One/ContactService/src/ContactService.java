import java.util.ArrayList;

public class ContactService {
		public String publicFirstName;
		public String publicLastName;
		public static String contactId;
		public String publicPhoneNum;
		public String publicAddress;
		
		// create an Array to store contacts
		static ArrayList<Contact> contacts = new ArrayList<Contact>(0);
		
		public static String generateId() {
			// placeholder
			String uniqueId;
			// default 10 digit number if empty
			if (contacts.isEmpty()) {
				contactId = "1000000001";
			}
			// check suze of array
			else {
				int arraySize = contacts.size();
				contactId = contacts.get(arraySize - 1).getId();
			}
			// convert string to int
			int tempInt = Integer.valueOf(contactId);
			// add 1
			tempInt += 1;
			// int to string
			uniqueId = Integer.toString(tempInt);
			return uniqueId;
		}
		
		// Object Creation
		public static void addContact(String firstName, String lastName, String phoneNum, String address) {
			String ID = generateId();
			Contact Contact1 = new Contact(ID, firstName, lastName, phoneNum, address);
			contacts.add(Contact1);
		}
		// add a contact
		public static void addContact(Contact newContact) {
			String tempId = newContact.getId();
			for (int i = 0; i < contacts.size(); i++) {
				if (tempId.equals(contacts.get(i).getId())) {
					throw new IllegalArgumentException("Contact ID Not Unique! ");
				}
			}
			contacts.add(newContact);
		}
		
		// updater methods
		public static void updateFirstName(String uniqueId, String publicFirstName) {
			for (int i = 0; i < contacts.size(); i++) {
				if (uniqueId.compareTo(contacts.get(i).getId()) == 0) {
				contacts.get(i).setFirstName(publicFirstName);
				}
			}
		}
		public static void updateLastName(String uniqueId, String publicLastName) {
			for (int i = 0; i < contacts.size(); i++) {
				if (uniqueId.compareTo(contacts.get(i).getId()) == 0) {
				contacts.get(i).setLastName(publicLastName);
				}
			}
		}
		public static void updatePhoneNum(String uniqueId, String publicPhone) {
			for (int i = 0; i < contacts.size(); i++) {
				if (uniqueId.compareTo(contacts.get(i).getId()) == 0) {
				contacts.get(i).setPhone(publicPhone);
				}
			}
		}
		public static void updateAddress(String uniqueId, String publicAddress) {
			for (int i = 0; i < contacts.size(); i++) {
				if (uniqueId.compareTo(contacts.get(i).getId()) == 0) {
				contacts.get(i).setAddress(publicAddress);
				}
			}
		}
		// delete contact
		public static void deleteContact(String uniqueId) {
			for (int i = 0; i < contacts.size(); i++) {
				if (uniqueId.compareTo(contacts.get(i).getId()) == 0) {
					int position = i;
					contacts.remove(position);
				}
			}
		}
		// quick search
		public static int searchContact(String uniqueId) {
			int result = 0;
			for (int i = 0; i < contacts.size(); i++) {
				if (uniqueId.compareTo(contacts.get(i).getId()) == 0) {
					result = 1;
				}
				else {
					result = 2;
				}
			}
			return result;
		}
		// find index
		public static int findIndex(String uniqueId) {
			int result = 0;
			for (int i = 0; i < contacts.size(); i++) {
				if (uniqueId.compareTo(contacts.get(i).getId()) == 0) {
					result = i;
				}
			}
			return result;
		}
			
}
