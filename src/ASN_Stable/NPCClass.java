package ASN_Stable;

public class NPCClass {
    private String name = "";
    private int HP;
    private int ATK;
    private int DEF;
    private int SPD; 
//Constructor method
public NPCClass() {
    name ="";
    HP = 1;
    ATK = 0;
    DEF =0;
    SPD =0;
}
//Instance Method
public NPCClass(String n, int h,int a, int d, int s){
    name = n;
    HP = h;
    ATK = a;
    DEF = d;
    SPD = s;
}
///Setting all the values for the characters
public void setName(String nam){
    name = nam;
}
public void setHP(int healf){
    HP = healf;
}
public void setDEF(int def){
    DEF = def;
}
public void setSPD(int sped){
    SPD = sped;
}

public int returnDMG(){
    return ATK;
}

public int returnHP(){
    return HP;
}

public int returnDEF(){
    return DEF;
}

public int returnSPD(){
    return SPD;
}
}//end of class