package it.contrader.automative.utils;

import java.util.Calendar;
import java.util.Date;

public class Differences {

	public static int numDays (Calendar cal)
	{
		return cal.getActualMaximum (Calendar.DAY_OF_MONTH);
	}

	public static int numDaysPreviousMonth (Calendar cal)
	{
		Calendar c = (Calendar)cal.clone ();
		c.roll (Calendar.MONTH, -1);
		return c.getActualMaximum (Calendar.DAY_OF_MONTH);
	}

	public static DiffDate diffDates (Calendar beforeDate, Date aftDate)
	{
		Calendar afterDate = Calendar.getInstance();
		
		afterDate.setTime(aftDate);
		
		
		int carryDay = 0;
		int carryMonth = 0;
		int diffday = afterDate.get(Calendar.DAY_OF_MONTH) - beforeDate.get(Calendar.DAY_OF_MONTH);
		if (diffday < 0)
		{
			diffday += numDaysPreviousMonth (afterDate);
			carryDay = 1;
		}

		int diffmonth = afterDate.get(Calendar.MONTH) - beforeDate.get(Calendar.MONTH) - carryDay;
		if (diffmonth < 0)
		{
			diffmonth += 12;
			carryMonth = 1;
		}
		int diffyear = afterDate.get(Calendar.YEAR) - beforeDate.get(Calendar.YEAR) - carryMonth;
		return new DiffDate (diffyear, diffmonth, diffday);
	}
}
