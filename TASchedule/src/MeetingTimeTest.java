import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;


public class MeetingTimeTest {

	@Before
	public void setUp() throws Exception {		
	}

	@Test
	public void testGetStartDateTime() {
		try {
		Date   baseLineDate =  new SimpleDateFormat("MM/dd/yyyy").parse("08/26/2013");	
		Course c1 = new Course("CSC500",baseLineDate,"MON,WED","08:05AM-09:20AM");	
		assertEquals("Test Get Start Date Time", true, c1.getDay().equals("MON,WED"));
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetTimeOfDay() {
		try {
			Date   baseLineDate =  new SimpleDateFormat("MM/dd/yyyy").parse("08/26/2013");	
			Course c1 = new Course("CSC500",baseLineDate,"MON,WED","08:05AM-09:20AM");	
			assertEquals("Test Get Time of Day", true, c1.getTimeOfDay().equals("08:05AM-09:20AM"));
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
	}

	@Test
	public void testOverlap() {
		try {
			Date   baseLineDate =  new SimpleDateFormat("MM/dd/yyyy").parse("08/26/2013");	
			Course c1 = new Course("CSC500",baseLineDate,"MON,WED","08:05AM-09:20AM");	
			Course c2 = new Course("CSC700",baseLineDate,"MON,WED","09:00AM-11:30AM");
			assertEquals("Does Course c1 and c2 Overlap?", true, c1.meetingDateTime.overlap(c2.meetingDateTime));
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
	}

}
