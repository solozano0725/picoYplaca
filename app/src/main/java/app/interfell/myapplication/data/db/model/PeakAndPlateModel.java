package app.interfell.myapplication.data.db.model;

import java.text.ParseException;

import app.interfell.myapplication.utils.Utils;

public class PeakAndPlateModel {

    private int ID;
    private int NUMBER_DAY;
    private String DAY;
    private String HOUR;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNUMBER_DAY() {
        return NUMBER_DAY;
    }

    public void setNUMBER_DAY(int NUMBER_DAY) {
        this.NUMBER_DAY = NUMBER_DAY;
    }

    public String getDAY() {
        return DAY;
    }

    public void setDAY(String DAY) {
        this.DAY = DAY;
    }

    public String getHOUR() {
        return HOUR;
    }

    public void setHOUR(String HOUR) {
        this.HOUR =  HOUR;
    }

    @Override
    public String toString() {
        return "PLACA: " + NUMBER_DAY +
                ", DIA='" + DAY + '\'' +
                ", HORA='" + HOUR + '\'';
    }
}
