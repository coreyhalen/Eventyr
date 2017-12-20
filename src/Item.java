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

    public Item(int slot){

        this.slot = slot;

        switch (this.slot){
            case 0: this.name = "Helmet";
                break;
            case 1: this.name = "Chestpiece";
                break;
            case 2: this.name = "Leggards";
                break;
            case 3: this.name = "Boots";
                break;
            case 4: this.name = "Weapon";
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

    public int getWidth(String name){

        int totalLength = name.length();

        if (totalLength%2 == 1){
            totalLength += 5;
        } else {
            totalLength += 4;
        }
        return totalLength;
    }

    public String firstHalf(String str, int length){
        while (str.length() < length/2){
            str = " " + str;
        }
        str = "*" + str;
        return str;
    }

    public String secondHalf(String str, int length){
        while (str.length() <= length){
            str += " ";
        }
        str += "*\n";
        return str;
    }

    public String printBar(int length){
        String str = "*";
        for (int i = 0; i < length; i++){
            str += "-";
        }
        str += "*\n";
        return str;
    }

    public String emptyLine(int length){
        String str = "*";
        for (int i = 0; i < length; i++){
            str += " ";
        }
        str += "*\n";
        return str;
    }

    public String nameLine(String name){
        String str = "*";
        if (name.length()%2 == 1){
            str += "  " + name + "   *\n";
        } else {
            str += "  " + this.getName() + "  *\n";
        }
        return str;
    }

    public String toString(){

        String str = getName() + "\n";

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



}
