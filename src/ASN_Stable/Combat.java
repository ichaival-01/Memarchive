package ASN_Stable;
import java.util.*;

public class Combat {
    
    ASN_Execute gm;
    public boolean inCombat;
    public boolean forInventoryCombat;
    private boolean pcActed = false;
    private boolean enemyActed = false;
    private boolean enemyAttacked;
    int partyDMG;
    int partyDEF;
    int partySPD;
    int chosen;
    EnemyClass currentThreat;
    Random rollForDMG = new Random();
    Random mySkin = new Random();
    Random goldGen = new Random();
    Random autoBattler = new Random();
    int currentRoom;
    
    public Combat(ASN_Execute gm){
        this.gm  = gm;
    }

    public void setupEnemy(int roomNum){
       nME(roomNum);
       forInventoryCombat = true;
    }
    
    public void startUpCombat(){
        partyDMG = gm.PC.giveSTR();
        partyDEF = gm.PC.giveDEF();
        partySPD = gm.PC.giveSPD();
        inCombat=true;
        currentPartyStats();
        combatStart();
        
    }
    public void currentPartyStats(){
        for(int i =0; i<gm.PC.party.size(); i++){
            int PD = gm.PC.party.get(i).returnDMG();
            int PT = gm.PC.party.get(i).returnDEF();
            int PS = gm.PC.party.get(i).returnSPD();
            partyDMG += PD; 
            partyDEF += PT;
            partySPD += PS;  
            }
        }

public void combatStart(){
    while(inCombat){
        System.out.println("you've officially entered combat");
            if(!pcActed){
                if(gm.PC.giveHP() <1){
                    System.out.println("You died");
                    pcLose();
                    break;
                }            
                if(currentThreat.giveHP() <1){
                    System.out.println("You won!");
                    pcWin(currentThreat.giveXP());
                    break;
                }       
                
                playerTurn();
                System.out.println("Enemy's Current HP: " + currentThreat.giveHP());
                
     
            }
            if(!enemyActed){
                if(gm.PC.giveHP() <1){
                    System.out.println("You died");
                    pcLose();
                    break;
                }            
                if(currentThreat.giveHP() <1){
                    System.out.println("You won!");
                    pcWin(currentThreat.giveXP());
                    break;
                } 
                
               
                enemyTurn();
                System.out.println(gm.PC.giveHP());            
                
 
            }
                pcActed =false;
                enemyActed =false;
                System.out.println("Current PC HP: " + gm.PC.giveHP() +"\nCurrent Enemy HP: " + currentThreat.giveHP());    
                System.out.println("=============================================");
            }
        }
    


public void playerTurn(){
    int choice = autoBattler.nextInt(2);
    if(choice ==0){
        pcAttack();
        System.out.println("You Attacked!");
    }
    if(choice ==1){
        pcParry();
        System.out.println("You readied a Parry!");        
    }
    pcActed = true;
    }   

public void enemyTurn(){
    int choice = autoBattler.nextInt(2);
    if(choice ==0){
        enemAttack();
    }
    if(choice ==1){
        System.out.println(currentThreat.giveName() + "Is just standing there stupidly.");  
    }
    if(gm.PC.isParrying  && enemyAttacked){
        pcParry();
        }
    enemyAttacked = false;
    enemyActed = true;
    }   

public void pcWin(int xp){
    inCombat = false;
    gm.PC.gainXP(xp);
    gm.PC.moneyUp(goldGen.nextInt(100)+1);
    gm.PC.boopRoomNumber();
    forInventoryCombat = false;
    gm.UI.enemyStore.setVisible(false);
    gm.swapper.visibilityModder(); 
}
public void pcLose(){
    inCombat = false;
    gm.UI.takeTheL();
    
}    

//Events
    public void pcAttack(){
        int crit = rollForDMG.nextInt(10);
        if(crit >= 7){
            partyDMG = partyDMG*2;
        }
        currentThreat.takeDMG(partyDMG);           

    }
    
    public void enemAttack(){
        int crit = rollForDMG.nextInt(10);
        int opDMG = 0;
        if(crit >= 4){
            opDMG = currentThreat.giveATK()*2;
        }
        else{
            opDMG = currentThreat.giveATK();
        }
        if(!gm.PC.isParrying){
        gm.PC.takeDMG(opDMG  - partyDEF);
        enemyAttacked = true;          
        System.out.println(currentThreat.giveName() + " Attacked!");
        }
        else{
           currentThreat.takeDMG(opDMG);
            gm.PC.isParrying = false;
            System.out.println(currentThreat.giveName() + " was Parried!");
        }
    }    
    
    public void pcParry(){
        gm.PC.isParrying = true;
    }
    

    
    public EnemyClass nME(int CR){
        chosen = mySkin.nextInt(2);
        if(CR == 2 || CR ==3){
            currentThreat = new EnemyClass("Astrageldon",50,5,1,3,35);
        } 
        if (CR == 5){
            if(chosen ==0){
                currentThreat = new EnemyClass("Goblin",30,10,3,5,60);
            }
            if(chosen ==1){
                currentThreat = new EnemyClass("Sentry Golem",50,15,20,1,80);
            }
        }
        if (CR == 7){
            currentThreat = new EnemyClass("Golem", 100, 30, 50, 1, 120);
            }        
        if (CR == 10){
            if(chosen ==0){
                currentThreat = new EnemyClass("Elf hunter", 40, 15, 5,7, 50);
            }
            if(chosen ==1){
                currentThreat = new EnemyClass("Elf Ranger", 40, 20, 3, 9, 55);
            }  
        } 
        if (CR == 12){
            currentThreat = new EnemyClass("Ent",80, 40, 40, 2, 240);
            }         
        if (CR == 15){
            if(chosen ==0){
                currentThreat = new EnemyClass("Wyvern", 120, 50, 30, 30, 70);
            }
            if(chosen ==1){
                currentThreat = new EnemyClass("Griffin", 120, 40, 20, 70, 80);
            } 
        }
        if (CR == 17){
            currentThreat = new EnemyClass("Dragon", 400, 90, 80, 80, 360);       
            }
            
        if (CR == 19){
            currentThreat = new EnemyClass("Chronos", 8000, 200, 0, 99, 1);
            }                   
    return currentThreat;
    }

}
