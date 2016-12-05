package tn.enis.com.shock_detection_alert;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hrizi on 12/5/16.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATA_BASE_VERSION = 1;
    private static final String DATA_BASE_NAME="maBase";
    private static final String TABLE_PARAMS= "ParamSensor";

    private static final String KEY_ID="id";
    private static final String KEY_PARAM_X="x";
    private static final String KEY_PARAM_Y="y";
    private static final String KEY_PARAM_Z="z";
    private static final String KEY_PARAM_TIME="time";






    public DataBaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREAT_TABLE_PARAM = "CREATE TABLE"+TABLE_PARAMS+"("+KEY_ID+"INTEGER PRIMARY KEY,"+KEY_PARAM_X+
                " FLOAT,"+KEY_PARAM_Y+" FLOAT,"+KEY_PARAM_Z+" FLOAT,"+KEY_PARAM_TIME+"TIMESTAMP"+" )";
        sqLiteDatabase.execSQL(CREAT_TABLE_PARAM);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
