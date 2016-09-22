package com.frc.zapi;

import edu.wpi.first.wpilibj.IterativeRobot;

import java.util.ArrayList;

/**
 * Created by Zach Herridge on 4/6/2016.
 */
public class ZRobot extends IterativeRobot{

    private ArrayList<ZSystem> subSystems = new ArrayList<>();

    public ArrayList<ZSystem> getSubSystems() {
        return subSystems;
    }

    public void addSubSystem(ZSystem... systems){
        for (ZSystem system : systems) {
            subSystems.add(system);
        }
    }

    public void loop(boolean autoMode){
        for (ZSystem subSystem : subSystems) {
            subSystem.loop(autoMode);
        }
    }

    @Override
    public void autonomousPeriodic() {
        loop(true);
    }

    @Override
    public void teleopPeriodic() {
        loop(false);
    }
}
