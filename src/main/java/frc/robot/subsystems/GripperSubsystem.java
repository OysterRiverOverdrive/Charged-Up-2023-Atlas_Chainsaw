// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class GripperSubsystem extends SubsystemBase {
  /** Creates a new GripperSubsystem. */
  public GripperSubsystem() {}

  private final CANSparkMax gripmot = new CANSparkMax(Constants.Gripper, MotorType.kBrushless);

  public void rotateoutGripper() {

    gripmot.set(-0.33);
  }

  public void rotateinGripper() {

    gripmot.set(0.33);
  }

  public void stopGripper() {

    gripmot.stopMotor();
  }

  @Override
  public void periodic() {}
}