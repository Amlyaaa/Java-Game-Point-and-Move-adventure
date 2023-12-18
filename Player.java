package Main;

public class Player {
	  GameManager gm;
	  public int playerMaxLife;
	  public int playerLife;
	  
	  public int hasSwoard;
	  public int hasShield;
	  public int hasLantern;
	  
	
	public Player(GameManager gm) {
		
	   this.gm =gm;
	}
	public void setPlayerDefaultStatus() {
		playerMaxLife = 5;
		playerLife = 3;
		hasSwoard = 0;
		hasShield = 0;
		hasLantern= 0;	
		
		updatePlayerStatus();
	}
	public void updatePlayerStatus() {
		int i =1;
		while(i<6) {
			gm.ui.lifeLabel[i].setVisible(false);
			i++;
		}
		int lifeCount = playerLife;
		while(lifeCount!=0) {
			gm.ui.lifeLabel[lifeCount].setVisible(true);
			lifeCount --;
		}
		
		if(hasSwoard==0) {
			gm.ui.swoardLabel.setVisible(false);	
		}
		if(hasSwoard==1) {
			gm.ui.swoardLabel.setVisible(true);	
		}
		
		if(hasShield==0) {
			gm.ui.shieldLabel.setVisible(false);	
		}
		if(hasShield==1) {
			gm.ui.shieldLabel.setVisible(true);	
		}
		
		if(hasLantern==0) {
			gm.ui.lanternLabel.setVisible(false);	
		}
		if(hasLantern==1) {
			gm.ui.lanternLabel.setVisible(true);	
		}
	}
}
