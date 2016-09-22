package com.frc.turtles.subsystems;

import com.frc.turtles.control.Controller;
import com.frc.turtles.robot.Robot2015;
import com.frc.turtles.robot.RobotBase;
import com.frc.zapi.ZSystem;

/**
 * Created by Zach Herridge on 4/6/2016.
 */
public class Intake extends ZSystem {

    @Override
    public void teleOpLoop() {
        if (!Robot2015.TURRET.isSystemState()){
            setIntake(Controller.getButtonLeftBumper());
            setElevator(Controller.getButtonA());
        }
    }

    public void setIntake(boolean state){
        RobotBase.INTAKE_MOTOR.set(state ? 1 : -1);
    }

    public void setElevator(boolean state){
        RobotBase.ELEVATOR_MOTOR.set(state ? 1 : -1);
    }

    public void setSystem(boolean state){
        if (state){
            RobotBase.ELEVATOR_MOTOR.set(1);
            RobotBase.INTAKE_MOTOR.set(1);
        }
        else {
            RobotBase.ELEVATOR_MOTOR.set(0);
            RobotBase.INTAKE_MOTOR.set(0);
        }
    }
}
