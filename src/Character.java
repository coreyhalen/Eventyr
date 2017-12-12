import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Character {

    private int level;
    private int maxHealth;
    private int currentHealth;
    private int intel;
    private int agi;
    private int str;
    private int stam;
    private int speed;
    private int currentSpeed;
    private ArrayList<Ability> spellBar;
    private ArrayList<Ability> onHitEffects;
    private ArrayList<Stack<Ability>> endOfTurnEffects;
    private ArrayList<Stack<Ability>> startOfTurnEffects;


    public ArrayList<Ability> getSpellBar() {
        return spellBar;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getStam() {
        return stam;
    }

    public void setStam(int stam) {
        this.stam = stam;
    }

    public  int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Character() {

        level = 1;
        stam = 2 * level;
        intel = 2 * level;
        agi = 2 * level;
        str = 2 * level;
        maxHealth = 20 + (5 * stam);
        setCurrentHealth(30);

        this.spellBar = new ArrayList<Ability>();


        if (getAgi() > 200) {
            speed = 10 + (int)Math.ceil(agi * .10);
        } else {
            speed = 30;
        }

    }

    public String stringOut(){
        String str = "Level " + this.getLevel() +
                "\nIntelligence " + this.getIntel() +
                "\nAgility " + this.getAgi() +
                "\nStrength " + this.getStr() +
                "\nHealth " + this.getMaxHealth();
        return str;
    }


    public static int randomNumRange(int start, int stop){
        Random rand = new Random();
        int randomNum = rand.nextInt(stop) + start;
        return randomNum;
    }
}
