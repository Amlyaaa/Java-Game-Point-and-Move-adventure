package Main;

public class SceneChanger {
	GameManager gm;
	
	public SceneChanger(GameManager gm) {
		this.gm=gm;
	}
    public void showScene1() {
    	gm.ui.bgPanel[1].setVisible(true);
    	gm.ui.bgPanel[2].setVisible(false);
    	gm.ui.messageText.setText("Lets defeat the Demon and Save the world!");
    }

    public void showScene2() {
	    gm.ui.bgPanel[1].setVisible(false);
	    gm.ui.bgPanel[2].setVisible(true);
	    gm.ui.bgPanel[3].setVisible(false);
	    gm.ui.messageText.setText("");
 }
    public void showScene3() {
	    gm.ui.bgPanel[2].setVisible(false);
	    gm.ui.bgPanel[3].setVisible(true);
	    gm.ui.messageText.setText("You Enter the cave.what is waiting for you inside...\n\n" + "*** this is the end of the demo.Thank you for playplaying ***");
	    
    }
    public void showGameOverScreen(int currentBgNum) {
    	gm.ui.bgPanel[currentBgNum].setVisible(false);
    	gm.ui.titleLabel.setVisible(true);
    	gm.ui.titleLabel.setText("You Died!");
    	gm.ui.restartButton.setVisible(true);
    	gm.ui.restartButton.setText("Click For Restart!");
    	 	
    }
    public void existGameOverScreen() {
    	gm.ui.titleLabel.setVisible(false);
    	gm.ui.restartButton.setVisible(false);
    	gm.player.setPlayerDefaultStatus();
    	
    }
    
}
