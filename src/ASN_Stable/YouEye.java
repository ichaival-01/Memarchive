package ASN_Stable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class YouEye{ 
    ASN_Execute gm;
    JFrame window;
    Container store;
    JPanel bgPanel[] = new JPanel[10];
    JLabel bgLabel[] = new JLabel[10];
    JLabel enemyStore;
    ImageIcon enemy;
    JPanel TPanel;
    JPanel SBPanel;
    JPanel PBPanel;
    JPanel mainTextPanel;
    JPanel LPanel;
    JPanel OptionUI;
    JPanel currentItemStore;
    JLabel GLabel;
    JLabel TLabel;
    JLabel currentItem;
    Font titleFont = new Font("Playbill", Font.PLAIN, 90);
    Font titleButtonFont = new Font("Playbill", Font.PLAIN,90);
    Font normalFont = new Font("Garamond", Font.PLAIN, 28);
    JButton startGame;
    JButton progress;
    JButton OP1;
    JButton OP2;
    JButton InventoryToggle;
    JButton inventoryLeft;
    JButton inventoryRight;
    JTextArea yap;
    int playerHP;
    int goldCount;
    int currentItemNo;
    boolean inventoryOut;
    boolean atVillage;
    boolean atShop;
    String weapon;
    TitleScreenHandler tsHandler = new TitleScreenHandler();
	
    ImageIcon logo;
    JPanel ImageIconPanel;
    JLabel ImageIconLabel;
    
    
    public YouEye(ASN_Execute gm){
        
        this.gm = gm;     
        
        createTitleScreen();
        
    }
    
    
    public void createTitleScreen() {
        window = new JFrame("May your sanity be conserved.");
        window.setSize(1600, 1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        store = window.getContentPane();

        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("TBG.jpg"));
        ImageIconPanel = new JPanel();
        ImageIconPanel.setBounds(0,0,1600,1000);
        ImageIconLabel = new JLabel();
        ImageIconLabel.setIcon(logo);
        ImageIconPanel.add(ImageIconLabel);
        
        TPanel = new JPanel();
        TPanel.setBounds(130, 220, 1300, 150);
        TPanel.setOpaque(false);
        TPanel.setBackground(Color.black);

        TLabel = new JLabel("A Sisyphian Nightmare");
        TLabel.setForeground(Color.black);
        TLabel.setFont(titleFont);

        SBPanel = new JPanel();
        SBPanel.setBounds(440, 645, 650, 230);
        SBPanel.setOpaque(false);
        SBPanel.setBackground(null);
        
        startGame = new JButton("BEGIN");
        startGame.setBackground(null);
        startGame.setForeground(Color.white);
        startGame.setFont(titleButtonFont);
        startGame.addActionListener(tsHandler);
        startGame.setFocusPainted(false);
        startGame.setOpaque(false);
        
        TPanel.add(TLabel);
        SBPanel.add(startGame);
        
        store.add(TPanel);
        store.add(SBPanel);
        store.add(ImageIconPanel);
        
        window.setVisible(true);
    }
    public void createMainField(){
        
        TPanel.setVisible(false);
        SBPanel.setVisible(false);
        ImageIconPanel.setVisible(false);
               
        yap = new JTextArea("You wake up, unaware of your surroundings...");
        yap.setBounds(130,745,1300,100);
        yap.setBackground(Color.black);
        yap.setForeground(Color.white);
        yap.setEditable(false);
        yap.setLineWrap(true);
        yap.setWrapStyleWord(true);
        yap.setFont(new Font ("Consolas", Font.PLAIN,26));
        window.add(yap);
        
        OptionUI = new JPanel();
        OptionUI.setBounds(450, 845, 650, 115);
        OptionUI.setOpaque(false);
        OptionUI.setLayout(new GridLayout(1,3));
        OptionUI.setBackground(Color.black);
        
        OP1 = new JButton("...");
        OP1.setBackground(Color.black);
        OP1.setForeground(Color.white);
        OP1.setFont(normalFont);
        OP1.addActionListener(gm.aHandler);
        OP1.setActionCommand("moveStory");
        OP1.setFocusPainted(false);
        
        OP2 = new JButton("...");
        OP2.setBackground(Color.black);
        OP2.setForeground(Color.white);
        OP2.setFont(normalFont);
        OP2.addActionListener(gm.aHandler);
        OP2.setActionCommand("moveStory");
        OP2.setFocusPainted(false);
        
        InventoryToggle = new JButton("...");
        InventoryToggle.setBackground(Color.black);
        InventoryToggle.setForeground(Color.white);
        InventoryToggle.setFont(normalFont);
        InventoryToggle.addActionListener(gm.aHandler);
        InventoryToggle.setActionCommand("moveStory");
        InventoryToggle.setFocusPainted(false);

        inventoryLeft = new JButton("<");
        inventoryLeft.setBackground(Color.black);
        inventoryLeft.setForeground(Color.white);
        inventoryLeft.setFont(normalFont);
        inventoryLeft.addActionListener(gm.aHandler);
        inventoryLeft.setActionCommand("cycleLeft");
        inventoryLeft.setFocusPainted(false);  
        inventoryLeft.setVisible(false);
        
        inventoryRight = new JButton(">");
        inventoryRight.setBackground(Color.black);
        inventoryRight.setForeground(Color.white);
        inventoryRight.setFont(normalFont);
        inventoryRight.addActionListener(gm.aHandler);
        inventoryRight.setActionCommand("cycleRight");
        inventoryRight.setFocusPainted(false); 
        inventoryRight.setVisible(false);
        
        currentItemStore = new JPanel();
        currentItemStore.setBounds(930, 910, 650, 115);
        currentItemStore.setOpaque(false);
        currentItemStore.setBackground(Color.black);
        
        currentItem = new JLabel("current Item:" + gm.PC.inventory.get(currentItemNo).returnNAME());
        currentItem.setForeground(Color.white);
        currentItem.setFont(normalFont);
        
        currentItemStore.add(currentItem);
       
        OptionUI.add(inventoryLeft);
        OptionUI.add(OP1);
        OptionUI.add(OP2);
        OptionUI.add(InventoryToggle);
        OptionUI.add(inventoryRight);
        window.add(currentItemStore);
        window.add(OptionUI);

        
        inventoryOut = false;
        currentItemStore.setVisible(false);
        
    }
    
    public void spawnEnemy(int roomNumber,int width, int height, String fileName){
        enemy = new ImageIcon(getClass().getClassLoader().getResource(fileName));
        
        enemyStore = new JLabel();
        enemyStore.setBounds(550,300,width,height);
        enemyStore.setIcon(enemy);
        
        bgPanel[roomNumber].add(enemyStore);
        bgPanel[roomNumber].add(bgLabel[roomNumber]);
        
        enemyStore.setVisible(false);
    }
    
    public void createBackgroundImage(int bgNum, String fileName){
        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(130,145,1300,550);
        bgPanel[bgNum].setBackground(null);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);
        
        ImageIcon logo1 = new ImageIcon(getClass().getClassLoader().getResource(fileName));
        
        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0,0,1295,545);
        bgLabel[bgNum].setIcon(logo1);
        
        bgPanel[bgNum].add(bgLabel[bgNum]);
    }
    public void generateCurrentRoom(){
        createBackgroundImage(1,"BG1.jpg");
        createBackgroundImage(2,"BG2.jpg");     
        createBackgroundImage(3,"BG3.jpg");
        createBackgroundImage(4,"BG4.jpg");
        createBackgroundImage(5,"BG3.jpg");
        createBackgroundImage(6,"BG6.jpg");
        createBackgroundImage(7,"shopBG.jpg");
        createBackgroundImage(8,"loss.jpg");
        createBackgroundImage(9,"BG8.jpg");
    }
    
public class TitleScreenHandler implements ActionListener{
		
    public void actionPerformed(ActionEvent event){
			
	createMainField();
        generateCurrentRoom();
        gm.stopMusic();
	}
    }

public void inventoryHandler(){
        
    if(!inventoryOut){
        currentItemStore.setVisible(true);
        inventoryLeft.setVisible(true);
        inventoryRight.setVisible(true);
        
        OP1.setText("Equip");
        OP1.setActionCommand("equipItem");
        
        OP2.setText("Close");
        OP2.setActionCommand("closeBag");  
        
        InventoryToggle.setText("Use");
        InventoryToggle.setActionCommand("useItem"); 
        
        inventoryOut = true;
    }
    
    else if(inventoryOut && gm.CMBT.forInventoryCombat){
        inventoryLeft.setVisible(false);
        inventoryRight.setVisible(false);
        currentItemStore.setVisible(false);
        
        showAutoCMBTUI();
        
        inventoryOut = false;        
    }
    
    else if(inventoryOut && atVillage){
        inventoryLeft.setVisible(false);
        inventoryRight.setVisible(false);
        
        showVillageUI();
        
        inventoryOut = false;        
    }
    
    else if(inventoryOut && atShop){
        inventoryLeft.setVisible(false);
        inventoryRight.setVisible(false);
        currentItemStore.setVisible(false);
        
        showShopEXTUI();
        
        inventoryOut = false;      
    }
      
    else if(inventoryOut){
        inventoryLeft.setVisible(false);
        inventoryRight.setVisible(false);
        currentItemStore.setVisible(false);
        
        showGeneralUI();
        
        inventoryOut = false;        
    }

        
}
public void showAutoCMBTUI(){
        
        
        OP1.setText("Fight");
        OP1.setActionCommand("beginFight");
        
        OP2.setText("Die");
        OP2.setActionCommand("toolAssistedSuicide");
        
        InventoryToggle.setText("Bag");
        InventoryToggle.setActionCommand("Inventory"); 
               
}
public void takeTheL(){
        
        gm.PC.setRoomNumber(39);
        OptionUI.setVisible(false);
        gm.swapper.visibilityModder();
        yap.setText("Close the Game and Retry");
        
        
}
public void showGeneralUI(){
        
        
        OP1.setText("Venture");
        OP1.setActionCommand("moveStory");
        
        OP2.setText("...");
        OP2.setActionCommand("...");
        
        InventoryToggle.setText("Bag");
        InventoryToggle.setActionCommand("Inventory");


}
public void showVillageUI(){
        
        
        OP1.setText("Venture");
        OP1.setActionCommand("moveStory");
        
        OP2.setText("Shop");
        OP2.setActionCommand("enterShop");
        
        InventoryToggle.setText("Bag");
        InventoryToggle.setActionCommand("Inventory"); 

        

}

public void showShopEXTUI(){
        
        
        OP1.setText("Gamble");
        OP1.setActionCommand("Buying");
        
        OP2.setText("Leave");
        OP2.setActionCommand("boogieDown");
               
}

public void showWinUI(){
        
        
        OP1.setText("You");
        OP1.setActionCommand("...");
        
        OP2.setText("Have");
        OP2.setActionCommand("...");
        
        InventoryToggle.setText("Won!");
        InventoryToggle.setActionCommand("Win"); 
               
}

public void shimmyDirectional(){
    currentItem.setText("current Item:" + gm.PC.inventory.get(currentItemNo).returnNAME());
    }
}
