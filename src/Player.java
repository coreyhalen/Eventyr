/**
 * Created by coreyjones on 5/1/17.
 */
public class Player
{
    //Instance Variables
    private String playName;
    private int level;
    public boolean warr;
    public boolean lock;
    public boolean rogue;
    private int health;
    private int damage;

    //Character Constructor
    public Player(String initName)
    {
        playName = initName;
        level = 1;
        health = 10;
        damage = 1;

    }

    //get Player Name
    public String getName()
    {
        return playName;
    }

    //get Player Level
    public int getLevel()
    {
        return level;
    }

    //Get Player Health
    public int getHealth()
    {
        return health;
    }


}
