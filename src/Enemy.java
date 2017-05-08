/**
 * Created by coreyjones on 5/7/17.
 */
public class Enemy
{
    private String playName;
    private int level;
    private int health;
    private int damage;

    Enemy(int initLevel)
    {
        level = 1;
        health = 10 + (5 * level);
        damage = 1 + (1 * level);
    }

}
