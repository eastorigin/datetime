package com.ktdsuniversity.edu.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExam {

	public static void printNowDate() {
		// 날짜만 가져오는 기능
		LocalDate now = LocalDate.now();
		System.out.println(now); // 2024-08-06
		
		// 시간만 가져오는 기능
		// java.time.LocalTime
		
		// 날짜와 시간을 모두 가져오는 기능
		// java.time.LocalDateTime
		
		// 기본 날짜 형식을 원하지 않는 경우 사용
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
		String formattedDate = dtf.format(now);
		System.out.println(formattedDate);
	}
	
	public static void printNowTime() {
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		DateTimeFormatter dft = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		String formattedTime = dft.format(now);
		System.out.println(formattedTime);
	}
	
	public static void printNowDateTime() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String formattedDateTime = dtf.format(now);
		System.out.println(formattedDateTime);
	}
	
	public static void printResultAddDate() {
		// LocalDate에 날짜를 더하기
		LocalDate date = LocalDate.of(2024, 8, 6);
		System.out.println("add before: " + date);
		DayOfWeek dayOfWeek = date.getDayOfWeek();
		System.out.println(dayOfWeek);
		
		date = date.plusDays(4);
		date = date.plusMonths(2);
		date = date.plusYears(5);
		
		dayOfWeek = date.getDayOfWeek();
		System.out.println("add after: " + date);
		System.out.println(dayOfWeek);
		
	}
	
	public static void printResultMinusDate() {
		// 2024년 10월 16일 LocalDate를 만들어서 4년 8개월 12일 뺀 결과를 출력
		LocalDate date = LocalDate.of(2024, 10, 16);
		System.out.println("before: " + date);
		
		date = date.minusDays(12);
		date = date.minusMonths(8);
		date = date.minusYears(4);
		
		System.out.println("after: " + date);
	}
	
	public static void printNowDayOfWeek() {
		LocalDate now = LocalDate.now();
		
		DayOfWeek dayOfWeek = now.getDayOfWeek();
		System.out.println(dayOfWeek);
		
	}
	
	public static void printResultAddTime() {
		// LocalTime
		LocalTime time = LocalTime.of(9, 21, 30);
		System.out.println("before: " + time);
		
		time = time.plusHours(11);
		time = time.plusMinutes(15);
		time = time.plusSeconds(26);
		
		System.out.println("after: " + time);
	}
	
	public static void printResultMinusTime() {
		// LocalTime
		LocalTime time = LocalTime.of(11, 15, 26);
		System.out.println("before: " + time);
		
		time = time.minusHours(9);
		time = time.minusMinutes(21);
		time = time.minusSeconds(30);
		
		System.out.println("after: "+ time);
	}
	
	public static void printResultAddDateTime() {
		// LocalDateTime
		LocalDateTime dateTime = LocalDateTime.of(2024, 9, 21, 9, 21, 30);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String formattedDateTime = dtf.format(dateTime);
		System.out.println("before: " + formattedDateTime);
		
		dateTime = dateTime.plusDays(9);
		dateTime = dateTime.plusWeeks(21);
		dateTime = dateTime.plusYears(30);
		dateTime = dateTime.plusHours(12);
		dateTime = dateTime.plusMinutes(1);
		dateTime = dateTime.plusSeconds(12);
		
		formattedDateTime = dtf.format(dateTime);
		System.out.println("after: " + formattedDateTime);
	}
	
	public static void printResultMinusDateTime() {
		// LocalDateTime
		LocalDateTime dateTime = LocalDateTime.of(2024, 11, 15, 11, 15, 26);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String formattedDateTime = dtf.format(dateTime);
		System.out.println("before: " + formattedDateTime);
		
		dateTime = dateTime.minusDays(11);
		dateTime = dateTime.minusWeeks(15);
		dateTime = dateTime.minusYears(26);
		dateTime = dateTime.minusHours(4);
		dateTime = dateTime.minusMinutes(29);
		dateTime = dateTime.minusSeconds(19);
		
		formattedDateTime = dtf.format(dateTime);
		System.out.println("after: " + formattedDateTime);
	}
	
	public static void printNextWorkingDay() {
		// LocalDate를 이용해 현재 날짜로부터 다음 6 영업일 이후의 날짜를 구하세요.
		LocalDate now = LocalDate.now();
		System.out.println(now);
		// int count = 0;
		int workingDays = 0;
		System.out.println(now.getDayOfWeek());
		
		while (true) {
//			if (count >= 6) {
//				break;
//			}
//			
//			if(!(now.getDayOfWeek() == DayOfWeek.SUNDAY || now.getDayOfWeek() == DayOfWeek.SATURDAY)) {
//				count++;
//			}
//			
//			now = now.plusDays(1);
			
			now = now.plusDays(1);
			
			// 하루 더한 날짜의 요일을 구한다
			DayOfWeek dayOfWeek = now.getDayOfWeek();
			if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
				workingDays++;
			}
			
			// 6 영업일을 더했다면 멈춤
			if (workingDays == 6) {
				break;
			}
		}
		
		System.out.println(now);
	}
	
	public static void printCorrectDatePeriod() {
		// 올바른 기간 검색 파라미터인가?
		
		LocalDate from = LocalDate.of(2024, 12, 31);
		LocalDate to = LocalDate.of(2024, 12, 31);
		
		// from이 to보다 같거나 과거인가?
		boolean isCorrectDatePeriod = from.isBefore(to) || from.isEqual(to);
		System.out.println(isCorrectDatePeriod);
	}
	
	public static void printBetween() {
		
		LocalDate startDate = LocalDate.of(2020, 1, 13);
		LocalDate endDate = LocalDate.of(2024, 8, 6);
		
		// startDate와 endDate의 차이는?
		Period between = Period.between(startDate, endDate);
		System.out.println(between);
		
		int years = between.getYears();
		int months = between.getMonths();
		int days = between.getDays();
		
		System.out.println(years + "년 " + months + "개월 " + days + "일 차이가 있습니다");
	}
	
	public static void main(String[] args) {
		printNowDate();
		printNowTime();
		printNowDateTime();
		printResultAddDate();
		printResultMinusDate();
		printNowDayOfWeek();
		printResultAddTime();
		printResultMinusTime();
		printResultAddDateTime();
		printResultMinusDateTime();
		System.out.println("===============");
		printNextWorkingDay();
		printCorrectDatePeriod();
		printBetween();
	}
}
