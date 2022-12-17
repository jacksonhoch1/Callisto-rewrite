// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//vendor libraries
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import com.kauailabs.navx.frc.AHRS;


//wpi libraries
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.SPI;

//utils
import frc.robot.utils.IDMap;
import frc.robot.utils.Dashboard;
import frc.robot.Constants;

public class Chassis extends SubsystemBase {
  WPI_TalonFX m_leftFront, m_leftRear, m_rightFront, m_rightRear;
  DifferentialDrive differentialDrive;
  AHRS m_gyro;

  private DifferentialDriveOdometry m_odometry;
  private Field2d m_field = new Field2d();

  public double throttleModifier = Constants.THROTTLE_MODIFIER;
  public double turnModifier = Constants.TURN_MODIFIER;
  /** Creates a new Chassis. */
  public Chassis() {
    //TalonFX setup
    TalonFXConfiguration configs = new TalonFXConfiguration();
    configs.primaryPID.selectedFeedbackSensor = FeedbackDevice.IntegratedSensor;

    //left front
    m_leftFront = new WPI_TalonFX(IDMap.CAN.LEFT_FRONT.ID);
    m_leftFront.configFactoryDefault();
    m_leftFront.configAllSettings(configs);
    m_leftFront.setInverted(TalonFXInvertType.Clockwise);
    m_leftFront.setNeutralMode(NeutralMode.Brake);

    //right Front
    m_rightFront = new WPI_TalonFX(IDMap.CAN.RIGHT_FRONT.ID);
    m_rightFront.configFactoryDefault();
    m_rightFront.configAllSettings(configs);
    m_rightFront.setInverted(TalonFXInvertType.CounterClockwise);
    m_rightFront.setNeutralMode(NeutralMode.Brake);

    //left rear
    m_leftRear = new WPI_TalonFX(IDMap.CAN.LEFT_REAR.ID);
    m_leftRear.configFactoryDefault();
    m_leftRear.configAllSettings(configs);
    m_leftRear.follow(m_leftFront);
    m_leftRear.setInverted(TalonFXInvertType.FollowMaster);
    m_leftRear.setNeutralMode(NeutralMode.Brake);

    //right rear
    m_rightRear = new WPI_TalonFX(IDMap.CAN.RIGHT_REAR.ID);
    m_rightRear.configFactoryDefault();
    m_rightRear.configAllSettings(configs);
    m_rightRear.follow(m_rightFront);
    m_rightRear.setInverted(TalonFXInvertType.FollowMaster);
    m_rightRear.setNeutralMode(NeutralMode.Brake);

    //sensor setup
    resetEncoders();
    m_gyro = new AHRS(SPI.Port.kMXP);
    m_gyro.reset();
    m_odometry = new DifferentialDriveOdometry(m_gyro.getRotation2d());
    Dashboard.putSendable("Field", m_field);

    


    //differential drive setup
    this.differentialDrive = new DifferentialDrive(m_leftFront, m_rightFront);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    Dashboard.GYRO_POSITION.put(getDegrees());

    m_odometry.update(
      m_gyro.getRotation2d(),
      getLeftDistanceMeters(),
      getRightDistanceMeters()
    );


  }

  //Drive methods
  public void arcadeDrive(double xAxisSpeed, double zAxisRotation) {
    this.differentialDrive.arcadeDrive(throttleModifier * xAxisSpeed, turnModifier * zAxisRotation);
  }

  public void setThrottleModifier(double throttleModifier) {
    this.throttleModifier = throttleModifier;
  }

  public void setTurnModifier(double turnModifier) {
    this.turnModifier = turnModifier;
  }

  public void setMaxOutput(double maxOutput) {
    this.differentialDrive.setMaxOutput(maxOutput);
  }

  //encoder methods
  public double getLeftDistanceMeters() {
    return m_leftFront.getSelectedSensorPosition() / Constants.COUNTS_PER_METER;
  }

  public double getRightDistanceMeters() {
    return m_rightFront.getSelectedSensorPosition() / Constants.COUNTS_PER_METER;
  }

  public double getLeftVelocityMetersPerSecond() {
    return m_leftFront.getSelectedSensorVelocity() / Constants.COUNTS_PER_METER;
  }

  public double getRightVelocityMetersPerSecond() {
    return m_rightFront.getSelectedSensorVelocity() / Constants.COUNTS_PER_METER;
  }

  public void resetEncoders() {
    m_leftFront.setSelectedSensorPosition(0);
    m_rightFront.setSelectedSensorPosition(0);
  }

  public void shiftUp() {
    this.differentialDrive.setMaxOutput(Constants.HIGH_SPEED);
  }

  public void shiftDown() {
    this.differentialDrive.setMaxOutput(Constants.LOW_SPEED);
  }

  //Gyro methods
  public double getDegrees() {
    return Math.IEEEremainder(m_gyro.getAngle(), 360);
  }

  public void resetGyro() {
    m_gyro.reset();
  }
}
