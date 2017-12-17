/**
 * switch statement to grant an ability at a certain point
 */

public class Ability {

    private String name;
    private int critChance;
    private double ratio;
    private StatType statMulti;
    private int cd;
    private boolean avail;
    private int strikes;
    private boolean overTime;

    public int getStrikes() {
        return strikes;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public boolean isOverTime() {
        return overTime;
    }

    public void setOverTime(boolean overTime) {
        this.overTime = overTime;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ScaleMulti) {
        this.ratio = ScaleMulti;
    }

    public StatType getStatMulti() {
        return statMulti;
    }

    public void setStatMulti(StatType statMulti) {
        this.statMulti = statMulti;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvail() {
        return avail;
    }

    public void setAvail(boolean avail) {
        this.avail = avail;
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public void cast(Character player, Character target) {


    }

    public boolean critCalc() {

        boolean result = false;
        double roll = Math.random() * 100;
        if (roll <= this.getCritChance()) {
            result = true;
        }
        return result;
    }

    public void castDmg(Character player, Character target){

        int dmg = 0;

        switch (this.getStatMulti()){
            case AGILITY:
                dmg = (int)(this.getRatio() * player.getAgi());
                break;
            case INTELLECT:
                dmg = (int)(this.getRatio() * player.getIntel());
                break;
            case STRENGTH:
                dmg = (int)(this.getRatio() * player.getStr());
                break;
            case ATKPOWER:

        }

        if (this.getStrikes() > 1){

            for (int i = 0; i < this.getStrikes(); i++) {

                if (this.critCalc() == true) {
                    dmg += dmg * .5;
                    target.setCurrentHealth(target.getCurrentHealth() - dmg);
                    System.out.print(this.getName() + " critically hit the enemy for " + dmg + "!");
                } else {
                    target.setCurrentHealth(target.getCurrentHealth() - dmg);
                    System.out.print(this.getName() + " hit the enemy for " + dmg + "!");
                }
                Driver.pressToContinue();
            }
        } else {

            if (this.critCalc() == true && this.getStatMulti() != StatType.ATKPOWER) {
                dmg += dmg * .5;
                target.setCurrentHealth(target.getCurrentHealth() - dmg);
                System.out.print(this.getName() + " critically hit the enemy for " + dmg + "!");
            } else {
                target.setCurrentHealth(target.getCurrentHealth() - dmg);
                System.out.print(this.getName() + " hit the enemy for " + dmg + "!");
            }
            Driver.pressToContinue();
        }
    }

    public void castHeal(Character player, Character Target){

    }


}
