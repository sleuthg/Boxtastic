
import javax.swing.JFrame;

public class Boxtastic {

	JFrame window;
	GamePanel panel;
	
	// final variables are constant, so they can't be changed
	static final int WIDTH = 500;
	static final int HEIGHT = 700;
	
	public static void main(String[] args) {
		new Boxtastic();
	}
	
	Boxtastic() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel = new GamePanel();
		window.add(panel);
		window.setVisible(true);
		
		// We can pack because we overwrote the preferred size of the panel
		window.pack();
		
		// Start the game
		panel.start();
	}
	
}
