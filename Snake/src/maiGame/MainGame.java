package maiGame;





import javax.swing.JFrame;


public class MainGame {

    private JFrame windown;
    

    private MainGame(){

        windown = new JFrame();
        windown.setTitle("Snake Game");
        windown.setResizable(false);
        windown.setLocationRelativeTo(null);
        windown.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windown.setVisible(true);
        windown.pack();

    }
    
    public static void main(String[] args) {

        new MainGame();
        
    }

}
