

import java.util.concurrent.atomic.AtomicLong;

public class Task {
	private final String ID;
	private String Name;
	private String Desc;
	private static AtomicLong idGenerator = new AtomicLong();
	
	public Task(String Name, String Desc) {
		
		this.ID = String.valueOf(idGenerator.getAndIncrement());
		
		if (Name == null || Name.isEmpty()) {
			this.Name = "NULL";
		} else if (Name.length() > 20) {
			this.Name = Name.substring(0, 20);
		} else {
			this.Name = Name;
		}
		
		if (Desc == null || Desc.isEmpty()) {
			this.Desc = "NULL";
		} else if (Desc.length() > 50) {
			this.Desc = Desc.substring(0, 50);
		} else {
			this.Desc = Desc;
		}
	}
	
	public String getName() {
		return Name;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getDesc() {
		return Desc;
	}

	public void setName(String Name) {
		if (Name == null || Name.isEmpty()) {
			this.Name = "NULL";
		} else if (Name.length() > 20) {
			this.Name = Name.substring(0, 20);
		} else {
			this.Name = Name;
		}
	}
	
	public void setDesc(String Desc) {
		if (Desc == null || Desc.isEmpty()) {
			this.Desc = "NULL";
		} else if (Desc.length() > 50) {
			this.Desc = Desc.substring(0, 50);
		} else {
			this.Desc = Desc;
		}
	}
}
