package app.interfell.myapplication.data.db.model;

public class HistoryModel {

    private int ID;
    private String DATE;
    private String HOUR;
    private String DATA_IN;
    private String DATA_OUT;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public String getHOUR() {
        return HOUR;
    }

    public void setHOUR(String HOUR) {
        this.HOUR = HOUR;
    }

    public String getDATA_IN() {
        return DATA_IN;
    }

    public void setDATA_IN(String DATA_IN) {
        this.DATA_IN = DATA_IN;
    }

    public String getDATA_OUT() {
        return DATA_OUT;
    }

    public void setDATA_OUT(String DATA_OUT) {
        this.DATA_OUT = DATA_OUT;
    }

    @Override
    public String toString() {
        return "HistoryModel{" +
                "ID=" + ID +
                ", DATE='" + DATE + '\'' +
                ", HOUR='" + HOUR + '\'' +
                ", DATA_IN='" + DATA_IN + '\'' +
                ", DATA_OUT='" + DATA_OUT + '\'' +
                '}';
    }
}
