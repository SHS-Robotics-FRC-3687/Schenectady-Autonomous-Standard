package us.ny.k12.schenectady.frc.recyclerush.standard;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SampleRobot;

public abstract class StandardRobot extends SampleRobot {
	public StandardRobot() {
		
	}
	
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
	
	boolean gBinaryDIO = false;
	int[] gDIOChannels = null;
	
	protected int code;
	
	/**
	 * Initialize a standard robot with a code.
	 * 
	 * @param code
	 */
	public void init(int code) {
		this.code = code;
		
		gBinaryDIO = false;
		gDIOChannels = null;
	}
	
	/**
	 * Initialize a standard robot with a code provided by 
	 * a set of DIO channels. Will search the channels 
	 * and use the code of the array index of the first 
	 * channel that returns a signal. If no channel is 
	 * found, will default to NOTHING (0).
	 * 
	 * @param dioChannels array of DIO channels to search, 
	 * in order of preference
	 */
	public void init(int[] dioChannels) {
		gBinaryDIO = false;
		gDIOChannels = dioChannels;
	}
	
	/**
	 * Initialize a standard robot with an autonomous code
	 * provided by three binary switches.
	 * 
	 * @param dioAChannel
	 * @param dioBChannel
	 * @param dioCChannel
	 */
	public void init(int dioAChannel, int dioBChannel, int dioCChannel) {
		gBinaryDIO = true;
		gDIOChannels = new int[] {dioAChannel, dioBChannel, dioCChannel};
	}
	
	public int getCode() {
		return code;
	}
	
	@Override
	public void autonomous() {
		if (gDIOChannels != null) {
			if (gBinaryDIO) {
				DigitalInput dioA = new DigitalInput(gDIOChannels[0]);
				DigitalInput dioB = new DigitalInput(gDIOChannels[1]);
				DigitalInput dioC = new DigitalInput(gDIOChannels[2]);
				
				boolean a = dioA.get(), b = dioB.get(), c = dioC.get();
				
				code = ((a ? 1 : 0) << 2) + ((b ? 1 : 0) << 1) + (c ? 1 : 0);
				
				dioA.free();
				dioB.free();
				dioC.free();
			} else {
				System.out.println("detecting knob setting");
				
				//If none of the DIOs are enabled, default to NOTHING
				code = NOTHING;
				
				for (int i = 0; i < gDIOChannels.length; i ++) {
					DigitalInput dio = new DigitalInput(gDIOChannels[i]);
					
					if (!dio.get()) {
						code = i;
						dio.free();
						
						break;
					} else {
						dio.free();
						
						continue;
					}
				}
			}
		}
		
		System.out.println("code: " + code);
		
		autonomousCode(code);
	}
	
	public abstract void autonomousCode(int code);
}
