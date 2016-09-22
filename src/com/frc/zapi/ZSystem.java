package com.frc.zapi;

/**
 * Created by Zach Herridge on 4/6/2016.
 */

import com.frc.turtles.robot.RobotBase.*;
import com.frc.turtles.control.Controller.*;


public abstract class ZSystem {

    public void loop(boolean autoMode){
        if (autoMode){
            autoLoop();
        }
        else {
            teleOpLoop();
        }
    }

    public void autoLoop(){

    }


    public void teleOpLoop(){

    }
}
