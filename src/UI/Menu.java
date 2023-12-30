package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import main.Game;

public class Menu {

    public String[] options = {"novo jogo","carregar jogo","sair"};

	public int currentOption = 0;
	public int maxOption = options.length - 1;

	public boolean up,down,enter;

	public boolean pause = false;
	public boolean agardando = false;

	public void tick() {
		if(up) {
			up = false;
			currentOption--;
			if(currentOption < 0)
				currentOption = maxOption;
		}

		if(down) {
			down = false;
			currentOption++;
			if(currentOption > maxOption)
				currentOption = 0;
		}

		if(enter) {
			enter = false;
			if(options[currentOption] == "novo jogo" || options[currentOption] == "continuar") {
				Game.gameStatus = "NORMAL";
				pause = false;
			}else if(options[currentOption] == "sair") {
				System.exit(1);
			}
		}
	}

	public void render(Graphics g) {	
		
		Font titleFont = new Font("arial",Font.BOLD,24);
		Font optionsMenu = new Font("arial",Font.BOLD,18);

		FontMetrics metrics = g.getFontMetrics(titleFont);
		g.setColor(Color.white);	
		g.setFont(titleFont);

		g.drawString("Snake Game", (Game.WIDTH - metrics.stringWidth("Snake Game")) / 2 , Game.HEIGHT - 320);

		metrics = g.getFontMetrics(optionsMenu);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(optionsMenu);
		if(pause == false)
			g.drawString("Novo jogo", (Game.WIDTH - metrics.stringWidth("Novo jogo")) / 2 , 160);
		else
			g.drawString("Resumir", (Game.WIDTH - metrics.stringWidth("Resumir")) / 2 , 160);

		g.drawString("Carregar jogo", (Game.WIDTH - metrics.stringWidth("Carregar jogo")) / 2 , 190);
		g.drawString("Sair", (Game.WIDTH - metrics.stringWidth("Sair")) / 2 , 220);

		if(options[currentOption] == "novo jogo") {
			g.drawString(">", (Game.WIDTH - metrics.stringWidth(">")) / 2 - 60 , 160);
		}else if(options[currentOption] == "carregar jogo") {
			g.drawString(">", (Game.WIDTH - metrics.stringWidth(">")) / 2 - 75, 190);
		}else if(options[currentOption] == "sair") {
			g.drawString(">", (Game.WIDTH - metrics.stringWidth(">")) / 2 - 30, 220);
		}

	}
	
}
