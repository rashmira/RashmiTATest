import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class TA {
		String studentID;
		String firstName;
		String lastName;		
		List<Course> enrolledCourses = new ArrayList<Course>();
		List<Course> teachingCourses = new ArrayList<Course>();
		
		
		public TA(String sid, String fname, String lname) 
		{
			studentID = sid;
			firstName = fname;
			lastName  = lname;		
		}
		
		public void EnrollCourse(Course c)
		{
			enrolledCourses.add(c);
	     }

		
		public void TeachCourse(Course c)
		{
			teachingCourses.add(c);
	     }
		
		
		public void DisplayEnrolledCourses()
		{
			Iterator it = enrolledCourses.iterator();
			System.out.println("Enrolled Courses: Student-SID:" + studentID + "  FirstName:"+firstName+"  LastName:"+lastName);
			while ( it.hasNext())
			{
				Course c = (Course)it.next();
				System.out.println(c.GetCourseId()+ "  Scheduled Days of Week:"+c.getDay());
			}
			
		}
		
		
		public void DisplayTeachingCourses()
		{
			Iterator it = teachingCourses.iterator();
			System.out.println("Teaching Courses: Student-SID:" + studentID + "  FirstName:"+firstName+"  LastName:"+lastName);
			while ( it.hasNext())
			{
				Course c = (Course)it.next();
				System.out.println(c.GetCourseId()+ "  Scheduled Days of Week:"+c.getDay());
			}
			
		}
		
		
}
