package ASN_Stable;
import java.awt.event.*;
import java.util.*;

public class ActionHandler implements ActionListener {

    ASN_Execute gm;
    Random getLost = new Random();
    int letGodDecide;
    int yourChoice = 0;

    public ActionHandler(ASN_Execute gm) {
        this.gm = gm;
    }

    public void actionPerformed(ActionEvent e) {
        
        String currentAction = e.getActionCommand();
        switch(currentAction){
            case("moveStory"):
                gm.PC.moveRooms();
                gm.swapper.visibilityModder();
                break; 
           case("enterShop"):
                gm.PC.setRoomNumber(38);
                gm.swapper.visibilityModder();
                break;
            case("Buying"):
                gm.shopMech.giveRandomItem();
                break;    
            case("beginFight"):
                gm.swapper.startCMBT();
                break;
            case("toolAssistedSuicide"):
                gm.UI.takeTheL();
                break;
            case("boogieDown"):
                letGodDecide = getLost.nextInt(2);
                if(letGodDecide ==0){
                    letGodDecide = 1;
                }
                gm.PC.setRoomNumber(letGodDecide);
                gm.swapper.visibilityModder();
                gm.UI.atShop = false;
                break;  
            case("Inventory"):
                gm.UI.inventoryHandler();
                break;
            case("closeBag"):
                gm.UI.inventoryHandler();                    
                break;
            case("cycleLeft"):
                if(gm.UI.currentItemNo >0){
                    gm.UI.currentItemNo --;
                    gm.UI.shimmyDirectional();
                }
                break;
            case("cycleRight"):
                if(gm.UI.currentItemNo < gm.PC.inventory.size()){
                    gm.UI.currentItemNo++;
                    gm.UI.shimmyDirectional();
                }
                break;
            case("useItem"): 
                gm.items.usedItems(gm.PC.inventory.get(gm.UI.currentItemNo));
                gm.UI.currentItem.setText("current Item:" + gm.PC.inventory.get(gm.UI.currentItemNo).returnNAME());
                break;    
            case("equipItem"):
                gm.PC.equipItem(gm.PC.inventory.get(gm.UI.currentItemNo));
                break;   
            case("Win"):
                try{
                gm.youWin();
                System.exit(0);
                }
                catch (Exception noFile){
                    System.exit(0);
                }
            }        
        }
        
}


