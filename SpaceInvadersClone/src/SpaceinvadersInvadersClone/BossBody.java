package SpaceinvadersInvadersClone;

public class BossBody extends Entity{
	private double moveSpeed = 0;
	private Game game;
	
	public BossBody(Game game,String ref,int x,int y){
		super(ref,x,y);
		
		this.game = game;
		dx = -moveSpeed;
	}

	public void move(long delta) {
		
		if ((dx < 0) && (x < 300)) {
			game.updateLogic();
		}
		if ((dx > 0) && (x > 400)) {
			game.updateLogic();
		}
		
		super.move(delta);
	}
	public void doLogic() {
		dx = -dx;
	}

	public void collidedWith(Entity other) {
	}
}
