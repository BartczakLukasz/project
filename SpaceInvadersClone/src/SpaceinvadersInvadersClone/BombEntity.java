package SpaceinvadersInvadersClone;

/**
 * Obiekt reprezentuj�cy bomb�
 * dodany w wersji 1.1
 */
public class BombEntity extends Entity {
	/** Pr�dko�� pocisku */
	private double moveSpeed = -170;
	/**Klatki animacji jakie posiada*/
	private Sprite[] frames = new Sprite[2]; 
	/** Ostatnia zmiana klatki*/
	private long lastFrameChange;
	/** Definiuje czas trwania jednej klatki */
	private long frameDuration = 35;
	/** Numer klatki */
	private int frameNumber;
	/** Gra w kt�rym egzystuje */
	private Game game;
	/**
	 * Stw�rz bomb� gracza
	 * 
	 * @param game Gra w kt�rym zosta� sworzony
	 * @param ref Sprite reprezentuj�cy strza�
	 * @param x Pocz�tkowy x
	 * @param y Pocz�tkowy y
	 */
	public BombEntity(Game game,String ref,int x,int y) {
		super(ref,x,y);
		frames[0] = sprite;
		frames[1] = SpriteStore.get().getSprite("sprites/bomb2.gif");
		
		this.game = game;
		
		dy = -moveSpeed;
	}
	/**
	 * Poruszanie bomby
	 * 
	 * @param delta Czas, kt�ry min�� od ostatniego ruchu
	 */
	public void move(long delta) {
		lastFrameChange += delta;
		if (lastFrameChange > frameDuration) {
		

			lastFrameChange = 0;
			
		

			frameNumber++;
			if (frameNumber >= frames.length) {
				frameNumber = 0;
			}
			
			sprite = frames[frameNumber];
		}
		//poruszaj si� ze zwyk�� prz�dko�ci�
		super.move(delta);
		
		// usu� bomb� gdy wyleci za ekran
		if (y > 800) {
			game.removeEntity(this);
		}
	}
	/**
	 * Powiadomienie o kolizji z innym obiektem
	 * 
	 * @param other Obiekt z kt�rym kolidujemy
	 */
	public void collidedWith(Entity other) {
		// je�eli to gracz to otrzyma obra�enia
		if (other instanceof ShipEntity) {
			game.removeEntity(this);
			if (game.healthPoints<=50){
				game.healthPoints -=15;
			}
			else{
				game.healthPoints -=10;
			}
			// je�eli zdrowie spadnie do 0
			// to gracz przegrywa
			if (game.healthPoints <= 0){
				game.healthPoints = 0;
				game.notifyDeath();
				}
		}
	}
}
