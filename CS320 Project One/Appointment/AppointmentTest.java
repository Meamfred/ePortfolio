import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppointmentTest {

  private String id, description;
  private String tooLongId, tooLongDescription;
  private Date date, pastDate;

  @SuppressWarnings("deprecation")
  @BeforeEach
  void setUp() {
    id = "1234567890";
    description = "The object requires a description.";
    date = new Date(2021, Calendar.MARCH, 25);
    tooLongId = "55555555555555555555555555555555555555";
    tooLongDescription =
        "This description is too long !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!.";
    pastDate = new Date(0);
  }

  @Test
  void testGetAppointmentId() {
    Appointment appt = new Appointment(id);
    assertNotNull(appt.getId());
    assertEquals(appt.getId().length(), 10);
    assertEquals(id, appt.getId());
  }

  @Test
  void testUpdateAppointmentId() {
    Appointment appt = new Appointment();
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateId(null));
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateId(tooLongId));
    appt.updateId(id);
    assertEquals(id, appt.getId());
  }
  
  @Test
  void testGetAppointmentDate() {
    Appointment appt = new Appointment(id, date);
    assertNotNull(appt.getDate());
    assertEquals(date, appt.getDate());
  }

  @Test
  void testUpdateDate() {
    Appointment appt = new Appointment();
    assertThrows(IllegalArgumentException.class, () -> appt.updateDate(null));
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateDate(pastDate));
    appt.updateDate(date);
    assertEquals(date, appt.getDate());
  }
  
  @Test
  void testGetDescription() {
    Appointment appt = new Appointment(id, date, description);
    assertNotNull(appt.getDesc());
    assertTrue(appt.getDesc().length() <= 50);
    assertEquals(description, appt.getDesc());
  }

  @Test
  void testUpdateDescription() {
    Appointment appt = new Appointment();
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateDesc(null));
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateDesc(tooLongDescription));
    appt.updateDesc(description);
    assertEquals(description, appt.getDesc());
  }
}