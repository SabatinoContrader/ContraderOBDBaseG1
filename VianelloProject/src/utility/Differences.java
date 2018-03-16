package utility;

import java.util.*;


public class Differences
{
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

	public static DiffDate diffDates (Calendar beforeDate, Calendar afterDate)
	{
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

//	public static void main (String[] args)
//	{
//		Calendar degree1 = Calendar.getInstance ();
//		degree1.set (Calendar.YEAR, 1992);
//		degree1.set (Calendar.MONTH, 9);
//		degree1.set (Calendar.DAY_OF_MONTH, 28);
//
//		Calendar degree2 = Calendar.getInstance ();
//		degree2.set (Calendar.YEAR, 2000);
//		degree2.set (Calendar.MONTH, 6);
//		degree2.set (Calendar.DAY_OF_MONTH, 6);
//		Calendar rightNow = Calendar.getInstance ();
//
//		Calendar wedding = Calendar.getInstance ();
//		wedding.set (Calendar.YEAR, 2004);
//		wedding.set (Calendar.MONTH, 5);
//		wedding.set (Calendar.DAY_OF_MONTH, 4);
//
//		DiffDate dd1 = diffDates (degree1, rightNow);
//		DiffDate dd2 = diffDates (degree2, rightNow);
//		DiffDate dd3 = diffDates (wedding, rightNow);
//
//		System.out.println ("Caro Sottovento, stai invecchiando. Dalla tua prima laurea sono passati");
//		System.out.println ("" + dd1.getYears() + " anni");
//		System.out.println ("" + dd1.getMonths() + " mesi");
//		System.out.println ("" + dd1.getDays() + " giorni");
//		System.out.println ("Dalla tua seconda laurea sono passati");
//		System.out.println ("" + dd2.getYears() + " anni");
//		System.out.println ("" + dd2.getMonths() + " mesi");
//		System.out.println ("" + dd2.getDays() + " giorni");
//		System.out.println ("Dal tuo matrimonio sono passati");
//		System.out.println ("" + dd3.getYears() + " anni");
//		System.out.println ("" + dd3.getMonths() + " mesi");
//		System.out.println ("" + dd3.getDays() + " giorni");
//		System.out.println ("Non e' l'ora di mettere la testa a posto?");
//	}
}

