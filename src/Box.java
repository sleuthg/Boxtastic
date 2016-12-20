import java.awt.Color;
import java.awt.Graphics;

public class Box {
	int x,y,width,height;
	int speedx, speedy;
	Color color;
	boolean player;
	boolean alive;
	
	Box(int x, int y, int width, int height, boolean player) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speedx = 5;
		this.speedy = 5;
		this.color = new Color((int)(Math.random() * 0x1000000));
		this.player = player;
		this.alive = true;
	}
	
	void update() {
		x+=speedx;
		y+=speedy;
		checkEdge();
	}
	
	void draw(Graphics g) {
		if (player) {
			g.setColor(color);
			g.drawRect(x, y, width, height);
		} else {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
	}
	
	void checkEdge() {
		if (x+width>Boxtastic.WIDTH) {
			x = Boxtastic.WIDTH-width;
			speedx = -Math.abs(speedx);
		}
		if (x<0) {
			x = 0;
			speedx = Math.abs(speedx);
		}
		
		if (y+height>Boxtastic.HEIGHT) {
			y = Boxtastic.HEIGHT-height;
			speedy = -Math.abs(speedy);
		}
		if (y<0) {
			y = 0;
			speedy = Math.abs(speedy);
		}
		
	}
	
	boolean isAlive() {
		return alive;
	}
}
