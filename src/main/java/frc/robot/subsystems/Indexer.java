// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


//robot files
import frc.robot.utils.IDMap;
import frc.robot.utils.Dashboard;

//wpilib
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//vendor libraries
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Indexer extends SubsystemBase {
  private CANSparkMax m_indexerMotor;
  /** Creates a new Indexer. */
  public Indexer() {
    m_indexerMotor = new CANSparkMax(IDMap.CAN.INDEXER.ID, MotorType.kBrushless);
    m_indexerMotor.restoreFactoryDefaults();
    m_indexerMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
    m_indexerMotor.setInverted(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Dashboard.INDEXER_SPEED.put(m_indexerMotor.get());
  }

  public void setSpeed(double speed) {
    m_indexerMotor.set(speed);
  }
}
