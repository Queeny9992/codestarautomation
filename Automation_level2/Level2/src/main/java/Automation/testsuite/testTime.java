package Automation.testsuite;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.annotations.Test;

public class testTime {

		@Test
	  public void getNext7DaysOfCurrentDateTime1() {
	  		Calendar calendar = Calendar.getInstance();
	  		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	  		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 7);
	  		String next7Days = df.format(calendar.getTime());
	  		System.out.println("Next 7 days from current day: " + next7Days);
	  		
	      }
		
		@Test
		public void getCurrentMonth() {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
			String currentMonth = df.format(calendar.getTime());
			System.out.println("currentMonthAsString: " + currentMonth);
			// return currentMonth;
		}
}
