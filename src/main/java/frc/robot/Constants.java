// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Default motor Speeds
    public static final double HIGH_SPEED = 1.0;
    public static final double LOW_SPEED = 0.2;

    public static final double THROTTLE_MODIFIER = 1.0;
    public static final double TURN_MODIFIER = 1.0;

    public static final double FEEDER_SPEED = 1.0;
    public static final double FEEDER_REVERSE_SPEED = -0.2;

    public static final double SHOOTER_SPEED = 0.35;

    public static final double INDEXER_SPEED = 0.5;
    public static final double INDEXER_REVERSE_SPEED = -0.2;

    //chassis constants
    public static double WHEEL_DIAMETER_INCHES = 4; 
    public static double WHEEL_DIAMETER_METERS = 0.1016;  
    public static double TRACK_WIDTH = 0;

    public static double GEAR_RATIO = 9.64;

    public static double ENCODER_COUNTS_PER_REVOLUTION = 2048; // this value is from the manufacturer
    public static double COUNTS_PER_REVOLUTION = ENCODER_COUNTS_PER_REVOLUTION * GEAR_RATIO; // this value incorporates the gear ratio and equals 19742.72

    public static double COUNTS_PER_INCH = COUNTS_PER_REVOLUTION / Math.PI * WHEEL_DIAMETER_INCHES;
    public static double COUNTS_PER_METER = COUNTS_PER_REVOLUTION / (Math.PI * WHEEL_DIAMETER_METERS);

}
