// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//robot files
import frc.robot.utils.IDMap;
import frc.robot.utils.Dashboard;

//wpi libraries
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

//vendor libraries
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;

public class Intake extends SubsystemBase {
  DoubleSolenoid m_intakeSolenoid;
  WPI_TalonFX m_intakeMotor;
  private boolean m_intakePosition;
  /** Creates a new Intake. */
  public Intake() {
    //TalonFX setup
    TalonFXConfiguration configs = new TalonFXConfiguration();
    configs.primaryPID.selectedFeedbackSensor = FeedbackDevice.IntegratedSensor;
    
    //intake motor
    m_intakeMotor = new WPI_TalonFX(IDMap.CAN.FEEDER.ID);
    m_intakeMotor.configFactoryDefault();
    m_intakeMotor.configAllSettings(configs);
    m_intakeMotor.setInverted(TalonFXInvertType.Clockwise);

    //intake solenoid
    m_intakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.REVPH, IDMap.CAN.INTAKE_DEPLOY.ID, IDMap.CAN.INTAKE_RETRACT.ID);
    m_intakeSolenoid.set(Value.kForward);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
