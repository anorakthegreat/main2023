// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team100.frc2023.commands;

import org.team100.lib.motion.drivetrain.SwerveDriveSubsystem;


import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.Command;

// import edu.wpi.first.wpilibj2.command.CommandBase;

public class RotateModules extends Command {
  /** Creates a new RotateModules. */
  SwerveDriveSubsystem m_drive;

  SwerveModuleState[] targetModuleStates = new SwerveModuleState[4];

  public RotateModules(SwerveDriveSubsystem drive, Rotation2d angle) {
    // Use addRequirements() here to declare subsystem dependencies.

    m_drive = drive;

    // targetModuleStates = {
    //     new SwerveModuleState(0, Rotation2d.fromDegrees(0))
    // };

    Rotation2d newAngle = angle.plus(m_drive.getPose().getRotation());

    targetModuleStates[0] = new SwerveModuleState(0.0, newAngle);
    targetModuleStates[1] = new SwerveModuleState(0.0, newAngle);
    targetModuleStates[2] = new SwerveModuleState(0.0, newAngle);
    targetModuleStates[3] = new SwerveModuleState(0.0, newAngle);


    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    m_drive.setModuleStates(targetModuleStates);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.setModuleStates(targetModuleStates);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
