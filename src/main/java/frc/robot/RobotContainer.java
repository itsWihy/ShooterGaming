// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ShooterCommands;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {

    private final Joystick driver = new Joystick(0);
    private final JoystickButton startShooter = new JoystickButton(driver, XboxController.Button.kX.value);
    private final JoystickButton startShooterNegative = new JoystickButton(driver, XboxController.Button.kY.value);

    private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
    private final ShooterCommands shooterCommands = new ShooterCommands(shooterSubsystem);

    public RobotContainer() {
        configureBindings();
    }


    private void configureBindings() {
        startShooter.whileTrue(shooterCommands.startShooter(0.7));
        startShooterNegative.whileTrue(shooterCommands.startShooter(-0.7));
    }


    public Command getAutonomousCommand() {
        // An example command will be run in autonomous
        return null;
    }
}
