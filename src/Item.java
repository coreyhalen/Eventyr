public class Item {

    private String name;
    private int stam;
    private int intel;
    private int agi;
    private int str;
    private int speed;
    private int slot;

    public Item(){

    }

    public Item(int stam, int intel, int agi, int str, int speed, int slot){

        this.stam = stam;
        this.intel = intel;
        this.agi = agi;
        this.str = str;
        this.speed = speed;
        this.slot = slot;

        switch (slot){
            case 0: name = "Helmet";
            break;
            case 1: name = "Chest";
            break;
            case 2: name = "Legs";
            break;
            case 3: name = "Boots";
            break;
            case 4: name = "Weapon";
            break;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStam() {
        return stam;
    }

    public void setStam(int stam) {
        stam = stam;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String toString(){

        String str = getName() + ": " + getName() + "\n";

        if (this.getStam() > 0) {
            String statStr = "Stamina: " + getStam();
            str += String.format("%20s", statStr);}
        if (this.getIntel() > 0) {
            String statStr = "Intelligence: " + getIntel();
            str += String.format("%20s", statStr); }
        if (this.getAgi() > 0) {
            String statStr = "Agility: " + getAgi();
            str += String.format("%20s", statStr); }
        if (this.getStr() > 0) {
            String statStr = "Strength: " + getStr();
            str += String.format("%20s", statStr); }
        if (this.getSpeed() > 0) {
            String statStr = "Speed: " + getSpeed();
            str += String.format("%20s", statStr); }

        str += "\n";
        return str;
    }

    public String itemCompare(Player player){

        String str = this.getName() + "\n";

        if (this.getStam() > 0 || player.getItem(this.getSlot()).getStam() > 0) {
            str += "Stamina: " + getStam() + " (" + (this.getStam() - player.getItem(this.getSlot()).getStam() + ")\n");
             }
        if (this.getIntel() > 0 || player.getItem(this.getSlot()).getIntel() > 0) {
            str += "Intelligence: " + getIntel() + " (" + (this.getIntel() - player.getItem(this.getSlot()).getIntel() + ")\n");
        }
        if (this.getAgi() > 0 || player.getItem(this.getSlot()).getAgi() > 0) {
            str += "Agility: " + getAgi() + " (" + (this.getAgi() - player.getItem(this.getSlot()).getAgi() + ")\n");
        }
        if (this.getStr() > 0 || player.getItem(this.getSlot()).getStr() > 0) {
            str += "Strength: " + getStr() + " (" + (this.getStr() - player.getItem(this.getSlot()).getStr() + ")\n");
        }
        if (this.getSpeed() > 0 || player.getItem(this.getSlot()).getSpeed() > 0) {
            str += "Stamina: " + getSpeed() + " (" + (this.getSpeed() - player.getItem(this.getSlot()).getSpeed() + ")\n");
        }

        return str;
    }
}
