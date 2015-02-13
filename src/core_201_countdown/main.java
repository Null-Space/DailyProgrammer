package core_201_countdown;

public class main
{
	
	/*------------------------------------------------
	 * 				Day Countdown <EASY>
	 * -----------------------------------------------
	 * 
	 * My solution to the daily programming task
	 * for [2015-02-9] over at reddit/r/dailyprogramer
	 * 
	 * ================================================
	 * ===   Short link: [http://bit.ly/1D2H88M]
	 * ================================================
	 */
	
	/*
	 * This program is designed to take a day of the year as Three integer
	 * values and give as output the number of days left until that date!
	 * 
	 * 
	 */
	public static void main(String[] args)
	{

		DayCountdown countDownOne = new DayCountdown(4,7,2015);
		DayCountdown countDownTwo = new DayCountdown(31,10,2015);
		DayCountdown countDownThree = new DayCountdown(24,12,2015);
		DayCountdown countDownFour = new DayCountdown(1,1,2016);
		DayCountdown countDownFive = new DayCountdown(9,2,2016);
		DayCountdown countDownSix = new DayCountdown(1,1,2020);
		DayCountdown countDownSeven = new DayCountdown(9,2,2020);
		DayCountdown countDownEight = new DayCountdown(1,3,2020);
		DayCountdown countDownNine = new DayCountdown(9,2,3015);
	}
}
