import java.text.ParseException;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

enum DayOfWeek {
	MON, TUE, WED, THU, FRI, SAT, SUN
};

public class Course {

	String CourseId;
	Date StartOfWeek;
	List<DayOfWeek> daysOfWeek;
	MeetingTime meetingDateTime;
	
	
	public String GetCourseId() {
		return CourseId;
	}

	public MeetingTime GetCourseMeetingTime()
	{
		
		return meetingDateTime;
	}
    
	// getDay gets the days of the week when the course is scheduled
	public String getDay() {
		String st = "";
		Iterator it = daysOfWeek.iterator();
		while (it.hasNext()) {
			DayOfWeek dow = (DayOfWeek) (it.next());
			st = st + "  " + dow.toString();
		}
		return st;
	}

	public String getTimeOfDay() {
		String str = "";
	    str = meetingDateTime.StartEndDateTime();
		return str;
	}

	public Course(String cid, Date startofWeek, String dOfWeek, String startEnd)
			throws ParseException {

		String[] day = dOfWeek.split(",");
		Date dt;

		CourseId = cid;
		StartOfWeek = startofWeek;

		if (day.length > 0) {
			daysOfWeek = new ArrayList<DayOfWeek>();
			for (int i = 0; i < day.length; i++)
				daysOfWeek.add(DayOfWeek.valueOf(day[i]));
		}

		String[] stime = startEnd.split("-");
		
		Iterator it = daysOfWeek.iterator();
		while (it.hasNext()) {
			switch ((DayOfWeek) it.next()) {
			case MON:
				Date st = setDateTime(StartOfWeek, stime[0]);
				Date end = setDateTime(StartOfWeek, stime[1]);
				meetingDateTime = new MeetingTime(st, end);
				break;
			case TUE:
				dt = addDaysToDate(StartOfWeek, 1);
				st = setDateTime(dt, stime[0]);
				end = setDateTime(dt, stime[1]);
				meetingDateTime = new MeetingTime(st, end);
				break;
			case WED:
				dt = addDaysToDate(StartOfWeek, 2);
				st = setDateTime(dt, stime[0]);
				end = setDateTime(dt, stime[1]);
				meetingDateTime = new MeetingTime(st, end);
				break;
			case THU:
				dt = addDaysToDate(StartOfWeek, 3);
				st = setDateTime(dt, stime[0]);
				end = setDateTime(dt, stime[1]);
				meetingDateTime = new MeetingTime(st, end);
				break;
			case FRI:
				dt = addDaysToDate(StartOfWeek, 4);
				st = setDateTime(dt, stime[0]);
				end = setDateTime(dt, stime[1]);
				meetingDateTime = new MeetingTime(st, end);
				break;
			case SAT:
				dt = addDaysToDate(StartOfWeek, 5);
				st = setDateTime(dt, stime[0]);
				end = setDateTime(dt, stime[1]);
				meetingDateTime = new MeetingTime(st, end);
				break;
			case SUN:
				dt = addDaysToDate(StartOfWeek, 6);
				st = setDateTime(dt, stime[0]);
				end = setDateTime(dt, stime[1]);
				meetingDateTime = new MeetingTime(st, end);
				break;
			}
			
		}
	}

	// set the date and time when a specific class is going to be held based on
	// the base line date
	public Date setDateTime(Date st, String timstr) { // 11:30AM
		Calendar c = Calendar.getInstance();
		c.setTime(st);
		c.add(Calendar.HOUR, Integer.parseInt(timstr.substring(0, 2)));
		c.add(Calendar.MINUTE, Integer.parseInt(timstr.substring(3, 5)));
		c.add(Calendar.AM_PM, (timstr.substring(5, 7).equals("AM")) ? 0 : 1);
		return c.getTime();
	}

	public Date addDaysToDate(Date st, int daysToAdd) {
		Calendar c = Calendar.getInstance();
		c.setTime(st);
		c.add(Calendar.DATE, daysToAdd);
		return c.getTime();
	}

	public void DisplayCourse() {
		System.out.print("Course ID:" + CourseId + "---" + "Days of Week:");
		Iterator it1 = daysOfWeek.iterator();
		while (it1.hasNext()) {
			System.out.print(it1.next() + "  ");
		}
		System.out.println("");	
		meetingDateTime.WriteStartEndDate();
	}
}
