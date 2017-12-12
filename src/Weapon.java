/**
 * Created by coreyjones on 12/11/17.
 */
public class Weapon extends Item {

    private WeaponTypes type;


    public void typeRoll() {

        double slotRoll = Math.random() * 70;

        if (slotRoll < 10){
            this.type = WeaponTypes.GREATSWORD;
            this.setName("Greatsword");
        } else if (slotRoll >= 10 && slotRoll < 20){
            this.type = WeaponTypes.GREATAXE;
            this.setName("Greataxe");
        } else if (slotRoll >= 20 && slotRoll < 30){
            this.type = WeaponTypes.HEAVYMACE;
            this.setName("Heavy Mace");
        } else if (slotRoll >= 30 && slotRoll < 40){
            this.type = WeaponTypes.STAFF;
            this.setName("Staff");
        } else if (slotRoll >= 40 && slotRoll < 50){
            this.type = WeaponTypes.DAGGER;
            this.setName("Dagger");
        } else if (slotRoll >= 50 && slotRoll < 60){
            this.type = WeaponTypes.MACE;
            this.setName("Mace");
        } else if (slotRoll >= 60 && slotRoll < 70){
            this.type = WeaponTypes.SWORD;
            this.setName("Sword");
        }
    }

}
