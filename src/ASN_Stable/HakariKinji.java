package ASN_Stable;
import java.util.*;

public class HakariKinji {
    ASN_Execute gm;
    Random itemPicker = new Random();
    
    public HakariKinji(ASN_Execute gm){
    this.gm = gm;
}
    public void giveRandomItem(){
        if(gm.PC.giveGOLD() <10 || gm.PC.inventory.size() ==16){
            gm.UI.yap.setText("I'm too broke/loaded, better luck next time");
            System.out.println("Bro you're broke/have too much stuff, please leave");
        }
        else{
        gm.PC.moneyDown(10);
        int randomItem = itemPicker.nextInt(34)+1;
///////////////////CONSUMABLE ITEMS/////////////////////////////////////////////////////////////////////        

        //Potions
        ItemClass cheapPot  = new ItemClass("Cheap Potion","Consumable",1, "A cheap potion. Smells like iron.",1, false,false, 0, 0, 10, 1);
        ItemClass regPot  = new ItemClass("Health Potion","Consumable",1, "A regular potion. It has a pungent floral scent.",1, false,false, 0, 0, 30, 1);
        ItemClass HighPot = new ItemClass("High Potion","Consumable",1, "An expensive potion. Your wallet cries in agony.",1, false, false, 0, 0, 60, 2);
        //
        
        //Food Items
        ItemClass bred = new ItemClass("Bread","Consumable",1, "A stale loaf of bread",1,false, false, 0, 0, 0, 3);
        ItemClass cordonBleu = new ItemClass("Expensive Food","Consumable",1, "An overpriced Salad.",1,false,false, 0, 0, 0, 6);
        //
        
        //Misc Consumables
        ItemClass StrangeCard  = new ItemClass("Strange Card","Consumable",1, "'I'm Counting on you, Persona!'",1, false,false,99999999 , 0, 0, 0);
        ItemClass FakePapers  = new ItemClass("Forged Documents","Consumable",1, "Might trick a government official.",1, false,false,99999999 , 0, 0, 0);
        ItemClass waterBucket  = new ItemClass("Water Bucket","Consumable",1, "A rock's worst nightmare",1, false,false,99999999 , 0, 0, 0);
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////      

///////////////////WEAPONS ///////////////////////////////////////////////////////////////////// 

        //Metal Shit weapons
        ItemClass mStick = new ItemClass("Metal Baton","Weapon",2, "A lightweight lump of metal.",99999999,true,false, 4, 0, 0, 0);
        ItemClass mBigStick = new ItemClass("Metal Staff","Weapon",2, "A lightweight lump of metal.",99999999,true,true,  6, 0, 0, 0);
        ItemClass mCircle = new ItemClass("Metal Circle","Weapon",2, "A lightweight lump of metal.",99999999,true,false, 2, 5, 0, 0);
        ItemClass mSlingshot = new ItemClass("Metal Slingshot","Weapon",2, "A lightweight lump of sparking metal.",99999999,true,true, 2, 0, 0, 0);
        //
        
        //Regular Shitty weapons
        ItemClass wStick = new ItemClass("Copper Sword","Weapon",2, "A slightly heavier lump of metal.",20,true,false, 6, 0, 0, 0);
        ItemClass wBigStick = new ItemClass("Stone Spear","Weapon",2, "A stick with a sharp rock.",25,true,true,8, 0, 0, 0);
        ItemClass wCircle = new ItemClass("Rusted Shield","Weapon",2, "A lightweight lump of metal.",40,true,false, 3, 3, 0, 0);
        ItemClass wSlingshot = new ItemClass("Wooden Bow","Weapon",2, "A shoddy wooden bow, looks weak.",10,true,true, 6, 0, 0, 0);     
        //
        
        //Decent weapons
        ItemClass dStick = new ItemClass("Steel Flamberge","Weapon",2, "A slithering sword,Good for slashes.",40,true,false, 10, 0, 0, 0);
        ItemClass dBigStick = new ItemClass("Aluminum Halberd","Weapon",2, "An incredibly powerful spear/axe hybrid.",60,true,true,14, 0, 0, 0);
        ItemClass dCircle = new ItemClass("Tungsten Nguni","Weapon",2, "A solid and sturdy Shield.",90,true,false, 6, 10, 0, 0);
        ItemClass dSlingshot = new ItemClass("Iron Crossbow","Weapon",2, "A powerful trigger-powered ranged weapon.",30,true,true, 10, 0, 0, 0);     
        //
        
        //Super weapons
        ItemClass pStick = new ItemClass("Admantite Falchion","Weapon",2, "A formidable sword at the pinnacle of slashing.",80,true,false, 18, 0, 0, 0);
        ItemClass pBigStick = new ItemClass("Adamantite Glaive","Weapon",2, "A true weapon for a spearman.",120,true,true,28, 0, 0, 0);
        ItemClass pCircle = new ItemClass("Adamantite Kite","Weapon",2, "A truly formidable wall in your hand.",180,true,false, 10, 17, 0, 0);
        ItemClass pSlingshot = new ItemClass("Adamantite Longbow","Weapon",2, "An archer's prised longbow.",50,true,true, 18, 0, 0, 0);     
        //
        
        //Endgame weapons
        ItemClass eStick = new ItemClass("Astral Chainsaw","Weapon",2, "A strange yet dominating swordlike weapon.",99999999,true,false, 40, 0, 0, 0);
        ItemClass eBigStick = new ItemClass("Astral Spear","Weapon",2, "A true weapon for a spearman.",99999999,true,true,96, 0, 0, 0);
        ItemClass eCircle = new ItemClass("Astral Ballistic Shield ","Weapon", 2, "A strange yet indomitable wall.",99999999,true,false, 50, 40, 0, 0);
        ItemClass eSlingshot = new ItemClass("Astral Gun","Weapon",2, "A weapon that channels the fury of the stars.",99999999,true,true, 100, 0, 0, 0); 
        //             
        
        //Forgot to add fists and armor
        ItemClass fistcuffs = new ItemClass("Fists","Weapon",2,"Sometimes doing it yourself is best.",99999999, true, false, 0,0,0,0);
        ItemClass rags = new ItemClass("Rags", "Armor",3, "The humble rags",99999999,true,false,0,10,0,0);
        ItemClass ILArmor = new ItemClass("Ranger outfit","Armor",3,"Leather outfitting paired with iron pauldrons",99999999,true,false,0,30,0,0);
        ItemClass AstrArmor = new ItemClass("Astral Armor","Armor",3,"A nebula of defence adorned on you",99999999,true,false,0,90,0,0);
////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////KEY ITEMS/////////////////////////////////////////////////////////////////// 

        ItemClass secondHand = new ItemClass("Second Hand",  "Key",4, "A strange starry clock's second hand.",99999999, false, false, 0, 0 ,0 ,0);
        ItemClass minuteHand = new ItemClass("Minute Hand",  "Key",4, "A strange starry clock's minute hand.",99999999, false, false, 0, 0 ,0 ,0);
        ItemClass hourHand = new ItemClass("Hour Hand",  "Key",4, "A strange starry clock's hour hand.",99999999, false, false, 0, 0 ,0 ,0);    
        ItemClass brokenClock = new ItemClass("Broken Clock",  "Key",4, "A strange starry clock. It rewinds the Bomb Tower,",99999999, false, false, 0, 0 ,0 ,0);
        //////////////////////////////////////
        
        ItemClass MysteriousKey = new ItemClass("Golden Key","Key",4, "A radiant golden key.",99999999, false, false, 0, 0 ,0 ,0);    
////////////////////////////////////////////////////////////////////////////////////////////////   

///////////////DEBUG ITEM////////////////////////////////////////////////////////////////////
        ItemClass debugStick = new ItemClass("Debug","Key",4, "Debugging purposes :D",2, true, true, 99999999,99999999,99999999,99999999);
        ItemClass slaveChildren = new ItemClass("Child of Slave", "Key",4, "Debugging purposes :D",2, true, true, 99999999,99999999,99999999,99999999);     
/////////////////////////////////////////////////////////////////////////////////////////////       
//////////////MERCS//////////////////////////////////////////////////////////////////////////        
        NPCClass ElfBow  = new NPCClass("Elric", 500,90, 36, 40);
        NPCClass PotsAndPans  = new NPCClass("Arven", 1200,0,100, 10);
        NPCClass uselessSwordsman = new NPCClass("Grayden",700,120,150, 30);
        NPCClass literalDeity = new NPCClass("Chronos", 26000,4000,2000,99999);
///////////////////ENEMIES ///////////////////////////////////////////////////////////////////// 
        
        switch(randomItem){
            case(1):
                gm.PC.addItems(cheapPot);
                break;
            case(2):
                gm.PC.addItems(mStick); 
                break;                
            case(3):
                gm.PC.addItems(mBigStick);
                break;                
            case(4):
                gm.PC.addItems(mCircle);
                break;
            case(5):
                gm.PC.addItems(mSlingshot); 
                break;
            case(6):
                gm.PC.addItems(wStick);  
                break;
            case(7):
                gm.PC.addItems(wBigStick);
                break;
            case(8):
                gm.PC.addItems(wCircle); 
                break;
            case(9):
                gm.PC.addItems(wSlingshot);  
                break;
            case(10):
                gm.PC.addItems(dStick);
                break;
            case(11):
                gm.PC.addItems(dBigStick); 
                break;
            case(12):
                gm.PC.addItems(dCircle);  
                break;
            case(13):
                gm.PC.addItems(dSlingshot);
                break;
            case(14):
                gm.PC.addItems(pStick); 
                break;
            case(15):
                gm.PC.addItems(pBigStick); 
                break;
            case(16):
                gm.PC.addItems(pCircle);
                break;
            case(17):
                gm.PC.addItems(pSlingshot); 
                break;
            case(18):
                gm.PC.addItems(eStick);
                break;
            case(19):
                gm.PC.addItems(eBigStick);
                break;
            case(20):
                gm.PC.addItems(eCircle);
                break;
            case(21):
                gm.PC.addItems(eSlingshot);  
                break;
            case(22):
                gm.PC.addItems(ILArmor);
                break; 
            case(23):
                gm.PC.addItems(AstrArmor); 
                break;
            case(24):
                gm.PC.addItems(MysteriousKey);  
            case(25):
                gm.PC.addItems(slaveChildren);
                break;
            case(26):
                gm.PC.addItems(regPot); 
                break;
            case(27):
                gm.PC.addItems(HighPot);  
                break;
            case(28):
                gm.PC.addItems(bred);
                break;
            case(29):
                gm.PC.addItems(cordonBleu); 
                break;
            case(30):
                gm.PC.addItems(StrangeCard);  
                break;
            case(31):
                gm.PC.addItems(FakePapers);
                break;
            case(32):
                gm.PC.addItems(waterBucket); 
                break;
            case(33):
                gm.PC.addParty(ElfBow);  
                break;
            case(34):
                gm.PC.addParty(PotsAndPans);    
                break;
            case(35):
                gm.PC.addParty(uselessSwordsman);    
                break;            
            default:
            System.out.println("Please never see this");
            }
        }   
    }
}
