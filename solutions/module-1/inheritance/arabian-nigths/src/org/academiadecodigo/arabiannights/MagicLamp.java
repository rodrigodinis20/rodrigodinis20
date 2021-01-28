package org.academiadecodigo.arabiannights;

import org.academiadecodigo.arabiannights.genie.Demon;
import org.academiadecodigo.arabiannights.genie.FriendlyGenie;
import org.academiadecodigo.arabiannights.genie.Genie;
import org.academiadecodigo.arabiannights.genie.GrumpyGenie;

/**
 * A Magic Lamp, capable of providing Geniuses when rubbed
 */
public class MagicLamp {

    private int genieLimit; // Maximum number of genies the lamp can generate
    private int rubs; // Number of times the lamp has been rubbed since the last recharge
    private int nRecharges; // Number of times the lamp has been recharged with nRecharges

    /**
     * Constructs Magic Lamps capable of providing a maximum number of geniuses
     *
     * @param genieLimit the maximum number of genies
     */
    public MagicLamp(int genieLimit) {
        this.genieLimit = genieLimit;
    }

    public int getGenieLimit() {
        return genieLimit;
    }

    public int getRubs() {
        return rubs;
    }

    public int getnRecharges() {
        return nRecharges;
    }

    /**
     * Calculates the number of genies the lamp is able to create before needing a demon recharge
     *
     * @return the number of available genies
     */
    public int getAvailableGenies() {
        return getGenieLimit() - getRubs();
    }

    /**
     * Get a Genie by rubbing the lamp
     *
     * @param wishes number of wishes to ask to the generated Genie
     * @return the generated Genie
     */
    public Genie rub(int wishes) {
        if(getAvailableGenies() == 0){
            return new Demon(wishes);
        }
        Genie genie;
        if (rubs % 2 == 0) {
            genie = new FriendlyGenie(wishes);
        } else {
            genie = new GrumpyGenie(wishes);
        }

        rubs++;
        return genie;

    }


   public void recharge(Demon demon){

        if(demon.isSacrificed()){
            System.out.println(" nope ...");
            return;
        }

        demon.sacrifice();
        rubs = 0;
        nRecharges++;

   }

    /**
     * Tests two lamps for equality
     *
     * @param lamp the lamp to test against
     * @return if both lamps have same number of available genies, demon recharges and genie limits
     */
    public boolean equals(MagicLamp lamp) {

        return getGenieLimit() == lamp.getGenieLimit() &&
                getAvailableGenies() == lamp.getAvailableGenies() &&
                getnRecharges() == lamp.getnRecharges();

    }

}
