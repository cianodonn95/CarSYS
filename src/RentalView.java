import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class RentalView extends JFrame {

    private Transaction aTrans = new Transaction(); //access class Transaction as global declaration.
    private Customer aCustomer = new Customer(); //access class Customer as global declaration
    private Car aCar = new Car(); //access class car as global declaration
    private WarningReserve openWarningReserve; //class to access warning window
    private WarningCustomer openWarningCustomer;
    private WarningCar openWarningCar;

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
    }
}

        