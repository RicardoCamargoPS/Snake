package windown;

import javax.swing.JFrame;

import controle.Controle;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

public class Windown {

    private Canvas canvas;
    private JFrame janela;
    private Controle controle;


    public Windown(String title, int width, int height){
        canvas = new Canvas();
        janela = new JFrame();

        canvas.setSize(new Dimension(width, height));

        janela = new JFrame();
        janela.add(canvas);
       
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.addKeyListener(controle);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        
    }

    public BufferStrategy getBufferStrategy(){
        return canvas.getBufferStrategy();
    }

    public void createBufferStrategy(){
        canvas.createBufferStrategy(3);
    }

}
