//necessary imports
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JPanel;

public class firstClick extends JPanel implements MouseListener {
    //global variables for drawing a circle
    int x;
    int y;
    int r = 20; //set default radius
    public firstClick() { //constructor necessary
        addMouseListener(this); //always include this in the constructor!
    }

    public static void main(String[] args){
        //usual graphics setup
        JFrame window = new JFrame("Graphics Demo");
        window.setBounds(100, 100, 600, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        firstClick b = new firstClick();
        b.setBackground(Color.WHITE);  // background color; the default color is light gray
        Container c = window.getContentPane(); //gets the Window
        c.add(b); //adds the panel to the window
        window.setVisible(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g); //usual
        g.drawOval(x-r,y-r,2*r,2*r); //draw a circle at the click location
        //remember the first 2 arguments are the top left corner, but we want our click to be the center!
        //the last 2 paramters are the width and height--these are the diameter!

    }

    //These 4 are necessary for mouseListener, but you don't need to do anything with them
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }

    //Called whenever mouse is clicked
    public void mouseClicked(MouseEvent e) {
        Point p = e.getPoint(); //get the coordinates of the point where the mouse was clicked
         y = p.y; //set our global variables
         x = p.x;
        repaint(); //update the image
    }
}
