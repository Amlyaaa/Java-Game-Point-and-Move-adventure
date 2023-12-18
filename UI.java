package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class UI {
	GameManager gm;
     
	JFrame window;
	public JTextArea messageText;
	public JPanel bgPanel[] = new JPanel[10];
	public JLabel bgLabel[] =  new JLabel[10];
	
	JPanel lifePanel;
	JLabel lifeLabel[] = new JLabel[6];
	JPanel inventoryPanel;
	public JLabel swoardLabel,shieldLabel,lanternLabel;
	
	//ui part
	public JLabel titleLabel;
	public JButton restartButton;
	
	
	
	public UI(GameManager gm) {
		this.gm = gm;
		createMainField();
		createPlayerField();
		createGameOverField();
		 generateScene();
		
		window.setVisible(true);
	}
	public void createMainField() {
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.BLACK);
		window.setLayout(null);
		
		
		messageText = new JTextArea("This is Sample Text");
		messageText.setBounds(50,410,700,150);
		messageText.setBackground(Color.BLACK);
		messageText.setForeground(Color.white);
		messageText.setEditable(false);
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setFont(new Font("Book Antiqua",Font.PLAIN,26));
		window.add(messageText);
		
	}
	public void createBackGround(int bgNum,String bgFileName) {
		bgPanel[bgNum] = new JPanel();
		bgPanel[bgNum].setBounds(50,50,700,350);
		bgPanel[bgNum].setBackground(Color.black);
		bgPanel[bgNum].setLayout(null);
		bgPanel[bgNum].setVisible(false);
		window.add(bgPanel[bgNum]);
		
		bgLabel[bgNum] =  new JLabel();
		bgLabel[bgNum].setBounds(0,0,700,350);
		
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
		bgLabel[bgNum].setIcon(bgIcon);
		}
	public void createObject(int bgNum,int objx,int objy,int objwidth,int objheight,String objFileName,String choice1Name,String choice2Name,String choice3Name,
			String choice1command,String choice2command,String choice3command) {
		JPopupMenu popMenu = new JPopupMenu();
		JMenuItem menuItem[] = new JMenuItem[4];
		
		menuItem[1] = new JMenuItem(choice1Name);
		menuItem[1].addActionListener(gm.aHandler);
		menuItem[1].setActionCommand(choice1command);
		popMenu.add(menuItem[1]);
		
		menuItem[2] = new JMenuItem(choice2Name);
		menuItem[2].addActionListener(gm.aHandler);
		menuItem[2].setActionCommand(choice2command);
		popMenu.add(menuItem[2]);
		
		menuItem[3] = new JMenuItem(choice3Name);
		menuItem[3].addActionListener(gm.aHandler);
		menuItem[3].setActionCommand(choice3command);
		popMenu.add(menuItem[3]);
		
		
		
		JLabel objectLabel = new JLabel();
		objectLabel.setBounds(objx,objy,objwidth,objheight);
		
	
		ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		objectLabel.setIcon(objectIcon);
		
		objectLabel.addMouseListener(new MouseListener() {

		 
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				 if(SwingUtilities.isRightMouseButton(e)) {
					 popMenu.show(objectLabel,e.getX(),e.getY());
				
			}
			}

			 
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
			
			
		});
		
		bgPanel[bgNum].add(objectLabel);
		
		
	}
	 
	public void createArrowButton(int bgNum,int x,int y,int width,int height,String arrowFileName,String command) {
		ImageIcon arrowIcon =  new ImageIcon(getClass().getClassLoader().getResource(arrowFileName));
		JButton arrowButton = new JButton();
		arrowButton.setBounds(x,y,width,height);
		arrowButton.setBackground(null);
		arrowButton.setContentAreaFilled(false);
		arrowButton.setFocusPainted(false);
		arrowButton.setIcon(arrowIcon);
		arrowButton.addActionListener(gm.aHandler);
		arrowButton.setActionCommand(command);
		arrowButton.setBorderPainted(false);
		
		bgPanel[bgNum].add(arrowButton);
	}
	public void createPlayerField() {
		lifePanel = new JPanel();
		lifePanel.setBounds(50,0,250,50);
		lifePanel.setBackground(Color.black);
		lifePanel.setLayout(new GridLayout(1,5));
		window.add(lifePanel);
		ImageIcon lifeIcon = new ImageIcon(getClass().getClassLoader().getResource("hert5.png"));
		Image image = lifeIcon.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
		lifeIcon = new ImageIcon(image);
		int i=1;
		while(i<6) {
			lifeLabel[i] = new JLabel();
			lifeLabel[i].setIcon(lifeIcon);
			lifePanel.add(lifeLabel[i]);
			i++;	
		}
		
		inventoryPanel =  new JPanel();
		inventoryPanel.setBounds(650,0,100,50);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(1,3));
		window.add(inventoryPanel);
		
		//create items
		swoardLabel = new JLabel();
		ImageIcon swordIcon = new ImageIcon(getClass().getClassLoader().getResource("swoard.png"));
		image = swordIcon.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
		swordIcon = new ImageIcon(image);
		swoardLabel.setIcon(swordIcon);
		inventoryPanel.add(swoardLabel);
		
		//shield
		shieldLabel = new JLabel();
		ImageIcon shieldIcon = new ImageIcon(getClass().getClassLoader().getResource("shield.png"));
		image = shieldIcon.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
		shieldIcon = new ImageIcon(image);
		shieldLabel.setIcon(shieldIcon);
		inventoryPanel.add(shieldLabel);
		
		
		//latern
		lanternLabel = new JLabel();
		ImageIcon lanternIcon = new ImageIcon(getClass().getClassLoader().getResource("lantern.png"));
		image = lanternIcon.getImage().getScaledInstance(35,35,Image.SCALE_DEFAULT);
		lanternIcon = new ImageIcon(image);
		lanternLabel.setIcon(lanternIcon);
		inventoryPanel.add(lanternLabel);
		
}
	
	public void createGameOverField() {
		titleLabel = new JLabel("",JLabel.CENTER);
		titleLabel.setBounds(200,150,400,200);
		titleLabel.setForeground(Color.red);
		titleLabel.setFont(new Font("Times New Roman",Font.PLAIN,70));
		titleLabel.setVisible(false);
		window.add(titleLabel);
		
		restartButton = new JButton();
		restartButton.setBounds(340,320,120,50);
		restartButton.setBorder(null);
		restartButton.setBackground(null);
		restartButton.setForeground(Color.white);
		restartButton.setFocusPainted(false);
		restartButton.addActionListener(gm.aHandler);
		restartButton.setActionCommand("restart");
		restartButton.setVisible(false);
		window.add(restartButton);
		}
	public void generateScene() {
		createBackGround(1,"landscape.png");
		createObject(1,440,140,200,200,"hut1.png","look","talk","rest","lookHut","talkHut","restHut");
		createObject(1,70,180,150,150,"gurd-removebg-preview.png","look","talk","attack","lookGuard","talkGuard","attackGuard");
		createObject(1,310,280,70,70,"chest.png","look","talk","open","lookChest","talkChest","openChest");
		createArrowButton(1,0,150,50,50,"left.png","goScene2");
		bgPanel[1].add(bgLabel[1]);
		
		//scene 2
		createBackGround(2,"cave2.png");
		createObject(2,0,100,100,300,"blank.png","Look","Talk","Enter","lookCave","talkCave","enterCave");
		createObject(2,355,250,50,50,"blank.png","Look","Talk","Search","lookRoot","talkRoot","searchRoot");
		createArrowButton(2,650,150,50,50,"right.png","goScene1");
		bgPanel[2].add(bgLabel[2]);
		//scene 3
		createBackGround(3,"cave3.jpg");
		createArrowButton(3,650,150,50,50,"right.png","goScene2");
		bgPanel[3].add(bgLabel[3]);
		
		
	}
}
