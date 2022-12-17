// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//robot files
import frc.robot.utils.IDMap;

//wpilib
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//vendor libraries
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Climber extends SubsystemBase {
  private CANSparkMax m_leftClimb, m_rightClimb;
  /** Creates a new Climber. */
  public Climber() {
    //left motor
    m_leftClimb = new CANSparkMax(IDMap.CAN.CLIMBER_LEFT.ID, MotorType.kBrushless);
    m_leftClimb.restoreFactoryDefaults();
    m_leftClimb.setIdleMode(CANSparkMax.IdleMode.kBrake);

    //right motor
    m_rightClimb = new CANSparkMax(IDMap.CAN.CLIMBER_RIGHT.ID, MotorType.kBrushless);
    m_rightClimb.restoreFactoryDefaults();
    m_rightClimb.setIdleMode(CANSparkMax.IdleMode.kBrake);
    m_rightClimb.follow(m_leftClimb);
  }

  public void setSpeed(double speed) {
    m_leftClimb.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
