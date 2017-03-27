package SpaceinvadersInvadersClone;

public class BossBomb extends Entity {
	private double moveSpeed = -700;
	private Game game;

	public BossBomb(Game game,String ref,int x,int y) {
		super(ref,x,y);

		
		this.game = game;
		
		dy = -moveSpeed;
	}

	public void move(long delta) {

		super.move(delta);
		
		if (y > 800) {
			game.removeEntity(this);
		}
	}
	public void collidedWith(Entity other) {
		if (other instanceof ShipEntity) {
			game.removeEntity(this);
			game.healthPoints -=25;
			if (game.healthPoints <= 0){
				game.healthPoints = 0;
				game.notifyDeath();
				}
		}
	}
}