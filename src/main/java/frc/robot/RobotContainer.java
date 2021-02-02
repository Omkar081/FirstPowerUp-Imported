/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Drive;
import frc.robot.commands.DriveAutonomous;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.GoForward;
import frc.robot.commands.TurnLeft;
import frc.robot.commands.TurnRight;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  Joystick joystick = new Joystick(0);
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  

  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);
  private final Drive m_drive = new Drive(m_driveSubsystem, () -> joystick.getY(), () -> joystick.getX());
  private final DriveAutonomous driveAutonomous = new DriveAutonomous(m_driveSubsystem);
  /*private final GoForward goForward = new GoForward(m_driveSubsystem, 5);
  private final TurnLeft turnLeft = new TurnLeft(m_driveSubsystem);
  private final TurnRight turnRight = new TurnRight(m_driveSubsystem); */



 



  /*
  public double getY() {
    return joystick.getY();
  }
  */
  

  





  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    m_driveSubsystem.setDefaultCommand(m_drive);
    configureButtonBindings();

 
  }

  /*public void AutonomousPractice() {
    for (int i = 0; i < 4; i++) {
      new SequentialCommandGroup(
        new GoForward(m_driveSubsystem, 5),
        new TurnLeft(m_driveSubsystem));
      
  } 
} */


  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }



  

 

  

   

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    return driveAutonomous;
  }
}
