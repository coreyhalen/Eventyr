public abstract class SavageQuestline {

    public static void startLine(){

        System.out.print("In a hurry to die huh? Well you'll get your wish soon enough if you stay here.");
        Driver.pressToContinue();
        System.out.print("Armored to the teeth and masters of the sword. Warriors can take a punch as well as" +
                " deal one.");
        Driver.pressToContinue();
        System.out.print("No magic, no mysteriousness, just plain brute force.");
        Driver.pressToContinue();
    }

    public static void line1(){

        System.out.print("Looks like I can't stand between between you and the glory of battle. Head over to " +
                " The Bleeding Dragon. I'd say ask for Lord Commander Nuse, but I'm sure you'll know 'em when" +
                "you seem 'em.");
        Driver.pressToContinue();
        System.out.println("Oh and kid... don't go dying on me too soon, ok?");
        Driver.pressToContinue();
    }
}
