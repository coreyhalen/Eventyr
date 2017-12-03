
public class Npc extends Character {

    public Npc(int lvl){
        super();
        setLevel(lvl);
    }

    public static Npc randomNpc(Character player){

        Npc enemy = new Npc(Character.randomEnemyLvl(player));

        return enemy;
    }
}
