import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
import java.security.Key;
import javax.swing.JPanel;
    public class KeyPress extends JPanel implements KeyListener {
        static int x;
        static int y;
        int r = 20;
        public KeyPress() { //constructor necessary
            addKeyListener(this); //must put this
            setFocusable(true); //and this!
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g); //usual
            g.drawOval(x,y,2*r,2*r); //draw a circle at the click location
            //the last 2 paramters are the width and height--these are the diameter!
        }

//called when a key is typed. Note this only works for keys that display something;
        //Keys like Shift or left arrow never call keyTyped
        public void keyTyped(KeyEvent e) {
        }

        //called when a key is pressed. If the key is held down, this will be called repeatedly.
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode(); //get the key value of they key that was pressed
//see https://docs.oracle.com/javase/8/docs/api/java/awt/event/KeyEvent.html for all keycodes
            if (key == KeyEvent.VK_LEFT|| key == KeyEvent.VK_QUOTE) { //note that you can use capital letters
                //or numbers directly--but only in single quotes (this makes them a character)
                x+= -10;
            }

            if (key == KeyEvent.VK_RIGHT || key == '2') {
                x+= 10;
            }

            if (key == KeyEvent.VK_UP || key == 'W') {
                y+= -10;
            }

            if (key == KeyEvent.VK_DOWN|| key == 'S') {
                y+= 10;
            }
            repaint();
        }

        //called when a key is released. Use this if you want to user to have to press the
        //key anew every time
        public void keyReleased(KeyEvent e) {
            }

            public static void main(String[] args){
            //usual graphics setup
        JFrame window = new JFrame("Graphics Demo");
        window.setBounds(100, 100, 600, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        KeyPress b = new KeyPress();
        b.setBackground(Color.WHITE);  // background color; the default color is light gray
        Container c = window.getContentPane(); //gets the Window
        c.add(b); //adds the panel to the window
        window.setVisible(true);
        //circle initialization
        x = 400;
        y = 400;

    }
}
