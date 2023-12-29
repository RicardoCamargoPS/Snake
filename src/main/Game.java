package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import UI.Menu;
import entidades.Snake;
import windown.Windown;

public class Game implements Runnable{

    public final static int WIDTH = 500;
    public final static int HEIGHT = 400;


    public static Menu menu;

    private Windown janela;
    private BufferedImage layer;
    private Thread thread;
    private boolean isRunning = false;

    private Snake sanke;
    private static String gameStatus = "menu";

    public Game(){
        janela = new Windown("Tetriz Game", WIDTH, HEIGHT);
        layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        menu = new Menu();
        sanke = new Snake();
    }

    public void tick(){

        if(gameStatus.equals("menu")){
            menu.tick();
        }

        sanke.tick();

    };
    ;

    public void render(){

        BufferStrategy bs = janela.getBufferStrategy();
        if(bs == null){
            janela.createBufferStrategy();
            bs = janela.getBufferStrategy();
        }

        Graphics g = layer.getGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        sanke.render(g);


        if(gameStatus.equals("menu")){
            menu.render(g);
        }

        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, WIDTH, HEIGHT, null);
        g.dispose();
        bs.show();
    
    }



    @Override
    public void run() {

        int fps = 60;
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

    public synchronized void stop(){
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
