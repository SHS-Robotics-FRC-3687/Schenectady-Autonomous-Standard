package us.ny.k12.schenectady.frc.recyclerush.standard;

import edu.wpi.first.wpilibj.SampleRobot;

public abstract class StandardRobot extends SampleRobot {
	/**
	 * Robot remains stationary during autonomous.
	 */
	public static final int NOTHING = 0;
	
	/**
	 * Robot starts on the left side of the field and places the first tote in the stack.
	 */
	public static final int STACK_LEFT = 1;
	
	/**
	 * Robot starts in the center of the field and places the second tote in the stack.
	 */
	public static final int STACK_CENTER = 2;
	
	/**
	 * Robot starts on the right side of the field and places the third tote in the stack.
	 */
	public static final int STACK_RIGHT = 3;
	
	/**
	 * Robot picks up the recycle bin and moves into the autonomous zone.
	 */
	public static final int BIN_SET = 4;
	
	/**
	 * (Optional) Robot attempts to build the entire tote stack.
	 */
	public static final int ALL_OPT = 5;
	
	/**
	 * (Optional) Robot may perform any action as long as it remains in its channel.
	 */
	public static final int CHANNEL_OPT = 6;
	
	@Override
	public void autonomous() {
		boolean a = false, b = false, c = false;
		
		int code = ((a ? 1 : 0) << 2) + ((b ? 1 : 0) << 1) + (c ? 1 : 0);
		
		autonomousCode(code);
	}
	
	public abstract void autonomousCode(int code);
}
