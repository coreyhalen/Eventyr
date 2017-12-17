import java.util.Scanner;

public class BattleSequence {


    public static void battlePrep(Character player, Character enemy){

        player.setCurrentSpeed(0);
        enemy.setCurrentSpeed(0);
    }


    public static boolean speedCalc(Character player, Character enemy){

        do {
            player.setCurrentSpeed(player.getCurrentSpeed() + (player.getSpeed()));
            enemy.setCurrentSpeed(enemy.getCurrentSpeed() + enemy.getSpeed());
        } while (player.getCurrentSpeed() < 100 || enemy.getCurrentSpeed() < 100);

        if (player.getCurrentSpeed() >= enemy.getCurrentSpeed()){
            player.setCurrentSpeed(player.getCurrentSpeed()%100);
            return true;
        } else {
            enemy.setCurrentSpeed(enemy.getCurrentSpeed()%100);
            return false;
        }

    }

    public static Item lootDrop(Player player){

        double roll = Math.random() * 5;

        if (roll < 4){
            return Armor.armorDrop(player);
        } else {
            return Weapon.weaponDrop(player);
        }

    }


    public void checkOnHit(Character attacker, Character defender) {

    }

    public static void battle(Player player) {

        System.out.println("You are being challenged!");
        Scanner in = new Scanner(System.in);
        Npc enemy = Npc.randomNpc(player);

        battlePrep(player, enemy);

        while (player.getCurrentHealth() > 0 && enemy.getCurrentHealth() > 0){



            if (speedCalc(player, enemy)){

                System.out.print("Pick an ability!\n");
                player.printSpellBar();
                int spellChoice = in.nextInt();
                player.getSpellBar().get(spellChoice - 1).cast(player, enemy);


            }
            else {
                //enemy attacks
                System.out.print("The enemy is attacking!");
                Driver.pressToContinue();
                player.setCurrentHealth(player.getCurrentHealth() - enemy.getAtkDmg());
                System.out.println("You took " + enemy.getAtkDmg() + " damage!");
                Driver.pressToContinue();
            }

        }
        if (player.getCurrentHealth() <= 0) {
            System.out.println("Great job, loser.");
        } else {
            System.out.println("You have defeated the enemy!");
            Driver.pressToContinue();
            System.out.println("It dropped some loot!");
            Driver.pressToContinue();
            Item drop = lootDrop(player);
           // drop.itemCompare(player);
            System.out.println("Do you want to equip this item? (Your previous item will be lost!)\n(1) Yes\n(2) No");
            int equipChoice = in.nextInt();
            System.out.println("You are about to replace " + player.getArmorSlot(drop.getSlot()).getName() + " with a " +
            drop.getName() + ". Are you sure you want to do this?\n(1) Yes\n(2) No");
            int equipVerify = in.nextInt();
            if (equipVerify == 1){
             //   drop.equip(player);
                System.out.println("YES! NEW LOOT!" + player.getName() + "'s stats: " + player.stringOut());
                player.setCurrentHealth(player.getMaxHealth());
                System.out.println("You're health has been restored!");
                player.giveExp(105);
            } else {
                System.out.println("Sticking with my current gear.");
                player.setCurrentHealth(player.getMaxHealth());
                System.out.println("You're health has been restored!");
                player.giveExp(105);
            }


        }
    }

}
