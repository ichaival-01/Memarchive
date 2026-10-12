package ASN_Stable;
import java.awt.event.*;
import java.net.*;
import java.util.HashSet;
import java.util.Set;
import java.io.*;

public class ASN_Execute {
    
    YouEye UI = new YouEye(this);
    NPCClass NPC = new NPCClass();
    PlayerClass PC = new PlayerClass(this);
    SceneChanger swapper = new SceneChanger(this);
    Music music = new Music();
    URL currentBGM;
    Combat CMBT = new Combat(this);
    ActionHandler aHandler = new ActionHandler(this);
    EnemyClass enemies = new EnemyClass(this);
    ItemClass items = new ItemClass(this);
    HakariKinji shopMech = new HakariKinji(this);
    
    ///MUSIC
    URL TandE = getClass().getClassLoader().getResource("Tandem.wav");
    URL BGMVill = getClass().getClassLoader().getResource("BGM2.wav");
    URL BGMForr = getClass().getClassLoader().getResource("BGM1.wav");
    URL BGMCMBT1 = getClass().getClassLoader().getResource("BasicCMBT.wav");
    URL BGMCMBT2 = getClass().getClassLoader().getResource("HardestFightOAT.wav");
    URL BGMCMBT3 = getClass().getClassLoader().getResource("BGM3.wav");
    URL BGMCMBT4 = getClass().getClassLoader().getResource("BGM4.wav");
    URL BGMCMBT5 = getClass().getClassLoader().getResource("BGM5.wav");
    URL SHOP = getClass().getClassLoader().getResource("Shop.wav");
    URL BGMDETH = getClass().getClassLoader().getResource("DBGM.wav");
    
    public static void main (String[] args){
        
        new ASN_Execute();
        System.err.close();
        
    }
    
    public ASN_Execute() {
	
        currentBGM = TandE; 
	playMusic(currentBGM);
    }   
    public void playMusic(URL url){
        music.setFile(url);
	music.play();
	music.loop();
    }
    public void stopMusic() {	
	music.stop();
    }
    
    public void youWin() throws IOException{
        PrintWriter winner = new PrintWriter(new File("Congrats.txt"));
        
        winner.println("Congrats on winning this horrible game! I appreciate that you took the time to struggle(?) over it lol");
        winner.println("Thank you for playing, now buhbye!");
    }
}
   