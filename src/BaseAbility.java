import java.util.Random;

/**
 * switch statement to grant an ability at a certain point
 */

public abstract class BaseAbility {

    private String name;
    private int critChance;
    private double ratio;
    private int statMulti;
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

    public int getStatMulti() {
        return statMulti;
    }

    public void setStatMulti(int statMulti) {
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
}
