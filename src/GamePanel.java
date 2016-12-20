import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

	Timer clock;
	BoxManager manager;
	
	GamePanel() {
		clock = new Timer(1000/60,this);
		manager = new BoxManager();
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Boxtastic.WIDTH, Boxtastic.HEIGHT);
		manager.draw(g);
	}

	public void start() {
		clock.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		manager.update();
		repaint();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(Boxtastic.WIDTH, Boxtastic.HEIGHT);
	}
	
}
