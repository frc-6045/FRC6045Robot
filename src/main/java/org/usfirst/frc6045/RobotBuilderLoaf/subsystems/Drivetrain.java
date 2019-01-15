// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6045.RobotBuilderLoaf.subsystems;


import org.usfirst.frc6045.RobotBuilderLoaf.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Drivetrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private VictorSP motorLeftFront;
    private VictorSP motorLeftBack;
    private SpeedControllerGroup motorGroupLeft;
    private PWMTalonSRX motorRightFront;
    private PWMTalonSRX motorRightBack;
    private SpeedControllerGroup motorGroupRight;

    public SpeedControllerGroup getLeftGroup() { return motorGroupLeft; }
    public SpeedControllerGroup getRightGroup() { return motorGroupRight; }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Drivetrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        motorLeftFront = new VictorSP(0);
        addChild("MotorLeftFront",motorLeftFront);
        motorLeftFront.setInverted(false);
        
        motorLeftBack = new VictorSP(1);
        addChild("MotorLeftBack",motorLeftBack);
        motorLeftBack.setInverted(false);
        
        motorGroupLeft = new SpeedControllerGroup(motorLeftFront, motorLeftBack  );
        addChild("MotorGroupLeft",motorGroupLeft);
        
        
        motorRightFront = new PWMTalonSRX(2);
        addChild("MotorRightFront",motorRightFront);
        motorRightFront.setInverted(false);
        
        motorRightBack = new PWMTalonSRX(3);
        addChild("MotorRightBack",motorRightBack);
        motorRightBack.setInverted(false);
        
        motorGroupRight = new SpeedControllerGroup(motorRightFront, motorRightBack  );
        addChild("MotorGroupRight",motorGroupRight);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

