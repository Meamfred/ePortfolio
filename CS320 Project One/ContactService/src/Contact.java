
public class Contact {
		private String phoneNum;
		private String address;
		private String contactId;
		private String firstName;
		private String lastName;
		
		public Contact(String contactId, String firstName, String lastName, String phoneNum, String address) {
			// checking ID is no more than 10 characters
			if (contactId == null || contactId.length() > 10) {
				throw new IllegalArgumentException("Invalid ID");
			}
			// checking first name is no more than 10 characters
			if (firstName == null || firstName.length() > 10) {
				throw new IllegalArgumentException("First Name Invalid!");
			}
			// checking last name is no more than 10 characters
			if (lastName == null || lastName.length() > 10) {
				throw new IllegalArgumentException("Last Name Invalid!");
			}
			// checking if the phone numer is 10 characters
			if (phoneNum == null || phoneNum.length() != 10) {
				throw new IllegalArgumentException("Phone Number Invalid!");
			}
			// checking address is under 30 characters
			if (address == null || address.length() > 30) {
				throw new IllegalArgumentException("Address Invalid");
			}
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.phoneNum = phoneNum;
			this.address = address;
			this.contactId = contactId;
		}
		
		// get
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public String getPhoneNum() {
			return phoneNum;
		}
		public String getAddress() {
			return address;
		}
		public String getId() {
			return contactId;
		}
		// set
		public void setFirstName(String firstName) {
			if (firstName == null || firstName.length() > 10) {
				throw new IllegalArgumentException("Invalid First Name");
			}
			this.firstName = firstName;
		}
		public void setLastName(String lastName) {
			if (lastName == null || lastName.length() > 10) {
				throw new IllegalArgumentException("Invalid Last Name");
			}
			this.lastName = lastName;
		}
		public void setPhone(String newPhoneNum) {
			if (newPhoneNum == null || newPhoneNum.length() != 10) {
				throw new IllegalArgumentException("Inavlid Phone Number");
			}
			this.phoneNum = newPhoneNum;
		}
		public void setAddress(String newAddress) {
			if (newAddress == null || newAddress.length() > 30) {
				throw new IllegalArgumentException("Invalid Address");
			}
			this.address = newAddress;
		}
	}
