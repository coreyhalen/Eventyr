import java.util.Scanner;

public class TestBattle {

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int input = 0;

        Player player = new Player("HVLN");

        player.setPlayerClass(PlayerClasses.NINJA);

        System.out.println("# of drops: ");
        int numDrops = in.nextInt();

        for (int i = 0; i < numDrops; i++){
            Item drop = Weapon.weaponDrop(player);
            System.out.println(drop.toString());
        }



        NinjaQuestline.grantShadowSlash(player);
        NinjaQuestline.grantShurikenToss(player);
//
//        while (input != 2) {
//            Driver.choices();
//            input = in.nextInt();
//            if (input ==1){
//
//                BattleSequence.battle(player);
//            }
//            else if (input == 2){
//                break;
//            }
//        }

        System.out.print("Until next time adventurer!");
    }
}
