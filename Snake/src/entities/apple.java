package entities;

import java.awt.Color;
import java.awt.Graphics;

public class apple {

    private int px, py;
    private int diameter = 4;

    private final int POS_IN = 30;
    private final int DOT_SIZE = 10;

    public apple(){

    }

    public void tick(){

        int r  = (int) (Math.random() * POS_IN);
        px = r * DOT_SIZE;

        r  = (int) (Math.random() * POS_IN);
        py = r * DOT_SIZE;

    }

    public void render(Graphics g){

        g.setColor(Color.red);
        g.fillOval(px, py, diameter, diameter);

    }

}
