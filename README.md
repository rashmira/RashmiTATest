RashmiTATest
============

CSC 747 TA Assignment Testing
The following classes are related to the implementation of the project:
1.	Course.java – This has the definitions for a Course.
2.	MeetingTime.java – This defines the Course Meeting time which has a start time, and end time.
3.	TA.java – This contains the definitions for a Teaching Assistant. A Teaching Assistant (TA) will enroll 
in courses as well as be teaching courses.
4.	TAMain.java – This is the main program and has the program “main”. It is used to instantiate all the classes
and demonstrate how the program is used.
JUNIT Testing Related: The following files are related to JUNIT Testing in this assignment.
1.	MeetingTimeTest.java – Used to do JUNIT testing of MeetingTimeTest class.
2.	AllTests.java – This has the test suite based on MeetingTimeTest.java
Implementation Details
A brief description of the project implementation. 
2.1	MeetingTime.java
MeetingTime.java implements the concept of a meeting time for the course. It has a start time and end time.
In this class I have implemented the two Getters requested in the assignment.
public Date getStartDateTime() {
		return startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}
It also implements a method to determine if two meeting times overlap.
public boolean overlap(MeetingTime dt2)
	{
		if ( (this.getEndDateTime().getTime() - dt2.getStartDateTime().getTime()) > 0)
			return true;
		else
			return false;
	}
2.2 Course.java

Course.java implements the representation of a course. It has the following private members.
                String CourseId;
                Date StartOfWeek;
                List<DayOfWeek> daysOfWeek;
                MeetingTime meetingDateTime;
                
I have to provide a baseline start of the week when the first week of classes will be held. In the current 
implementation I also have to provide 
a list of days i.e. “MON, WED”  as the list of days when the class will be held, as well as the Meeting Time for
the class which has the start, and end time of the course.

I have provided a constructor which takes the form shown below and instantiates this course.  
Let us say that courses start on the week of August 26th.
The course c1 is help “MON, WED” from “08:15AM-09:20AM”. 
Date   baseLineDate =  new SimpleDateFormat ("MM/dd/yyyy").      parse( "08/26/2013" );			
Course c1 = new Course("CSC500",baseLineDate,"MON,WED","08:05AM-09:20AM");	
I can determine if two courses overlap using the overlap method as shown below. This is a Boolean method 
returning true if courses overlap
and false if courses do not overlap.
System.out.println("Does Course c1 and c2 Overlap?:"+c1.meetingDateTime.overlap(c2.meetingDateTime));
System.out.println("Does Course c1 and c3 Overlap?:"+c1.meetingDateTime.overlap(c3.meetingDateTime));
2.3 TA.java
TA.java is a representation of a teaching assistant. 
It has the following private members.
String studentID;
		String firstName;
		String lastName;		
		List<Course> enrolledCourses = new ArrayList<Course>();
		List<Course> teachingCourses = new ArrayList<Course>();

A TA can enroll in courses, and a TA can also teach courses.I can check if there is conflict between course 
schedules using the overlap method in a course.
The following code snipped below shows how we can create a new TA and enroll him/her in courses. It also shows how a
TA can be assigned to teach courses. 
The “DisplayEnrolledCourses” 
and “DisplayTeachingCourses” methods is used for displaying the current enrolled courses for a TA and the 
list of current courses he/she is
teaching.
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

2.4 TAMain.java
This is the driver program used to create instances of the classes, and also has the main program in it.

2.5 MeetingTimeTest.java
The first JUNIT test is done in MeetingTimeTest.java. I have written a small JUNIT test for GetStartDate, 
GetTimeOfDay as well as Overlap function.

public void testGetStartDateTime()
public void testGetTimeOfDay()
public void testOverlap()

2.6 AllTests.java
This implements a regression testing suite on MeetinTimetest.java and tests all the cases.
