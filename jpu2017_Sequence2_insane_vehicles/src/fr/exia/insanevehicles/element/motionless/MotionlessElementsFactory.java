package fr.exia.insanevehicles.element.motionless;

import fr.exia.insanevehicles.element.Element;

/**
 * <h1>A factory for creating MotionlessElements objects.</h1>
 *
 * @author Jade
 * @version 0.1
 */
public abstract class MotionlessElementsFactory {

    /** The Constant DITCH. */
    private static final Ditch    DITCH    = new Ditch();
    
    /** The Constant DITCH. */
    private static final Median    MEDIAN    = new Median();
    
    /** The Constant RDITCH. */
    private static final RightDitch    RDITCH    = new RightDitch();
    
    /** The Constant LDITCH. */
    private static final LeftDitch    LDITCH    = new LeftDitch();
    
    /** The Constant MACADAM. */
    private static final Macadam  MACADAM  = new Macadam();

    /** The Constant OBSTACLE. */
    private static final Obstacle OBSTACLE = new Obstacle();

    /**
     * Creates a new ditch object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDitch() {
        return DITCH;
    }
    public static MotionlessElement createRightDitch() {
        return RDITCH;
    }
    public static MotionlessElement createLeftDitch() {
        return LDITCH;
    }
    public static MotionlessElement createMedian() {
        return MEDIAN;
    }

    /**
     * Creates a new macadam object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createMacadam() {
        return MACADAM;
    }

    /**
     * Creates a new obstacle object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createObstacle() {
        return OBSTACLE;
    }

	public static Element create(char c) {
		// TODO Auto-generated method stub
		
		switch(c){
		
		case ' ' : return createMacadam();
	
		case '|' : return createDitch();
	
		case '/' : return createRightDitch();

		case '\\' : return createLeftDitch();

		case 'X' : return createObstacle();

		case '^' : return createMedian();

			
		}
		
		throw new IllegalArgumentException("Invalid caractere : " + c);
	}
}
