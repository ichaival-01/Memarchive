package ASN_Stable;
import java.util.*;

public class PlayerClass {  
    ASN_Execute gm; 
    private int LVL;
    private int HP;
    private int MHP;
    private int STR;
    private int DEF;
    private int SPD;
    private int MXP;
    private int EXP;
    private int GLD;
    private int FOD;
    private int ROM;
    private int ARM;
    private int WEP;
    public boolean isParrying;
    ArrayList <ItemClass> inventory = new ArrayList<>(16);
    ArrayList <NPCClass> party = new ArrayList<>(2);
    ArrayList <ItemClass> equipment = new ArrayList<>(2);
    
//Constructor method
public PlayerClass(ASN_Execute gm){
    this.gm = gm;
    HP = 10;
    MHP = HP;
    LVL = 1;
    STR = 10;
    DEF =2;
    SPD =1;
    EXP = 0;
    GLD = 0;
    FOD = 10;  
    ROM = 0;
    ARM = 0;
    WEP = 0;
    startingEquipment();
}
///Setting all the values for the characters
public void setDEF(int def){
    DEF += def;
}
public void setATK (int dmg){
    STR += dmg;
}
public void setRoomNumber (int RN){
    ROM = RN;
}
public void boopRoomNumber(){
    ROM = ROM+1;
}
public int giveHP(){
    return HP;
}
public int giveXP (){
    return EXP;
}
public int giveFOOD(){
    return FOD;
}
public int giveGOLD(){
    return GLD;
}
public int giveDEF(){
    return DEF;
}
public int giveSTR(){
    return STR;
}
public int giveSPD(){
    return SPD;
}
public void gainXP(int amount){
    EXP = EXP + amount;
    while (EXP >= 100){
       increaseLevel();
       EXP -= 100;
    }
}

public void increaseLevel(){
    LVL++;
    Random iMadeLevelUpsPurelyLuckBased = new Random();
    MHP += iMadeLevelUpsPurelyLuckBased.nextInt(10)+1;
    STR += 10;
    DEF += iMadeLevelUpsPurelyLuckBased.nextInt(10);
    SPD += iMadeLevelUpsPurelyLuckBased.nextInt(10);
    levelUpHeal();
    }

public void healItems(int a, int b){
    HP = HP + a;
    FOD = FOD + b;
    }

public void moneyUp(int g){
    GLD = GLD + g;
    }

public void moneyDown (int g){
    GLD = GLD -  g;
}
public void addItems(ItemClass item){
    inventory.add(item);
    sortInventory(inventory);
}

public void addParty(NPCClass team){
    party.add(team);
}
public void levelUpHeal(){
    HP = MHP;
}
public void swapEquip(ItemClass swapper){
    for(int curItem=0; curItem<equipment.size();curItem++){
        if(swapper.returnType().equalsIgnoreCase(equipment.get(curItem).returnType())){
            equipment.set(curItem,swapper);
            if(swapper.returnType().equalsIgnoreCase("Armor")){
                ARM--;
            }
            if(swapper.returnType().equalsIgnoreCase("Weapon")){
                WEP--;
            }
        }
    }
}
public void equipItem(ItemClass item){
    
    if(item.returnWear()){
        if (item.returnType().equalsIgnoreCase("Armor")){
            ARM++;
            if(ARM >1||WEP>1){
            swapEquip(item);
        }
            else{
            equipment.add(item);
            }
        }
        else if(item.returnType().equalsIgnoreCase("Weapon")){
            WEP++;
            if(ARM >1||WEP>1){
            swapEquip(item);
        }
            else{
            equipment.add(item);
            }            
        }
        inventory.remove(item);
        equipmentBuff();
    }
    else{        
        System.out.println("This isn't an equipabble bro...");
    }
}
public void moveRooms(){
    ROM++;
}

public int returnRoom(){
    return ROM;
}

public void takeDMG(int pain){
    if(pain >0){
    HP -= pain;   
    }
    else{}

}

public void equipmentBuff(){
    for (int i=0; i<equipment.size(); i++){
        setATK(equipment.get(i).returnATK());
        setDEF(equipment.get(i).returnDEF());
    }
}
public String toString(){
    String str = " STR:" + STR 
        +"\n Max HP:" + MHP
        +"\n HP: " + HP    
        +"\n DEF:" + DEF
        +"\n SPD:" + SPD     
        +"\n LVL:" + LVL     
        +"\n XP:" + EXP;         
    
    return str;
}

public void startingEquipment(){
    ItemClass fistcuffs = new ItemClass("Fists","Weapon",2,"Sometimes doing it yourself is best.",99999999, true, false, 0,0,0,0);
    ItemClass placeholder = new ItemClass("None","Consumable",1,"Null and Void",99999999, true, false, 0,0,0,0);
    ItemClass rags = new ItemClass("Rags", "Armor",3, "The humble rags",99999999,true,false,0,2,0,0);
    ItemClass cheapPot  = new ItemClass("Cheap Potion","Consumable",1, "A cheap potion. Smells like iron.",1, false,false, 0, 0, 10, 1);
    ItemClass bred = new ItemClass("Bread","Consumable",1, "A stale loaf of bread",1,false, false, 0, 0, 0, 3);
    equipItem(fistcuffs);
    equipItem(rags);
    inventory.add(placeholder);
    inventory.add(cheapPot);
    inventory.add(bred);
       
}

public void sortInventory(ArrayList <ItemClass> inventory){
    int index = 0;
    boolean itemSwapped = true;
    
    while((index < inventory.size() - 1)&& itemSwapped ){
        itemSwapped = false;
        index++;
        for (int i =0; i<inventory.size() - index; i++){
            if(inventory.get(i).typeID > inventory.get(i+1).typeID){
                swap(inventory, i, i+1);
                itemSwapped = true;
            }
        }
        
    }
}

public void swap(ArrayList <ItemClass> inventory, int b, int s){
   ItemClass temp = inventory.get(b);
   inventory.set(b,inventory.get(s));
   inventory.set(s, temp);
}

}//end of class