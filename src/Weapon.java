import java.util.List;
import java.util.Scanner;

/**
 * Created by coreyjones on 12/11/17.
 */
public class Weapon extends Item {

    private ItemTypes type;
    private int atkDmg;
    private List<Ability> onHitEffects;
    private boolean twoHand;

    public List<Ability> getEffectSlots(){
        return this.onHitEffects;
    }

    public Ability getEffect(int slot) {
        return onHitEffects.get(slot);
    }

    public void addEffect(Ability effect) {
        this.onHitEffects.add(effect);
    }

    public ItemTypes getType() {
        return type;
    }

    public void setType(ItemTypes type) {
        this.type = type;
    }

    public int getAtkDmg() {
        return atkDmg;
    }

    public void setAtkDmg(int atkDmg) {
        this.atkDmg = atkDmg;
    }

    public boolean isTwoHand() {
        return twoHand;
    }

    public void setTwoHand(boolean twoHand) {
        this.twoHand = twoHand;
    }

    public Weapon(){

    }

    public Weapon(ItemTypes type){
        type = type;
        atkDmg = 1;
    }

    public void equip(Player player){

        if (this.isTwoHand() == true){
            if (player.getWeaponSlot(0) != null){
                System.out.print(player.getWeaponSlot(0).getName() + " has been moved to your inventory.");
                player.setAtkDmg(player.getAtkDmg() - player.getWeaponSlot(0).getAtkDmg());
                player.getInventory().add(player.getWeaponSlot(0));
            }
            if (player.getWeaponSlot(1) != null){
                System.out.print(player.getWeaponSlot(1).getName() + " has been moved to your inventory.");
                player.setAtkDmg(player.getAtkDmg() - player.getWeaponSlot(1).getAtkDmg());
                player.getInventory().add(player.getWeaponSlot(1));
            }
            player.setWeaponSlot(0, this);
            player.setAtkDmg(this.getAtkDmg());
            System.out.print(this.getName() + " is now equipped!");
        } else {

            if (player.getWeaponSlot(0) != null || player.getWeaponSlot(1) != null){
                Scanner in = new Scanner(System.in);
                System.out.print("Which hand would you like to hold this weapon with?\n(1) Left\n(2) Right");
                int hand = in.nextInt();
                if (hand == 1){
                    player.getInventory().add(player.getWeaponSlot(0));
                    player.setAtkDmg(player.getAtkDmg() - player.getWeaponSlot(0).getAtkDmg());
                    player.setWeaponSlot(0, this);
                    player.setAtkDmg(player.getAtkDmg() + this.getAtkDmg());
                } else {
                    player.getInventory().add(player.getWeaponSlot(1));
                    player.setAtkDmg(player.getAtkDmg() - player.getWeaponSlot(1).getAtkDmg());
                    player.setWeaponSlot(1, this);}
                player.setAtkDmg(player.getAtkDmg() + this.getAtkDmg());
            } else {
                player.setWeaponSlot(0, this);
            }
        }
    }

    public void typeRoll() {

        double slotRoll = Math.random() * 70;

        if (slotRoll < 10){
            this.type = ItemTypes.GREATSWORD;
            this.setName("Greatsword");
            this.twoHand = true;
        } else if (slotRoll >= 10 && slotRoll < 20){
            this.type = ItemTypes.GREATAXE;
            this.setName("Greataxe");
            this.twoHand = true;
        } else if (slotRoll >= 20 && slotRoll < 30){
            this.type = ItemTypes.HEAVYMACE;
            this.setName("Heavy Mace");
            this.twoHand = true;
        } else if (slotRoll >= 30 && slotRoll < 40){
            this.type = ItemTypes.STAFF;
            this.setName("Staff");
            this.twoHand = true;

        } else if (slotRoll >= 40 && slotRoll < 50){
            this.type = ItemTypes.DAGGER;
            this.setName("Dagger");
        } else if (slotRoll >= 50 && slotRoll < 60){
            this.type = ItemTypes.MACE;
            this.setName("Mace");
        } else if (slotRoll >= 60 && slotRoll < 70){
            this.type = ItemTypes.SWORD;
            this.setName("Sword");
        }
    }

    public void baseStatRoll(Character player) {

        int level = player.getLevel();
        double baseStatRoll = Math.random() * 100;
        if (baseStatRoll < 33){
            this.setName("Wizard's " + this.getName());
            this.setIntel(level);

        } else if (baseStatRoll >= 33 && baseStatRoll < 66){
            this.setName("Marshall's " + this.getName());
            this.setStr(level);

        } else {
            this.setName("Samurai's " + this.getName());
            this.setAgi(level);

        }
    }

    public int bonusAmountRoll() {

        double amountRoll = Math.random() * 100;

        if (amountRoll >= 90){
            return 15;
        } else if (amountRoll >= 80 && amountRoll < 90){
            return 14;
        } else if (amountRoll >= 70 && amountRoll < 80){
            return 13;
        } else if (amountRoll >= 60 && amountRoll < 70){
            return 12;
        } else if (amountRoll >= 50 && amountRoll < 60){
            return 11;
        } else if (amountRoll >= 40 && amountRoll < 50){
            return 10;
        } else if (amountRoll >= 30 && amountRoll < 40){
            return 9;
        } else if (amountRoll >= 20 && amountRoll < 30){
            return 8;
        } else if (amountRoll >= 10 && amountRoll < 20){
            return 7;
        } else {
            return 6;
        }
    }

    public void bonusStatRoll() {

        int bonusAmount = bonusAmountRoll();
        double bonusRoll = Math.random() * 90;
        if (bonusRoll >= 80) {
            this.setName("Swift " + this.getName());
            this.setSpeed(10);
        } else if (bonusRoll >= 60 && bonusRoll < 80) {
            this.setName("Enchanted " + this.getName());
            this.setIntel(this.getIntel() + bonusAmount);
        } else if (bonusRoll >= 40 && bonusRoll < 60) {
            this.setName("Weighted " + this.getName());
            this.setStr(this.getStr() + bonusAmount);
        } else if (bonusRoll >= 20 && bonusRoll < 40){
            this.setName("Balanced " + this.getName());
            this.setAgi(this.getAgi() + bonusAmount);
        } else {
            this.setName("Deadly " + this.getName());
            this.setAgi(this.getAtkDmg() + bonusAmount);
        }

    }

    public boolean infiniteRoll() {

        boolean result = false;
        double infiniteRoll = Math.random() * 1000;
        if (infiniteRoll >= 994) {
            this.setName("Infinite " + this.getName());
            this.setAtkDmg(this.getAtkDmg() + 50);
            this.setIntel(this.getIntel() + 20);
            this.setStr(this.getStr() + 20);
            this.setAgi(this.getAgi() + 20);
            this.setSpeed(this.getSpeed() + 10);
            result = true;
        }

        return result;
    }

    public String itemCompare(Player player){


            System.out.printf(player.getWeaponSlot(this.getSlot()).toString());

    String str = this.getName() + "\n";

        if (this.getStam() > 0 || player.getArmorSlot(this.getSlot()).getStam() > 0) {
        str += "Stamina: " + getStam() + " (" + (this.getStam() - player.getArmorSlot(this.getSlot()).getStam() + ")\n");
    }
        if (this.getIntel() > 0 || player.getArmorSlot(this.getSlot()).getIntel() > 0) {
        str += "Intelligence: " + getIntel() + " (" + (this.getIntel() - player.getArmorSlot(this.getSlot()).getIntel() + ")\n");
    }
        if (this.getAgi() > 0 || player.getArmorSlot(this.getSlot()).getAgi() > 0) {
        str += "Agility: " + getAgi() + " (" + (this.getAgi() - player.getArmorSlot(this.getSlot()).getAgi() + ")\n");
    }
        if (this.getStr() > 0 || player.getArmorSlot(this.getSlot()).getStr() > 0) {
        str += "Strength: " + getStr() + " (" + (this.getStr() - player.getArmorSlot(this.getSlot()).getStr() + ")\n");
    }
        if (this.getSpeed() > 0 || player.getArmorSlot(this.getSlot()).getSpeed() > 0) {
        str += "Stamina: " + getSpeed() + " (" + (this.getSpeed() - player.getArmorSlot(this.getSlot()).getSpeed() + ")\n");
    }

        return str;
    }

    public String statLine(StatType stat, int totalLength){
        String subStr = "";
        switch (stat){
            case ATK:
                subStr = firstHalf("Attack:", totalLength);
                subStr += "  " + this.getAtkDmg();
                subStr = secondHalf(subStr, totalLength);
                break;
            case AGILITY:
                subStr = firstHalf("Agility:", totalLength);
                subStr += "  " + this.getAgi();
                subStr = secondHalf(subStr, totalLength);
                break;
            case INTELLECT:
                subStr = firstHalf("Intellect:", totalLength);
                subStr += "  " + this.getIntel();
                subStr = secondHalf(subStr, totalLength);
                break;
            case STRENGTH:
                subStr = firstHalf("Strength:", totalLength);
                subStr += "  " + this.getStr();
                subStr = secondHalf(subStr, totalLength);
                break;
            case SPEED:
                subStr = firstHalf("Speed:", totalLength);
                subStr += "  " + this.getSpeed();
                subStr = secondHalf(subStr, totalLength);
                break;
        }
        return subStr;
    }


    public String toString(){
        int totalLength = getWidth(this.getName());
        String str = printBar(totalLength);
        str += nameLine(this.getName());
        str += printBar(totalLength);
        str += emptyLine(totalLength);
        if (this.getAtkDmg() > 0){
            str += statLine(StatType.ATK, totalLength);
        }
        if (this.getIntel() > 0) {
            str += statLine(StatType.INTELLECT, totalLength);
        }
        if (this.getAgi() > 0) {
            str += statLine(StatType.AGILITY, totalLength);
        }
        if (this.getStr() > 0) {
            str += statLine(StatType.STRENGTH, totalLength);
        }
        if (this.getSpeed() > 0) {
            str += statLine(StatType.SPEED, totalLength);
        }
        str += emptyLine(totalLength);
        str += printBar(totalLength);
        return str;
    }

    public static Item weaponDrop(Character player){

        Weapon drop = new Weapon();
        drop.setAtkDmg(player.getLevel() * 10);
        drop.typeRoll();
        drop.baseStatRoll(player);
        double chance = Math.random() * 100;
        if (chance < 20 && !drop.infiniteRoll()){
            drop.bonusStatRoll();
        }
        return drop;
    }

}
