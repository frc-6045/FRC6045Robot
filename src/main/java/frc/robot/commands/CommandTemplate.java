package frc.robot.commands;

//import frc.robot.RobotMap; //Get our RobotMappings
import edu.wpi.first.wpilibj.command.Command;

public class CommandTemplate extends Command{
        //requires(Robot.subsubsystemVariableInRobot); 
    

    protected void initialize() { //Called when command is initialized
		
	}

	protected void execute() { //Called periodicly by scheduler(every 20ms)

	}
	
	protected void interrupted() { //Called when the subsystem being used is needed by another command
		end();
	}
	
	protected void end() { 
		
	}
	
	protected boolean isFinished() {
		return false;
	}

	/*
	package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveArcade extends Command {
	public DriveArcade() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.m_drivetrain);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		double moveSpeed = -Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS);
		double rotateSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_ROTATE_AXIS);

		Robot.m_drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.m_drivetrain.arcadeDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
	*/
}