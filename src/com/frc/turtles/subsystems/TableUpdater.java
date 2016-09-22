package com.frc.turtles.subsystems;

import com.frc.turtles.robot.Robot2015;
import com.frc.turtles.robot.RobotBase;
import com.frc.zapi.ZSystem;

/**
 * Created by Zach Herridge on 4/6/2016.
 */
public class TableUpdater extends ZSystem {

    @Override
    public void autoLoop() {
        updateTableValues();
    }

    @Override
    public void teleOpLoop() {
        updateTableValues();
    }

    public void updateTableValues(){
        Robot2015.TABLE.writeNumber("angleEncoder", RobotBase.ANGLE_ENCODER.get());
        Robot2015.TABLE.writeNumber("rotationEncoder", RobotBase.ROTATION_ENCODER.get());
    }
}
