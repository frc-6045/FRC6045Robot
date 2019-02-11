/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  //INSTANCE VARIABLES
  //-Motors
  TalonSRX clawMotor;
  TalonSRX tiltMotor;
  //GETTERS
  //-Motors
  public TalonSRX getClawMotor() { return clawMotor; }
  public TalonSRX getTiltMotor() { return tiltMotor; }

  //Constructor
  public Claw(){
    //Setup Claw Motor
    clawMotor = new TalonSRX(RobotMap.MOTOR_CLAW);
    tiltMotor = new TalonSRX(RobotMap.MOTOR_CLAW_TILT);
  }

  public void setClawGrab(double per){
    clawMotor.set(ControlMode.PercentOutput, per);
  }

  public void setClawTilt(double per){
    tiltMotor.set(ControlMode.PercentOutput, per);
  }

  public void setClawEject(double per){
    //No Eject Motor yet
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
