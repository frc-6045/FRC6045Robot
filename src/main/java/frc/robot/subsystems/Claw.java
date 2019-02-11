/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
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
  TalonSRX ejectMotor;
  //-Limit Switches
  DigitalInput openLimit;
  DigitalInput closedLimit;
  //GETTERS
  //-Motors
  public TalonSRX getClawMotor() { return clawMotor; }
  public TalonSRX getTiltMotor() { return tiltMotor; }
  public TalonSRX getEjectMotor() { return ejectMotor; }
  //-Limit Switches
  public boolean getOpenLimit() { return openLimit.get(); }
  public boolean getClosedLimit() { return closedLimit.get(); }

  //Constructor
  public Claw(){
    //Setup Claw Motor
    clawMotor = new TalonSRX(RobotMap.MOTOR_CLAW);
    clawMotor.setInverted(false);
    clawMotor.configPeakCurrentDuration(0, 30);
    clawMotor.setSelectedSensorPosition(0);
    //Setup Tilt Motor
    tiltMotor = new TalonSRX(RobotMap.MOTOR_CLAW_TILT);
    //Setup Eject Motor
    ejectMotor = new TalonSRX(RobotMap.MOTOR_CLAW_EJECT);
    ejectMotor.setInverted(false);
    ejectMotor.configPeakCurrentDuration(0, 30);
    ejectMotor.setSelectedSensorPosition(0);
  }

  public void setClawGrab(double per){ //Set the grab motion of the claw
    clawMotor.set(ControlMode.PercentOutput, per);
  }

  public void setClawTilt(double per){ //Set the tilt motion of the claw
    tiltMotor.set(ControlMode.PercentOutput, per);
  }

  public void setClawEject(double per){ //Set the belt speed on the claw
    ejectMotor.set(ControlMode.PercentOutput, per);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}