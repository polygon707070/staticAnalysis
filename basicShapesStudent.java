//Import statements:

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


// This program displays simple graphics
public class basicShapesStudent extends JPanel //don't worry about what the "extends Jpanel" means
//make sure to include it, but we'll talk more about it later
    {
        //The method paintComponent gets called anytime we need to redraw things
        //e.g. something moves, or you resize the window. It takes a Graphics object.
        public void paintComponent(Graphics g) {
            super.paintComponent(g);  // Call JPanel's paintComponent method
                                        //  to paint the background
                                        //don't worry about the "super" notation for now
                                        //we'll get there
            g.setColor(Color.RED); //this is the drawing (pen) color. for other colors, see
            //https://docs.oracle.com/javase/7/docs/api/java/awt/Color.html

            //There are many things we can draw, as shown below

            // Draw a 150 (wide) by 45 (tall) rectangle with the upper-left
            // corner at x = 20, y = 40:
            g.drawRect(20, 40, 150, 45);

            //draw an oval that inscribes a rectangle with its upper left
            //corner at x=20, y = 40, with width 150 and height 45.
            g.drawOval(20, 40, 150, 45);

            g.setColor(Color.BLUE); // change the pen color

            //Draw an arc that traces out part of an oval whose parameters
            //(see above) are 20, 40, 150, 45.
            //Draw from angle 40 degrees to angle 40+170 degrees, where we measure
            //angles as in math class (0 is +x axis, angles go counterclockwise)
            g.drawArc(20, 44, 150, 45, 40, 170);

            // Draw a rectangle with parameters 175, 40, 150, 45
            //but make the corners rounded starting 40 pixels from the edge
            //horizontally and 15 vertically
            g.drawRoundRect(175, 40, 150, 45, 40, 15);

            //Draw a line from (20, 100) to (170, 130)
            g.drawLine(20, 100, 170, 130);
            //draw the text "Hello Graphics!" with its upper left corner
            // at x = 55, y = 65

            g.drawString("Hello, Graphics!", 55, 65);
            //Create a font with the SERIF style (other options are SANS_SERIF and MONOSPACED)
            //and that is both bold and italic (can do one, or if neither, use Font.PLAIN),
            //and with size 18 text.
            Font f1 = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 20);
            //set this font to be the font to use
            g.setFont(f1);
            g.drawString("Hello, Bold and Italics!", 180, 65);

            //draw a polygon with 3 points, whose x coordinates are 70, 20, and 120
            // and whose y coordinates are 250, 290, and 290
            g.drawPolygon(new int[]{70, 20, 120}, new int[]{250, 290, 290}, 3);

                g.setColor(Color.RED);
                //draw a set of straight lines from (70, 250) to (20, 290), then from
                //(20,290) to (120,290), to connect a total of 3 points.
                //Note this is the same as drawPoly, excpt the last line isn't drawn
                g.drawPolyline(new int[]{70, 20, 120}, new int[]{254, 294, 294}, 3);

                //Java also has filled in versions of Rect, Arc, RoundRect, and Polygon
                //where the shape is filled with a color. arguments are the same,
                //functions are the same but with "draw" replaced by "fill"


                BufferedImage image; //declare an image to be read in
                try { //you must put this call in a try-catch statement
                    String currentDirectory = System.getProperty("user.dir"); //get the current location, which is where you shoudl put your image
                    image = ImageIO.read(new File(currentDirectory + "/phoenix.jpg")); //read in the image
                    //draw the image, at x=200, y=100, 50 pixels wide and 80 pixels tall
                    //the "null" at the end must be there, but has no significance for us
                    g.drawImage(image, 200, 100, 50, 80, null);
                }
                catch(Exception e){}
        }

        public static void main(String[] args) {
            //Create the window you'll display on, and have the title bar at the top
            // say "Graphics Demo"
            JFrame window = new JFrame("Graphics Demo");
            // Set this window's location and size:
            // upper-left corner at 300, 300; width 600, height 400
            window.setBounds(300, 300, 600, 400);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stops the window when you close it

            //creates a basicShapes object
            basicShapesStudent panel = new basicShapesStudent();
            panel.setBackground(Color.WHITE);  // background color; the default color is light gray
            Container c = window.getContentPane(); //gets the Window
            c.add(panel); //adds the panel to the window

            window.setVisible(true); //display the window
        }
    }

