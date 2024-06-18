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

//don't worry about the extends and implements for now,
//just include them in the beginning
public class advancedAnimation extends JPanel
        implements ActionListener
{
    private int xPos, yPos;  // hold the coordinates of the ball
    private int xmov,ymov; //incrementers to determine the direction of x or y change (+/-1)
    private boolean isSecond = false; //boolean to determine if its the first or second
    // loop. false if first/third/fifth etc, true if 2nd 4th etc.
    public int diam = 10; //ball diameter

    // Called automatically after a repaint request
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g); // Paint
        if (isSecond) {
            g.setColor(Color.blue); //pick the ball color as blue on the even cycles
        }
        else{
            g.setColor(Color.RED); //pick the ball color as red on the odd cycles
        }
        g.fillOval(xPos, yPos, diam, diam); //draw the circle
    }

    // Called automatically when the timer "fires"
    public void actionPerformed(ActionEvent e)
    {
        if (yPos > (getHeight()- diam) || yPos < 0) //if we're on a top or bottom, reverse the y direction
            ymov*=-1;
        if (xPos > (getWidth()- diam) || xPos < 0) //if we're on a lwft or right edge, reverse the x direction
            xmov*=-1;
        if (xPos > (getWidth()- diam)) { //if we bounced off the right, change the ball color
                isSecond = !isSecond;
        }
        yPos += ymov;
        xPos += xmov;
        repaint(); //update the panel
    }

    public static void main(String[] args)
    {
        JFrame window = new JFrame("Action Demo");

        // Set this window's location and size:
        // upper-left corner at 300, 300; width 300, height 320
        window.setBounds(300, 300, 300, 320);

        //  Create panel, a Banner object, which is a kind of JPanel.
        // This is like
        advancedAnimation panel = new advancedAnimation();
        //Background color of panel
        panel.setBackground(Color.orange);  // the default color is light gray
        //find other colors here:
        //https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html

        // Add panel to window:
        Container c = window.getContentPane();
        c.add(panel);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        // Set the initial position of the ball:
        panel.xPos = panel.getWidth()-2*panel.diam; //on the far right
        panel.yPos = (panel.getHeight()-2*panel.diam) / 2; //halfway down
        panel.xmov = -1; //going left
        panel.ymov = 2; //goign down

        // Create a Timer object that fires every 30 milliseconds;
        // attach it to panel so that panel "listens to" and
        // processes the timer events; start the timer:
        Timer clock = new Timer(2, panel); //the smaller this number, the faster the ball moves!
        clock.start();

    }
}
