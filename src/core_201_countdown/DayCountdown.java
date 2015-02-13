package core_201_countdown;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DayCountdown 
{
	//The DayCountdown class
	
	private Countdown newCountdownDate;
	
	public DayCountdown(int day, int month, int year)
	{
		/* Takes as default three integer inputs as argument for the
		 * day in which to calculate the days remaining!
		 */	
		
		this.newCountdownDate = calculateTimeUntillDate(day, month, year);
		
		System.out.println(this.newCountdownDate.returnCountdown());
		
	}
	
	private Countdown calculateTimeUntillDate(int dayArg, int monthArg, int yearArg)
	{
			return new Countdown(dayArg, monthArg, yearArg);
	}
	
	public class Countdown
	{
		private static final long MILLISECONDS_PER_SECOND = 1000;
		private static final long MILLISECONDS_PER_MINUTE = 60 * MILLISECONDS_PER_SECOND;
		private static final long MILLISECONDS_PER_HOUR = 60 * MILLISECONDS_PER_MINUTE;
		private static final long MILLISECONDS_PER_DAY = MILLISECONDS_PER_HOUR*24;
		
		private Calendar CurrentCalendarTime;
		private Calendar SpecialCalendarTime;
		
		private int CountdownDays = 0;
		private int RemainderHours = 0;
		private int RemainderMinutes = 0;
		
		public Countdown(int day, int month, int year)
		{
			Calendar currentCalendarTime = Calendar.getInstance();	// Grabbing the Calendar Instance for the current Date
			
			CurrentCalendarTime = currentCalendarTime;
			SpecialCalendarTime = dateValidation(day, month, year);
			
			performCountdownInDays();
			
			if(CurrentCalendarTime.before(SpecialCalendarTime))
			{
				System.out.println("The current calendar date [ "+calendarToString_CompactDateOnly(CurrentCalendarTime)+" ] <====> The targeted countdown date: [ "+calendarToString_CompactDateOnly(SpecialCalendarTime)+" ]");
			}
			else System.out.println("The current calendar date ["+calendarToString_CompactDateOnly(CurrentCalendarTime)+"] was not before the targeted Calendar date: ["+calendarToString_CompactDateOnly(SpecialCalendarTime)+"]");
			
		}
		
		private Calendar dateValidation(int day, int month, int year)
		{
			Calendar specialCalendar = Calendar.getInstance();		// Grabbing the Calendar Instance for the special Date
			specialCalendar.clear();
			
			//Must validate the month to the supported Calendar input values [0-11] I.E. Reduce by 1!
			month--;
			
			specialCalendar.set(year, month, day);					// Setting the Calendar to the specified date month and year!
			
			return specialCalendar;
		}
		
		/*
		 * In this method we will be calculating the days until the specified date in time!
		 */
		private void performCountdownInDays()
		{
			//Calculate the time between calendar dates in milliseconds first
			final long timeBetween = SpecialCalendarTime.getTimeInMillis() - CurrentCalendarTime.getTimeInMillis();
			//Next value calculated is just to make the remainder calculations easier to read
			final long ramainderInDay = timeBetween % MILLISECONDS_PER_DAY;
			
			CountdownDays = (int) (timeBetween / MILLISECONDS_PER_DAY);									//<------	The days remaining [The solution]
			
			//This code below is just extra calculations that I wanted to find!
			RemainderHours = (int) ((ramainderInDay)/MILLISECONDS_PER_HOUR);							//<------ 	The Minutes remaining [Not required]
			RemainderMinutes = (int) ((ramainderInDay%MILLISECONDS_PER_HOUR)/MILLISECONDS_PER_MINUTE);	//<------ 	The Seconds remaining [Again Not required]
		}
		
		/*
		 * A glorified toString Method
		 */
		public String returnCountdown()
		{
			return new String("Countdown until the date: "+this.CountdownDays+" Days "+RemainderHours+" Hours & "+this.RemainderMinutes+" Minutes");
		}
	}
	
	//=========================================== Print Methods ================================================
	
	/*
	 * Below are a few helper methods for printing out the Calendar variables in a format I can read easily.
	 */
	private String calendarToString_WrittenDateOnly(Calendar calendarArgument)
	{
		//Print out the values for the calendar date without the time portion!
		return new String(dayFormatter(calendarArgument.get(Calendar.DAY_OF_WEEK))+" the "+(calendarArgument.get(Calendar.DAY_OF_MONTH)+suffixify(calendarArgument.get(Calendar.DAY_OF_MONTH)))+" of "+monthFormatter(calendarArgument.get(Calendar.MONTH))+" "+calendarArgument.get(Calendar.YEAR));
	}
	
	private String calendarToString_CompactDateOnly(Calendar calendarArgument)
	{
		//Print out the values for the calendar date without the time portion!
		return new String(calendarArgument.get(Calendar.DAY_OF_MONTH)+suffixify(calendarArgument.get(Calendar.DAY_OF_MONTH))+" / "+(calendarArgument.get(Calendar.MONTH)+1)+suffixify(calendarArgument.get(Calendar.MONTH)+1)+" / "+calendarArgument.get(Calendar.YEAR));
	}
	
	private String calendarToString_DateTime(Calendar calendarArgument)
	{
		//Print out the values for the calendar date with the time!
		return new String(calendarArgument.getTime().toString());
	}
	
	/*
	 * The dayFormatter formats the integer argument into the relevant day of the week in name form
	 */
	private String dayFormatter(int dayToFormat)
	{
		switch(dayToFormat)
		{
			case 1 : return new String("Sunday");

			case 2 : return new String("Monday");

			case 3 : return new String("Tuesday");

			case 4 : return new String("Wednesday");

			case 5 : return new String("Thursday");

			case 6 : return new String("Friday");

			case 7 : return new String("Saturday");

			default : System.out.println("Unknown value: "+dayToFormat);
				throw new IllegalArgumentException();
		}
	}
	
	/*
	 * This monthFormatter method performs the same procedure as the dayFormatter, just on Month values
	 */
	private String monthFormatter(int monthToFormat)
	{
		switch(monthToFormat)
		{
			case 0 : return new String("January");

			case 1 : return new String("February");

			case 2 : return new String("March");

			case 3 : return new String("April");

			case 4 : return new String("May");

			case 5 : return new String("June");

			case 6 : return new String("July");
			
			case 7 : return new String("August");
			
			case 8 : return new String("September");
			
			case 9 : return new String("October");
			
			case 10 : return new String("November");
			
			case 11 : return new String("December");

			default : System.out.println("Unknown value: "+monthToFormat);
				throw new IllegalArgumentException();
		}
	}
	
	/*
	 * The Suffixify method returns a suffix to the number of the month inputed!
	 */
	private String suffixify(int dayOfTheMonth)
	{
		//1st, 21st, 31st
		//2nd, 22nd
		//3rd, 23rd
		//the rest is 'th'
		
		if(dayOfTheMonth == 1 || dayOfTheMonth == 21 || dayOfTheMonth == 31)
		{
			return new String("st");
		}
		
		if(dayOfTheMonth == 2 || dayOfTheMonth == 22)
		{
			return new String("nd");
		}
		
		if(dayOfTheMonth == 3 || dayOfTheMonth == 23)
		{
			return new String("rd");
		}
		
		return new String("th");
	}
}
