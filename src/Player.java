public class Player extends Character {

    private String name;
    private int money;
    private int currentExp;
    private int levelExp;
    private PlayerClasses playerClass = null;
    private Item[] armorSlots = new Item[4];
    private Item[] weaponSlot = new Item[2];

    public void equipItem(Item item) {

        this.armorSlots[item.getSlot()] = item;

    }

    public String printItems(){
        String str = "------------------------------------------------------------\n";

        for (int i = 0; i < armorSlots.length; i++){
            str += this.armorSlots[i].toString();
        }

        str += "------------------------------------------------------------\n";

        return str;
    }

    public Item getItem(int slot) {
        return armorSlots[slot];
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
            Item item = new Item(0);
            item.setName("Common" + item.getName());
            this.equipItem(item);
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
