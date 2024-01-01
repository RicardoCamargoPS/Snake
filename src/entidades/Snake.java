package entidades;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class Snake {

    private final int DOT_SIZE = 10;
    private final int MAX_DOTS = 50;
    private final int px[] = new int[MAX_DOTS];
    private final int py[] = new int[MAX_DOTS];

    public boolean leftDirection = false;
    public boolean rightDirection = true;
    public boolean upDirection = false;
    public boolean downDirection = false;

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

        if (leftDirection) {
            px[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            px[0] += DOT_SIZE;
        }

        if (upDirection) {
            py[0] -= DOT_SIZE;
        }

        if (downDirection) {
            py[0] += DOT_SIZE;
        }
        checkCollision();
                
    }

    private void checkCollision() {

        for (int z = length; z > 0; z--) {

            if ((z > 4) && (px[0] == px[z]) && (py[0] == py[z])) {
                Game.isRunning = false;
            }
        }

        if (py[0] >= Game.WIDTH) {
            Game.isRunning = false;
        }

        if (py[0] < 0) {
            Game.isRunning = false;
        }

        if (px[0] >= Game.WIDTH) {
            Game.isRunning = false;
        }

        if (px[0] < 0) {
            Game.isRunning = false;
        }
        
        if (!Game.isRunning) {
            Game.stop();
        }        

        if ((px[0] == Game.apple.px ) && (py[0] == Game.apple.py)) {
    
            length++;
            Game.apple.locateApple();

        }

        if ((px[0] == Game.pear.px ) && (py[0] == Game.pear.py)) {
    
            length++;
            Game.pear.locatePear();

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
            g.fillRect(px[i], py[i], DOT_SIZE, DOT_SIZE);
        }

    }

}
