// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.utils;

//import subsystems
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

/** Add your docs here. */
public class AllRobotSubsystems {
    Chassis chassis;
    Climber climber;
    Indexer indexer;
    Intake intake;
    Shooter shooter;

    public AllRobotSubsystems(Chassis chassis, Climber climber, Indexer indexer, Intake intake, Shooter shooter) {
        this.chassis = chassis;
        this.climber = climber;
        this.indexer = indexer;
        this.intake = intake;
        this.shooter = shooter;
    }
}
