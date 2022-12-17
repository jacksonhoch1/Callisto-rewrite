// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.utils;

/** A class to store all of the IDs such as CAN and DIO*/
public class IDMap {

    private IDMap() {};

    /**CAN ids */
    public enum CAN {
        //Chassis
        LEFT_FRONT (2),     //TalonFX
        LEFT_REAR (21),     //TalonFX
        RIGHT_FRONT (1),    //TalonFX
        RIGHT_REAR (11),    //TalonFX

        //Climber
        CLIMBER_LEFT (42),  //SparkMAX
        CLIMBER_RIGHT (43), //SparkMAX

        //Feeder
        FEEDER (5),         //TalonFX

        //Indexer
        INDEXER (4),        //SparkMAX

        //Intake
        INTAKE (3),         //TalonFX
        INTAKE_PH (1),      //Pneumatics Hub

        INTAKE_DEPLOY (3),  //not CAN id, but solenoid position on PH
        INTAKE_RETRACT (4), //not CAN id, but solenoid position on PH

        //Shooter
        SHOOTER_LEFT (6),   //TalonFX
        SHOOTER_RIGHT (61); //TalonFX

        public final int ID;
        private CAN(int id) {
            ID = id;
        }
    }

    /**Button and gamepad ids for 2 player controls*/
    public enum Button2p {
        //Gamepads
        DRIVER_GAMEPAD (0),
        OPERATOR_GAMEPAD (1),

        //Driver
        ARCADE_THROTTLE_CHANNEL (1),
        ARCADE_ROTATION_CHANNEL(2),

        SPEED_SHIFT_UP (5),
        SPEED_SHIFT_DOWN (7),

        //Operator
        INTAKE_DEPLOY (8),
        INTAKE_RETRACT (6),
        INTAKE_OFF (3),
        INTAKE_REVERSE (4),

        INDEXER_OFF (2),
        INDEXER_REVERSE (1),

        SHOOTER_SHIFT_UP (0),           //POV button
        SHOOTER_SHIFT_DOWN (180),       //POV button
        READY_SHOOTER (9),
        SHOOT (7),
        STOP_SHOOTER ( 14),

        CLIMBER_CHANNEL (1);

        public int ID;
        private Button2p(int id) {
            ID = id;
        }
    }

    /**Button bindings for 1 player controls */
    public enum Button1p {
        //Gamepads
        DRIVER_GAMEPAD (0),

        //Buttons
        ARCADE_THROTTLE_CHANNEL (1),
        ARCADE_ROTATION_CHANNEL (2),

        SPEED_SHIFT_UP (10),
        SPEED_SHIFT_DOWN (9),

        RUN_INTAKE (7),
        RUN_INTAKE_REVERSE (5),
        STOP_INTAKE (3),

        SHOOTER_SHIFT_UP (0),           //POV button
        SHOOTER_SHIFT_DOWN (180),       //POV button
        SHOOT (8),
        STOP_SHOOTER (1),

        CLIMBER_EXTEND (2),
        CLIMBER_RETRACT (4);



        public int ID;
        private Button1p(int id) {
            ID = id;
        }
    }
}
