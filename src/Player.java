import java.util.ArrayList;
import java.util.List;

public class Player extends Character {

    private String name;
    private int money;
    private int currentExp;
    private int levelExp;
    private PlayerClasses playerClass = null;
    private Item[] itemSlots = new Item[5];

    public void equipItem(Item item) {

        this.itemSlots[item.getSlot()] = item;

    }

    public String printItems(){
        String str = "------------------------------------------------------------\n";

        for (int i = 0; i < itemSlots.length; i++){
            str += this.itemSlots[i].toString();
        }

        str += "------------------------------------------------------------\n";

        return str;
    }

    public Item getItem(int slot) {
        return itemSlots[slot];
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public PlayerClasses getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(PlayerClasses playerClass) {
        this.playerClass = playerClass;
    }

    public Player(){

    }

    public Player(String name){
        super();
        setLevelExp(100);
        setCurrentExp(0);
        for (int i = 0; i < 0; i++){
            Item item = new Item(1, 0, 0, 0, 0, i);
            this.equipItem(item);
        }

//        if (getPlayerClass() == PlayerClasses.NINJA){
//            setAtkDmg(getAgi() * 5);
//        } else if (getPlayerClass() == PlayerClasses.SAVAGE){
//            setAtkDmg(getStr() * 5);
//        } else if (getPlayerClass() == PlayerClasses.CULTIST){
//            setAtkDmg(getIntel() * 5);
//        } else {setAtkDmg(getLevel());}
        switch (playerClass){
            case NINJA: setAtkDmg(getAgi() * 5);
                        break;
            case SAVAGE: setAtkDmg(getStr() * 5);
                        break;
            case CULTIST: setAtkDmg(getIntel() * 5);
                        break;
            default: setAtkDmg(getLevel());
                        break;
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



    public void grantShadowSlash(){
        System.out.print("You've gained a new Ability! Shadow Slash!");
        Driver.pressToContinue();
        System.out.print("The Ninja strikes the target for a large amount of damage and has " +
                "a 25% critical strike chance.");
        Driver.pressToContinue();
        this.getSpellBar().add(new NinjaDmgAbility("Shadow Slash", 1, 2, 1,
                25, 1));
    }

    public void grantShurikenToss(){
        System.out.print("You've gained a new Ability! Shuriken Toss!");
        Driver.pressToContinue();
        System.out.print("The Ninja throws three deadly shuriken at the target, inflicting a small " +
                "amount of damage, but strikes three separate times ");
        this.getSpellBar().add(new NinjaDmgAbility("Shuriken Toss", 1, .75, 1,
                10, 3));
    }

    public Item lootDrop(){

        Item item = new Item();

        double slotRoll = Math.random() * 100;

        //roll for slot
        if (slotRoll < 20){
            item.setSlot(0);
        } else if (slotRoll >= 20 && slotRoll < 40){
            item.setSlot(1);
        } else if (slotRoll >= 40 && slotRoll < 60){
            item.setSlot(2);
        } else if (slotRoll >= 60 && slotRoll < 80) {
            item.setSlot(3);
        } else {
            item.setSlot(4);
        }

        //roll for baseline stats and name
        double baseStatRoll = Math.random() * 100;
        if (baseStatRoll < 33){
            item.setName(item.getName() + " of the Evoker");
            item.setIntel(this.getLevel());
            item.setStam(this.getLevel());
        } else if (baseStatRoll >= 33 && baseStatRoll < 66){
            item.setName(item.getName() + " of the Beserker");
            item.setStr(this.getLevel());
            item.setStam(this.getLevel());
        } else {
            item.setName(item.getName() + " of the Shinokage");
            item.setAgi(this.getLevel());
            item.setStam(this.getLevel());
        }

        //Rolling for how much of the bonus stat, used later
        double varRoll = Math.random() *100;
        int bonusAmount;
        if (varRoll >= 984){
            bonusAmount = 10;
        } else if (varRoll >= 963 && varRoll < 984){
            bonusAmount = 9;
        } else if (varRoll >= 923 && varRoll < 963){
            bonusAmount = 8;
        } else if (varRoll >= 873 && varRoll < 923){
            bonusAmount = 7;
        } else if (varRoll >= 798 && varRoll < 873){
            bonusAmount = 6;
        } else if (varRoll >= 698 && varRoll < 798){
            bonusAmount = 5;
        } else if (varRoll >= 573 && varRoll < 698){
            bonusAmount = 4;
        } else if (varRoll >= 423 && varRoll < 573){
            bonusAmount = 3;
        } else if (varRoll >= 248 && varRoll < 423){
            bonusAmount = 2;
        } else {
            bonusAmount = 1;
        }

        //Rolling for Infinite, or which bonus stat (not Infinite gear)
        double bonusRoll = Math.random() * 1000;
        if (bonusRoll >= 994) {
            item.setName("Infinite" + item.getName());
            item.setIntel(item.getIntel() + 10);
            item.setStam(item.getStam() + 10);
            item.setStr(item.getStr() + 10);
            item.setAgi(item.getAgi() + 10);
            item.setSpeed(5);
        } else if (bonusRoll >= 892 && bonusRoll < 994) {
            item.setSpeed(5);
        } else if (bonusRoll >= 669 && bonusRoll < 892) {
            item.setName("Bolstered " + item.getName());
            item.setStam(item.getStam() + bonusAmount);
        } else if (bonusRoll >= 446 && bonusRoll < 669) {
            item.setName("Enchanted " + item.getName());
            item.setIntel(item.getIntel() + bonusAmount);
        } else if (bonusRoll >= 223 && bonusRoll < 446) {
            item.setName("Tempered " + item.getName());
            item.setStr(item.getStr() + bonusAmount);
        } else {
            item.setName("Oiled " + item.getName());
            item.setAgi(item.getAgi() + bonusAmount);
        }

        return item;
    }
    
    
}
