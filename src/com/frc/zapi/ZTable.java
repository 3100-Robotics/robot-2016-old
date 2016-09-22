package com.frc.zapi;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * Created by Zach Herridge on 4/6/2016.
 */
public class ZTable {

    public static final int DEFULT = -999999999;

    private String tableName;
    private NetworkTable table;

    public ZTable(String tableName) {
        this.tableName = tableName;
        this.table = NetworkTable.getTable(tableName);
    }

    public void writeNumber(String key, double value){
        table.putNumber(key, value);
    }

    public void writeNumber(String key, int value){
        table.putNumber(key, value);
    }

    public void writeString(String key, String value){
        table.putString(key, value);
    }

    public void writeBoolean(String key, boolean value){
        table.putBoolean(key, value);
    }

    public int getInt(String key){
        return (int) table.getNumber(key, DEFULT);
    }

}
