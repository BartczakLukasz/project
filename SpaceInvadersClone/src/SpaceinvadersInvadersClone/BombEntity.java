package SpaceinvadersInvadersClone;

public class BombEntity extends Entity {
	private double moveSpeed = -170;
	private Game game;
	public BombEntity(Game game,String ref,int x,int y) {
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
			if (game.healthPoints<=50){
				game.healthPoints -=15;
			}
			else{
				game.healthPoints -=10;
			}
			if (game.healthPoints <= 0){
				game.healthPoints = 0;
				game.notifyDeath();
				}
		}
	}
}
