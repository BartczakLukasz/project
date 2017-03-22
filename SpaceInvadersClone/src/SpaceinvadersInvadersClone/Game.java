package SpaceinvadersInvadersClone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;




public class Game extends Canvas {
	private BufferStrategy strategy;
	private boolean gameRunning = true;
	private ArrayList entities = new ArrayList();
	private ArrayList removeList = new ArrayList();
	private Entity ship;
	private Entity boss;
	private double moveSpeed = 300;
	private long lastFire = 0;
	private long firingInterval = 500;
	private long lastBomb = System.currentTimeMillis()+1500;
	private long bombingInterval = 500;
	private int alienCount;
	public boolean bombFired = false;
	public boolean shotFired = false;
	private String message = "";
	private boolean waitingForKeyPress = true;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private boolean firePressed = false;
	private boolean logicRequiredThisLoop = false;
	public static int healthPoints = 100;
	public int chooseAlien = 1;
	Random r = new Random();
	Random z = new Random();
	Random q = new Random();
	public int x1=400,x2=340,x3=333,x4=445,
			x5=230,x6=403,x7=695,x8=150,x9=90,x10=30,
			x11=367,x12=100,x13=456,x14=643,x15=444,x16=521,
			x17,x18,x19,x20,y1=50,y2=543,y3=233,y4=123,y5=200,
			y6=20,y7=123,y8=500,y9=340,y10=250,y11=653,y12=352,
			y13=654,y14=743,y15=253,y16=533,y17=233,y18=373,y19=400,y20=700;
	static int bossHealth = 100;
	public boolean bossCame = false;
	public boolean alive = false;
	public Game() {
		JFrame container = new JFrame("Space Invaders Clone");
		
		JPanel panel = (JPanel) container.getContentPane();
		panel.setPreferredSize(new Dimension(800,650));
		panel.setLayout(null);
		
		setBounds(0,0,800,650);
		panel.add(this);
		
		setIgnoreRepaint(true);
		
		container.pack();
		container.setResizable(false);
		container.setVisible(true);
		
		container.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		addKeyListener(new KeyInputHandler());
		
		requestFocus();

		createBufferStrategy(2);
		strategy = getBufferStrategy();
		
		initEntities();
	}
	
	private void startGame() {
		entities.clear();
		initEntities();
		
		leftPressed = false;
		rightPressed = false;
		firePressed = false;
	}
	
	private void initEntities() {
		ship = new ShipEntity(this,"sprites/ship.gif",370,550);
		entities.add(ship);
		
		alienCount = 0;
		for (int row=0;row<5;row++) {
			for (int x=0;x<12;x++) {
				Entity alien = new AlienEntity(this,"sprites/alien.gif",100+(x*50),(50)+row*30);
				entities.add(alien);
				alienCount++;
			}
		}
		boss = new BossEntity(this,"sprites/boss.GIF",300,200);
	}
	
	public void updateLogic() {
		logicRequiredThisLoop = true;
	}
	
	public void removeEntity(Entity entity) {
		removeList.add(entity);
	}
	
	public void notifyDeath() {
		message = "Oh no! They got you, try again?";
		bossCame = false;
		bossHealth = 100;
		waitingForKeyPress = true;
	}
	
	public void notifyWin() {
		message = "Well done! You Win!";
		waitingForKeyPress = true;
	}
	public void bringBoss(){
		entities.add(boss);
		alive = true;
		bossCame = true;
	}
	
	public void notifyAlienKilled() {
		alienCount--;
		
		if (alienCount == 0) {
			bringBoss();
		}
		
		for (int i=0;i<entities.size();i++) {
			Entity entity = (Entity) entities.get(i);
			
			if (entity instanceof AlienEntity) {
				entity.setHorizontalMovement(entity.getHorizontalMovement() * 1.02);
			}
		}
	}
	public void notifyBossKilled(){
		bossCame = false;
		notifyWin();
	}
	
	public void tryToFire() {
		if (System.currentTimeMillis() - lastFire < firingInterval) {
			return;
		}
		
		lastFire = System.currentTimeMillis();
		ShotEntity shot = new ShotEntity(this,"sprites/shot.gif",ship.getX()+10,ship.getY()-30);
		entities.add(shot);
	}
	public void tryBombing(){
		if (System.currentTimeMillis() - lastBomb <bombingInterval || alienCount == 0){
			return;
			
		}
		bombingInterval = (long)z.nextInt(300)+500;
		lastBomb = System.currentTimeMillis();
		Entity alien = (Entity) entities.get(chooseAlien);
		BombEntity bomb = new BombEntity(this,"sprites/bomb.gif",alien.getX()+10,alien.getY()+25);
		bombFired = true;
		entities.add(bomb);	
	}
public void choseAlien(){
		
		if (alienCount>0)
		chooseAlien = r.nextInt(alienCount)+1;
	}
	private void chooseStars(){ 
		if(System.currentTimeMillis()%275 <= 5)
		{
			 x1 = z.nextInt(800);
			 x2 = z.nextInt(800);
			 x3 = z.nextInt(800);
			 x4 = z.nextInt(800);
			 x5 = z.nextInt(800);
			 x6 = z.nextInt(800);
			 x7 = z.nextInt(800);
			 x8 = z.nextInt(800);
			 x9 = z.nextInt(800);
			 x10 = z.nextInt(800);
			 x11 = z.nextInt(800);
			 x12 = z.nextInt(800);
			 x13 = z.nextInt(800);
			 x14 = z.nextInt(800);
			 x15 = z.nextInt(800);
			 x16 = z.nextInt(800);
			 x17 = z.nextInt(800);
			 x18 = z.nextInt(800);
			 x19 = z.nextInt(800);
			 x20 = z.nextInt(800);
			 y11 = q.nextInt(600);
			 y12 = q.nextInt(600);
			 y13 = q.nextInt(600);
			 y14 = q.nextInt(600);
			 y15 = q.nextInt(600);
			 y16 = q.nextInt(600);
			 y17 = q.nextInt(600);
			 y18 = q.nextInt(600);
			 y19 = q.nextInt(600);
			 y20 = q.nextInt(600);
			 y1 = q.nextInt(600);
			 y2 = q.nextInt(600);
			 y3 = q.nextInt(600);
			 y4 = q.nextInt(600);
			 y5 = q.nextInt(600);
			 y6 = q.nextInt(600);
			 y7 = q.nextInt(600);
			 y8 = q.nextInt(600);
			 y9 = q.nextInt(600);
			 y10 = q.nextInt(600);
		}
	}
	
	void starMovement(){
		if (System.currentTimeMillis()%1 == 0)
		{
			y1+=1;
			y2+=1;
			y3+=1;
			y4+=1;
			y5+=1;
			y6+=1;
			y7+=1;
			y8+=1;
			y9+=1;
			y10+=1;
			y11+=1;
			y12+=1;
			y13+=1;
			y14+=1;
			y15+=1;
			y16+=1;
			y17+=1;
			y18+=1;
			y19+=1;
			y20+=1;
		}
	}
	
	public void gameLoop() {
		long lastLoopTime = System.currentTimeMillis();
		
		while (gameRunning) {
			long delta = System.currentTimeMillis() - lastLoopTime;
			lastLoopTime = System.currentTimeMillis();
			chooseStars();
			choseAlien();
			
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			g.setColor(Color.black);
			g.fillRect(0,0,800,650);
			g.setColor(Color.red);
			g.fillRect(x1,y1,1,1);
			g.setColor(Color.blue);
			g.fillRect(x2,y2,1,1);
			g.setColor(Color.green);
			g.fillRect(x3,y3,1,1);
			g.setColor(Color.white);
			g.fillRect(x4,y4,1,1);
			g.setColor(Color.cyan);
			g.fillRect(x5,y5,1,1);
			g.setColor(Color.red);
			g.fillRect(x6,y6,1,1);
			g.setColor(Color.blue);
			g.fillRect(x7,y7,1,1);
			g.setColor(Color.green);
			g.fillRect(x8,y8,1,1);
			g.setColor(Color.yellow);
			g.fillRect(x9,y9,1,1);
			g.setColor(Color.cyan);
			g.fillRect(x10,y10,1,1);
			g.setColor(Color.red);
			g.fillRect(x11,y11,1,1);
			g.setColor(Color.blue);
			g.fillRect(x12,y12,1,1);
			g.setColor(Color.green);
			g.fillRect(x13,y13,1,1);
			g.setColor(Color.orange);
			g.fillRect(x14,y14,1,1);
			g.setColor(Color.cyan);
			g.fillRect(x15,y15,1,1);
			g.setColor(Color.red);
			g.fillRect(x16,y16,1,1);
			g.setColor(Color.magenta);
			g.fillRect(x17,y17,1,1);
			g.setColor(Color.green);
			g.fillRect(x18,y18,1,1);
			g.setColor(Color.pink);
			g.fillRect(x19,y19,1,1);
			g.setColor(Color.magenta);
			g.fillRect(x20,y20,1,1);
			starMovement();		
			if (!waitingForKeyPress) {
				for (int i=0;i<entities.size();i++) {
					Entity entity = (Entity) entities.get(i);
					
					entity.move(delta);
				}
			}
			
			for (int i=0;i<entities.size();i++) {
				Entity entity = (Entity) entities.get(i);
				
				entity.draw(g);
			}
			
			for (int p=0;p<entities.size();p++) {
				for (int s=p+1;s<entities.size();s++) {
					Entity me = (Entity) entities.get(p);
					Entity him = (Entity) entities.get(s);
					
					if (me.collidesWith(him)) {
						me.collidedWith(him);
						him.collidedWith(me);
					}
				}
			}
			
			entities.removeAll(removeList);
			removeList.clear();

			if (logicRequiredThisLoop) {
				for (int i=0;i<entities.size();i++) {
					Entity entity = (Entity) entities.get(i);
					entity.doLogic();
				}
				
				logicRequiredThisLoop = false;
			}
			
			if (waitingForKeyPress) {
				g.setColor(Color.white);
				g.drawString(message,(800-g.getFontMetrics().stringWidth(message))/2,250);
				g.drawString("Press any key",(800-g.getFontMetrics().stringWidth("Press any key"))/2,300);
			}
			
			g.dispose();
			strategy.show();
			
			ship.setHorizontalMovement(0);
			
			if ((leftPressed) && (!rightPressed)) {
				ship.setHorizontalMovement(-moveSpeed);
			} else if ((rightPressed) && (!leftPressed)) {
				ship.setHorizontalMovement(moveSpeed);
			}
			
			if (firePressed) {
				tryToFire();
			}
			if (!waitingForKeyPress){
				tryBombing();
			}
			
			try { Thread.sleep(10); } catch (Exception e) {}
		}
	}
	
	private class KeyInputHandler extends KeyAdapter {
		private int pressCount = 1;
		
		public void keyPressed(KeyEvent e) {
			if (waitingForKeyPress) {
				return;
			}
			
			
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				leftPressed = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				rightPressed = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				firePressed = true;
			}
		} 
		
		public void keyReleased(KeyEvent e) {
			if (waitingForKeyPress) {
				return;
			}
			
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				leftPressed = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				rightPressed = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				firePressed = false;
			}
		}
		

		public void keyTyped(KeyEvent e) {
			if (waitingForKeyPress) {
				if (pressCount == 1) {
					waitingForKeyPress = false;
					startGame();
					pressCount = 0;
				} else {
					pressCount++;
				}
			}
			
			if (e.getKeyChar() == 27) {
				System.exit(0);
			}
		}
	}
	
	public static void main(String argv[]) {
		Game g =new Game();

		g.gameLoop();
	}
}
