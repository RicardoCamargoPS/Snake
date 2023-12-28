package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Snake {

    private final int DOT_SIZE = 10;
    private final int MAX_DOTS = 50;
    private final int px[] = new int[MAX_DOTS];
    private final int py[] = new int[MAX_DOTS];

    private int length = 3;


    public Snake(){

        for(int i = 0; i < length; i++){
            px[i] = 100 - i * DOT_SIZE;
            py[i] = 100;
        }

    }

    public void tick(){

        for(int i = length; i > 0; i--){
            px[i] = px[i - 1];
            py[i] = py[i - 1];
        }

    }

    public void render(Graphics g){

        for(int i = 0; i < length; i++){
            if(i == 0){
                g.setColor(Color.white);
            }
            else{
                g.setColor(Color.green);
            }
            g.drawRect(px[i], py[i], DOT_SIZE, DOT_SIZE);
        }

    }

}
