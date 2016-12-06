package tn.enis.com.shock_detection_alert;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hrizi on 12/5/16.
 */

public class DataBaseHandler extends SQLiteOpenHelper {

    private static final int DATA_BASE_VERSION = 1;
    private static final String DATA_BASE_NAME = "maBase";
    private static final String TABLE_PARAMS = "ParamSensor";
    private static final String KEY_ID = "id";
    private static final String KEY_PARAM_X = "x";
    private static final String KEY_PARAM_Y = "y";
    private static final String KEY_PARAM_Z = "z";
    private static final String KEY_PARAM_TIME = "time";


    public DataBaseHandler(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREAT_TABLE_PARAM = "CREATE TABLE" + TABLE_PARAMS + "(" + KEY_ID + "INTEGER PRIMARY KEY," + KEY_PARAM_X +
                " FLOAT," + KEY_PARAM_Y + " FLOAT," + KEY_PARAM_Z + " FLOAT," + KEY_PARAM_TIME + "LONG" + " )";
        sqLiteDatabase.execSQL(CREAT_TABLE_PARAM);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PARAMS);
        onCreate(sqLiteDatabase);
    }

    public void addParams(Params params) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_PARAM_X, params.getX());
        values.put(KEY_PARAM_Y, params.getY());
        values.put(KEY_PARAM_Z, params.getZ());
        values.put(KEY_PARAM_TIME, params.getTime());

        db.insert(TABLE_PARAMS, null, values);
        db.close();
    }

    public Params getParams(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Params params = null;
        Cursor cursor = db.query(TABLE_PARAMS, new String[]{KEY_ID, KEY_PARAM_X, KEY_PARAM_Y, KEY_PARAM_Z, KEY_PARAM_TIME},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();

            params = new Params(Float.parseFloat(cursor.getString(1)),
                    Float.parseFloat(cursor.getString(2)), Float.parseFloat(cursor.getString(3)),
                    Long.parseLong(cursor.getString(4)));
        }
        return params;
    }
}
