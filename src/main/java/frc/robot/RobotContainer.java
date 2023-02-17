// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.*;
import frc.robot.commands.*;
import frc.robot.commands.OneBar.*;
import frc.robot.subsystems.*;
import java.util.function.BooleanSupplier;

public class RobotContainer {
  // Defining Controllers
  private final Joystick driver1 = new Joystick(Controllers.DRIVER_ONE_PORT);
  private final Joystick driver2 = new Joystick(Controllers.DRIVER_SEC_PORT);
  private final Joystick operator = new Joystick(Controllers.OPER_PORT);

  // Defining Subsystems
  private final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
  private final ControllerSubsystem controls = new ControllerSubsystem();
  private final OnebarSubsystem onebar = new OnebarSubsystem();

  // Defining Commands
  private final AutoCmd m_autoCommand = new AutoCmd();
  private final TeleopCmd teleopCmd = new TeleopCmd(drivetrain);
  private final ShiftdownCmd shiftdown = new ShiftdownCmd(drivetrain);
  private final ShiftupCmd shiftup = new ShiftupCmd(drivetrain);

  private final OnebarDown armDown = new OnebarDown(onebar);
  private final OnebarUp armUp = new OnebarUp(onebar);
  private final OnebarOut armOut = new OnebarOut(onebar);
  private final OnebarIn armIn = new OnebarIn(onebar);
  private final ArmExtStop armExtStop = new ArmExtStop(onebar);
  private final ArmRotStop armRotStop = new ArmRotStop(onebar);

  public Trigger supplier(int buttonID) {
    BooleanSupplier bsup = () -> driver1.getRawButton(buttonID);
    Trigger mybutton = new Trigger(bsup);
    return mybutton;
  }
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();
    drivetrain.setDefaultCommand(teleopCmd);
    controls.setup();
    onebar.setup();
  }

  private void configureButtonBindings() {
    // // Arm Extension In
    // supplier(5).onTrue(armIn).onFalse(armExtStop);
    // // Arm Extension Out
    // supplier(3).onTrue(armOut).onFalse(armExtStop);
    // // Arm Rotation Up
    // supplier(6).onTrue(armUp).onFalse(armRotStop);
    // // Arm Rotation Down
    // supplier(4).onTrue(armDown).onFalse(armRotStop);

    // Shift Up
    supplier(Controllers.xbox_rbutton).onTrue(shiftup);
    // Shift Down
    supplier(Controllers.xbox_lbutton).onTrue(shiftdown);
  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
