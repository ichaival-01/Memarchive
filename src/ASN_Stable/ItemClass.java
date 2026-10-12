package ASN_Stable;
public class ItemClass {
    ASN_Execute gm;
    private String name;
    private String type;
    public int typeID;
    private String desc;
    private int dura;
    private boolean isWearable;
    private boolean hasRange;
    private int dmg;
    private int def;
    private int heal;
    private int sustain;
    
public ItemClass(ASN_Execute gm) {
    this.gm = gm;
    name = "Item";
    type = "Consumable";
    desc = "For Debugging purposes! :D";
    dura = 1;
    isWearable =false;
    hasRange = false;
    dmg = 0;
    def = 0; 
    heal = 1;
    sustain = 1;
}

public ItemClass(String iName,String myType, int typID, String descriptor,int drrrability, boolean clothes,boolean ranja, int values, int shield, int healthy, int sus){
    name = iName;
    type = myType;
    typeID = typID;
    desc =  descriptor;
    dura = drrrability;
    isWearable = clothes;
    hasRange = ranja;
    dmg = values;
    def = shield;
    heal = healthy;
    sustain = sus;
}

public int returnDurability(){
    return dura;
}
public void usedItems(ItemClass item){
    if(item.dura >0){
        item.dura = item.dura - 1;  
        gm.PC.healItems(item.heal, item.sustain);
        gm.enemies.takeDMG(item.dmg);
        } 
    else if (item.dura <1 ){
        breakItem(item);
        }

    }

public void breakItem(ItemClass item){
    for (int i =0; i <gm.PC.inventory.size(); i++){
        if(gm.PC.inventory.get(i).returnDurability()<1){
            gm.PC.inventory.remove(i);
            }
        }
    }

public boolean returnWear(){
    return isWearable;
    }
public String returnNAME(){
    return name;
}
public int returnATK(){
    return dmg;
}
public int returnDEF(){
    return def;
}
public String returnType(){
    return type;
}

}

