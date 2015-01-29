package us.ny.k12.schenectady.frc.recyclerush.standard;

/**
 * A simplified implementation of StandardRobot.
 * 
 * To use this implementation, have your robot 
 * inherit from this class, implement each 
 * of the methods that correspond to the different 
 * autonomous codes, and call one of the 
 * superclass' init() methods.
 */
public abstract class SimpleStandardRobot extends StandardRobot {
	/**
	 * You cannot override this method. If you feel tempted 
	 * to override this method, then you should be using 
	 * StandardRobot instead.
	 */
	@Override
	public final void autonomousCode(int code) {
		switch (code) {
		case NOTHING:
			// Do nothing if mode is set to nothing
			break;
		case STACK_LEFT:
		case STACK_CENTER:
		case STACK_RIGHT:
			autonomousStack(code);
		case BIN_SET:
			autonomousBinSet();
		case ALL_OPT:
			autonomousAll();
		case CHANNEL_OPT:
			autonomousChannel();
		}
	}
	
	// OPTIONAL METHODS
	
	/**
	 * (Optional) See ALL_OPT.
	 */
	public void autonomousAll() {}
	
	/**
	 * (Optional) See CHANNEL_OPT. 
	 */
	public void autonomousChannel() {}
	
	// REQUIRED METHODS
	
	/**
	 * See STACK_LEFT, STACK_CENTER, and STACK_RIGHT.
	 * 
	 * @param code either STACK_LEFT, STACK_CENTER, or STACK_RIGHT
	 */
	public abstract void autonomousStack(int code);
	
	/**
	 * See BIN_SET.
	 */
	public abstract void autonomousBinSet();
}
