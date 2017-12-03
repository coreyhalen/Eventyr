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

        System.out.print("I don't fancy it, but I know someone who does. You see that big set of stairs on the" +
                " side of the mountain over there?");
        Driver.pressToContinue();
        System.out.print("Well your training starts with climbing those damn things. Once you're at the top, " +
                "ask for Fang Xifu. He's the Grandmaster up there from what I hear.");
        Driver.pressToContinue();
        System.out.println("Oh and kid... hope I see you back down here one day.");

    }
}
