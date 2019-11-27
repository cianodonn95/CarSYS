import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class RentalView extends JFrame {

    private Transaction aTrans = new Transaction(); //access Transaction class global declaration.
    private Customer aCustomer = new Customer(); //access Customer as global declaration
    private Car aCar = new Car(); //access Car Class as global declaration
    private WarningReserve openWarningReserve; //Access WarningReserve Class as global declaration
    private WarningCustomer openWarningCustomer; //Access WarningCustomer as a global variable
    private WarningCar openWarningCar; //Access WarningCar class as a global variable

    Container pane = getContentPane();
    private JPanel mainP, reserveP, customerP, carP, finalP; //Pages for layout

    //-----------------Welcome
    private JLabel titleL, dateL; //Inside the mainP page
    private JButton mainNextB;
    private JComboBox cMCB, cDCB, cYCB;

    //-----------------Date Reservation
    private JLabel dayL, pickupDateL, returnDateL, birthDateL; //Inside the reserveP page
    private JComboBox pUMCB, pUDCB, pUYCB, rMCB, rDCB, rYCB,
            bMCB, bDCB, bYCB;
    private JLabel dateChecker, ageChecker;
    private JButton reserveNextB, reserveBackB;

    //-----------------Customer Info
    private JLabel customerL, firstNameL, lastNameL, locationL, contactL, genderL, ageL, statusL, showAgeL; //Inside the customerP page
    private JTextField firstNameTF, lastNameTF, locationTF, contactTF, genderTF, statusTF;
    private JLabel firstNameChecker, lastNameChecker, genderChecker, statusChecker, locationChecker, contactChecker;
    private JButton customerNextB, customerBackB;

    //-----------------Pick a Car
    private JLabel carL; //inside the carP page
    private JButton firstCarB, secondCarB, thirdCarB, forthCarB, carNextB, carBackB;
    private JTextArea carDetailsTA;

    //---------------------Receipt
    private JTextArea receiptA;

//======================================================================================================================================================

    //------------------Welcome Screen (mainP)
    public RentalView() {
        pane.setLayout(new CardLayout());
        mainP = new JPanel(null);
        mainP.setBackground(Color.WHITE);//Page Background
        dateL = new JLabel("Enter Today's Date "); //Enter Today's Date
        dateL.setFont(new Font("Serif", Font.BOLD, 23));
        dateL.setForeground(Color.BLUE);
        dateL.setBounds(195, 110, 300, 25);
        mainP.add(dateL);

        //---------------------Combo Box for current date
        Integer[] currentDateCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        cDCB = new JComboBox(currentDateCB);
        cDCB.setBounds(200, 160, 60, 25);
        mainP.add(cDCB);

        String[] currentMonthCB = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        cMCB = new JComboBox(currentMonthCB);
        cMCB.setBounds(260, 160, 60, 25);
        mainP.add(cMCB);

        Integer[] currentYearCB = {2019, 2020};
        cYCB = new JComboBox(currentYearCB);
        cYCB.setBounds(320, 160, 60, 25);
        mainP.add(cYCB);

        //------------------------Main Screen Next Button
        ImageIcon mainNextImage = new ImageIcon("images/next.gif");
        mainNextB = new JButton(mainNextImage);
        mainNextB.addActionListener(new mainNextButton());
        mainNextB.setBounds(460, 300, 100, 50);
        mainNextB.setActionCommand("NextToReserve");
        mainP.add(mainNextB);
        pane.add(mainP, "welcomeForm");

//==================================================================================================================================================================

        //---------------------------Second Page "reserve" (reserveP)
        //---------------------------LABELS for reservation date.
        reserveP = new JPanel(null);
        reserveP.setBackground(Color.WHITE);

        dayL = new JLabel("Reserve Rental Day(s):");
        dayL.setFont(new Font("Serif", Font.BOLD, 23));
        dayL.setForeground(Color.BLUE);
        dayL.setBounds(50, 1, 250, 100);
        reserveP.add(dayL); //adding to reservation details

        pickupDateL = new JLabel("Pick-up Date:");
        pickupDateL.setBounds(50, 40, 100, 100);
        reserveP.add(pickupDateL); //adding to reservation details

        returnDateL = new JLabel("Return Date:");
        returnDateL.setBounds(50, 80, 100, 100);
        reserveP.add(returnDateL); //adding to reservation details

        birthDateL = new JLabel("Date of Birth:");
        birthDateL.setBounds(60, 150, 100, 100);
        reserveP.add(birthDateL); //adding to reservation details

        //----------------------------CHECK BOX for pickup date, return date, birth date
        //----------------------------Pick up date
        Integer[] pickUpDateCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        pUDCB = new JComboBox(pickUpDateCB);
        pUDCB.setBounds(150, 80, 60, 25);
        reserveP.add(pUDCB);

        String[] pickUpMonthCB = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        pUMCB = new JComboBox(pickUpMonthCB);
        pUMCB.setBounds(215, 80, 60, 25);
        reserveP.add(pUMCB);

        Integer[] pickUpYearCB = {2019, 2020};
        pUYCB = new JComboBox(pickUpYearCB);
        pUYCB.setBounds(280, 80, 60, 25);
        reserveP.add(pUYCB);

        //------------------------------Return date section
        Integer[] returnDateCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        rDCB = new JComboBox(returnDateCB);
        rDCB.setBounds(150, 120, 60, 25);
        reserveP.add(rDCB);

        String[] returnMonthCB = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        rMCB = new JComboBox(returnMonthCB);
        rMCB.setBounds(215, 120, 60, 25);
        reserveP.add(rMCB);

        Integer[] returnYearCB = {2019, 2020};
        rYCB = new JComboBox(returnYearCB);
        rYCB.setBounds(280, 120, 60, 25);
        reserveP.add(rYCB);

        //------------------------------Date of Birth Section
        Integer[] birthDateCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        bDCB = new JComboBox(birthDateCB);
        bDCB.setBounds(150, 190, 60, 25);
        reserveP.add(bDCB);

        String[] birthMonthCB = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        bMCB = new JComboBox(birthMonthCB);
        bMCB.setBounds(215, 190, 60, 25);
        reserveP.add(bMCB);

        Integer[] birthYearCB = {1944, 1945, 1946, 1947, 1948, 1949 , 1950,
                1951, 1952, 1953, 1954, 1955, 1956, 1957, 1958, 1959, 1960,
                1961, 1962, 1963, 1964, 1965, 1966, 1967, 1968, 1969, 1970,
                1971, 1972, 1973, 1974, 1975, 1976, 1977, 1978, 1979, 1980,
                1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988, 1989, 1990,
                1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000,
                2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010,
                2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019};
        bYCB = new JComboBox(birthYearCB);
        bYCB.setBounds(280, 190, 60, 25);
        reserveP.add(bYCB);

        //---------------------------------------------checker for date
        dateChecker = new JLabel("");
        dateChecker.setFont(new Font("Serif", Font.BOLD, 15));
        dateChecker.setBounds(350, 83, 100, 100);
        reserveP.add(dateChecker);

        ageChecker = new JLabel("");
        ageChecker.setFont(new Font("Serif", Font.BOLD, 15));
        ageChecker.setBounds(350, 153, 100, 100);
        reserveP.add(ageChecker);

        //--------------------------------------BUTTONS
        //--------------------------------------Go forward to customer section
        ImageIcon dateNextImage = new ImageIcon("images/next.GIF");
        reserveNextB = new JButton(dateNextImage);
        reserveNextB.addActionListener(new reserveNextButton());
        reserveNextB.setBounds(460, 300, 100, 50);
        reserveNextB.setActionCommand("NextToCustomer");
        reserveP.add(reserveNextB);

        //------------------------------------Go back welcome section
        ImageIcon dateBackImage = new ImageIcon("images/back.GIF");
        reserveBackB = new JButton(dateBackImage);
        reserveBackB.setBounds(330, 300, 100, 50);
        reserveBackB.addActionListener(new reserveBackButton());
        reserveBackB.setActionCommand("BackToWelcome");
        reserveP.add(reserveBackB);
        pane.add(reserveP, "reserveForm");

//===========================================================================================================================================

        //----------Third Page Customer (customerP)
        //----------Customer Details
        customerP = new JPanel(null);
        customerP.setBackground(Color.WHITE);
        customerL = new JLabel("Customer's Data");
        customerL.setFont(new Font("Serif", Font.BOLD, 23));
        customerL.setForeground(Color.BLUE);
        customerL.setBounds(50, 10, 250, 30);
        customerP.add(customerL);

        firstNameL = new JLabel("First Name:");
        firstNameL.setBounds(50, 60, 250, 30);
        customerP.add(firstNameL);

        lastNameL = new JLabel("Last Name:");
        lastNameL.setBounds(50, 95, 250, 30);
        customerP.add(lastNameL);

        genderL = new JLabel("Gender:");
        genderL.setBounds(50, 130, 250, 30);
        customerP.add(genderL);

        statusL = new JLabel("Status:");
        statusL.setBounds(50, 165, 250, 30);
        customerP.add(statusL);

        locationL = new JLabel("Location:");
        locationL.setBounds(50, 200, 250, 30);
        customerP.add(locationL);

        contactL = new JLabel("Contact:");
        contactL.setBounds(50, 235, 250, 30);
        customerP.add(contactL);

        ageL = new JLabel("Age:");
        ageL.setBounds(50, 270, 250, 30);
        customerP.add(ageL);

        //----Takes and Displays age from the first page
        showAgeL = new JLabel("");
        showAgeL.setBounds(145, 270, 60, 30);
        customerP.add(showAgeL);

        //----TEXT FIELD for customer details and get data from keyboard section
        firstNameTF = new JTextField("Type First Name Here");
        firstNameTF.setBounds(150, 60, 250, 30);
        customerP.add(firstNameTF);

        lastNameTF = new JTextField("Type Last Name Here");

        lastNameTF.setBounds(150, 95, 250, 30);
        customerP.add(lastNameTF);

        genderTF = new JTextField("M/F");
        genderTF.setBounds(150, 130, 50, 30);
        customerP.add(genderTF);

        statusTF = new JTextField("S/Ma");
        statusTF.setBounds(150, 165, 50, 30);
        customerP.add(statusTF);

        locationTF = new JTextField("Type Complete Address Here");
        locationTF.setBounds(150, 200, 250, 30);
        customerP.add(locationTF);

        contactTF = new JTextField("Type Contact Number Here");
        contactTF.setBounds(150, 235, 250, 30);
        customerP.add(contactTF);

        //-----------------Customer Checker
        firstNameChecker = new JLabel("");
        firstNameChecker.setBounds(410, 25, 100, 100);
        customerP.add(firstNameChecker);

        lastNameChecker = new JLabel("");
        lastNameChecker.setBounds(410, 60, 100, 100);
        customerP.add(lastNameChecker);

        genderChecker = new JLabel("");
        genderChecker.setBounds(210, 95, 100, 100);
        customerP.add(genderChecker);

        statusChecker = new JLabel("");
        statusChecker.setBounds(210, 130, 100, 100);
        customerP.add(statusChecker);

        locationChecker = new JLabel("");
        locationChecker.setBounds(410, 165, 100, 100);
        customerP.add(locationChecker);

        contactChecker = new JLabel("");
        contactChecker.setBounds(410, 200, 100, 100);
        customerP.add(contactChecker);

        //------------------BUTTONS for customer
        //------------------To go pick a car section
        ImageIcon customerNextImage = new ImageIcon("images/next.GIF");
        customerNextB = new JButton(customerNextImage);
        customerNextB.setBounds(460, 300, 100, 50);
        customerNextB.setRolloverEnabled(true);
        customerNextB.setRolloverIcon(customerNextImage);
        customerNextB.setPressedIcon(customerNextImage);
        customerNextB.addActionListener(new customerNextButton());
        customerNextB.setActionCommand("NextToPickCar");
        customerP.add(customerNextB);

        //----------------to go back reserve section
        ImageIcon customerBackImage = new ImageIcon("images/back.GIF");
        customerBackB = new JButton(customerBackImage);
        customerBackB.setBounds(330, 300, 100, 50);
        customerBackB.setRolloverEnabled(true);
        customerBackB.setRolloverIcon(customerBackImage);
        customerBackB.setPressedIcon(customerBackImage);
        customerBackB.addActionListener(new customerBackButton());
        customerBackB.setActionCommand("backToReserve");
        customerP.add(customerBackB);
        pane.add(customerP, "customerForm");

//================================================================================================================================================

        //--------------Forth Page "pick a car" (carP)
        //--------------LABELS for pick a car
        carP = new JPanel(null);
        carL = new JLabel("Car Detail's");
        carL.setForeground(Color.BLUE);
        carL.setBounds(435, 4, 140, 30);
        carP.add(carL);

        //-----------------Car Buttons
        //-----------------First Car
        ImageIcon firstCarImage = new ImageIcon("images/VW_Golf.jpg");
        firstCarB = new JButton(firstCarImage);
        firstCarB.addActionListener(new firstCarButton());
        firstCarB.setRolloverEnabled(true);
        firstCarB.setRolloverIcon(firstCarImage);
        firstCarB.setPressedIcon(firstCarImage);
        firstCarB.setBounds(10, 10, 190, 130);
        carP.add(firstCarB);

        //---------------------------------Second Car
        ImageIcon secondCarImage = new ImageIcon("images/Audi_A4.jpg");
        secondCarB = new JButton(secondCarImage);
        secondCarB.addActionListener(new secondCarButton());
        secondCarB.setRolloverEnabled(true);
        secondCarB.setRolloverIcon(secondCarImage);
        secondCarB.setPressedIcon(secondCarImage);
        secondCarB.setBounds(210, 10, 190, 130);
        carP.add(secondCarB);

        //---------------------------------------Third Car
        ImageIcon thirdCarImage = new ImageIcon("images/Citroen_C5.jpeg");
        thirdCarB = new JButton(thirdCarImage);
        thirdCarB.addActionListener(new thirdCarButton());
        thirdCarB.setRolloverEnabled(true);
        thirdCarB.setRolloverIcon(thirdCarImage);
        thirdCarB.setPressedIcon(thirdCarImage);
        thirdCarB.setBounds(10, 150, 190, 130);
        carP.add(thirdCarB);

        //------------------------------------------Forth Car
        ImageIcon forthCarImage = new ImageIcon("images/Bugatti_Veyron.jpg");
        forthCarB = new JButton(forthCarImage);
        forthCarB.addActionListener(new forthCarButton());
        forthCarB.setRolloverEnabled(true);
        forthCarB.setRolloverIcon(forthCarImage);
        forthCarB.setPressedIcon(forthCarImage);
        forthCarB.setBounds(210, 150, 190, 130);
        carP.add(forthCarB);

        //-----------Go to Receipt Page
        ImageIcon carNextImage = new ImageIcon("images/submit.GIF");
        carNextB = new JButton(carNextImage);
        carNextB.setBounds(460, 300, 100, 50);
        carNextB.addActionListener(new finalStepButton());
        carNextB.setRolloverEnabled(true);
        carNextB.setRolloverIcon(carNextImage);
        carNextB.setPressedIcon(carNextImage);
        carP.add(carNextB);

        //------------to go back customer section
        ImageIcon carBackImage = new ImageIcon("images/back.GIF");
        carBackB = new JButton(carBackImage);
        carBackB.addActionListener(new carBackButton());
        carBackB.setBounds(330, 300, 100, 50);
        carBackB.setRolloverEnabled(true);
        carBackB.setRolloverIcon(carBackImage);
        carBackB.setPressedIcon(carBackImage);
        carBackB.setActionCommand("BackToCustomer");
        carP.add(carBackB);

        //-----------Description to the Right
        carDetailsTA = new JTextArea(6, 25);
        carDetailsTA.setAutoscrolls(true);
        carDetailsTA.setEditable(false);
        carDetailsTA.setBounds(420, 40, 150, 240);
        carP.add(carDetailsTA);
        pane.add(carP, "pickCarForm");

//============================================================================================================================================

        //------------Last Page "Receipt" (finalP)
        finalP = new JPanel(null);
        receiptA = new JTextArea(2000, 2000);
        receiptA.setFont(new Font("Serif", Font.PLAIN, 15));
        receiptA.setEditable(false);
        receiptA.setBounds(80, 30, 400, 800); //
        finalP.add(receiptA);
        pane.add(finalP, "receipt");
    }

//============================================================================================================================================

    //--------------CONTROLLERS
    //---------------Main (go to reserveForm)
    private class mainNextButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            CardLayout cL = (CardLayout) pane.getLayout();

            if (event.getActionCommand().equals("NextToReserve")) {
                cL.show(pane, "reserveForm");
            }
        }
    }

    //-------------------Reservation
    //-------------------Go to customerForm
    //-------------------Including the validation if requirements are met for the Next Page
    private class reserveNextButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            CardLayout cL = (CardLayout) pane.getLayout();

            if (event.getActionCommand().equals("NextToCustomer")) {

                String currentMonth, pickUpMonth, returnMonth, birthMonth;
                int currentDate, currentYear, pickUpDate, pickUpYear, returnDate,
                        returnYear, birthDate, birthYear;

                currentMonth = (String) cMCB.getSelectedItem();
                currentDate = (int) cDCB.getSelectedItem();
                currentYear = (int) cYCB.getSelectedItem();

                pickUpMonth = (String) pUMCB.getSelectedItem();
                pickUpDate = (int) pUDCB.getSelectedItem();
                pickUpYear = (int) pUYCB.getSelectedItem();

                returnMonth = (String) rMCB.getSelectedItem();
                returnDate = (int) rDCB.getSelectedItem();
                returnYear = (int) rYCB.getSelectedItem();

                birthMonth = (String) bMCB.getSelectedItem();
                birthDate = (int) bDCB.getSelectedItem();
                birthYear = (int) bYCB.getSelectedItem(); //saving dates for transaction, validation for date and age, should prompt to WarningReserve

                aTrans.setTransaction(aCustomer, aCar, currentMonth, currentDate, currentYear, pickUpMonth,
                        pickUpDate, pickUpYear, returnMonth, returnDate, returnYear,
                        birthMonth, birthDate, birthYear);
                showAgeL.setText(aTrans.toStringAge()); //Show age as a string from Transaction Class

                if (!aTrans.toStringDateChecker().equals("TRUE")) { //Validates Pick up and Return
                    dateChecker.setForeground(Color.RED);
                    dateChecker.setText("Invalid!");
                } else {
                    dateChecker.setForeground(Color.GREEN);
                    dateChecker.setText("Valid");
                }

                // Age Validation
                if (!aTrans.toStringAgeChecker().equals("TRUE")) {
                    ageChecker.setForeground(Color.RED);
                    ageChecker.setText("Invalid!");
                } else {
                    ageChecker.setForeground(Color.GREEN);
                    ageChecker.setText("Valid");
                }

                //Checker to proceed next Page - If Validated, Proceed
                if (aTrans.toStringDateChecker().equals("TRUE") && aTrans.toStringAgeChecker().equals("TRUE")) {
                    cL.show(pane, "customerForm");
                }

                //Pop up window for warning to customer
                else {
                    if (openWarningReserve == null) {
                        openWarningReserve = new WarningReserve();
                        ImageIcon warningReserveImage = new ImageIcon("images/warning_top_icon.GIF");
                        openWarningReserve.setIconImage(warningReserveImage.getImage());
                        openWarningReserve.setTitle("WARNING");
                        openWarningReserve.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        openWarningReserve.setSize(300, 150);
                        openWarningReserve.setVisible(true);
                        openWarningReserve.setResizable(false);
                    } else {
                        openWarningReserve.setVisible(!openWarningReserve.isVisible());
                    }
                }
            }
        }
    }

    //--------------Go back to welcomeForm
    private class reserveBackButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            CardLayout cL = (CardLayout) pane.getLayout();

            if (event.getActionCommand().equals("BackToWelcome")) {
                cL.show(pane, "welcomeForm");
            }
        }
    }

    //---------Go to pickCarForm
    //---------Including the validation if requirements are met for Next Page
    private class customerNextButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            CardLayout cL = (CardLayout) pane.getLayout();


            if (event.getActionCommand().equals("NextToPickCar")) {

                String firstName, lastName, gender, status, location, contact;

                firstName = firstNameTF.getText();
                lastName = lastNameTF.getText();
                gender = genderTF.getText();
                status = statusTF.getText();
                location = locationTF.getText();
                contact = contactTF.getText();

                aCustomer.setCustomer(firstName, lastName, gender, status, location, contact);

                // Info Validator (No Blanks only)
                if (aCustomer.getFirstName().equals("Type First Name Here")) {
                    firstNameChecker.setForeground(Color.RED);
                    firstNameChecker.setText("Invalid!");
                } else {
                    firstNameChecker.setForeground(Color.GREEN);
                    firstNameChecker.setText("Valid");//Validates First Name  -If Valid, Proceed
                }

                if (aCustomer.getLastName().equals("Type Last Name Here")) {
                    lastNameChecker.setForeground(Color.RED);
                    lastNameChecker.setText("Invalid!");
                } else {
                    lastNameChecker.setForeground(Color.GREEN);
                    lastNameChecker.setText("Valid");//Validate Last Name -If Valid, Proceed
                }

                if (aCustomer.getGender().equals("M/F")) {
                    genderChecker.setForeground(Color.RED);
                    genderChecker.setText("Invalid!");
                } else {
                    genderChecker.setForeground(Color.GREEN);
                    genderChecker.setText("Valid");//Validate Gender -If Valid, Proceed
                }

                if (aCustomer.getStatus().equals("S/Ma")) {
                    statusChecker.setForeground(Color.RED);
                    statusChecker.setText("Invalid!");
                } else {
                    statusChecker.setForeground(Color.GREEN);
                    statusChecker.setText("Valid");//Validate Status -If Valid, Proceed
                }

                if (aCustomer.getLocation().equals("Type Complete Address Here")) {
                    locationChecker.setForeground(Color.RED);
                    locationChecker.setText("Invalid!");
                } else {
                    locationChecker.setForeground(Color.GREEN);
                    locationChecker.setText("Valid");//Validate Location -If Valid, Proceed
                }

                if (aCustomer.getContact().equals("Type Contact Number Here")) {
                    contactChecker.setForeground(Color.RED);
                    contactChecker.setText("Invalid!");//
                } else {
                    contactChecker.setForeground(Color.GREEN);
                    contactChecker.setText("Valid");//Validate Contact -If yes, Proceed
                }

                if (!aCustomer.getFirstName().equals("Type First Name Here") && !aCustomer.getLastName().equals("Type Last Name Here") && !aCustomer.getGender().equals("M/F") && !aCustomer.getStatus().equals("S/Ma") && !aCustomer.getLocation().equals("Type Complete Address Here") && !aCustomer.getContact().equals("Type Contact Number Here")) {
                    firstNameTF.setText("Type First Name Here"); //if all of the above is valid , proceed to Car Form
                    lastNameTF.setText("Type Last Name Here");
                    genderTF.setText("M/F");
                    statusTF.setText("S/Ma");
                    locationTF.setText("Type Complete Address Here");
                    contactTF.setText("Type Contact Number Here");
                    cL.show(pane, "pickCarForm");
                }

                //------If invalid, pop out window for warning
                else {
                    if (openWarningCustomer == null) {
                        openWarningCustomer = new WarningCustomer();
                        ImageIcon warningCustomerImage = new ImageIcon("images/warning_top_icon.GIF");
                        openWarningCustomer.setIconImage(warningCustomerImage.getImage());
                        openWarningCustomer.setTitle("Invalid");
                        openWarningCustomer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        openWarningCustomer.setSize(300, 150);
                        openWarningCustomer.setVisible(true);
                        openWarningCustomer.setResizable(false);
                    } else {
                        openWarningCustomer.setVisible(!openWarningCustomer.isVisible());
                    }
                }
            }
        }
    }

    //------Go back to the reserveForm
    private class customerBackButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            CardLayout cL = (CardLayout) pane.getLayout();

            if (event.getActionCommand().equals("backToReserve")) {
                cL.show(pane, "reserveForm");
            }
        }
    }

    private class firstCarButton implements ActionListener { //When its clicked, show the details of the Golf
        public void actionPerformed(ActionEvent event) {

            carDetailsTA.setText("");
            carDetailsTA.setText("Brand: VW Golf\nRegistration: 10-KY-0001\nType: Hatchback\nYear: 2010\nColor: Silver\nRental Price: €60.00\n\n\n");
            carNextB.setActionCommand("Car1");
        }
    }

    private class secondCarButton implements ActionListener { //When its clicked, show the details of the Audi
        public void actionPerformed(ActionEvent event) {

            carDetailsTA.setText("");
            carDetailsTA.setText("Brand: Audi A4\nRegistration: 131-TS-1234\nType: Saloon\nYear: 2013\nColor: Blue\nRental Price: €70.00\n\n\n");
            carNextB.setActionCommand("Car2");
        }
    }

    private class thirdCarButton implements ActionListener { //When its clicked, show the details of the Citroen
        public void actionPerformed(ActionEvent event) {

            carDetailsTA.setText("");
            carDetailsTA.setText("Brand: Citroen C5\nRegistration: 12-KY-4321\nType: Saloon\nYear: 2012\nColor: Purple\nRental Price: €80.00\n\n\n");
            carNextB.setActionCommand("Car3");
        }
    }

    private class forthCarButton implements ActionListener { //When its clicked, show the details of the Bugatti
        public void actionPerformed(ActionEvent event) {

            carDetailsTA.setText("");
            carDetailsTA.setText("Brand: Bugatti Veyron\nRegistration: 191-TS-9876\nType: SuperCar\nYear: 2019\nColor: Orange\nRental Price: €90.00\n\n\n");
            carNextB.setActionCommand("Car4");
        }
    }

    private class finalStepButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            CardLayout cL = (CardLayout) pane.getLayout();

            //Passing the details to car details class and final transactions.
            if (event.getActionCommand().equals("Car1")) {                  //Pass Golf details to car details as a string

                String carType = "VW Golf", carModel = "2010";
                double carPrice = 60.00;
                aCar.setCar(carType, carModel, carPrice);

                //To save in file Transaction_Inventory
                try {
                    aTrans.saveToFile();
                } catch (IOException e) {}

                receiptA.setText(aTrans.toStringReceipt());
                cL.show(pane, "receipt");
            } else if (event.getActionCommand().equals("Car2")) {           //Pass the details of the Audi A4 to car details as a string

                String carType = "Audi A4", carModel = "2013";
                double carPrice = 70.00;
                aCar.setCar(carType, carModel, carPrice);

                try { //to save in file Transaction_Inventory
                    aTrans.saveToFile();
                } catch (IOException e) {}

                receiptA.setText(aTrans.toStringReceipt());
                cL.show(pane, "receipt");
            } else if (event.getActionCommand().equals("Car3")) {            //Pass Citroen details to car details as a string

                String carType = "Citroen C5", carModel = "2012";
                double carPrice = 80.00;
                aCar.setCar(carType, carModel, carPrice);

                //To save in file Transaction_Inventory
                try {
                    aTrans.saveToFile();
                } catch (IOException e) {}

                receiptA.setText(aTrans.toStringReceipt());
                cL.show(pane, "receipt");
            } else if (event.getActionCommand().equals("Car4")) {            //Passes the Bugatti Veyron to car details as a string

                String carType = "Bugatti Veyron", carModel = "2019";
                double carPrice = 90.00;
                aCar.setCar(carType, carModel, carPrice);

                //To save in file Transaction_Inventory
                try {
                    aTrans.saveToFile();
                } catch (IOException e) {}

                receiptA.setText(aTrans.toStringReceipt());
                cL.show(pane, "receipt");
            }

            //If a car isn't picked, the warning label should appear
            else {
                if (openWarningCar == null) {
                    openWarningCar = new WarningCar();
                    ImageIcon warningCarImage = new ImageIcon("images/warning_top_icon.GIF");
                    openWarningCar.setIconImage(warningCarImage.getImage());
                    openWarningCar.setTitle("Select A Car");
                    openWarningCar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    openWarningCar.setSize(300, 150);
                    openWarningCar.setVisible(true);
                    openWarningCar.setResizable(false);
                } else {
                    openWarningCar.setVisible(!openWarningCar.isVisible());
                }
            }
        }
    }

    //Go back to customer form when it is clicked and performed
    private class carBackButton implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            CardLayout cL = (CardLayout) pane.getLayout();

            if (event.getActionCommand().equals("BackToCustomer")) {
                cL.show(pane, "customerForm");
            }
        }
    }
}
