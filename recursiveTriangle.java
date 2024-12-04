//Written by Jackson Antonelli
import javax.swing.*;
import java.awt.*;

public class recursiveTriangle extends JPanel {
	//draws triangles
    public void draw(Graphics t, int x, int y, int side, int depth) {
        if (depth == 0) {
            int[] xPoints = {x, x + side / 2, x - side / 2};
            int[] yPoints = {y, y + (int) (Math.sqrt(3) / 2 * side), y + (int) (Math.sqrt(3) / 2 * side)};
            t.fillPolygon(xPoints, yPoints, 3);
        } else {
            int newSide = side / 2;
            draw(t, x, y, newSide, depth - 1);
            draw(t, x - newSide / 2, y + (int) (Math.sqrt(3) / 2 * newSide), newSide, depth - 1);
            draw(t, x + newSide / 2, y + (int) (Math.sqrt(3) / 2 * newSide), newSide, depth - 1);
        }
    }

    // this paints the canvas, setting the background white and the pixel black
    public void paintComponent(Graphics t) {
        super.paintComponent(t);
        setBackground(Color.WHITE);
        t.setColor(Color.BLACK);
        int sideLength = getWidth() / 2;
        draw(t, getWidth() / 2, 50, sideLength, 5);  
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Triangle"); //creates frame
        recursiveTriangle panel = new recursiveTriangle();
        frame.add(panel);
        frame.setSize(400, 300); //sets frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true); //allows user to see frame
    }
}