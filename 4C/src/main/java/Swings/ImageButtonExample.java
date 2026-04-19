/*4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass
is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by
implementing the event handling mechanism with addActionListener( ).*/

package Swings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonExample {

    JLabel l1;

    ImageButtonExample() {

        JFrame f = new JFrame("Image Button Example");

        // Label
        l1 = new JLabel();
        l1.setBounds(50, 50, 600, 50);
        l1.setFont(new Font("Arial", Font.BOLD, 20));

        // Load images (place images in project folder)
        ImageIcon clockIcon = new ImageIcon("C:\\Users\\anush\\Downloads\\clock.png");
        ImageIcon hourglassIcon = new ImageIcon("C:\\Users\\anush\\Downloads\\hourglass.png");

        // Buttons with images
        JButton b1 = new JButton(clockIcon);
        JButton b2 = new JButton(hourglassIcon);

        // Set button positions
        b1.setBounds(100, 150, 120, 120);
        b2.setBounds(300, 150, 120, 120);

        // Event handling
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Digital Clock is pressed");
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Hour Glass is pressed");
            }
        });

        // Add components
        f.add(b1);
        f.add(b2);
        f.add(l1);

        // Frame settings
        f.setSize(500, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageButtonExample();
    }
}