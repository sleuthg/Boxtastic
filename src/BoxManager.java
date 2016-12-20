import java.awt.Graphics;
import java.util.ArrayList;

public class BoxManager {

	Box playerBox;
	ArrayList<Box> enemyBoxes;
	
	long enemyTimer = 0;
	int enemySpawnTime = 20;
	
	public BoxManager() {
		playerBox = new Box(10,10,50,50,true);
		enemyBoxes = new ArrayList<Box>();
	}
	
	public void update() {
		// update all of the boxes
		// decide when to add enemy boxes
		// check to see which boxes should be eaten
		// remove dead boxes
		for (int i=0; i<enemyBoxes.size(); i++) {
			Box b = enemyBoxes.get(i);
			b.update();
		}
		playerBox.update();
		manageEnemies();
		checkNomNom();
		cleanupBoxes();
	}
	
	public void draw(Graphics g) {
		// draw all of the boxes
		for (int i=0; i<enemyBoxes.size(); i++) {
			Box b = enemyBoxes.get(i);
			b.draw(g);
		}
		playerBox.draw(g);
	}

	public void addEnemy(Box box) {
		// add an enemy
		enemyBoxes.add(box);
	}
	
	private void cleanupBoxes() {
		// check to see which enemies are dead
		// remove dead enemies from the array list
		for (int i = 0; i < enemyBoxes.size(); i++) {
			if (!enemyBoxes.get(i).isAlive()) {
				enemyBoxes.remove(i);
			}
		}
	}
	
	void manageEnemies() {
		// add enemies over time
		enemyTimer++;
		if (enemyTimer > enemySpawnTime) {
			int bx = (int)(Math.random() * (Boxtastic.WIDTH-25));
			int by = (int)(Math.random() * (Boxtastic.HEIGHT-25));
			addEnemy(new Box(bx,by,25,25,false));
			enemyTimer = 0;
//			enemySpawnTime--;
		}
	}
	
	void checkNomNom() {
		// check when boxes are inside each other, if they are, set to alive to false
		for (int i = 0; i < enemyBoxes.size(); i++) {
			Box b = enemyBoxes.get(i);
			if (b.x > playerBox.x && b.x+b.width < playerBox.x+playerBox.width &&
					b.y > playerBox.y && b.y+b.height < playerBox.y+playerBox.height) {
				b.alive = false;
				playerBox.width+=1;
				playerBox.height+=1;
			}
		}
	}
	
}
