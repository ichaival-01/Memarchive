/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASN_Stable;

/**
 *
 * @author ahmeda012
 */
public class EnemyClass {
    ASN_Execute gm;
    private String name = "";
    private int HP;
    private int ATK;
    private int DEF;
    private int SPD; 
    private int EXP;
    public boolean isParrying;
//Constructor method
public EnemyClass(ASN_Execute gm){
    this.gm = gm;
    name ="";
    HP = 1;
    ATK = 0;
    DEF =0;
    SPD =0;
    EXP = 0;
}
//Instance Method
public EnemyClass(String n, int h, int a, int d, int s, int e){
    name = n;
    HP = h;
    ATK = a;
    DEF = d;
    SPD = s;
    EXP = e;
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
public void setXP (int moneymoneymoneymoney){
    EXP = moneymoneymoneymoney;
}
public String giveName(){
    return name;
}
public int giveDEF(){
    return DEF;
}
public int giveHP(){
    return HP;
}
public int giveATK(){
    return ATK;
}
public int giveSPD(){
    return SPD;
}
public int giveXP(){
    return EXP;
}
public void takeDMG(int ow){
    if(ow>0){
        HP -= ow;       
    }
    else{}
}

public String toString(){
    String str = "Name: " + name 
        +"\n HP:" + HP
        +"\n STR:" + ATK            
        +"\n DEF:" + DEF
        +"\n SPD:" + SPD            
        +"\n XP:" + EXP;         
    
    return str;
}
}//end of class

