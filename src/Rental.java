import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Rental{ 

  private static final int WIDTH = 600;
  private static final int HEIGHT = 400;

//------------MAIN
  public static void main(String[] args) {

    JFrame frame = new RentalView();
    frame.setTitle("Car Rental");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WIDTH, HEIGHT);
    frame.setVisible(true);
    frame.setResizable(false);
   }
}
