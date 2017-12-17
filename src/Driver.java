import java.util.Scanner;
import java.util.List;

public class Driver {

    private static Scanner in = new Scanner(System.in);

    public static void choices(){
        System.out.println("What would you like to do?\n(1) Battle \n(2) Quit");
    }

    public static void pressToContinue(){
        try{System.in.read();}
        catch(Exception e){}
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int input = 0;


        System.out.print("Would you look at this! A face I don't recognize... I'll be damned. What do you call " +
                "yourself kid?\nEnter your name: ");
        String playerName = in.nextLine();
        System.out.print("Alright " + playerName + ", welcome to Dodens Trone. The land of no king... at least no " +
                "king that's living...");
        pressToContinue();
        System.out.print("It's not the nicest looking place, but I've seen worse. I'd say you'll fair well here " +
                        "with a little bit of help.");
        pressToContinue();
        System.out.println("Lucky for you, I know every bottom feeder, mercenary and aspiring noble in this Hellhole." +
               " ");

        Player player = new Player(playerName);

        while (player.getPlayerClass() == null) {
           System.out.println("But tell me, what makes " + playerName + " tick?\nChoose a response:\n(1) I like to " +
                   "live in the shadows. If my enemy hears or sees me, it's already too late.\n(2) I fear nothing. " +
                   "The bones of my enemies will crush with every devastating blow from my weapon.\n(3) Knowledge is " +
                   "power... no matter where it comes from, even if I have to sacrifice my own blood.");
           int classChoice = in.nextInt();

           switch (classChoice){
               case 1: NinjaQuestline.startLine();
                        break;
               case 2: SavageQuestline.startLine();
                        break;
               case 3: CultistQuestline.startLine();
                        break;
               default: System.out.println("\nThat's not a choice.");
           }

           System.out.println("You sure that's the kind of life you want to live?\n\nChoose one:\n(1) Yes\n(2) No");
           int choiceConfirm = in.nextInt();

           switch (choiceConfirm){
               case 1:
                   switch (classChoice){
                       case 1:
                           player.setPlayerClass(PlayerClasses.NINJA);
                        //   player.grantShadowSlash();
                           break;
                       case 2:
                           player.setPlayerClass(PlayerClasses.SAVAGE);
                           break;
                       case 3:
                           player.setPlayerClass(PlayerClasses.CULTIST);
                           break;
                   }
                   break;
               case 2:
                   System.out.println("Then what kind of person are ya?");
                   player.setPlayerClass(null);
                   break;
           }

       }

        switch (player.getPlayerClass()){
            case NINJA: NinjaQuestline.line1();
                        break;
            case SAVAGE: SavageQuestline.line1();
                        break;
            case CULTIST: CultistQuestline.line1();
                        break;
        }

       while (input != 2) {
            choices();
            input = in.nextInt();
            if (input ==1){
                BattleSequence.battle(player);
            }
            else if (input == 2){
                break;
            }
        }

        System.out.print("Until next time adventurer!");

    }
}

