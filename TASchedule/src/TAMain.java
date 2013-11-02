import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TAMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
        try {
        	//baseLineDate is the first day of class for the semester, we have look at conflicts
        	//in the first week - the same conflicts will happen every week.
        	
        	//initialize list of courses
			Date   baseLineDate =  new SimpleDateFormat("MM/dd/yyyy").parse("08/26/2013");			
			Course c1 = new Course("CSC500",baseLineDate,"MON,WED","08:05AM-09:20AM");	
			System.out.println("Course id:"+c1.GetCourseId()+", getDay of course:"+c1.getDay()+", getTimeOfDay:"+c1.getTimeOfDay());
			Course c2 = new Course("CSC550",baseLineDate,"MON,WED","09:05AM-11:30AM");
			System.out.println("Course id:"+c2.GetCourseId()+", getDay of course:"+c2.getDay()+", getTimeOfDay:"+c2.getTimeOfDay());
			Course c3 = new Course("CSC600",baseLineDate,"TUE,THU","10:30AM-11:30AM");	
			System.out.println("Course id:"+c3.GetCourseId()+", getDay of course:"+c3.getDay()+", getTimeOfDay:"+c3.getTimeOfDay());
			Course c4 = new Course("CSC650",baseLineDate,"FRI","10:30AM-11:30AM");		
			System.out.println("Course id:"+c4.GetCourseId()+", getDay of course:"+c4.getDay()+", getTimeOfDay:"+c4.getTimeOfDay());
			Course c5 = new Course("CSC700",baseLineDate,"MON,WED","10:30AM-11:30AM");
			System.out.println("Course id:"+c5.GetCourseId()+", getDay of course:"+c5.getDay()+", getTimeOfDay:"+c5.getTimeOfDay());
			
			//does course c1 and c2 overlap
			System.out.println("Does Course c1 and c2 Overlap?:"+c1.meetingDateTime.overlap(c2.meetingDateTime));
			System.out.println("Does Course c1 and c3 Overlap?:"+c1.meetingDateTime.overlap(c3.meetingDateTime));
			System.out.println("Does Course c1 and c4 Overlap?:"+c1.meetingDateTime.overlap(c4.meetingDateTime));
			System.out.println("Does Course c2 and c4 Overlap?:"+c2.meetingDateTime.overlap(c4.meetingDateTime));
			System.out.println("Does Course c2 and c5 Overlap?:"+c2.meetingDateTime.overlap(c5.meetingDateTime));
			
			//now create the TA
			TA t1 = new TA("T1","Bob","Kidd");
			t1.EnrollCourse(c1);
			t1.EnrollCourse(c2);
			t1.EnrollCourse(c3);
			//display TAs enrolled courses
			t1.DisplayEnrolledCourses();
			t1.TeachCourse(c1);
			t1.TeachCourse(c2);
			t1.TeachCourse(c3);
			t1.DisplayTeachingCourses();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
