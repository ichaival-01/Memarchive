package ASN_Stable;

public class SceneChanger {
    
    ASN_Execute gm;
    
    public SceneChanger(ASN_Execute gm){
        this.gm = gm;
    }
    
    public void visibilityModder(){  
        if((gm.PC.returnRoom() == 0) ||(gm.PC.returnRoom() == 1)||(gm.PC.returnRoom() == 4) ||(gm.PC.returnRoom() == 6) ||(gm.PC.returnRoom() == 9)||(gm.PC.returnRoom() == 11)||(gm.PC.returnRoom() == 14)||(gm.PC.returnRoom() == 16)){
            gm.UI.atVillage = false;
            gm.UI.atShop = false;
            showForest();
            if(gm.PC.returnRoom() >2){
                if(gm.UI.enemyStore.isVisible() == true){
                    gm.UI.enemyStore.setVisible(false);
                }
            }
            gm.UI.showGeneralUI();
            gm.stopMusic();
            gm.currentBGM = gm.BGMForr;
            gm.playMusic(gm.currentBGM);
            gm.UI.yap.setText("The enchanted forest is quaint but relaxing...");
        }
        if((gm.PC.returnRoom() == 3) ||(gm.PC.returnRoom() == 8)||(gm.PC.returnRoom() == 13)){
            showVillage();
            gm.UI.atVillage = true;
            gm.UI.atShop = false;
            gm.UI.showVillageUI();
            gm.stopMusic();
            gm.currentBGM = gm.BGMVill;
            gm.playMusic(gm.currentBGM);
            gm.UI.yap.setText("The same, repeating village. Over and Over again. \n What do I do here?");
        }    
        if((gm.PC.returnRoom() == 5)||(gm.PC.returnRoom() == 10)||(gm.PC.returnRoom() == 15)){
            gm.UI.atVillage = false;
            gm.UI.atShop = false;
            gm.UI.showAutoCMBTUI();
            gm.CMBT.setupEnemy(gm.PC.returnRoom());
            createEnemyIcon(gm.CMBT.chosen);
            gm.stopMusic();
            gm.currentBGM = gm.BGMCMBT1;
            gm.playMusic(gm.currentBGM);
            gm.UI.yap.setText("\nA(n) " + gm.CMBT.currentThreat.giveName() + " Approaches!\nWhat do you do?");
        }
        if(((gm.PC.returnRoom() == 2) ||gm.PC.returnRoom() == 7) ||(gm.PC.returnRoom() == 12)||(gm.PC.returnRoom() == 17)||(gm.PC.returnRoom() == 19)){
            gm.UI.atVillage = false;
            gm.UI.atShop = false;
            gm.UI.showAutoCMBTUI();
            gm.CMBT.setupEnemy(gm.PC.returnRoom());
            createSpecialEnemyIcon();
            gm.stopMusic();
            switch(gm.PC.returnRoom()) {
                case 2:
                    gm.currentBGM = gm.BGMCMBT2;
                    break;
                case 7:
                    gm.currentBGM = gm.BGMCMBT3;
                    break;
                case 12:
                    gm.currentBGM = gm.BGMCMBT4;
                    break;
                case 17:
                    gm.currentBGM = gm.BGMCMBT2;
                    break;
                case 19:
                    gm.currentBGM = gm.BGMCMBT5;
                    break;
                default:
                    break;
            }
            gm.playMusic(gm.currentBGM);
            gm.UI.yap.setText("\nA(n) " + gm.CMBT.currentThreat.giveName() + " Approaches!\nWhat do you do?");
        }
        if(gm.PC.returnRoom() == 18){
           gm.UI.atVillage = false;
           gm.UI.atShop = false;
           gm.UI.showGeneralUI();
           showDeath();
           gm.stopMusic();
           gm.currentBGM = gm.TandE;
           gm.playMusic(gm.currentBGM);
           gm.UI.yap.setText("So you've arrived, regressor of ole. I admit I am quite intrigued by your ingenuity, now come forth and face me.");
        }
        if(gm.PC.returnRoom() == 20){
           gm.UI.atVillage = false;
           gm.UI.atShop = false;
           gm.UI.showWinUI();
           showWin();
           gm.stopMusic();
           gm.currentBGM = gm.TandE;
           gm.playMusic(gm.currentBGM);
           gm.UI.yap.setText("You've been freed from this nightmare, never take it for granted...");
        }
        if(gm.PC.returnRoom() == 38){
           gm.UI.atVillage = false;
            gm.UI.atShop = true;
            gm.UI.showShopEXTUI();
            showShop();
            gm.stopMusic();
            gm.currentBGM = gm.SHOP;
            gm.playMusic(gm.currentBGM);
            gm.UI.yap.setText("Time to buy junk");
        }
        if(gm.PC.returnRoom() == 39){
            showLoss();
            gm.stopMusic();
            gm.currentBGM = gm.BGMDETH;
            gm.playMusic(gm.currentBGM);
            gm.UI.yap.setText("Close the game to restart");
        }
    }

    public void showForest(){
           gm.UI.bgPanel[1].setVisible(true);
           gm.UI.bgPanel[2].setVisible(false);
           gm.UI.bgPanel[3].setVisible(false);
           gm.UI.bgPanel[4].setVisible(false);
           gm.UI.bgPanel[5].setVisible(false); //cave2
           gm.UI.bgPanel[6].setVisible(false); //castle
           gm.UI.bgPanel[7].setVisible(false); //clock
           gm.UI.bgPanel[8].setVisible(false); 
           
    }
    
    public void showVillage(){
           gm.UI.bgPanel[1].setVisible(false);
           gm.UI.bgPanel[2].setVisible(true);
           gm.UI.bgPanel[3].setVisible(false);
           gm.UI.bgPanel[4].setVisible(false);
           gm.UI.bgPanel[5].setVisible(false);
           gm.UI.bgPanel[6].setVisible(false);
           gm.UI.bgPanel[7].setVisible(false);
           gm.UI.bgPanel[8].setVisible(false); 
    }
    public void showDeath(){
           gm.UI.bgPanel[1].setVisible(false);
           gm.UI.bgPanel[2].setVisible(false);
           gm.UI.bgPanel[3].setVisible(false);
           gm.UI.bgPanel[4].setVisible(false);
           gm.UI.bgPanel[5].setVisible(false);
           gm.UI.bgPanel[6].setVisible(true);
           gm.UI.bgPanel[7].setVisible(false); 
           gm.UI.bgPanel[8].setVisible(false);
           
    }        
    public void showShop(){
           gm.UI.bgPanel[1].setVisible(false);
           gm.UI.bgPanel[2].setVisible(false);
           gm.UI.bgPanel[3].setVisible(false);
           gm.UI.bgPanel[4].setVisible(false);
           gm.UI.bgPanel[5].setVisible(false);
           gm.UI.bgPanel[6].setVisible(false);
           gm.UI.bgPanel[7].setVisible(true);
           gm.UI.bgPanel[8].setVisible(false);
    }       
    
    public void showLoss(){
           gm.UI.bgPanel[1].setVisible(false);
           gm.UI.bgPanel[2].setVisible(false);
           gm.UI.bgPanel[3].setVisible(false);
           gm.UI.bgPanel[4].setVisible(false);
           gm.UI.bgPanel[5].setVisible(false);
           gm.UI.bgPanel[6].setVisible(false);
           gm.UI.bgPanel[7].setVisible(false);
           gm.UI.bgPanel[8].setVisible(true);
    }
    
    public void showWin(){
           gm.UI.bgPanel[1].setVisible(false);
           gm.UI.bgPanel[2].setVisible(false);
           gm.UI.bgPanel[3].setVisible(false);
           gm.UI.bgPanel[4].setVisible(false);
           gm.UI.bgPanel[5].setVisible(false);
           gm.UI.bgPanel[6].setVisible(false);
           gm.UI.bgPanel[7].setVisible(false);
           gm.UI.bgPanel[8].setVisible(false);
           gm.UI.bgPanel[9].setVisible(true);
    }
    public void createEnemyIcon(int x){
        if(gm.PC.returnRoom() ==5){
            if(x == 0){
                gm.UI.spawnEnemy(1,200, 200, "Goblin.jpg");
                gm.UI.enemyStore.setVisible(true); 
            }
            if(x == 1){
                gm.UI.spawnEnemy(1,200, 200, "sGolem.jpg");
                gm.UI.enemyStore.setVisible(true); 
            }
        }
        if(gm.PC.returnRoom() ==10){
            if(x == 0){
                gm.UI.spawnEnemy(1,200, 200, "eDagger.jpg");
                gm.UI.enemyStore.setVisible(true); 
            }
            if(x == 1){
                gm.UI.spawnEnemy(1,200, 200, "eRanger.jpg");
                gm.UI.enemyStore.setVisible(true); 
            } 
        }
        if(gm.PC.returnRoom() ==15){
            if(x == 0){
                gm.UI.spawnEnemy(1,200, 200, "zephyr.jpg");
                gm.UI.enemyStore.setVisible(true); 
            }
            if(x == 1){
                gm.UI.spawnEnemy(1,200, 200, "peter.jpg");
                gm.UI.enemyStore.setVisible(true); 
            }                
        }
    }
    
    public void createSpecialEnemyIcon(){
        switch (gm.PC.returnRoom()) {
            case 2:
                gm.UI.spawnEnemy(1,200, 200, "Slime.jpg");
                gm.UI.enemyStore.setVisible(true);
                break;
            case 7:
                gm.UI.spawnEnemy(1,200, 200, "Golem.jpg");
                gm.UI.enemyStore.setVisible(true);
                break;
            case 12:
                gm.UI.spawnEnemy(1,200, 200, "Ent.jpg");
                gm.UI.enemyStore.setVisible(true);
                break;
            case 17:
                gm.UI.spawnEnemy(1,200, 200, "Dragon.jpg");
                gm.UI.enemyStore.setVisible(true);
                break;
            case 19:
                gm.UI.spawnEnemy(6,200, 200, "Chronos.jpg");
                gm.UI.enemyStore.setVisible(true);          
                break;
            default:
                break;
        }

    }
    
    public void startCMBT(){
        gm.CMBT.startUpCombat();   
    }
}
