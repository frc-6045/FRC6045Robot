/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class TestCommand extends Command {

  TalonSRX motor;
  double speed;
  int lastError = 0;
  int errorSum = 0;
  DigitalInput limitSwitch;
  DigitalInput limitSwitch2;
  int limitCounter = 0;

  public TestCommand(double speed){
    requires(Robot.m_subsystem);
    System.out.println("TestCommand Made");
    
    this.speed = speed;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("TestCommand Init");
    motor = Robot.m_subsystem.getMotor();
    motor.configPeakCurrentDuration(0, 30);
    /*
    motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 30);
    //motor.setSelectedSensorPosition(motor.getSensorCollection().getQuadraturePosition()); */
    
    motor.setSelectedSensorPosition(0);
   
    limitSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH_FRONT);
    limitSwitch2 = new DigitalInput(RobotMap.LIMIT_SWITCH_BACK);

    /*motor.setSensorPhase(true);
    motor.setInverted(false);
    motor.configNominalOutputForward(0, 30);
    motor.configNominalOutputReverse(0, 30);
    motor.configPeakOutputForward(1, 30);
    motor.configPeakOutputReverse(1, 30);

    motor.config_kF(0, 0, 30);
    motor.config_kP(0, 0.15, 30);
    motor.config_kI(0, 0, 30);
    motor.config_kD(0, 1, 30);
    */



    motor = Robot.m_subsystem.getMotor(); //Get the motor from the subsysytem
    motor.configPeakCurrentDuration(0, 30); //Mystery code that just works
    motor.setSelectedSensorPosition(0); //Set current position to 0
  }

   

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    int target = 4096 * 2;

    System.out.println("Target:" + target);
    motor.set(ControlMode.Position, target);

    if (limitSwitch.get() && limitCounter > 1000){
      Timer.delay(.01);
      System.out.println("Front Limit Switch Activated");
      limitCounter = 0;
    }
      
    if (limitSwitch2.get()  && limitCounter > 1000){
      Timer.delay(.01);
      System.out.println("Back Limit Switch Activated");
      limitCounter = 0;
    }

    }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    motor.set(ControlMode.PercentOutput, 0.0);
    System.out.println("TestCommand Ended");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
