/**
 * This program displays a message that moves horizontally
 * across the window.
 */

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BasicAnimation extends JPanel
        implements ActionListener
{
    private int xPos, yPos;  // hold the coordinates of the message

    // Called automatically after a repaint request
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // Paint the background
        g.setColor(Color.RED); //pick the text color (see below)
        g.drawString("Hello, Action!", xPos, yPos); //draw this phrase
    }

    // Called automatically when the timer "fires"
    public void actionPerformed(ActionEvent e)
    {
        // Adjust the horizontal position of the message by shifting it left:
        xPos-=40;  // subtract 1 from the position
        if (xPos < -100){
            xPos = getWidth(); //loop back around if goes too far off screen to right
        }

        repaint(); //update the panel
    }

    public static void main(String[] args)
    {
        JFrame window = new JFrame("Action Demo");

        // Set this window's location and size:
        // upper-left corner at 300, 300; width 300, height 100
        window.setBounds(300, 300, 300, 300);

        //  Create panel, a Banner object, which is a kind of JPanel.
        // This is like
        BasicAnimation panel = new BasicAnimation();
        //Background color of panel
        panel.setBackground(Color.orange);  // the default color is light gray
        //find other colors here:
        //https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html

        // Add panel to window:
        Container c = window.getContentPane();
        c.add(panel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        // Set the initial position of the message:
        panel.xPos = panel.getWidth(); //on the far right
        panel.yPos = panel.getHeight() / 2; //halfway down

        // Create a Timer object that fires every 30 milliseconds;
        // attach it to panel so that panel "listens to" and
        // processes the timer events; start the timer:
        Timer clock1 = new Timer(1000, panel);
        Timer clock2 = new Timer(600, panel);
        clock1.start();
        clock2.start();
    }
}
