// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import Library things
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

//import utilities
import frc.robot.utils.IDMap;
import frc.robot.utils.AllRobotSubsystems;

//import subsystems
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

//import commands
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  /** The container for the robot. Contains subsystems, OI devices, and commands. */

  private final Chassis m_chassis = new Chassis();
  private final Climber m_climber = new Climber();
  private final Indexer m_indexer = new Indexer();
  private final Intake m_intake = new Intake();
  private final Shooter m_shooter = new Shooter();

  private final AllRobotSubsystems m_allRobotSubsystems = new AllRobotSubsystems(m_chassis, m_climber, m_indexer, m_intake, m_shooter);

  private final Joystick m_gamepadDriver = new Joystick(IDMap.Button2p.DRIVER_GAMEPAD.ID);
  private final Joystick m_gamepadOperator = new Joystick(IDMap.Button2p.OPERATOR_GAMEPAD.ID);


  public RobotContainer() {


    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new InstantCommand();
  }
}
