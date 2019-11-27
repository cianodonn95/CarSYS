import java.util.*;
import java.io.*;

/*
 * By Cian O'Donnell
 * This class represents the potential customer that will rent a car.
 * Customer contains basic customer details to be stored and printed to a file.
 */



//---------------------Customer Class
public class Customer {

	private String firstName, lastName, gender, status, location, contact;

	/*
	 * Customer first name, last name, gender, marital status, location and contact information.
	 */

	public Customer() {

		firstName = "";
		lastName = "";
		gender = "";
		status = "";
		location = "";
		contact = "";
	}

	/*
	Assigning Customer details
	 */

	public void setCustomer(String fN, String lN, String g, String s, String l, String c){

		firstName = fN;
		lastName = lN;
		gender = g;
		status = s;
		location = l;
		contact = c;
	}

	/*
	 * Takes name entered into the first name field and stores it to be printed in the receipt at the end and in the text file
	 */
	public String getFirstName() {
		return firstName;
	}

	/*
	 * Takes name entered into the last name  field and stores it to be printed in the receipt at the end and in the text file
	 */

	public String getLastName() {
		return lastName;
	}

	/*
	 * Takes the first and last name and puts them together to be displayed together later in receipt and text file
	 */


	public String getFullName() {
		return getFirstName() + " " + getLastName();
	}

	/*
	 *Takes the gender entered to be displayed together later in receipt and text file
	 */
	public String getGender() {
		return gender;
	}

	/*
	 * Takes the status entered and puts them together to be displayed together later in receipt and text file
	 */

	public String getStatus() {
		return status;
	}

	/*
	 * Takes the location entered to be displayed later in receipt and text file
	 */

	public String getLocation() {
		return location;
	}


	/*
	 * Takes the contact number entered to be displayed together later in receipt and text file
	 */
	public String getContact() {
		return contact;
	}
}
