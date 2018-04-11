package it.contrader.automative.utils;

public class DiffDate {

	private int years;
	private int months;
	private int days;

	public DiffDate ()
	{
		years = 0;
		months = 0;
		days = 0;
	}

	public DiffDate (int years, int months, int days)
	{
		this.years = years;
		this.months = months;
		this.days = days;
	}

	public void setYears (int years)
	{
		this.years = years;
	}

	public void setMonths (int month)
	{
		this.months = months;
	}

	public void setDays (int days)
	{
		this.days = days;
	}

	public int getYears ()			{ return years;		}
	public int getMonths ()			{ return months;	}
	public int getDays ()				{	return days;		}

}
