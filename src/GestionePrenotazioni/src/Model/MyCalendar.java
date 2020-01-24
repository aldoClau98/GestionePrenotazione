package Model;

import java.util.Calendar;

public class MyCalendar {

	public MyCalendar() {

		date = Calendar.getInstance();

	}

	/*
	 * funzioni per prendere giorno mese anno ed il giorno della settimana
	 * 
	 */
	public int getYear() {
		return date.get(1);
	}

	public int getMonth() {
		return (date.get(2));
	}

	public int getDay() {
		return date.get(5);
	}

	public int getDayofWeek() {
		return date.get(7);
	}

	public void setDayofWeek(int dayOfWeek) {
		date.set(Calendar.DAY_OF_WEEK, dayOfWeek);
	}

	public void setDate(int year, int month, int day) {
		date.set(Calendar.YEAR, year);
		date.set(Calendar.MONTH, month);
		date.set(Calendar.DAY_OF_MONTH, day);

	}

	// lo uso per fare qary al database
	public String getDate() {
		return date.get(1) + "-" + (date.get(2) + 1) + "-" + date.get(5);
	}

	/* Funzione per trovare il giorno della settimana in base alla data */

	public String getToday() {
		Calendar temp = Calendar.getInstance();

		String data = temp.YEAR + "-" + temp.MONTH + "-" + temp.DAY_OF_MONTH;
		return data;
	}

	/*
	 * Funzioni per settare anno giorno mese e giorno della settimana
	 */
	public void SplitData(String temp) {
		MyCalendar date = new MyCalendar();
		int year = Integer.parseInt(temp.substring(0, 3));
		int month = Integer.parseInt(temp.substring(5, 7));
		int day = Integer.parseInt(temp.substring(9, 10));
		date.setDate(year, month, day);
	}

	public int setDayofWeek() {

		// Set up the day's of the week with 0 being Sat as per algorithm.
		final String[] DAY_OF_WEEK = { "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica" };
		int month = date.get(2);
		int year = date.get(1);
		int day = date.get(5);
		// According to the algorithm Jan is 13 & Feb 14...
		if (month < 3)
			month = month + 12;
		// Calculate
		double h = (((day + (((month + 1) * 26) / 10) + year + (year / 4) + (6 * (year / 100)) + (year / 400)) - 1)
				% 7);
		// Cast answer back to integer to get result from array
		int ans = (int) h;

		date.set(Calendar.DAY_OF_WEEK, ans);
		return ans;
	}

	// serve per calcolarsi il range di data per prendere le prenotazioni della
	// settimana
	public int getDayofWeek(String data) {

		// Set up the day's of the week with 0 being Sat as per algorithm.
		final String[] DAY_OF_WEEK = { "Lunedi", "Martedi", "Mercoledi", "Giovedi", "Venerdi", "Sabato", "Domenica" };

		int month = date.get(2);
		int year = date.get(1);
		int day = date.get(5);
		// According to the algorithm Jan is 13 & Feb 14...
		if (month < 3)
			month = month + 12;
		// Calculate
		double h = (((day + (((month + 1) * 26) / 10) + year + (year / 4) + (6 * (year / 100)) + (year / 400)) - 1)
				% 7);
		// Cast answer back to integer to get result from array
		int ans = (int) h;

		date.set(Calendar.DAY_OF_WEEK, ans);
		return ans;
	}

	private Calendar date;

}
