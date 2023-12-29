package controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;

public class Controle implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
       
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			Game.setGameStatos("dalay");	
			if(Game.getGameStatos().equals("menu")){
				Game.menu.enter = true;
			}			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {			
			Game.setGameStatos("menu");
			Game.menu.paused = true;
		}		

		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(Game.getGameStatos().equals("menu")){
				Game.menu.up = true;
				System.out.println("cima precionado");
			}	
		}

		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(Game.getGameStatos().equals("menu")){
				Game.menu.down = true;	
				
				System.out.println("baixo precionado");
			}		
		}

		if(e.getKeyCode() == KeyEvent.VK_S) {	
			//Game.snake.setMuving(true);
			//Game.player.mudaDir(1);				
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {	
			//Game.player.setMuving(true);
			//Game.player.mudaDir(-1);		
				 
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			
		}

    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_S) {
			//Pong.player.setMuving(false);
			//Pong.player.mudaDir(0);			
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			//Pong.player.setMuving(false);
			//Pong.player.mudaDir(0);			 
		}	

    }

}
