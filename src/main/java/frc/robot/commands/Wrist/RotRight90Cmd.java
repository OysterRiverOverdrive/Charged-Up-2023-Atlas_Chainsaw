// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Wrist;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WristSubsystem;

public class RotRight90Cmd extends CommandBase {
  /** Creates a new RotRight90Cmd. */
  private WristSubsystem wrist;

  public RotRight90Cmd(WristSubsystem wrists) {
    wrist = wrists;
    addRequirements(wrists);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    wrist.resetrot();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    wrist.rotWristRight90();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double rotation = wrist.getrotations() * 360;
    System.out.println("Rotations " + rotation);
    if (rotation > 90) {
      wrist.stoprot();
      return true;
    } else {
      return false;
    }
  }
}
