/**
 * Created by coreyjones on 12/11/17.
 */
public class Armor extends Item {

    public void equip(Player player){
        if (player.getArmorSlot(this.getSlot()) != null){
            player.getInventory().add(player.getArmorSlot(this.getSlot()));
        }
        player.setArmorSlot(this.getSlot(), this);
    }

    public void slotRoll() {

        double slotRoll = Math.random() * 100;

        if (slotRoll < 25){
            this.setSlot(0);
            this.setName("Helmet");
        } else if (slotRoll >= 25 && slotRoll < 50){
            this.setSlot(1);
            this.setName("Chestpiece");
        } else if (slotRoll >= 50 && slotRoll < 75){
            this.setSlot(2);
            this.setName("Leggards");
        } else {
            this.setSlot(3);
            this.setName("Boots");
        }
    }

    public void baseStatRoll(Character player) {

        int level = player.getLevel();
        double baseStatRoll = Math.random() * 100;
        if (baseStatRoll < 33){
            this.setName(this.getName() + " of the Evoker");
            this.setIntel(level);
            this.setStam(level);
        } else if (baseStatRoll >= 33 && baseStatRoll < 66){
            this.setName(this.getName() + " of the Beserker");
            this.setStr(level);
            this.setStam(level);
        } else {
            this.setName(this.getName() + " of the Shinokage");
            this.setAgi(level);
            this.setStam(level);
        }
    }

    public int bonusAmountRoll() {

        double amountRoll = Math.random() * 100;

        if (amountRoll >= 90){
            return 10;
        } else if (amountRoll >= 80 && amountRoll < 90){
            return 9;
        } else if (amountRoll >= 70 && amountRoll < 80){
            return 8;
        } else if (amountRoll >= 60 && amountRoll < 70){
            return 7;
        } else if (amountRoll >= 50 && amountRoll < 60){
            return 6;
        } else if (amountRoll >= 40 && amountRoll < 50){
            return 5;
        } else if (amountRoll >= 30 && amountRoll < 40){
            return 4;
        } else if (amountRoll >= 20 && amountRoll < 30){
            return 3;
        } else if (amountRoll >= 10 && amountRoll < 20){
            return 2;
        } else {
            return 1;
        }
    }

    public void bonusStatRoll() {

        int bonusAmount = bonusAmountRoll();
        double bonusRoll = Math.random() * 100;
        if (bonusRoll >= 88) {
            this.setName("Swift " + this.getName());
            this.setSpeed(5);
        } else if (bonusRoll >= 66 && bonusRoll < 88) {
            this.setName("Bolstered " + this.getName());
            this.setStam(this.getStam() + bonusAmount);
        } else if (bonusRoll >= 44 && bonusRoll < 66) {
            this.setName("Enchanted " + this.getName());
            this.setIntel(this.getIntel() + bonusAmount);
        } else if (bonusRoll >= 22 && bonusRoll < 44) {
            this.setName("Tempered " + this.getName());
            this.setStr(this.getStr() + bonusAmount);
        } else {
            this.setName("Oiled " + this.getName());
            this.setAgi(this.getAgi() + bonusAmount);
        }

    }

    public boolean infiniteRoll() {

        boolean result = false;
        double infiniteRoll = Math.random() * 1000;
        if (infiniteRoll >= 994) {
            this.setName("Infinite " + this.getName());
            this.setIntel(this.getIntel() + 10);
            this.setStam(this.getStam() + 10);
            this.setStr(this.getStr() + 10);
            this.setAgi(this.getAgi() + 10);
            this.setSpeed(this.getSpeed() + 5);
            result = true;
        }

        return result;
    }

    public String itemCompare(Player player){

        System.out.printf(player.getArmorSlot(this.getSlot()).toString());

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

    public static Item armorDrop(Character player){

        Armor drop = new Armor();
        drop.slotRoll();
        drop.baseStatRoll(player);
        double chance = Math.random() * 100;
        if (chance < 20 && !drop.infiniteRoll()){
            drop.bonusStatRoll();
        }
        return drop;
    }
}
