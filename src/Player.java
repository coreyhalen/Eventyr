import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player extends Character {

    private int money;
    private int currentExp;
    private int levelExp;
    private List<Item> inventory = new ArrayList<>();
    private Weapon[] weaponSlot = new Weapon[2];
    private Armor[] armorSlots = new Armor[4];

    public Armor getArmorSlot(int slot) {
        return armorSlots[slot];
    }

    public void setArmorSlot(int slot, Armor armor){ this.armorSlots[slot] = armor; }

    public Armor[] getArmorArray(){ return armorSlots; }

    public List<Item> getInventory() { return inventory; }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
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

    public Weapon getWeaponSlot(int slot) { return weaponSlot[slot]; }

    public void setWeaponSlot(int slot, Weapon weapon){ this.weaponSlot[slot] = weapon; }

    public Player(){

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
        Weapon weapon = new Weapon(ItemTypes.SWORD);
        weapon.setAtkDmg(5);
        weapon.setName("Dull Sword");
        weapon.equip(this);
    }

    public String printPlayer(){
        String role = "";
        switch (this.getPlayerClass()){
            case NINJA:
                role = "Ninja";
                break;
            case SAVAGE:
                role = "Warrior";
                break;
            case CULTIST:
                role = "Mage";
                break;
        }

        String.format("%14s:%-8s", )

        String.format("%5s", this.getName());
        String str = "*------------------------------------------------------------*\n";

        for (int i = 0; i < this.getArmorArray().length; i++){
            str += this.getArmorSlot(i).toString();
        }

        str += "*------------------------------------------------------------*\n";

        return str;
    }

    /**
     *
     * first half left justified, 14 spaces
     *
     * second half 8 spaces
     *
     *
     *--------------------*
     *   HVLN             *
     *   Level 20 Warrior *
     *--------------------*
     *   Attack:    347   *
     *   Stamina:   156   *
     *   Intellect: 156   *
     *   Agility:   123   *
     *   Strength:   23   *
     *   Speed:      20   *
     *--------------------*
     *
     *
     */

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
