package org.usfirst.frc.team5530.robot.subsystems;

import org.usfirst.frc.team5530.robot.RobotMap;
import org.usfirst.frc.team5530.robot.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DrivetrainSS extends Subsystem {

	public static WPI_TalonSRX frontRight  = new WPI_TalonSRX(RobotMap.FR);
	public static WPI_TalonSRX frontLeft  = new WPI_TalonSRX(RobotMap.FL);
	public static WPI_TalonSRX backRight  = new WPI_TalonSRX(RobotMap.BR);
	public static WPI_TalonSRX backLeft = new WPI_TalonSRX(RobotMap.BL);
	
	public static void initialize() {
		backRight.set(ControlMode.Follower, (double)RobotMap.FR);
		backLeft.set(ControlMode.Follower, (double)RobotMap.FL);
		frontRight.setInverted(true);
		backRight.setInverted(true);
		
		frontRight.setSensorPhase(true);
		
		frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
	}

    public void initDefaultCommand() {
    		setDefaultCommand(new XboxDrive());
        //setDefaultCommand(new MySpecialCommand());
    }
}

