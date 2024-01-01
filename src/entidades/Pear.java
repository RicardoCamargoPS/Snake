package entidades;

import java.awt.Graphics;
import java.awt.Color;

public class Pear {

    public static int px;
    public static int py;
    private int diameter = 10;

    private final int DOT_SIZE = 10;
    private final static int RAND_POS = 30;

    public void render(Graphics g){

        g.setColor(Color.BLUE);
        g.fillOval(px, py, diameter, diameter);

    }

    public void locatePear() {

        int r = (int) (Math.random() * RAND_POS);
        px = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        py = ((r * DOT_SIZE));
    }

}
