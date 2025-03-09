import java.util.Date;

public class Appointment {

  final private byte ID_LENGTH;
  final private byte DESC_LENGTH;
  final private String INITIALIZER;
  private String ID;
  private Date Date;
  private String desc;

  {
    ID_LENGTH = 10;
    DESC_LENGTH = 50;
    INITIALIZER = "INITIAL";
  }

  Appointment() {
    Date today = new Date();
    ID = INITIALIZER;
    Date = today;
    desc = INITIALIZER;
  }

  Appointment(String id) {
    Date today = new Date();
    updateId(id);
    Date = today;
    desc = INITIALIZER;
  }

  Appointment(String id, Date date) {
    updateId(id);
    updateDate(date);
    desc = INITIALIZER;
  }

  Appointment(String id, Date date, String desc) {
    updateId(id);
    updateDate(date);
    updateDesc(desc);
  }
  
  public String getId() { return ID; }
  
  public void updateId(String id) {
    if (id == null) {
      throw new IllegalArgumentException("Appointment ID cannot be empty.");
    } else if (id.length() > ID_LENGTH) {
      throw new IllegalArgumentException("Appointment ID cannot be more than " +
                                         ID_LENGTH +
                                         " characters.");
    } else {
      this.ID = id;
    }
  }

  public void updateDate(Date date) {
    if (date == null) {
      throw new IllegalArgumentException("Appointment date cannot be null.");
    } else if (date.before(new Date())) {
      throw new IllegalArgumentException(
          "Cannot make appointment in the past.");
    } else {
      this.Date = date;
    }
  }

  public Date getDate() { return Date; }
  
  public String getDesc() { return desc; }

  public void updateDesc(String desc) {
    if (desc == null) {
      throw new IllegalArgumentException(
          "Appointment description cannot be empty.");
    } else if (desc.length() > DESC_LENGTH) {
      throw new IllegalArgumentException(
          "Appointment description cannot be more than " +
          DESC_LENGTH + " characters.");
    } else {
      this.desc = desc;
    }
  }
}