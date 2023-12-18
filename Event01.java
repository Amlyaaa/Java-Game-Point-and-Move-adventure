package Event;

import Main.GameManager;

public class Event01 {
     GameManager gm;
     
     public Event01(GameManager gm) {
    	 this.gm = gm;
    	 
     }
     public void lookHut() {
    	 gm.ui.messageText.setText("This is Your House");
     }
     
     public void talkhut() {
    	 gm.ui.messageText.setText("Who are you talking to?");
     }
     public void restHut() {
    	 if(gm.player.playerLife!=gm.player.playerMaxLife) {
    		 gm.ui.messageText.setText("You rest at the house.\n(your life has recovred!)");
    		 gm.player.playerLife++;
    		 gm.player.updatePlayerStatus();
    	 }else {
    		 gm.ui.messageText.setText("Your Life is Full!)");
    	 }
    	
     }
     
     public void lookGuard() {
    	 gm.ui.messageText.setText("A Guard is standing infront of you");
     }
     public void talkGuard() {
    	 gm.ui.messageText.setText("Guard:Dont go any further without weapon!\nyou should check the chest over there");
     }
     public void attackGuard() {
    	 if(gm.player.hasShield==0) {
    		 if(gm.player.hasSwoard==0) {
    			 if(gm.player.playerLife!=1){
    				 gm.ui.messageText.setText("Guard:Hey don be stupid!\n(The Guard hits you back and your life decreses by 1!)");
        			 gm.player.playerLife--;
        			 //gm.player.updatePlayerStatus();
    			 }
    			 else if(gm.player.playerLife==1){
    				 gm.ui.messageText.setText("Guard:What a Fool!");
        			 gm.player.playerLife--;
        			 gm.sChanger.showGameOverScreen(1);
    				 
    			 }
    			 
    		 }
    		 else if(gm.player.hasSwoard==1) {
    			gm.ui.messageText.setText("Guard:oh!!Shit\n(You have defetaed the guard and gotten his shield!))");
                gm.player.hasShield=1;
                gm.player.updatePlayerStatus();
    		 }
    		 gm.player.updatePlayerStatus();
    	 }
    	 else {
    		 gm.ui.messageText.setText("Guard:Just leave me alone!");
    	 }
    	
     }
     
     public void lookChest() {
    	 gm.ui.messageText.setText("A chest is on the ground!");
     }
     public void talkChest() {
    	 gm.ui.messageText.setText("You talk to the Chest but it says nothing");
     }
     public void openChest() {
    	 if(gm.player.hasSwoard==0) {
    		 gm.ui.messageText.setText("You Open the Chest and Found the Sword!");
    		 gm.player.hasSwoard=1;
    		 gm.player.updatePlayerStatus();
    	 }
    	 else {
    		 gm.ui.messageText.setText("There is Nothing inside!");
    	 }
    	 
     }
     
}
