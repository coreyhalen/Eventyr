public class NinjaDmgAbility extends NinjaBaseAbility {

    public NinjaDmgAbility(String name, int statMulti, double ratio, int cd, int critChance, int strikes){

        this.setName(name);
        this.setStatMulti(statMulti);
        this.setRatio(ratio);
        this.setCd(cd);
        this.setCritChance(critChance);
        this.setStrikes(strikes);

    }


    public void cast(Character player, Character target){

        int dmg = 0;


        switch (this.getStatMulti()){
            case 1:
                dmg = (int)(this.getRatio() * player.getAgi());
                break;
            case 2:
                dmg = (int)(this.getRatio() * player.getIntel());
                break;
            case 3:
                dmg = (int)(this.getRatio() * player.getStr());
                break;
        }

        if (this.getStrikes() > 1){

            int strikeNum = 1;

            for (int i = 0; i < this.getStrikes(); i++) {



                if (this.critCalc() == true) {
                    dmg += dmg * .5;

                    target.setCurrentHealth(target.getCurrentHealth() - dmg);

                    System.out.print("You cast " + this.getName() + " and strike #" + strikeNum +
                            " critically hit the enemy for " + dmg + "!");

                    strikeNum++;

                } else {

                    target.setCurrentHealth(target.getCurrentHealth() - dmg);

                    System.out.print("You cast " + this.getName() + " and strike #" + strikeNum +
                            " hit the enemy for " + dmg + "!");

                    strikeNum++;
                }

                Driver.pressToContinue();
            }
        } else {

            if (this.critCalc() == true) {
                dmg += dmg * .5;

                target.setCurrentHealth(target.getCurrentHealth() - dmg);

                System.out.print("You cast " + this.getName() + " and critically hit the enemy for " + dmg + "!");

            } else {

                target.setCurrentHealth(target.getCurrentHealth() - dmg);

                System.out.print("You cast " + this.getName() + " and hit the enemy for " + dmg + "!");

            }

            Driver.pressToContinue();
        }
    }

}
