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
        int count = 0;

        while (snailsInPasture != 0 ) {
            int num = rand.nextInt(corral.length);
            Gate G = corral[num];       //select a random Gate
            int snailsToMove = rand.nextInt(snailsInPasture);

            if (G.getSwingDirection() != 0) {
                snailsInPasture += G.thru(snailsToMove);
//                snailsInPasture += updateSnailInPasture(G,
//                                        snailsInPasture, snailsToMove);
                mOut.println(snailsToMove + " are trying to move through corral "
                            + num);
                count++;
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
            corral[i].open(random.nextInt(gateSwing.length)+1);

            if(corral[i].getSwingDirection() == 0)
                mOut.println("Gate " + i +": This gate is CLOSED");
            else {
                mOut.print("Gate " + i +": This gate is open and swings to ");
                if(corral[i].getSwingDirection() == 1)
                    mOut.println("ENTER");
                else if(corral[i].getSwingDirection() == -1)
                    mOut.println("EXIT");
            }
        }
    }

}
