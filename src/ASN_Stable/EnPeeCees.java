package ASN_Stable;
public class EnPeeCees {
    
    ASN_Execute gm;
    
    public EnPeeCees(ASN_Execute gm){
        this.gm = gm;
        createNPCS();
    }
    
    public static void createNPCS(){
//////////////MERCS//////////////////////////////////////////////////////////////////////////        
        NPCClass ElfBow  = new NPCClass("Elric", 500,90, 36, 40);
        NPCClass PotsAndPans  = new NPCClass("Arven", 1200,0,100, 10);
        NPCClass uselessSwordsman = new NPCClass("Grayden",700,120,150, 30);
        NPCClass literalDeity = new NPCClass("Chronos", 26000,4000,2000,99999);
///////////////////ENEMIES ///////////////////////////////////////////////////////////////////// 
        //Shit tutorial Enemy
        EnemyClass slime = new EnemyClass("Astrageldon",50,5,1,3,35);
        
        //Quest 1 enemies
        EnemyClass Goblinsky = new EnemyClass("Goblin",30,10,3,5,60);
        EnemyClass shitGolem = new EnemyClass("Sentry Golem",50,15,20,1,80);
        EnemyClass boss1 = new EnemyClass("Golem", 100, 30, 50, 1, 120);
        
        //Quest 2 Enemies
        EnemyClass stabElf = new EnemyClass("Elf hunter", 40, 15, 5,7, 50);
        EnemyClass shootElf = new EnemyClass("Elf Ranger", 40, 20, 3, 9, 55);
        EnemyClass boss2 = new EnemyClass("Ent",80, 40, 40, 2, 240);
        
        //Quest 3 Enemies
        EnemyClass betaDrago = new EnemyClass("Wyvern", 120, 50, 30, 30, 70);
        EnemyClass peter = new EnemyClass("Griffin", 120, 40, 20, 70, 80);
        EnemyClass boss3 = new EnemyClass("Dragon", 400, 90, 80, 80, 360);
        
        //Final Boss(es)
        EnemyClass literalTimeBender = new EnemyClass("Chronos", 8000, 200, 0, 99, 1);
        EnemyClass secretFinalBoss = new EnemyClass("Sisyphus", 12000, 300, 0, 99, -1);
        
////////////////////////////////////////////////////////////////////////////////////////////////

///////////////DEBUG NPCS///////////////////////////////////////////////////////////////////
        NPCClass debugMerc = new NPCClass("debug", 999999999,999999999,999999999,999999999);
        EnemyClass debugEnemy = new EnemyClass("debug", 999999999, 999999999, 999999999,999999999,999999999);
/////////////////////////////////////////////////////////////////////////////////////////////        
    }
}

