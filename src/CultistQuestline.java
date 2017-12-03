public abstract class CultistQuestline {

    public static void startLine(){
        System.out.print("You'll never meet a creepier bunch. Gives me the chills anytime I look at them.");
        Driver.pressToContinue();
        System.out.print("They say it's some kind of knowledge they're after, but I say it's a bunch of black" +
                " magic, demons and wizardry.");
        Driver.pressToContinue();
        System.out.print("I don't think the red stains on their cloaks are wine either...");
        Driver.pressToContinue();
    }

    public static void line1(){
        System.out.print("I wouldn't of guessed it by just lookin' at ya, but if your must be darker than I thought." +
                "Speaking of dark, you see that almost destroyed chapel on the edge of town?");
        Driver.pressToContinue();
        System.out.print("The man you're looking for goes by Vandran Highmore. No need to mention my name...");
        Driver.pressToContinue();
        System.out.print("And kid... once you get out of there, remember I was nice to ya ok?.");
        Driver.pressToContinue();
    }
}
