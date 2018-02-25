package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    public static final int CLOSED = 0;
    public static final int IN = 1;
    public static final int OUT = -1 ;
    private int mSwing = 0;
    private int total = 0;

    public Gate () {
        this.mSwing = CLOSED;
    }
    public Gate (int swing) {
        this.mSwing = swing;
    }
    // TODO -- Fill in your code here

    public int getSwingDirection() {
        return this.mSwing;
    }

    /**
     * setter for mSwing direction
     * @param dir: value of direction
     * @return false if no change in value, otherwise true if successfully set
     */
    public boolean setSwing(int dir) {
        if( this.mSwing != dir ) {
            this.mSwing = dir;
            return true;
        }
        return false;
    }

    public void close() {
        setSwing(CLOSED);
    }
    public boolean open(int dir) {
        if( dir == IN || dir == OUT ) {
            setSwing(dir);
            return true;
        }
        return false;
    }

    public int thru(int count) {
        if( getSwingDirection() > 0 ){
            return count;
        } else if( getSwingDirection() < 0 ) {
            return -count;
        } else
            return 0;
    }


    public String toString() {
        if( this.getSwingDirection() == IN )
            return "This gate is open and swings to enter the pen only";
        else if ( this.getSwingDirection() == OUT )
            return "This gate is open and swings to exit the pen only";
        else if ( this.getSwingDirection() == CLOSED)
            return "The gate is CLOSED";
        else
            return "This gate has an invalid swing direction";
    }


}
