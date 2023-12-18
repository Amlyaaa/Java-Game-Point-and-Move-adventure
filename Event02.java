package Event;

import Main.GameManager;

public class Event02 {
      public GameManager gm;
      
      public Event02(GameManager gm) {
    	  this.gm=gm;  
      }
      public void lookCave() {
    	  gm.ui.messageText.setText("Its Cave!");
      }
      public void talkCave() {
    	  gm.ui.messageText.setText("you hear the echo of your voice!");
      }
      public void enterCave() {
    	  if(gm.player.hasLantern==0) {
    		  gm.ui.messageText.setText("Its to dark to enter");
    	  }
    	  else {
    		  gm.sChanger.showScene3();
    	  }
    	  
      }
      public void lookRoot() {
    	  
    	  gm.ui.messageText.setText("This is large a tree!");
      }
      public void talkRoot() {
    	  gm.ui.messageText.setText("Tree talks to you!");
      }
      public void searchRoot() {
    	  if(gm.player.hasLantern==0) {
    		  gm.ui.messageText.setText("you Found the Lantern!");
    		  gm.player.hasLantern=1;
    		  gm.player.updatePlayerStatus();
    	  }else {
    	      gm.ui.messageText.setText("You didnt find Anything!");
    	  }
      }
}
