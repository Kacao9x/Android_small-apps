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
        int snailsInPasture = 10;
        int attempt = 0;                   //total attempt to corral all snail

        while (snailsInPasture != 0 ) {
            int num = rand.nextInt(corral.length);
            /* select random Gate*/
            Gate G = corral[num];

            /* select random amount of snail to move */
            int snailsToMove = rand.nextInt(snailsInPasture) + 1;
            mOut.println("# of snail to move: "+ snailsToMove
                        + "  Gate number: " + num
                        + "   swing: " + G.getSwingDirection());
            if (G.getSwingDirection() != 0) {
//                snailsInPasture -= G.thru(snailsToMove);        //decrement # of snails after move
                snailsInPasture = updateSnailInPasture(G,
                                        snailsInPasture, snailsToMove);
                mOut.println(snailsToMove + " are trying to move through corral "
                            + num);
                attempt++;
            }

        }
        mOut.println("Total attempt: " + attempt);

    }

    /**
     * update the number of snail in pasture after move
     */
    private int updateSnailInPasture(Gate corral_x, int totalSnail, int snailMove) {
        return totalSnail - corral_x.thru(snailMove);
    }

    /**
     * check if there is at least one corral open IN
     * otherwise return false
     */
    public boolean anyCorralAvailable(Gate[] corral) {
        int i, count = 0;
        for (i=0; i<corral.length; i++) {
            if( corral[i].getSwingDirection() != Gate.CLOSED )
                count++;
        }
        return (count != 0 ? true: false);
    }

    /**
     * set the direction of the gate's swing for the corral array
     */
    public void setCorralGates(Gate[] corral, Random random) {
        int[] gateSwing = {Gate.OUT, Gate.IN, Gate.CLOSED};
        for (int i=0; i < corral.length; i++) {
            /* define the direction of the gate swing randomly*/
            corral[i].open(random.nextInt(gateSwing.length));

            if(corral[i].getSwingDirection() == Gate.CLOSED)
                mOut.println("Gate " + i +": This gate is CLOSED");
            else {
                mOut.print("Gate " + i +": This gate is open and swings to ");
                if(corral[i].getSwingDirection() == Gate.IN)
                    mOut.println("ENTER");
                else if(corral[i].getSwingDirection() == Gate.OUT)
                    mOut.println("EXIT");
            }
        }
    }

}
