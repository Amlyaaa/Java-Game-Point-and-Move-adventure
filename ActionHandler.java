package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {
	GameManager gm;
	
	public ActionHandler(GameManager gm) {
		this.gm=gm;
		
		
	}

	 
	public void actionPerformed(ActionEvent e) {
		 String yourChoice = e.getActionCommand();
		 
		 switch(yourChoice) {
		   case "lookHut" :gm.ev1.lookHut();break;
		   case "talkHut":gm.ev1.talkhut();break;
		   case "restHut":gm.ev1.restHut();break;
		   
		   case "lookGuard":gm.ev1.lookGuard();break;
		   case "talkGuard":gm.ev1.talkGuard();break;
		   case "attackGuard":gm.ev1.attackGuard();break;
		   
		   case "lookChest":gm.ev1.lookChest();break;
		   case "talkChest":gm.ev1.talkChest();break;
		   case "openChest":gm.ev1.openChest();break;
		   //scence 2
		   case "lookCave":gm.ev2.lookCave();break;
		   case "talkCave":gm.ev2.talkCave();break;
		   case "enterCave":gm.ev2.enterCave();break;
		   case "lookRoot":gm.ev2.lookRoot();break;
		   case "talkRoot":gm.ev2.talkRoot();break;
		   case "searchRoot":gm.ev2.searchRoot();break;
		   //chnge scene
		   case "goScene1":gm.sChanger.showScene1(); break;
		   case "goScene2":gm.sChanger.showScene2(); break;
		   //other
		   case "restart":gm.sChanger.existGameOverScreen();gm.sChanger.showScene1();break;
		   
		   
		 }
	}

}
