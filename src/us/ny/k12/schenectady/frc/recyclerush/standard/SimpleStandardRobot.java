package us.ny.k12.schenectady.frc.recyclerush.standard;

public abstract class SimpleStandardRobot extends StandardRobot {
	@Override
	public void autonomousCode(int code) {
		switch (code) {
		case NOTHING:
			autonomousNothing();
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
	
	//Optional methods
	public void autonomousNothing() {}
	public void autonomousAll() {}
	public void autonomousChannel() {}
	
	//Required methods
	public abstract void autonomousStack(int code);
	public abstract void autonomousBinSet();
}
