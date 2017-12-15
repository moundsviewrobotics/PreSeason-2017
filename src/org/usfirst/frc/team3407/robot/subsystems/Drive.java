package org.usfirst.frc.team3407.robot.subsystems;

import org.usfirst.frc.team3407.robot.OI;
import org.usfirst.frc.team3407.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**w
 *
 */
public class Drive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private RobotDrive drive = new RobotDrive(0,1,2,3);
	
	public void driveForward(double time, double value) {
		drive.drive(value, 0);
		System.out.println("start ");
		Timer.delay(time);
		System.out.println(value + " "+ time);
		drive.drive(0, 0);
	}
	public void turnLeft(double time, double value){
		drive.drive(value, -1);
		Timer.delay(time);
		drive.drive(0, 0);
		
	}
	public void turnRight(double time, double value) {
		drive.drive(value, 1);
		Timer.delay(time);
		drive.drive(0, 0);
	}
	public void tankDrive() {
	drive.tankDrive(OI.lStick.getY()*.5, OI.rStick.getY()*.5);
	}
	public void stop() {
		drive.drive(0, 0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveCommand());
    }
}

