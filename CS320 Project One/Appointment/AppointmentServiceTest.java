import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {
  private String id, description, tooLongDescription;
  private Date date, pastDate;

  @SuppressWarnings("deprecation")
  @BeforeEach
  void setUp() {
	    id = "1234567890";
	    description = "The object requires a description.";
	    date = new Date(2021, Calendar.MARCH, 25);
	    tooLongDescription =
	        "This description is too long !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!.";
	    pastDate = new Date(0);
	  }

  @Test
  void deleteAppointment() throws Exception {
    AppointmentService service = new AppointmentService();

    service.newAppointment();
    service.newAppointment();
    service.newAppointment();

    String firstId = service.getAppointmentList().get(0).getId();
    String secondId = service.getAppointmentList().get(1).getId();
    String thirdId = service.getAppointmentList().get(2).getId();

    assertNotEquals(firstId, secondId);
    assertNotEquals(firstId, thirdId);
    assertNotEquals(secondId, thirdId);
    assertNotEquals(id, firstId);
    assertNotEquals(id, secondId);
    assertNotEquals(id, thirdId);

    assertThrows(Exception.class, () -> service.deleteAppointment(id));

    service.deleteAppointment(firstId);
    assertThrows(Exception.class, () -> service.deleteAppointment(firstId));
    assertNotEquals(firstId,
                    service.getAppointmentList().get(0).getId());
  }
  @Test
  void testNewAppointment() {
    AppointmentService service = new AppointmentService();

    service.newAppointment();
    assertNotNull(service.getAppointmentList().get(0).getId());
    assertNotNull(service.getAppointmentList().get(0).getDate());
    assertNotNull(service.getAppointmentList().get(0).getDesc());

    service.newAppointment(date);
    assertNotNull(service.getAppointmentList().get(1).getId());
    assertEquals(date,
                 service.getAppointmentList().get(1).getDate());
    assertNotNull(service.getAppointmentList().get(1).getDesc());

    service.newAppointment(date, description);
    assertNotNull(service.getAppointmentList().get(2).getId());
    assertEquals(date,
                 service.getAppointmentList().get(2).getDate());
    assertEquals(description,
                 service.getAppointmentList().get(2).getDesc());

    assertNotEquals(service.getAppointmentList().get(0).getId(),
                    service.getAppointmentList().get(1).getId());
    assertNotEquals(service.getAppointmentList().get(0).getId(),
                    service.getAppointmentList().get(2).getId());
    assertNotEquals(service.getAppointmentList().get(1).getId(),
                    service.getAppointmentList().get(2).getId());

    assertThrows(IllegalArgumentException.class,
                 () -> service.newAppointment(pastDate));
    assertThrows(IllegalArgumentException.class,
                 () -> service.newAppointment(date, tooLongDescription));
  }
}