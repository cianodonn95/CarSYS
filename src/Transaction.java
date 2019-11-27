import java.io.*;

public class Transaction {

	final static int MONTHS_DAYS = 31, MONTHS = 12; //30 days in a month //12 months in a year
	private Customer aCustomer; //from the Customer
	private Car aCar; //from the Customer
	private int month = 0, days = 0;

	private String CurrentMonth;
	private int CurrentDate, Currentyear;

	private String PickMonth;
	private int PickDate, PickYear;

	private String returnMonth;
	private int returnDate, returnYear;

	private String birthMonth;
	private int birthDate, birthYear, age = 0;

	public Transaction() { //constructor
		aCustomer = new Customer();
		aCar = new Car();
		CurrentMonth = "";
		CurrentDate = 0;
		Currentyear = 0;
		PickMonth = "";
		PickDate = 0;
		PickYear = 0;
		returnMonth = "";
		returnDate = 0;
		returnYear = 0;
		birthMonth = "";
		birthDate = 0;
		birthYear = 0;
	}

	public void setTransaction(Customer cU, Car cA, String m, int d, int y, String pM, int pD, int pY, String rM, int rD, int rY, String bM, int bD, int bY) { //constructor
		aCustomer = cU;
		aCar = cA;
		CurrentMonth = m;
		CurrentDate = d;
		Currentyear = y;
		PickMonth = pM;
		PickDate = pD;
		PickYear = pY;
		returnMonth = rM;
		returnDate = rD;
		returnYear = rY;
		birthMonth = bM;
		birthDate = bD;
		birthYear = bY;
	}

	public String getCurrentMonth() {
		return CurrentMonth;
	}

	public int getCurrentDate() {
		return CurrentDate;
	}

	public int getCurrentYear() {
		return Currentyear;
	}
	//-----------------------getting the value of current month
	public int getCurrentMonthValue() {
		if(getCurrentMonth().equals("Jan"))
			month = 1;

		else if(getCurrentMonth().equals("Feb"))
			month = 2;

		else if(getCurrentMonth().equals("Mar"))
			month = 3;

		else if(getCurrentMonth().equals("Apr"))
			month = 4;

		else if(getCurrentMonth().equals("May"))
			month = 5;

		else if(getCurrentMonth().equals("Jun"))
			month = 6;

		else if(getCurrentMonth().equals("Jul"))
			month = 7;

		else if(getCurrentMonth().equals("Aug"))
			month = 8;

		else if(getCurrentMonth().equals("Sep"))
			month = 9;

		else if(getCurrentMonth().equals("Oct"))
			month = 10;

		else if(getCurrentMonth().equals("Nov"))
			month = 11;

		else if(getCurrentMonth().equals("Dec"))
			month = 12;

		return month;
	}

	public String getPickMonth() {
		return PickMonth;
	}

	public int  getPickDate() {
		return PickDate;
	}

	public int getPickYear() {
		return PickYear;
	}

	//--------------------getting the value of pick up month
	public int getPickMonthValue() {
		if(getPickMonth().equals("Jan"))
			month = 1;

		else if(getPickMonth().equals("Feb"))
			month = 2;

		else if(getPickMonth().equals("Mar"))
			month = 3;

		else if(getPickMonth().equals("Apr"))
			month = 4;

		else if(getPickMonth().equals("May"))
			month = 5;

		else if(getPickMonth().equals("Jun"))
			month = 6;

		else if(getPickMonth().equals("Jul"))
			month = 7;

		else if(getPickMonth().equals("Aug"))
			month = 8;

		else if(getPickMonth().equals("Sep"))
			month = 9;

		else if(getPickMonth().equals("Oct"))
			month = 10;

		else if(getPickMonth().equals("Nov"))
			month = 11;

		else if(getPickMonth().equals("Dec"))
			month = 12;

		return month;
	}

	public String getReturnMonth() {
		return returnMonth;
	}

	public int getReturnDate() {
		return returnDate;
	}

	public int getReturnYear() {
		return returnYear;
	}

	//---------------------------getting the value of return month
	public int getReturnMonthValue() {

		if(getReturnMonth().equals("Jan"))
			month = 1;

		else if(getReturnMonth().equals("Feb"))
			month = 2;

		else if(getReturnMonth().equals("Mar"))
			month = 3;

		else if(getReturnMonth().equals("Apr"))
			month = 4;

		else if(getReturnMonth().equals("May"))
			month = 5;

		else if(getReturnMonth().equals("Jun"))
			month = 6;

		else if(getReturnMonth().equals("Jul"))
			month = 7;

		else if(getReturnMonth().equals("Aug"))
			month = 8;

		else if(getReturnMonth().equals("Sep"))
			month = 9;

		else if(getReturnMonth().equals("Oct"))
			month = 10;

		else if(getReturnMonth().equals("Nov"))
			month = 11;

		else if(getReturnMonth().equals("Dec"))
			month = 12;

		return month;
	}

	public String getBirthMonth() {
		return birthMonth;
	}

	public int getBirthDate() {
		return birthDate;
	}

	public int getBirthYear() {
		return birthYear;
	}

	//--------------------Getting the value of birth month
	public int getBirthMonthValue() {
		if(getBirthMonth().equals("Jan"))
			month = 1;

		else if(getBirthMonth().equals("Feb"))
			month = 2;

		else if(getBirthMonth().equals("Mar"))
			month = 3;

		else if(getBirthMonth().equals("Apr"))
			month = 4;

		else if(getBirthMonth().equals("May"))
			month = 5;

		else if(getBirthMonth().equals("Jun"))
			month = 6;

		else if(getBirthMonth().equals("Jul"))
			month = 7;

		else if(getBirthMonth().equals("Aug"))
			month = 8;

		else if(getBirthMonth().equals("Sep"))
			month = 9;

		else if(getBirthMonth().equals("Oct"))
			month = 10;

		else if(getBirthMonth().equals("Nov"))
			month = 11;

		else if(getBirthMonth().equals("Dec"))
			month = 12;

		return month;
	}

	//-----------------------------getting the age
	public int getAge(){

		int age = 0;
		if((getCurrentYear() > getBirthYear())&&(getCurrentMonthValue() == getBirthMonthValue())) {
			if(getCurrentDate() == getBirthDate())
				age = getCurrentYear() - getBirthYear();

			else if(getCurrentDate() < getBirthDate())
				age = getCurrentYear() - getBirthYear();

			else if(getCurrentDate() > getBirthDate())
				age = (getCurrentYear() - 1) - getBirthYear();
		}

		else if((getCurrentYear() > getBirthYear())&&(getCurrentMonthValue() > getBirthMonthValue()))
			age = getCurrentYear() - getBirthYear();

		else if((getCurrentYear() > getBirthYear())&&(getCurrentMonthValue() < getBirthMonthValue()))
			age = (getCurrentYear() - 1) - getBirthYear();

		return age;
	}

	//---------------------For getting how many days Car has been rented
	//-------------ASK JB---------------
	public int getDays(){

		int totalMonth = 0, totalYear = 0;

		if((getPickYear() == getReturnYear()) && (getPickMonthValue() == getReturnMonthValue())) {
			if(getPickDate() == getReturnDate())
				days = 0;
			else if(getPickDate() < getReturnDate())
				days = getReturnDate() - getPickDate();
		}

		else if((getPickYear() == getReturnYear()) && (getPickMonthValue() < getReturnMonthValue())) {
			if(getPickDate() == getReturnDate()) {
				totalMonth = getReturnMonthValue() - getPickMonthValue();
				days = totalMonth * MONTHS_DAYS;
			}
			else if(getPickDate() < getReturnDate()) {
				totalMonth = getReturnMonthValue() - getPickMonthValue();
				days = (totalMonth * MONTHS_DAYS) + (getReturnDate() - getPickDate());
			}
		}

		else if(getPickYear() < getReturnYear()) {
			if(getPickMonthValue() == getReturnMonthValue()) {
				totalYear = getReturnYear() - getPickYear();
				days = ((totalYear * MONTHS) * MONTHS_DAYS) + (getReturnDate() - getPickDate());
			}

			else if(getPickMonthValue() < getReturnMonthValue()) {
				totalMonth = getReturnMonthValue() - getPickMonthValue();
				days = ((totalMonth + MONTHS) * MONTHS_DAYS) + (getReturnDate() - getPickDate());
			}

			else if(getPickMonthValue() > getReturnMonthValue()) { //kani mali
				totalMonth = MONTHS - (getPickMonthValue() - getReturnMonthValue());
				days = (totalMonth * 30) + (getReturnDate() - getPickDate());
			}
		}

		return days;
	}

	//-----------------------to get the total Rental price
	public double getRentalPrice() {

		return getDays() * aCar.getCarPrice();
	}

	//--------------------change to String for checking the date
	public String toStringDateChecker() {
		String outPut = "";

		if((getPickMonthValue() > getReturnMonthValue()) && (getPickYear() == getReturnYear()))
			outPut += String.format("FALSE");

		if((getPickMonthValue() == getReturnMonthValue()) && (getPickDate() > getReturnDate()) && (getPickYear() == getReturnYear()))
			outPut += String.format("FALSE");

		if(getPickYear() > getReturnYear())
			outPut += String.format("FALSE");

		else
			outPut += String.format("TRUE");

		return outPut;
	}

	//-----------------------change to String for checking the age of customer
	public String toStringAgeChecker() {
		String outPut = "";

		if(getAge() >= 18)
			outPut += String.format("TRUE");

		else if(getAge() < 18)
			outPut += String.format("FALSE");

		return outPut;
	}

	//--------------------------------(int)age to (String)age to print in GUI
	public String toStringAge() {
		String outPut = "";
		outPut += String.format("%d", getAge());
		return outPut;
	}

	//---------------REFERENCE STACK OVER FLOW----------Converts (formats) the details entered to readable string for Receipt page and txt file
	public String toStringMrMrs() {
		String outPut = "";


		if (aCustomer.getGender().equals("M") || aCustomer.getGender().equals("m"))
			outPut += String.format("Mr.");

		else if ((aCustomer.getStatus().equals("S") || aCustomer.getStatus().equals("s")) && aCustomer.getGender().equals("F") || aCustomer.getGender().equals("f"))
			outPut += String.format("Ms.");

		else if ((aCustomer.getStatus().equals("Ma") || aCustomer.getStatus().equals("ma")) && aCustomer.getGender().equals("F") || aCustomer.getGender().equals("f"))
			outPut += String.format("Mrs.");

		return outPut;
	}

	//---------------REFERENCE STACK OVERFLOW---------------show all for customers
	public String toStringReceipt() {
		String outPut = "";

		outPut += String.format("                             RENTAL TRANSACTION\n");
		outPut += String.format("-----------------------------------------------------------------------------------------------------\n");
		outPut += String.format("Car                                                        %s\n", aCar.getCar());
		outPut += String.format("Rental Days                                                %d\n", getDays());
		outPut += String.format("Rental Price                                               %.2f\n", aCar.getCarPrice());
		outPut += String.format("                                                           --------------\n");
		outPut += String.format("Total Payment                                              %.2f\n",getRentalPrice());
		outPut += String.format(toStringMrMrs() + aCustomer.getFullName());
		return outPut;
	}

	//-------REFERENCE - STACK OVERFLOW--------save all data to .txt file for the Owner
	public void saveToFile() throws IOException {

		PrintWriter outFile = new PrintWriter(new FileOutputStream(new File("Transactions.txt"), true));
		outFile.println("Current Date: " + getCurrentMonth() + " " + getCurrentDate() + ", " + getCurrentYear());
		outFile.println(" ");
		outFile.println("Pick up Date: " + getPickMonth() + " " + getPickDate() + ", " + getPickYear());
		outFile.println("Return Date: " + getReturnMonth() + " " + getReturnDate() + ", " + getReturnYear()  + " = Days: " + getDays());
		outFile.println("Full Name: " + aCustomer.getFullName());
		outFile.println("Age: " + getAge());
		outFile.println("Location: " + aCustomer.getLocation());
		outFile.println("Contact: " + aCustomer.getContact());
		outFile.println("Car: " + aCar.getCar());
		outFile.printf("Total Rent Price: %.2f", + getRentalPrice());
		outFile.println(" ");
		outFile.println("--------------------------------------------------");
		outFile.close();
	}
}
