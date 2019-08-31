package app.interfell.myapplication.data.db;

public class CommonDB {

    public static final String DATABASE_NAME = "PEAKANDPLATE.DB";
    public static final String PP_TABLE_NAME = "PEAKSANDPLATE";
    public static final String PP_TABLE_NAME_COLUMN_ID = "NUMBER_DAY";
    public static final String PP_TABLE_NAME_COLUMN_DAY = "DAY";

    public static final String HISTORY_TABLE_NAME = "HISTORY_PEAKANDPLATE";
    public static final String HISTORY_TABLE_NAME_COLUMN_ID = "ID";
    public static final String HISTORY_TABLE_NAME_COLUMN_DATE = "DATE";
    public static final String HISTORY_TABLE_NAME_COLUMN_HOUR = "HOUR";
    public static final String HISTORY_TABLE_NAME_COLUMN_IN = "DATA_IN";
    public static final String HISTORY_TABLE_NAME_COLUMN_OUT = "DATA_OUT";

    public static final String CREATE_TABLE_PP = "CREATE TABLE IF NOT EXISTS "+PP_TABLE_NAME+
            " ("+PP_TABLE_NAME_COLUMN_ID+" INTEGER PRIMARY KEY NOT NULL, "
            +PP_TABLE_NAME_COLUMN_DAY+" TEXT "+")";

    public static final String CREATE_TABLE_HISTORY = "CREATE TABLE IF NOT EXISTS "+HISTORY_TABLE_NAME+
            " ("+HISTORY_TABLE_NAME_COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            +HISTORY_TABLE_NAME_COLUMN_DATE+" TEXT, "
            +HISTORY_TABLE_NAME_COLUMN_HOUR+" TEXT, "
            +HISTORY_TABLE_NAME_COLUMN_IN+" TEXT, "
            +HISTORY_TABLE_NAME_COLUMN_OUT+" TEXT "+")";

    public static final String DROP_TABLE_PP = "DROP TABLE IF EXISTS "+PP_TABLE_NAME;
    public static final String DROP_TABLE_HISTORY = "DROP TABLE IF EXISTS "+HISTORY_TABLE_NAME;
    public static final String SELECT_ALL_PP = "SELECT * FROM " + PP_TABLE_NAME;

    public static final String INSERT_1 = "INSERT INTO " + PP_TABLE_NAME + " ("
            + PP_TABLE_NAME_COLUMN_DAY + ", " + PP_TABLE_NAME_COLUMN_ID + ") Values ('Lunes', 1)";
    public static final String INSERT_2 = "INSERT INTO " + PP_TABLE_NAME + " ("
            + PP_TABLE_NAME_COLUMN_DAY + ", " + PP_TABLE_NAME_COLUMN_ID + ") Values ('Lunes', 2)";
    public static final String INSERT_3 = "INSERT INTO " + PP_TABLE_NAME + " ("
            + PP_TABLE_NAME_COLUMN_DAY + ", " + PP_TABLE_NAME_COLUMN_ID + ") Values ('Martes', 3)";
    public static final String INSERT_4 = "INSERT INTO " + PP_TABLE_NAME + " ("
            + PP_TABLE_NAME_COLUMN_DAY + ", " + PP_TABLE_NAME_COLUMN_ID + ") Values ('Martes', 4)";
    public static final String INSERT_5 = "INSERT INTO " + PP_TABLE_NAME + " ("
            + PP_TABLE_NAME_COLUMN_DAY + ", " + PP_TABLE_NAME_COLUMN_ID + ") Values ('Miercoles', 5)";
    public static final String INSERT_6 = "INSERT INTO " + PP_TABLE_NAME + " ("
            + PP_TABLE_NAME_COLUMN_DAY + ", " + PP_TABLE_NAME_COLUMN_ID + ") Values ('Miercoles', 6)";
    public static final String INSERT_7 = "INSERT INTO " + PP_TABLE_NAME + " ("
            + PP_TABLE_NAME_COLUMN_DAY + ", " + PP_TABLE_NAME_COLUMN_ID + ") Values ('Jueves', 7)";
    public static final String INSERT_8 = "INSERT INTO " + PP_TABLE_NAME + " ("
            + PP_TABLE_NAME_COLUMN_DAY + ", " + PP_TABLE_NAME_COLUMN_ID + ") Values ('Jueves', 8)";
    public static final String INSERT_9 = "INSERT INTO " + PP_TABLE_NAME + " ("
            + PP_TABLE_NAME_COLUMN_DAY + ", " + PP_TABLE_NAME_COLUMN_ID + ") Values ('Viernes', 9)";
    public static final String INSERT_10 = "INSERT INTO " + PP_TABLE_NAME + " ("
            + PP_TABLE_NAME_COLUMN_DAY + ", " + PP_TABLE_NAME_COLUMN_ID + ") Values ('Viernes', 0)";
}
