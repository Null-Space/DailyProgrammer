package core_201_countdown;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DayCountdown 
{
	//The DayCountdown class
	
	private Date CurrentDateInTime;
	private Date SpecialDateInTime;
	
	
	public DayCountdown(int day, int month, int year)
	{
		/* Takes as default three integer inputs as argument for the
		 * day in which to calculate the days remaining!
		 */
		
		/*DateFormat specialDateFormatInstance = DateFormat.getDateInstance();
		DateFormat currentDateformatInstance = DateFormat.getDateTimeInstance();
		
		try 
		{
			SpecialDateInTime = specialDateFormatInstance.parse(new String(day+"/"+month+"/"+year));
			
			System.out.println("Current date is: "+SpecialDateInTime);
			Calendar newCalendar = Calendar.getInstance();
			Calendar specialCalendar = Calendar.getInstance();
			specialCalendar.set(year, month, day);
			
			if(newCalendar.before(specialCalendar))
			{
				System.out.println("The current calendar date ["+newCalendar.toString()+" is before the targeted Calendar date: "+specialCalendar.toString());
			}
			else System.out.println("The current calendar date ["+new Date(newCalendar.getTimeInMillis())+" was not before the targeted Calendar date: "+new Date(specialCalendar.getTimeInMillis()));
			
			
			
			
		}
		catch (ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		calculateTimeUntillDate(day, month, year);
		
		//Date currentDate = currentDateformatInstance.get
		//DateFormat.getDateInstance().parse(new String(day+"/"+month+"/"+year));
		//format.format(new Date(new String(day+"/"+month+"/"+year)));
		//System.currentTimeMillis();
	}
	
	private Countdown calculateTimeUntillDate(int dayArg, int monthArg, int yearArg)
	{
			return new Countdown(dayArg, monthArg, yearArg);
	}
	
	public class Countdown
	{
		private final int theDayOfTheMonth;
		private final int theMonthOfTheYear;
		private final int theYear;
		
		private Calendar CurrentCalendarTime;
		private Calendar SpecialCalendarTime;
		
		public Countdown(int day, int month, int year)
		{
			
			
			Calendar currentCalendarTime = Calendar.getInstance();	// Grabbing the Calendar Instance for the current Date
			
			CurrentCalendarTime = currentCalendarTime;
			
			SpecialCalendarTime = dateValidation(day, month, year, currentCalendarTime);
				this.theDayOfTheMonth = day;
				this.theMonthOfTheYear = month;
				this.theYear = year;
				if(CurrentCalendarTime.before(SpecialCalendarTime))
				{
					System.out.println("The current calendar date ["+calendarToString_WrittenDateOnly(CurrentCalendarTime)+" is before the targeted Calendar date: "+calendarToString_WrittenDateOnly(SpecialCalendarTime));
				}
				else System.out.println("The current calendar date ["+calendarToString_CompactDateOnly(CurrentCalendarTime)+"] was not before the targeted Calendar date: ["+calendarToString_CompactDateOnly(SpecialCalendarTime)+"]");
			
		}
		
		private Calendar dateValidation(int day, int month, int year, Calendar currentCalendar)
		{
			Calendar specialCalendar = Calendar.getInstance();		// Grabbing the Calendar Instance for the special Date
			specialCalendar.clear();
			
			//Must validate the month to the supported Calendar input values [0-11] I.E. Reduce by 1!
			month--;
			
			specialCalendar.set(year, month, day);					// Setting the Calendar to the specified date month and year!
			
			return specialCalendar;
		}
	}
	
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
	
	private String dayFormatter(int dayToFormat)
	{
		System.out.println("The day to format: "+dayToFormat);
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
