package SpaceinvadersInvadersClone;



public class ShotEntity extends Entity {
	private double moveSpeed = -300;
	private Game game;
	private boolean used = false;
	
	public ShotEntity(Game game,String sprite,int x,int y) {
		super(sprite,x,y);
		
		this.game = game;
		
		dy = moveSpeed;
	}

	public void move(long delta) {
		super.move(delta);
		
		if (y < -100) {
			game.removeEntity(this);
		}
	}
	
	
	public void collidedWith(Entity other) {
		if (used) {
			return;
		}
		
		if (other instanceof AlienEntity) {
			game.removeEntity(this);
			game.removeEntity(other);
			game.score+=250;
			game.notifyAlienKilled();
			used = true;
		}
		if (other instanceof BossEntity){
			if (game.bossHealth <= 0){
				game.removeEntity(this);
				game.removeEntity(other);
				game.alive = false;
				game.notifyBossKilled();
				game.score+=10000;
			} else {
				game.removeEntity(this);
				game.bossHealth-=2;
			}
		}
	}
}