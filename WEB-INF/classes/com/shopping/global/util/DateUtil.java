package com.shopping.global.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTimeConstants;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Component;
@Component
public class DateUtil {

	public  Date stringToDate(String date)
	{
		try{
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		    return formatter.parse(date);
		}
	    catch(Exception e){
	    	e.printStackTrace();
	    }
		return null;
	}
	public static String dateFormatChange(String date) throws ParseException
	{
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date date1=formatter.parse(date);
	    SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");
	    return formatter1.format(date1);
	}
	public static int noOfDayBetweenTwoDate(String startDate,String endDate) throws ParseException{
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		Date date=formatter.parse(startDate);
		Date date1=formatter.parse(endDate);
		LocalDate start = new LocalDate(date.getTime());
	    LocalDate end = new LocalDate(date1.getTime()).plusDays(1);
	    int days = Days.daysBetween(start, end).getDays();
		return days;
	    
	}

	public static int noOfHoliDay(String startDate,String endDate) throws ParseException{
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
		Date date=formatter.parse(startDate);
		Date date1=formatter.parse(endDate);
	    LocalDate start = new LocalDate(date.getTime());
	    LocalDate end = new LocalDate(date1.getTime()).plusDays(1);
	    int count=0;
	    LocalDate weekday = start;
	    int days = Days.daysBetween(start, end).getDays();
	    if (start.getDayOfWeek() == DateTimeConstants.SATURDAY ||
	        start.getDayOfWeek() == DateTimeConstants.SUNDAY) {
	        weekday = weekday.plusWeeks(1).withDayOfWeek(DateTimeConstants.MONDAY);
	    }
	    while (weekday.isBefore(end)) {
	        count++;
	        if (weekday.getDayOfWeek() == DateTimeConstants.FRIDAY)
	            weekday = weekday.plusDays(3);
	        else
	            weekday = weekday.plusDays(1);
	    }
	    int holiDays=days-count;
		return holiDays;
	}
	public static void main(String[] args) throws ParseException {
		
	}
}
