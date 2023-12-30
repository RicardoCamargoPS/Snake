package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import UI.Menu;
import entidades.Apple;
import entidades.Snake;
import windown.Windown;

public class Game implements Runnable{

    public final static int WIDTH = 500;
    public final static int HEIGHT = 400;

    public static Menu menu;
    public static Apple apple;

    private Windown janela;
    private BufferedImage layer;
    public static Thread thread;
    public static boolean isRunning = false;

    public static Snake snake;
    public static String gameStatus = "MENU";

    public Game(){
        
        janela = new Windown("Snake Game", WIDTH, HEIGHT);
        layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        menu = new Menu();
        snake = new Snake();
        apple = new Apple();
        apple.locateApple();

    }

    public void tick(){         
        
        if(gameStatus.equals("NORMAL")){            
            snake.tick();        
            
        }

        if(gameStatus.equals("MENU")){
           menu.tick();
        }
    }


    public void render(){

        BufferStrategy bs = janela.getBufferStrategy();
        if(bs == null){
            janela.createBufferStrategy();
            bs = janela.getBufferStrategy();
        }

        Graphics g = layer.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        if(gameStatus.equals("NORMAL")){
            snake.render(g);          
            apple.render(g);

        }

        if(gameStatus.equals("MENU")){
            menu.render(g);
        }
        
        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, WIDTH, HEIGHT, null);
        g.dispose();
        bs.show();
    
    }

    


    @Override
    public void run() {

        int fps = 10;
        double timerPertick = 1000000000 / fps;
        double deltaTime = 0;

        long nowTime;
        long lastTime = System.nanoTime();

        while(isRunning){
            
            nowTime = System.nanoTime();
            deltaTime +=(nowTime - lastTime) / timerPertick;
            lastTime = nowTime;           

            if(deltaTime >= 1){          

                tick();
                render();                
                deltaTime = 0;

            }
        }

        stop();        
    }

    public synchronized void start(){
        if(thread != null) return;
        else {
            thread = new Thread(this);
            isRunning = true;
        }
        thread.start();
        isRunning = true;

    }

    public synchronized static void stop(){
        if(thread == null) return;
        isRunning = false;

        try {
            thread.join();
        } catch (InterruptedException ie) {            
            ie.printStackTrace();
        };
    }

    public static void setGameStatos(String status){
        gameStatus = status;
    }

    public static String getGameStatos(){
        return gameStatus;
    }

}
