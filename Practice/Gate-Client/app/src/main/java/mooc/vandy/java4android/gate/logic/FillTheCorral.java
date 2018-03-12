package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }


    // TODO -- Fill your code in here

    /**
     * 
     *
     */
    public void corralSnails(Gate[] corral, Random rand) {
        int snailsInPasture = 5;
        int snailsToMove = rand.nextInt(snailsInPasture);
        while (snailsInPasture >0 ) {
            Gate G = corral[rand.nextInt(corral.length)];       //select a random Gate

            if (G.getSwingDirection() != 0) {
                snailsInPasture = updateSnailInPasture(G, snailsInPasture, snailsToMove);
            }
        }

    }

    /**
     * update the number of snail in pasture after move
     */
    private int updateSnailInPasture(Gate corral_x, int snail, int snailMove) {
        return snail+corral_x.thru(snailMove);
    }

    /**
     * check if there is at least one corral open IN
     * otherwise return false
     */
    public boolean anyCorralAvailable(Gate[] corral) {
        int i = 0;
        while( corral[i].getSwingDirection() == 1 ) {
            i++;
            return true;
        }
        return false;
    }

    /**
     * set the direction of the gate's swing for the corral array
     */
    public void setCorralGates(Gate[] corral, Random random) {
        int[] gateSwing = {-1, 0, 1};
        for (int i=0; i < corral.length; i++) {
            corral[i].open(random.nextInt(gateSwing.length));
        }
    }

}
