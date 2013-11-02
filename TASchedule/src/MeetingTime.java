import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

//class StartEndTime has a starting and ending date/time. In Java Date object contains both the Date and Time
//Each  Subject      has a StartEndDateTime object as part of it
public class MeetingTime {
	private Date startDateTime;
	private Date endDateTime;

	public Date getStartDateTime() {
		return startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}
	
	//simple constructor to take a start and end date to create a StartEndDateTime object
	MeetingTime(Date st, Date end)
	{
		startDateTime = st;
		endDateTime   = end;
	}
	
	//how long is this duration between start and end date/time
	public long GetDurationMinutes()
	{
		long diff = (endDateTime.getTime() - startDateTime.getTime()) / (60 * 1000);
		return diff;	
	}
	
	//what is the duration of this StartEndDateTime
	public void WriteDurationMinutes()
	{
		long diff = (endDateTime.getTime() - startDateTime.getTime()) / (60 * 1000);
		System.out.println(diff+" min");	
	}
	
	
	public String StartEndDateTime()
	{
		String str = "";
		
		SimpleDateFormat date_format = new SimpleDateFormat("HH:mm");
		str = date_format.format(startDateTime) + "-" + date_format.format(endDateTime) + "  ";
		return str;
		
	}
	
	
	public void WriteStartEndDate()
	{
		SimpleDateFormat date_format = new SimpleDateFormat("EEE MMM dd,yyyy HH:mm");
		System.out.println(date_format.format(startDateTime) + "--" + date_format.format(endDateTime) );
	}
	
	//do the two start end date times overlap. This simple test shows if the date time instance overlaps
	public boolean overlap(MeetingTime dt2)
	{
		if ( (this.getEndDateTime().getTime() - dt2.getStartDateTime().getTime()) > 0)
			return true;
		else
			return false;
	}
}
