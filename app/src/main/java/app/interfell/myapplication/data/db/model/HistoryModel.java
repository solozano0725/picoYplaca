package app.interfell.myapplication.data.db.model;

public class HistoryModel {

    private String DATE;
    private String DATA_IN;
    private String DATA_OUT;


    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
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
                " DATE='" + DATE + '\'' +
                ", DATA_IN='" + DATA_IN + '\'' +
                ", DATA_OUT='" + DATA_OUT + '\'' +
                '}';
    }
}
