/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    WPI_TalonSRX leftFront = new WPI_TalonSRX(0);
    WPI_TalonSRX rightFront = new WPI_TalonSRX(1);
    WPI_TalonSRX leftBack = new WPI_TalonSRX(2);
    WPI_TalonSRX rightBack = new WPI_TalonSRX(3);

    SpeedControllerGroup leftSide = new SpeedControllerGroup(leftFront, leftBack);
    SpeedControllerGroup rightSide = new SpeedControllerGroup(rightFront, rightBack);

    DifferentialDrive drive = new DifferentialDrive(leftSide, rightSide);
    Timer timer = new Timer();

  
  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {

  }

  public void drive(double speed, double rotation) {
    drive.arcadeDrive(speed, rotation);
  }

  public void turnRight() {
    leftSide.set(.5);
    rightSide.set(0);
   // drive.arcadeDrive(0, 0.5);
  }

  public void turnLeft() {
    rightSide.set(.5);
    leftSide.set(0);
   // drive.arcadeDrive(0, -0.5);
  }

  public void goForward(double seconds) {
    timer.start();
    while(timer.get() < seconds) {
      drive.arcadeDrive(0.5, 0);
    }
    timer.stop();
    drive.arcadeDrive(0, 0);
  }


  public void stop() {
    leftSide.set(0);
    rightSide.set(0);
  }

  

 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
