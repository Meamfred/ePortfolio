
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AppointmentService {
  final private List<Appointment> List = new ArrayList<>();
  
  public void deleteAppointment(String id) throws Exception {
	    List.remove(appointmentSearch(id));
	  }

  private String newUniqueId() {
    return UUID.randomUUID().toString().substring(
        0, Math.min(toString().length(), 10));
  }

  public void newAppointment() {
    Appointment appt = new Appointment(newUniqueId());
    List.add(appt);
  }

  public void newAppointment(Date date) {
    Appointment appt = new Appointment(newUniqueId(), date);
    List.add(appt);
  }

  public void newAppointment(Date date, String description) {
    Appointment appt = new Appointment(newUniqueId(), date, description);
    List.add(appt);
  }

  protected List<Appointment> getAppointmentList() { return List; }

  private Appointment appointmentSearch(String id) throws Exception {
    int index = 0;
    while (index < List.size()) {
      if (id.equals(List.get(index).getId())) {
        return List.get(index);
      }
      index++;
    }
    throw new Exception("The appointment does not exist!");
  }
}