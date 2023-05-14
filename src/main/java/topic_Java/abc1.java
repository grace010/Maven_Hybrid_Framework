package topic_Java;

import java.time.LocalDate; // import the LocalDate class

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class abc1 {
	protected String getCurrentDate() {
		DateTime nowUTC = new DateTime(DateTimeZone.UTC);
		int day = nowUTC.getDayOfMonth();
		if (day < 10) {
			String dayValue = "0" + day;
			return dayValue;
		}
		return String.valueOf(day);
	}

//	protected String getCurrentMonth() {
//		DateTime now = new DateTime();
//		int month = now.getMonthOfYear();
//		if (month < 10) {
//			String monthValue = "0" + month;
//			return monthValue;
//		}
//		
//		return String.valueOf(month);
//	}
	
	protected String getCurrentMonth() {
		DateTime now = new DateTime();
		int month = now.getMonthOfYear();
		if (month==3) {
			return "March";
		}
		return String.valueOf(month);
	}
	
	
	protected String getCurrentYear() {
		DateTime now = new DateTime();
		return String.valueOf(now.getYear());
	}

	protected String getCurrentDay() {
		return  getCurrentMonth() + " " + getCurrentDate() + ", "+ getCurrentYear();
	}
	
	public static void main(String[]args) {
		abc1 obj = new abc1();
		System.out.println(obj.getCurrentDay());
	}
	
}