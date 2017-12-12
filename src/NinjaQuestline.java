import java.util.Scanner;

public abstract class NinjaQuestline extends Player {

    public static void startLine() {

        System.out.print("I got to hand it to ya, that kind of life ain't easy.");
        Driver.pressToContinue();
        System.out.print("You train all your life to learn how to kill someone with the flick of a finger, " +
                "and for what? So you can be \"disciplined\" and give up the rest of your life!");
        Driver.pressToContinue();
        System.out.print("I will say this. I don't think I've ever heard someone talk about winning a sparring " +
                "match against a Ninja.");
        Driver.pressToContinue();
        System.out.println("Probably because it's never happened... or they aren't around anymore.");


    }

    public static void line1(){

        Scanner in = new Scanner(System.in);

        System.out.print("I don't fancy it, but I know someone who does. You see that big set of stairs on the" +
                " side of the mountain over there?");
        Driver.pressToContinue();
        System.out.print("Well your training starts with climbing those damn things. Once you're at the top, " +
                "ask for Fang Xifu. He's the Grandmaster up there from what I hear.");
        Driver.pressToContinue();
        System.out.println("Oh and kid... hope I see you back down here one day.");
        Driver.pressToContinue();
        System.out.println("...");
        Driver.pressToContinue();
        System.out.println("These stairs seem to never end.");
        Driver.pressToContinue();
        System.out.println("...");
        Driver.pressToContinue();
        System.out.println("Hello, wanderer. Quite a feat to have come this far. Why would anyone go through all this" +
                " trouble?");
        Driver.pressToContinue();
        System.out.println("(1) I'm looking for Xifu Fang. He's going to take me as his next apprentice\n" +
                "(2) I'm here to find my place in the universe.\n(3) Give me some water already!... Can't " +
                "you see I'm dying here?!");
        int choice = in.nextInt();

        switch (choice){
            case 1: System.out.println("Is that so? We'll see about that.");
            break;
            case 2: System.out.println("It seems that the universe has not been very friendly towards you.");
            break;
            case 3: System.out.println("Well of course!");
            break;
            default: System.out.println("Well whatever it is, I'm sure you didn't come all this way to turn around.");
                break;

        }


    }

    public static void Line2(){

        System.out.print(" ");


    }


    public static void grantShadowSlash(Character player){
        System.out.print("You've gained a new Ability! Shadow Slash!");
        Driver.pressToContinue();
        System.out.print("The Ninja strikes the target for a large amount of damage and has " +
                "a 25% critical strike chance.");
        Driver.pressToContinue();
        player.getSpellBar().add(new DmgAbility("Shadow Slash", 1, 2, 1,
                25, 1));
    }

    public static void grantShurikenToss(Character player){
        System.out.print("You've gained a new Ability! Shuriken Toss!");
        Driver.pressToContinue();
        System.out.print("The Ninja throws three deadly shuriken at the target, inflicting a small " +
                "amount of damage, but strikes three separate times ");
        player.getSpellBar().add(new DmgAbility("Shuriken Toss", 1, .75, 1,
                10, 3));
    }
}
