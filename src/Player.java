import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends Character {

    private int money;
    private int currentExp;
    private int levelExp;
    private List<Item> inventory = new ArrayList<>();

    public List<Item> getInventory() {
        return inventory;
    }

    public int getMoney() {
        return money;
    }

    public int getCurrentExp() {
        return currentExp;
    }

    public int getLevelExp() {
        return levelExp;
    }

    public void setLevelExp(int levelExp) {
        this.levelExp = levelExp;
    }

    public void setCurrentExp(int exp) {
        this.currentExp = exp;
    }

    public void setMoney(int money) {
        this.money = money;
    }



    public Player(){

    }

    public String printPlayer(){
        String str = "------------------------------------------------------------\n";

        for (int i = 0; i < this.getArmorArray().length; i++){
            str += this.getArmorSlot(i).toString();
        }

        str += "------------------------------------------------------------\n";

        return str;
    }

    public Player(String name){
        super();
        setLevelExp(100);
        setCurrentExp(0);
        for (int i = 0; i < 4; i++){
            Armor item = new Armor();
            item.setSlot(i);
            item.setName("Common" + item.getName());
            item.equip(this);
        }
    }

    public void levelUp(){
        this.setLevel(getLevel() + 1);
        setCurrentExp(currentExp%levelExp);
        setLevelExp((int)(levelExp * 1.25));
        this.setAgi(this.getAgi() + 2);
        this.setIntel(this.getIntel() + 2);
        this.setStr(this.getStr() + 2);
        System.out.println("You leveled up!\n" + this.stringOut());
}

    public void giveExp(int exp){

        this.setCurrentExp(this.getCurrentExp() + exp);
        if (this.getCurrentExp() >= this.getLevelExp()){
            this.levelUp();
        }
    }

    public void levelCheck() {

        switch (this.getPlayerClass()){
            case NINJA:
                switch (this.getLevel()){
                    case 5:
                }
            case SAVAGE: {}
            case CULTIST: {}
        }

    }

    public void printSpellBar(){

        int abilNum = 1;

        for (int i = 0; i < this.getSpellBar().size(); i++){
            System.out.print("(" + abilNum + ") " + this.getSpellBar().get(i).getName() + "\n");
            abilNum++;
        }
    }
}
