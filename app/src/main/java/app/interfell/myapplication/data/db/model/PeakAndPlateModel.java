package app.interfell.myapplication.data.db.model;

public class PeakAndPlateModel {

    private int ID;
    private int DAY;
    private int NUMBER_DAY;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getDAY() {
        return DAY;
    }

    public void setDAY(int DAY) {
        this.DAY = DAY;
    }

    public int getNUMBER_DAY() {
        return NUMBER_DAY;
    }

    public void setNUMBER_DAY(int NUMBER_DAY) {
        this.NUMBER_DAY = NUMBER_DAY;
    }

    @Override
    public String toString() {
        return "PeakAndPlateModel{" +
                "ID=" + ID +
                ", DAY=" + DAY +
                ", NUMBER_DAY=" + NUMBER_DAY +
                '}';
    }
}
