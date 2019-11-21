import java.util.*;
import java.io.*;

public class Transaction {

    final static int MONTHS_DAYS = 30, MONTHS = 12; //For the sake of the program every month has 30 days
    private Customer aCustomer; //from the Customer class
    private Car aCar; //from the Customer class
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

    //getting the value of current month
    public int getCurrentMonthValue() {
        if (getCurrentMonth().equals("Jan"))
            month = 1;

        else if (getCurrentMonth().equals("Feb"))
            month = 2;

        else if (getCurrentMonth().equals("Mar"))
            month = 3;

        else if (getCurrentMonth().equals("Apr"))
            month = 4;

        else if (getCurrentMonth().equals("May"))
            month = 5;

        else if (getCurrentMonth().equals("Jun"))
            month = 6;

        else if (getCurrentMonth().equals("Jul"))
            month = 7;

        else if (getCurrentMonth().equals("Aug"))
            month = 8;

        else if (getCurrentMonth().equals("Sep"))
            month = 9;

        else if (getCurrentMonth().equals("Oct"))
            month = 10;

        else if (getCurrentMonth().equals("Nov"))
            month = 11;

        else if (getCurrentMonth().equals("Dec"))
            month = 12;

        return month;
    }

    public String getPickMonth() {
        return PickMonth;
    }

    public int getPickDate() {
        return PickDate;
    }

    public int getPickYear() {
        return PickYear;
    }

    //getting the value of pick up month
    public int getPickMonthValue() {
        if (getPickMonth().equals("Jan"))
            month = 1;

        else if (getPickMonth().equals("Feb"))
            month = 2;

        else if (getPickMonth().equals("Mar"))
            month = 3;

        else if (getPickMonth().equals("Apr"))
            month = 4;

        else if (getPickMonth().equals("May"))
            month = 5;

        else if (getPickMonth().equals("Jun"))
            month = 6;

        else if (getPickMonth().equals("Jul"))
            month = 7;

        else if (getPickMonth().equals("Aug"))
            month = 8;

        else if (getPickMonth().equals("Sep"))
            month = 9;

        else if (getPickMonth().equals("Oct"))
            month = 10;

        else if (getPickMonth().equals("Nov"))
            month = 11;

        else if (getPickMonth().equals("Dec"))
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

    //getting the value of return month
    public int getReturnMonthValue() {
        if (getReturnMonth().equals("Jan"))
            month = 1;

        else if (getReturnMonth().equals("Feb"))
            month = 2;

        else if (getReturnMonth().equals("Mar"))
            month = 3;

        else if (getReturnMonth().equals("Apr"))
            month = 4;

        else if (getReturnMonth().equals("May"))
            month = 5;

        else if (getReturnMonth().equals("Jun"))
            month = 6;

        else if (getReturnMonth().equals("Jul"))
            month = 7;

        else if (getReturnMonth().equals("Aug"))
            month = 8;

        else if (getReturnMonth().equals("Sep"))
            month = 9;

        else if (getReturnMonth().equals("Oct"))
            month = 10;

        else if (getReturnMonth().equals("Nov"))
            month = 11;

        else if (getReturnMonth().equals("Dec"))
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
}//remove