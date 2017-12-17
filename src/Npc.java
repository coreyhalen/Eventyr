import java.util.Random;

public class Npc extends Character {

    public  Npc(int lvl){
        super();
        setLevel(lvl);
        this.setMaxHealth(50 + this.getStam() * 10);
    }

    public static Npc randomNpc(Character player){

        Npc enemy = new Npc(randomEnemyLvl(player));
        return enemy;
    }

    public static int randomEnemyLvl(Character player){
        Random rand = new Random();
        int enemyLvl = rand.nextInt(player.getLevel() + 1) + player.getLevel() - 1;
        return enemyLvl;
    }


    public void agiBuild(){
        this.setAgi(this.getAgi() + this.getLevel());
        NinjaQuestline.grantShadowSlash(this);
        NinjaQuestline.grantShurikenToss(this);
    }

    public void strBuild(){

    }

    public void intelBuild(){

    }
}
