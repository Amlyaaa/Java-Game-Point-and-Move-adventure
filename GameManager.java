package Main;

import java.net.URL;

import Event.Event01;
import Event.Event02;

public class GameManager {

	ActionHandler aHandler = new ActionHandler(this);
	public UI ui = new UI(this);
	public Player player = new Player(this);
	public SceneChanger sChanger = new SceneChanger(this);
	
	Music music = new Music();
	SE se = new SE();

	public Event01 ev1 = new Event01(this);
	public Event02 ev2 = new Event02(this);
	//sound
	 
	public URL fieldMusic1 = getClass().getClassLoader().getResource("audio//Bensound.wav");
	public URL  chest =   getClass().getClassLoader().getResource("audio//chest.wav");
	public URL  collectSound =   getClass().getClassLoader().getResource("audio//collect.wav");
	public URL  deathSound =   getClass().getClassLoader().getResource("audio//death.wav");
	public URL  defeted   =   getClass().getClassLoader().getResource("audio//defeted.wav");
	public URL  stupid    =   getClass().getClassLoader().getResource("audio//stupid.wav");
	public URL  enter     =   getClass().getClassLoader().getResource("audio//enter.wav");
	public URL found      =   getClass().getClassLoader().getResource("audio//founds.wav");
	public URL heal       =   getClass().getClassLoader().getResource("audio//heal.wav");
	public URL leave      =   getClass().getClassLoader().getResource("audio//leave.wav");
	public URL nothing    =   getClass().getClassLoader().getResource("audio//nothing.wav");
	public URL fieldMusic2=   getClass().getClassLoader().getResource("audio//oflias.wav");
	public URL chestT     =   getClass().getClassLoader().getResource("audio//tchest.wav");
	public URL fool       =   getClass().getClassLoader().getResource("audio//fool.wav");
	public URL yoda       =   getClass().getClassLoader().getResource("audio//ydeath.wav");
    public URL currentMusic;



	public static void main(String[] args) {
		
		new GameManager();

	}
	public GameManager() {
		
		//currentMusic = fieldMusic1;
		//playMusic(currentMusic);
		
		player.setPlayerDefaultStatus();
		sChanger.showScene1();
	}
	
	public void playSE(URL url) {
		
		se.setFile(url);
		se.play(url);
	}
	public void playMusic(URL url) {
		music.setFile(url);
		music.play(url);
		music.loop(url);		
	}
	public void stopMusic(URL url) {
		
		music.stop(url);
	}
}
