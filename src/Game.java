/**
 * Created by coreyjones on 5/1/17.
 */
import java.util.Scanner;
import java.util.Random;

public class Game
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);

        //Intro to game and asks for name
        System.out.println("This is how the game starts");

        //picking a name
        String playName = in.next();

        Player Hero = new Player(playName);

        //game feedback from input
        System.out.println(Hero.getName());

        //choice of what to do
        do
        {
           String decision = in.next();
           Random rand = new Random();

           if (decision.equalsIgnoreCase("Adventure"))
            {
                int monsterLevel = rand.nextInt(Hero.getLevel() + 1) + (Hero.getLevel() - 1);
                Enemy monster = new Enemy(monsterLevel);
            }
        }

        while (in.next() != "q");


    }
}
