/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class DriveAutonomous extends SequentialCommandGroup {
  /**
   * Creates a new DriveAutonomous.
   */
  public DriveAutonomous(DriveSubsystem drive) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
   super(
     //makes a square
    new GoForward(drive, 2), 
    new TurnLeft(drive), 
    new GoForward(drive, 2), 
    new TurnLeft(drive), 
    new GoForward(drive, 2), 
    new TurnLeft(drive), 
    new GoForward(drive, 2), 
    new TurnLeft(drive),
    new TurnRight(drive)
    );
    drive.stop();
    
  }
}
