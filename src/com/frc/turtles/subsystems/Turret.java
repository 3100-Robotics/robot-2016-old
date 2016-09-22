package com.frc.turtles.subsystems;

import com.frc.turtles.control.Controller;
import com.frc.turtles.robot.Robot2015;
import com.frc.turtles.robot.RobotBase;
import com.frc.zapi.ZSystem;
import com.frc.zapi.ZTable;

/**
 * Created by Zach Herridge on 4/6/2016.
 */
public class Turret extends ZSystem {

    private boolean shotCurrentState = false;
    private long lastToggleTime = 0;
    private boolean systemState = false;

    @Override
    public void teleOpLoop() {
        if (Controller.getButtonRightBumper() && (System.currentTimeMillis() - lastToggleTime) > 500){
            shotCurrentState = !shotCurrentState;
            lastToggleTime = System.currentTimeMillis();

            toggleShot(shotCurrentState);

            Robot2015.TABLE.writeBoolean("shotState", shotCurrentState);
        }
    }

    @Override
    public void autoLoop() {
        int angleTarget = Robot2015.TABLE.getInt("angleTarget");
        int angleCurrent = RobotBase.ANGLE_ENCODER.get();

        int rotationTarget = Robot2015.TABLE.getInt("rotationTarget");
        int rotationCurrent = RobotBase.ROTATION_ENCODER.get();

        if (angleTarget == ZTable.DEFULT || rotationTarget == ZTable.DEFULT){
            RobotBase.ROTATION_MOTOR.set(0);
            RobotBase.ANGLE_MOTOR.set(0);
            return;
        }

        if (isInZone(rotationCurrent, rotationTarget) && isInZone(angleCurrent, angleTarget)){
            RobotBase.ROTATION_MOTOR.set(0);
            RobotBase.ANGLE_MOTOR.set(0);
            toggleShot(true);
        }
        else {
            RobotBase.ROTATION_MOTOR.set(scaleSpeed(rotationCurrent, rotationTarget));
            RobotBase.ANGLE_MOTOR.set(scaleSpeed(angleCurrent, angleTarget));
        }
    }

    public boolean isSystemState() {
        return systemState;
    }

    public void toggleShot(boolean state){
        systemState = state;
        if (state){
            Robot2015.INTAKE.setSystem(false);
            RobotBase.SHOOTER_MOTOR.set(0);
        }
        else {
            Robot2015.INTAKE.setSystem(true);
            RobotBase.SHOOTER_MOTOR.set(1);
        }
    }

    private boolean isInZone(int current, int target){
        int absDifference = Math.abs(current - target);
        if (absDifference < 20){
            return true;
        }
        return false;
    }

    private double scaleSpeed(int current, int target){
        int absDifference = Math.abs(current - target);
        int direction = (current > target) ? -1 : 1;

        if (absDifference < 20){
            return 0;
        }

        if (absDifference < 50){
            return .2 * direction;
        }
        else {
            return .6 * direction;
        }
    }
}
