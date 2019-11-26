import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WarningReserve extends JFrame{

    private Transaction aTrans = new Transaction(); //access my class Transaction as global declaration

    WarningReserve(){

        Container pane = getContentPane();
        JPanel warningP = new JPanel(null);
        warningP.setBackground(Color.WHITE);

        ImageIcon warningImage = new ImageIcon("warning_icon.GIF");
        JLabel iconL = new JLabel(warningImage);
        iconL.setBounds(20, 35, 50, 50);
        warningP.add(iconL);

        JLabel textL = new JLabel("");
        textL.setText("Invalid");
        textL.setFont(new Font("Serif", Font.BOLD, 15));
        textL.setForeground(Color.RED);
        textL.setBounds(80, 48, 100, 20);
        warningP.add(textL);
        pane.add(warningP);
    }
}