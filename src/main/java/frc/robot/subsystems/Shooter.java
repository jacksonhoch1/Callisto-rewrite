// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//robot files
import frc.robot.utils.IDMap;

//wpi libraries
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//vendor libraries
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;

public class Shooter extends SubsystemBase {
  WPI_TalonFX m_feeder, m_leftShooter, m_rightShooter;
  private double[] m_shooterSpeeds = {0.25, 0.50, 0.75, 1.0};
  private int m_shooterSpeedsPointer = 0;
  /** Creates a new Shooter. */
  public Shooter() {
    //TalonFX setup
    TalonFXConfiguration configs = new TalonFXConfiguration();
    configs.primaryPID.selectedFeedbackSensor = FeedbackDevice.IntegratedSensor;
    
    //feeder
    m_feeder = new WPI_TalonFX(IDMap.CAN.FEEDER.ID);
    m_feeder.configFactoryDefault();
    m_feeder.configAllSettings(configs);
    m_feeder.setInverted(TalonFXInvertType.Clockwise);

    //left shooter motor
    m_leftShooter = new WPI_TalonFX(IDMap.CAN.SHOOTER_LEFT.ID);
    m_leftShooter.configFactoryDefault();
    m_leftShooter.configAllSettings(configs);
    m_leftShooter.setInverted(TalonFXInvertType.Clockwise);

    //right shooter motor
    m_rightShooter = new WPI_TalonFX(IDMap.CAN.SHOOTER_RIGHT.ID);
    m_rightShooter.configFactoryDefault();
    m_rightShooter.configAllSettings(configs);
    m_rightShooter.setInverted(TalonFXInvertType.CounterClockwise);

  }

  //shooter methods
  public void setShooter(double speed) {
    m_leftShooter.set(speed);
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
