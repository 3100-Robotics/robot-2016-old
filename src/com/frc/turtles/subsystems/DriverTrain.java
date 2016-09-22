package com.frc.turtles.subsystems;

import com.frc.turtles.control.Controller;
import com.frc.turtles.robot.RobotBase;
import com.frc.zapi.ZSystem;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * Created by Zach Herridge on 4/6/2016.
 */
public class DriverTrain extends ZSystem {

    private RobotDrive robotDrive = new RobotDrive(RobotBase.LEFT_DRIVE_MOTOR, RobotBase.RIGHT_DRIVE_MOTOR);

    @Override
    public void teleOpLoop() {
        robotDrive.arcadeDrive(Controller.getLeftStickY(), Controller.getRightStickX());
    }

    @Override
    public void autoLoop() {

    }
}
