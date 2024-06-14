//necessary imports
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JPanel;
import java.util.Arrays;

public class secondClick extends JPanel implements MouseListener {
    final int r = 20;
    int[][] circles = new int[20][2]; //array to keep track of 20 circles, so they don't all dissapear
    int index = 0; //start filling out our array at index 0
    public secondClick() {
        addMouseListener(this); //always include this in the constructor!
    }

    public static void main(String[] args){
        //usual graphics setup
        JFrame window = new JFrame("Graphics Demo");
        window.setBounds(100, 100, 600, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secondClick b = new secondClick();
        b.setBackground(Color.WHITE);  // background color; the default color is light gray
        Container c = window.getContentPane(); //gets the Window
        c.add(b); //adds the panel to the window
        window.setVisible(true);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g); //usual
        for(int i = 0; i< circles.length; i++){ //cycle through all circles and display them
            if (i%2 == 0)
                g.setColor(Color.RED);
            else if(circles[i][0] < 300)
                g.setColor(Color.BLUE);
            else
                g.setColor(Color.MAGENTA);
            g.drawOval(circles[i][0]-r,circles[i][1]-r,2*r,2*r);
        }

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
        circles[index][0] = p.x; //set values to click location
        circles[index][1] = p.y;
        index = (index+1)%circles.length; //increase the index; loop back around if at the end
        repaint();//update the image
    }


}
