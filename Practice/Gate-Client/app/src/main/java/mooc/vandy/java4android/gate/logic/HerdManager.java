package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    //value for simulation
    public static final int HERD = 24;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    /**
     * Random is used to select a gate randomly and
     * ...move a random num of snails in/out the pens
     * @param random
     */
    public void simulateHerd(Random random) {
        int penSize = HERD;
        //this.mOut.println("EAST Gate: This gate is closed");
        //this.mOut.println("WEST Gate: This gate is closed");
        mOut.println("There are currently " + penSize 
            + " snails in the pen and " + (HERD - penSize)
            + " snails in the pasture");

        for( int i=0; i<MAX_ITERATIONS; i++) {
            Gate gateToUse = null;
            /* select gate to open*/
            if( penSize == 0 )
                gateToUse = mWestGate;
            else if( penSize == HERD )
                gateToUse = mEastGate;
            else
                gateToUse = ((random.nextBoolean()) ? mWestGate : mEastGate);
            
            /* select the number snails In/Out through each gate*/
            int snails = 0;
            if( gateToUse == mWestGate )
                snails = random.nextInt(HERD - penSize) + 1;
            else( gateToUse == mEastGate )
                snails = random.nextInt(penSize) + 1;

            /* let the snail go In/Out*/
            penSize += gateToUse.thru(snails);
            mOut.println("There are currently "+ penSize
                + " snails in the pen and " + (HERD - penSize)
                + " snails in the pasture");
        }
    }

    /* East Gate: This gate is closed
    West Gate: This gate is closed
    There are currently 24 snails in the pen and 0 snails in the pasture*/

    // TODO -- Fill your code in here so somthing here


}
