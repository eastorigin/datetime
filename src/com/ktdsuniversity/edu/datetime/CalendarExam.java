package com.ktdsuniversity.edu.datetime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExam {

	/**
	 * 현재 시간을 출력
	 * Calendar 인스턴스 출력
	 */
	public static void printNow() {
		// Calendar는 Singleton Instance라서 getInstance() 메소드를 통해 가져와야 한다
		// 아래 코드가 실행되는 순간의 PC 시간을 가져옴
		Calendar now = Calendar.getInstance();
		System.out.println(now);
	}
	
	/**
	 * 컴퓨터가 처음 개발된 1970년 1원 1일 00시 00분 00초부터 현재까지 흐른 시간
	 * 1초 == 1000ms
	 */
	public static void printMilliSeconds() {
		
		long ms = System.currentTimeMillis();
		System.out.println(ms);
	}
	
	public static void printNowUseDate() {
		// 밀리세컨즈를 사용하는 이유
		// 메소드가 실행된 시간을 구할 때만 ms가 사용됨
		// 예를 들어, 게시글을 등록하는 데 걸린시간 0.012ms 소요됨

		long ms = System.currentTimeMillis();
		
		// java.util.Date
		Date now = new Date();
		System.out.println(now);
	}
	
	public static void printYearMonthDate() {
		
		// 1. Calendar 인스턴스 가져오기
		Calendar now = Calendar.getInstance();
		
		// 2. 연도 가져오기
		int year = now.get(Calendar.YEAR);
		
		// 3. 월 가져오기
		int month = now.get(Calendar.MONTH) + 1;
		
		// 4. 일 가져오기
		int day = now.get(Calendar.DAY_OF_MONTH);
		
		// 5. 출력하기
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
	}
	
	public static void printHourMinuteSecond() {
		
		// 1. Calendar 인스턴스 가져오기
		Calendar now = Calendar.getInstance();
		
		// 2. 시 가져오기
		int hour = now.get(Calendar.HOUR);
		
		// 3. 분 가져오기
		int minute = now.get(Calendar.MINUTE);
		
		// 4. 초 가져오기
		int second = now.get(Calendar.SECOND);
		
		// 5. 출력하기
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);
	}
	
	public static void printWeekDay() {
		// 1. Calendar 인스턴스 가져오기
		Calendar now = Calendar.getInstance();
		
		// 2. 현재 요일 가져오기 ( 1 ~ 7 ) ( 일 ~ 토 )
		int day = now.get(Calendar.DAY_OF_WEEK);
		
		// 3. 출력하기
		System.out.println(day);
	}
	
	public static void printWeekDayString() {
		String[] Weekdays = {"일", "월", "화", "수", "목", "금", "토"};
		// 1. Calendar 인스턴스 가져오기
		Calendar now = Calendar.getInstance();
		
		// 2. 현재 요일 가져오기 ( 1 ~ 7 ) ( 일 ~ 토 )
		int day = now.get(Calendar.DAY_OF_WEEK);
		
		// 3. 출력하기 (요일로 출력)
		for (int i = 0; i < Weekdays.length; i++) {
			if (day == i + 1) {
				System.out.println(Weekdays[i]);
			}
		}
	}
	
	public static void printFormattedDateTime() {
		
		// 1. Calendar 인스턴스 가져오기
		Calendar now = Calendar.getInstance();
		
		// 2. 날짜 포메터 생성 - 정해진 규칙
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		
		// 3. 날짜 포메터를 이용해서 날짜 만들기
		String dateString = sdf.format(now.getTime());
		
		// 4. 출력
		System.out.println(dateString);
	}
	
	public static void printFormattedDate() {
		// 연 원 일 출력
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = sdf.format(now.getTime());
		System.out.println(dateString);
	}
	
	public static void printFormattedTime() {
		// 시 분 초 출력
		Calendar now = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String dateString = sdf.format(now.getTime());
		System.out.println(dateString);
	}
	
	public static void printAfterDay(int amount) {
		
		// 1. Calendar 인스턴스 가져오기
		Calendar now = Calendar.getInstance();
		
		// 2. Calendar 인스턴스에 amout만큼 더하기
		now.add(Calendar.DAY_OF_MONTH, amount);
		
		// 3. SimpleDateFormat으로 출력하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(now.getTime());
		
		System.out.println(formattedDate);
	}
	
	public static void printBeforeDay(int amount) {
		// 1. Calendar 인스턴스 가져오기
		
		Calendar now = Calendar.getInstance();
		
		// 2. Calendar 인스턴스에 amout만큼 빼기
		// now.add(Calendar.DAY_OF_MONTH, -amount);
		now.add(Calendar.DAY_OF_MONTH, amount > 0 ? -amount : amount);
		
		// 3. SimpleDateFormat으로 출력하기
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(now.getTime());
		System.out.println(formattedDate);
	}
	
	public static void printAfterMonth(int amount) {
		Calendar now = Calendar.getInstance();
		
		now.add(Calendar.MONTH, amount);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedMonth = sdf.format(now.getTime());
		
		System.out.println(formattedMonth);
		
	}
	
	public static void printBeforeMonth(int amount) {
		Calendar now = Calendar.getInstance();
		
		now.add(Calendar.MONTH, amount > 0 ? -amount : amount);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedMonth = sdf.format(now.getTime());
		System.out.println(formattedMonth);
	}
	
	public static void printAfterYear(int amount) {
		Calendar now = Calendar.getInstance();
		
		now.add(Calendar.YEAR, amount);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedYear = sdf.format(now.getTime());
		System.out.println(formattedYear);
	}
	
	public static void printBeforeYear(int amount) {
		Calendar now = Calendar.getInstance();
		
		now.add(Calendar.YEAR, amount > 0 ? -amount : amount);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedYear = sdf.format(now.getTime());
		System.out.println(formattedYear);
	}
	
	public static void print(int year, int month, int date) {
		
		// 1. Calendar 인스턴스 가져오기
		Calendar calendar = Calendar.getInstance();
		
		// 2. 파라미터 변수들을 Calendar 인스턴스에 적용하기
		calendar.set(year, month - 1, date);
		
		// 3. 포멧에 맞추어 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = sdf.format(calendar.getTime());
		System.out.println(formattedDate);
	}
	
	public static void print(int year, int month, int date, int hour, int minute, int second) {
		
		Calendar calendar = Calendar.getInstance();
		
		calendar.set(year, month - 1, date, hour, minute, second);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = sdf.format(calendar.getTime());
		System.out.println(formattedDate);
	}
	
	// datetime = "2023.05.05";
	public static void print(String datetime) {
		
		String hintString = "2024년 08월 05일";
		String[] dateArray = hintString.split("[^0-9 ]");
		for (int i = 0; i < dateArray.length; i++) {
			dateArray[i] = dateArray[i].trim();
		}
		
		int year = Integer.parseInt(dateArray[0]);
		System.out.println(year);
		int month = Integer.parseInt(dateArray[1]) - 1;
		System.out.println(month);
		int date = Integer.parseInt(dateArray[2]);
		System.out.println(date);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formattedDate = sdf.format(calendar.getTime());
		System.out.println(formattedDate);
	}
	
	public static void printAllDays(int year, int month) {
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		
		// 1. 해당 년월의 마지막 날짜가 언제인지 구한다
		// 1-1. 월을 더해서 하루를 뺀다
		// calendar.add(calendar.MONTH, 1);
		// calendar.add(calendar.DAY_OF_MONTH, -1);
		
		// 1-2. 해당 월의 마지막 날짜를 구한다
		int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(lastDay);
		
		// 2. 1일부터 마지막 날짜까지 반복하면서 모든 날짜를 출력한다
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i = 0; i < lastDay; i++) {
			String formattedDate = sdf.format(calendar.getTime());
			System.out.println(formattedDate);
			
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
	
	public static void printNextWorkingDay(int year, int month, int date) {
		
		// 1. Calendar 인스턴스 가져오기
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, date);
		
		// 2. 다음 영업일을 알기 위해서 일단 하루 더하기
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		
		// 3. 하루를 더한 날짜가 영업일이 아니라면 계속 하루 더하기
		while(true) {
			
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			
			if (dayOfWeek == 1 || dayOfWeek == 7) {
				calendar.add(Calendar.DAY_OF_MONTH, 1);
			}else {
				break;
			}
		}
		
		// 4. 출력
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = sdf.format(calendar.getTime());
		System.out.println(formattedDate);
	}
	
	public static void calculateBirthDay(int year, int month, int date) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, date);
		Calendar now = Calendar.getInstance();
		
		int nowDate = now.get(Calendar.DAY_OF_YEAR);	
		int birthDay = calendar.get(Calendar.DAY_OF_YEAR);
		int nowYear = now.get(Calendar.YEAR);
		
		if (birthDay- nowDate >= 0) {
			System.out.println(birthDay - nowDate + "일");
		}else {
			if(nowYear % 4 == 0) {
				System.out.println(birthDay + (366 - nowDate) + "일");
			}else {
				System.out.println(birthDay + (365 - nowDate) + "일");
			}
		}
	}
	
	public static void printDDay (int birthMonth, int birthDate) {
		Calendar now = Calendar.getInstance();
		
		int dayCount = 0;
		
		while (true) {
			int nowMonth = now.get(Calendar.MONTH) + 1;
			int nowDate = now.get(Calendar.DAY_OF_MONTH);
			
			if (nowMonth == birthMonth && nowDate == birthDate) {
				break;
			}
			
			now.add(Calendar.DAY_OF_MONTH, 1);
			dayCount++;
		}
		
		System.out.println("생일까지 " + dayCount + "일 남았습니다.");
	}
	
	public static void main(String[] args) {
		printNow();
		printMilliSeconds();
		printNowUseDate(); // Date 사용됨
		
		// Calendar 사용
		printYearMonthDate();
		printHourMinuteSecond();
		System.out.println("============");
		printWeekDay();
		printWeekDayString();
		printFormattedDateTime();
		printFormattedDate();
		printFormattedTime();
		printAfterDay(1); /// 하루 뒤는 몇 년 몇 월 며칠?
		printAfterDay(10); // 열흘 뒤는 몇 년 몇 월 며칠?
		printAfterDay(30); // 30일 뒤는 몇 년 몇 월 며칠?
		printAfterDay(100); // 100일 뒤는 몇 년 몇 월 며칠?
		System.out.println("========일 빼기===========");
		printBeforeDay(1);
		printBeforeDay(10);
		printBeforeDay(30);
		printBeforeDay(100);
		System.out.println("===============월 더하기===================");
		printAfterMonth(1);
		printAfterMonth(10);
		printAfterMonth(30);
		System.out.println("===========월 빼기==================");
		printBeforeMonth(1);
		printBeforeMonth(10);
		printBeforeMonth(30);
		System.out.println("===============연 더하기====================");
		printAfterYear(1);
		printAfterYear(10);
		printAfterYear(30);
		System.out.println("==============연 빼기=================");
		printBeforeYear(1);
		printBeforeYear(10);
		printBeforeYear(30);
		System.out.println("========================================");
		print(2023, 5, 5);
		print(2022, 5, 5, 18, 19, 38);
		print("2024년 9월 21일"); // yyyy-MM-dd 출력
		
		printAllDays(2024, 2);
		printNextWorkingDay(2024, 9, 21); // 토요일, 다음 영업일은 8월 5일이 출력되어야 한다
		calculateBirthDay(2025, 2, 18);
		calculateBirthDay(2024, 9, 21);
		printDDay(1, 23);
	}
}
