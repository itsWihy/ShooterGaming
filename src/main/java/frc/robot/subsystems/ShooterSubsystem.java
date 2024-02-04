package frc.robot.subsystems;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Constants.ShooterConstants.FLYWHEEL_LEFT_ID;
import static frc.robot.Constants.ShooterConstants.FLYWHEEL_RIGHT_ID;

public class ShooterSubsystem extends SubsystemBase {
    private final CANSparkFlex flywheelMaster = new CANSparkFlex(FLYWHEEL_LEFT_ID, CANSparkLowLevel.MotorType.kBrushless);
    private final CANSparkFlex flywheelSlave = new CANSparkFlex(FLYWHEEL_RIGHT_ID, CANSparkLowLevel.MotorType.kBrushless);

    public ShooterSubsystem() {
        flywheelMaster.restoreFactoryDefaults();
        flywheelSlave.restoreFactoryDefaults();

        flywheelSlave.setInverted(true);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Current Speed Master", flywheelMaster.getEncoder().getVelocity());
        SmartDashboard.putNumber("Current Speed Slave", flywheelSlave.getEncoder().getVelocity());

        SmartDashboard.putNumber("Current Voltage Master", flywheelMaster.getAppliedOutput() * flywheelSlave.getBusVoltage());
        SmartDashboard.putNumber("Current Voltage Slave", flywheelSlave.getAppliedOutput() * flywheelSlave.getBusVoltage());

    }

    public void setSpeed(double speed) {
        flywheelMaster.set(speed);
        flywheelSlave.set(speed);
    }

    public void stopFlywheels() {
        flywheelMaster.stopMotor();
        flywheelSlave.stopMotor();
    }
}
