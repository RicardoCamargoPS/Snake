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
			if(Game.gameStatus == "MENU") {
				Game.menu.enter = true;
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {			
			Game.gameStatus = "MENU";
			Game.menu.pause = true;
		}		

		if(e.getKeyCode() == KeyEvent.VK_UP) {
			System.out.println("tecla up precionada");
			if(Game.gameStatus == "MENU") {
				Game.menu.up = true;
			}
		}

		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			System.out.println("tecla down precionada");
			if(Game.gameStatus == "MENU") {
				Game.menu.down = true;
			}
		}

		if(e.getKeyCode() == KeyEvent.VK_W && (Game.snake.downDirection == false)) {			
			Game.snake.upDirection = true;
			Game.snake.leftDirection = false;
			Game.snake.rightDirection = false;			
		}

		if(e.getKeyCode() == KeyEvent.VK_S && (Game.snake.upDirection == false)) {
			Game.snake.downDirection = true;			
			Game.snake.leftDirection = false;
			Game.snake.rightDirection = false;							 
		}

		if(e.getKeyCode() == KeyEvent.VK_D && (Game.snake.leftDirection == false)) {	
			Game.snake.rightDirection = true;
			Game.snake.downDirection = false;	
			Game.snake.upDirection = false;			
			
		}
		if(e.getKeyCode() == KeyEvent.VK_A && (Game.snake.rightDirection == false)) {			
			Game.snake.leftDirection = true;
			Game.snake.downDirection = false;	
			Game.snake.upDirection = false;			
				 
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
	}

}
