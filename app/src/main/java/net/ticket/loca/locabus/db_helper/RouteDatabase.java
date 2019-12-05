package net.ticket.loca.locabus.db_helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Administrator on 10/12/2017.
 */

public class RouteDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "route_database";


    public static final String FARE_DENOMINATION_TABLE = "fare_denom";
    public static final String FARE_TABLE_ID = "table_id";
    public static final String FARE_BASE_ID = "fare_base_id";
    public static final String FARE = "fare";
    public static final String TICKET_DENOM_DESC = "ticket_deno_desc";
    public static final String ORDER_BY = "order_by";
    public static final String TICKET_TYPE = "ticket_type";
    public static final String FARE_TYPE = "fare_type";
    public static final String TICKET_ORDER = "ticket_order";
    public static final String IS_ACTIVE = "is_active";
    public static final String UN_USED = "un_used";
    public static final String UNIT_ID = "unit_id";

    public static final String FARE_MASTER_TABLE = "fare_master";

    public static final String FARE_MASTER_ID = "fare_master_id";

    public static final String FARE_STEP_NUMBER = "fare_step_number";

    public static final String ADULT_FARE = "adult_fare";

    public static final String CHILD_FARE = "child_fare";

    public static final String CHILD_ONE_MONTH_PASS = "child_pass_fare_one";

    public static final String CHILD_THREE_MONTH_PASS = "child_pass_fare_three";

    public static final String CHILD_SIX_MONTH_PASS = "child_pass_fare_six";

    public static final String ADULT_ONE_MONTH_PASS = "adult_pass_fare_one";

    public static final String ADULT_THREE_MONTH_PASS = "adult_pass_fare_three";

    public static final String ADULT_SIX_MONTH_PASS = "adult_pass_fare_six";

    public static final String ADULT_FARE_LTD = "adult_fare_ltd";

    public static final String CHILD_FARE_LTD = "child_fare_ltd";

    public static final String AC_FARE = "ac_fare";

    public static final String SR_CITIZEN_FARE = "sr_citizen_fare";

    public static final String SR_CITIZEN_FARE_LTD = "sr_citizen_fare_ltd";

    public static final String FARE_MASTER_TABLE_ID = "id";


    public static final String ROUTE_TABLE = "route";

    public static final String ROUTE_TABLE_ID = "route_id";

    public static final String ROUTE_WISE_ID = "route_wise_id";

    public static final String ROUTE_NUMBER = "route_number";

    public static final String STOP_NAME_ENG = "stop_name_eng";

    public static final String STOP_NAME_MAR = "stop_name_mar";

    public static final String FARE_STAGE_NUMBER = "fare_stage_number";

    public static final String STAGE_ORDER_NUMBER = "stage_order_number";

    public static final String IS_STAGE_CHANGE = "is_state_change";

    public static final String ROUTE_DIRECTION = "route_direction";

    public static final String CHANGE_DATE = "change_date";

    public static final String ENTRY_DATE = "entry_date";

    public static final String ROUTE_NAME = "route_name";

    public static final String DEPOT_NAME = "depot_name";

    public static final String BUS_TYPE = "bus_type";

    public static final String BUS_TABLE = "bus_table";

    public static final String BUS_TABLE_ID = "bus_id";

    public static final String BUS_NUMBER_ID = "bus_no_id";

    public static final String BUS_NUMBER = "bus_number";

    public static final String ROUTE_FROM_TO_TABLE = "from_to";

    public static final String FROM_TO_TABLE_ID = "from_to_id";
    public static final String FROM_NAME_ENG = "from_name_eng";
    public static final String FROM_NAME_MAR = "from_name_mar";
    public static final String TO_NAME_ENG = "to_name_eng";
    public static final String TO_NAME_MAR = "to_name_mar";

    public static final String RECENT_TRIP_TABLE = "recent_trip_table";
    public static final String RECENT_FROM_STOP = "recent_from";
    public static final String RECENT_TO_STOP = "recent_to";
    public static final String RECENT_DATE = "recent_date";
    public static final String RECENT_TYPE = "recent_type";
    public static final String RECENT_TRIP_ID = "recent_id";

    public static final String STOP_NAME_TABLE = "stop_name";
    public static final String STOP_ID = "stop_id";
    public static final String STOP_NAME = "stop_name";
    public static final String STOP_TYPE = "stop_type";
    public static final String IS_STOP_POPULAR = "is_popular";

    public static final String BUS_STOP_MASTER = "bus_stop_master";
    public static final String BUS_STOP_MASTER_ID = "stop_id";
    public static final String BUS_STOP_MASTER_NAME = "stop_name";
    public static final String BUS_STOP_MASTER_TYPE = "stop_type";

//    public static final String TICKET_TABLE="ticket_table";
//    public static final String TICKET_SOURCE="ticket_source";
//    public static final String TICKET_DEST="ticket_source";
//    public static final String TICKET_DATE="ticket_source";
//    public static final String TICKET_TOTAL"ticket_source";
//    public static final String TICKET_A_COUNT="ticket_source";
//    public static final String TICKET_C_COUNT="ticket_source";

    public RouteDatabase(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        String CREATE_FARE_DENOM_TABLE = "CREATE TABLE " + FARE_DENOMINATION_TABLE + "(" + FARE_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                FARE_BASE_ID + " TEXT ," + FARE + " TEXT ," + TICKET_DENOM_DESC + " TEXT ," + ORDER_BY + " TEXT ,"
                + TICKET_TYPE + " TEXT ," + FARE_TYPE + " TEXT ," + TICKET_ORDER + " TEXT ,"
                + IS_ACTIVE + " TEXT ," + UN_USED + " TEXT ," + UNIT_ID + " TEXT )";

        String CREATE_FARE_MASTER_TABLE = "CREATE TABLE " + FARE_MASTER_TABLE + "(" + FARE_MASTER_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                FARE_MASTER_ID + " TEXT ," + FARE_STEP_NUMBER + " TEXT ," + ADULT_FARE + " TEXT ," + CHILD_FARE + " TEXT ,"
                + ADULT_FARE_LTD + " TEXT ," + CHILD_FARE_LTD + " TEXT ," + AC_FARE + " TEXT ," + SR_CITIZEN_FARE + " TEXT ,"
                + SR_CITIZEN_FARE_LTD + " TEXT )";

        String CREATE_ROUTE_TABLE = "CREATE TABLE " + ROUTE_TABLE + "(" + ROUTE_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ROUTE_WISE_ID + " TEXT ," + ROUTE_NUMBER + " TEXT ," + STOP_NAME_ENG + " TEXT ," + STOP_NAME_MAR + " TEXT ," +
                STAGE_ORDER_NUMBER + " TEXT ," + FARE_STAGE_NUMBER + " TEXT ," + IS_STAGE_CHANGE + " TEXT ," + ROUTE_DIRECTION + " TEXT ,"
                + ROUTE_NAME + " TEXT ," + DEPOT_NAME + " TEXT ," + BUS_TYPE + " TEXT ," + CHANGE_DATE + " TEXT ," +
                ENTRY_DATE + " TEXT)";

        String CREATE_BUS_TABLE = "CREATE TABLE " + BUS_TABLE + "(" + BUS_TABLE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                BUS_NUMBER_ID + " TEXT ," + BUS_NUMBER + " TEXT)";

        String CREATE_FROM_TO_TABLE = "CREATE TABLE " + ROUTE_FROM_TO_TABLE + "(" + FROM_TO_TABLE_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + ROUTE_NUMBER + " TEXT ," + FROM_NAME_ENG + " TEXT ," +
                FROM_NAME_MAR + " TEXT ," + TO_NAME_ENG + " TEXT ," + TO_NAME_MAR + " TEXT ," + BUS_TYPE + " TEXT )";


        String CREATE_RECENT_TRIP_TABLE = "CREATE TABLE " + RECENT_TRIP_TABLE + "(" + RECENT_TRIP_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + RECENT_FROM_STOP + " TEXT ," +
                RECENT_TO_STOP + " TEXT ," + RECENT_DATE + " TEXT ," + RECENT_TYPE + " TEXT )";

        String CREARE_STOP_TABLE = "CREATE TABLE " + STOP_NAME_TABLE + "(" + STOP_ID +
                " INTEGER PRIMARY KEY AUTOINCREMENT, " + STOP_NAME + " TEXT ," +
                STOP_TYPE + " INTEGER ," + IS_STOP_POPULAR + " INTEGER )";


        sqLiteDatabase.execSQL(CREATE_FARE_DENOM_TABLE);
        sqLiteDatabase.execSQL(CREATE_FARE_MASTER_TABLE);
        sqLiteDatabase.execSQL(CREATE_ROUTE_TABLE);
        sqLiteDatabase.execSQL(CREATE_BUS_TABLE);
        sqLiteDatabase.execSQL(CREATE_FROM_TO_TABLE);
        sqLiteDatabase.execSQL(CREATE_RECENT_TRIP_TABLE);
        sqLiteDatabase.execSQL(CREARE_STOP_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FARE_DENOMINATION_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FARE_MASTER_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ROUTE_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + BUS_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void onDelete() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(" delete from " + FARE_MASTER_TABLE);
        db.execSQL(" delete from " + FARE_DENOMINATION_TABLE);
        db.execSQL(" delete from " + ROUTE_TABLE);
        db.execSQL(" delete from " + BUS_TABLE);
        db.close();
    }

    public String getDbVersion() {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return "" + sqLiteDatabase.getVersion();
    }

    public void Delete_Fare() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(" delete from " + FARE_MASTER_TABLE);
        db.close();
    }

    public void Delete_Denom() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(" delete from " + FARE_DENOMINATION_TABLE);

        db.close();
    }


    public void Delete_Route() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(" delete from " + ROUTE_TABLE);

        db.close();
    }


    public boolean addBusData(String bus_no_id, String bus_number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BUS_NUMBER_ID, bus_no_id);
        contentValues.put(BUS_NUMBER, bus_number);
        db.insert(BUS_TABLE, null, contentValues);
        db.close();
        return true;
    }

    public boolean addRecentTrip(String from_name, String to_name, String date, String type) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RECENT_FROM_STOP, from_name);
        contentValues.put(RECENT_TO_STOP, to_name);
        contentValues.put(RECENT_DATE, date);
        contentValues.put(RECENT_TYPE, type);
        db.insert(RECENT_TRIP_TABLE, null, contentValues);
        db.close();

        return true;
    }


    public boolean addFareMaster(String fare_id, String fare, String denom_desc, String order_by, String t_type, String f_type, String t_order,
                                 String is_active, String un_used, int unit) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FARE_BASE_ID, fare_id);
        contentValues.put(FARE, fare);
        contentValues.put(TICKET_DENOM_DESC, denom_desc);
        contentValues.put(ORDER_BY, order_by);
        contentValues.put(TICKET_TYPE, t_type);
        contentValues.put(FARE_TYPE, f_type);
        contentValues.put(TICKET_ORDER, t_order);
        contentValues.put(IS_ACTIVE, is_active);
        contentValues.put(UN_USED, un_used);
        contentValues.put(UNIT_ID, unit);
        db.insert(FARE_DENOMINATION_TABLE, null, contentValues);
        db.close();
        return true;
    }


    public boolean addFare(String fare_master_id, String fare_step_number, String adult_fare, String child_fare,
                           String adult_fare_ltd, String child_fare_ltd, String ac_fare, String sr_citizen,
                           String sr_citizen_ltd) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FARE_MASTER_ID, fare_master_id);
        contentValues.put(FARE_STEP_NUMBER, fare_step_number);
        contentValues.put(ADULT_FARE, adult_fare);
        contentValues.put(CHILD_FARE, child_fare);
        contentValues.put(ADULT_FARE_LTD, adult_fare_ltd);
        contentValues.put(CHILD_FARE_LTD, child_fare_ltd);
        contentValues.put(AC_FARE, ac_fare);
        contentValues.put(SR_CITIZEN_FARE, sr_citizen);
        contentValues.put(SR_CITIZEN_FARE_LTD, sr_citizen_ltd);
        db.insert(FARE_MASTER_TABLE, null, contentValues);
        db.close();
        return true;
    }

    public boolean addRoute(String route_wise_id, String route_number, String stop_name_eng, String stop_name_mar,
                            String stage_order_no, String fare_stage_no, String is_stage_changed,
                            String route_direction, String route_name, String depot_name, String bus_type) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROUTE_WISE_ID, route_wise_id);
        contentValues.put(ROUTE_NUMBER, route_number);
        contentValues.put(STOP_NAME_ENG, stop_name_eng);
        contentValues.put(STOP_NAME_MAR, stop_name_mar);
        contentValues.put(STAGE_ORDER_NUMBER, stage_order_no);
        contentValues.put(FARE_STAGE_NUMBER, fare_stage_no);
        contentValues.put(IS_STAGE_CHANGE, is_stage_changed);
        contentValues.put(ROUTE_DIRECTION, route_direction);
        contentValues.put(ROUTE_NAME, route_name);
        contentValues.put(DEPOT_NAME, depot_name);
        contentValues.put(BUS_TYPE, bus_type);
        db.insert(ROUTE_TABLE, null, contentValues);
        db.close();
        return true;
    }

    public boolean addFromToData(String from_name_eng, String from_name_mar, String to_name_eng,
                                 String to_name_mar, String route_no, String bus_type) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ROUTE_NUMBER, route_no);
        contentValues.put(FROM_NAME_ENG, from_name_eng);
        contentValues.put(FROM_NAME_MAR, from_name_mar);
        contentValues.put(TO_NAME_ENG, to_name_eng);
        contentValues.put(TO_NAME_MAR, to_name_mar);
        contentValues.put(BUS_TYPE, bus_type);
        db.insert(ROUTE_FROM_TO_TABLE, null, contentValues);
        db.close();
        return true;
    }


    public Cursor getPopularStopName() {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("select * " + " from " + STOP_NAME_TABLE
                + " where " + STOP_TYPE + " = 2 and " + IS_STOP_POPULAR + " = 1", null);
    }

    public Cursor getRecentTrip() {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("select * " + " from " + RECENT_TRIP_TABLE
                + " group by " + RECENT_FROM_STOP + " having count(*) > 1"
                + " order by " + RECENT_TRIP_ID + " desc ", null);


    }

    public Cursor getURecentTrip() {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("select " + RECENT_FROM_STOP + " as STOPS from " + RECENT_TRIP_TABLE
                        + " union " + "select " + RECENT_TO_STOP + " from " + RECENT_TRIP_TABLE
                , null);


    }

    public Cursor getStopName() {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.rawQuery("select * " + " from " + ROUTE_TABLE
                + " group by " + ROUTE_NUMBER + " having count(*) > 1" + " order by " + ROUTE_TABLE_ID + " asc ", null);
    }

    public String getRouteFrom(String route_no, int type, int lang) {

        String from = "", query = "";

        String selectQuery = "SELECT " + STOP_NAME_ENG + " FROM " + ROUTE_TABLE + " where " +
                ROUTE_NUMBER + " = '" + route_no +
                "' and " + ROUTE_DIRECTION + " = 'false' " + " ORDER BY " + ROUTE_WISE_ID + " DESC LIMIT 1 ";

        String selectQueryMar = "SELECT " + STOP_NAME_ENG + " FROM " + ROUTE_TABLE + " where " +
                ROUTE_NUMBER + " = '" + route_no +
                "' and " + ROUTE_DIRECTION + " = 'false' " + " ORDER BY " + ROUTE_WISE_ID + " DESC LIMIT 1 ";

        String selectToEng = "SELECT " + STOP_NAME_ENG + " FROM " + ROUTE_TABLE + " where " +
                ROUTE_NUMBER + " = '" + route_no +
                "' and " + ROUTE_DIRECTION + " = 'false' " + " ORDER BY " + ROUTE_WISE_ID + " ASC LIMIT 1 ";

        String selectToMar = "SELECT " + STOP_NAME_ENG + " FROM " + ROUTE_TABLE + " where " +
                ROUTE_NUMBER + " = '" + route_no +
                "' and " + ROUTE_DIRECTION + " = 'false' " + " ORDER BY " + ROUTE_WISE_ID + " ASC LIMIT 1 ";

        if (type == 1 && lang == 1) {

            query = selectQuery;
        } else if (type == 1 && lang == 2) {

            query = selectQueryMar;
        } else if (type == 2 && lang == 1) {

            query = selectToEng;
        } else if (type == 2 && lang == 2) {

            query = selectToMar;
        }


        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor db_cursor = sqLiteDatabase.rawQuery(query, null);

        if (db_cursor.getCount() > 0) {

            if (db_cursor.moveToFirst()) {
                do {

                    from = db_cursor.getString(0);
                } while (db_cursor.moveToNext());
            }
        }
        db_cursor.close();
        sqLiteDatabase.close();
        return from;
    }


    public Cursor getFromToData() {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("select * " + " from " + ROUTE_FROM_TO_TABLE, null);
    }

    public Cursor getFromToData(int type,String stop_name){

        SQLiteDatabase db=this.getReadableDatabase();

        String query=" select * from from_to INNER JOIN route on from_to.route_number=route.route_number where route.stop_name_eng ='"+stop_name+"'"+
                " group by from_to.route_number";

        if (type==0){

            return db.rawQuery("select * "+" from "+ROUTE_FROM_TO_TABLE,null);
        }
        else {

            return db.rawQuery(query,null);
        }




    }

    public Cursor getFromToData(String route_no) {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("select * " + " from " + ROUTE_FROM_TO_TABLE +
                " where " + ROUTE_NUMBER + " = '" + route_no + "'", null);
    }

    public Cursor getBusStopForRoute(String route_no) {

        SQLiteDatabase db = this.getReadableDatabase();

        return db.rawQuery("select * " + " from " + ROUTE_TABLE + " where "
                + ROUTE_NUMBER + " = '" + route_no + "' and " + ROUTE_DIRECTION + " = 'false' ", null);
    }

    public Cursor getSelectedFare(String step_no) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from " + FARE_MASTER_TABLE + " where " + FARE_STEP_NUMBER + "= '" + step_no + "'", null);
    }


    public String getFareStageNumber(String route_no, int route_id) {

        String stage_number = "";

        String query = " select " + FARE_STAGE_NUMBER + " from " + ROUTE_TABLE + " where " + FARE_STAGE_NUMBER +
                " !='' and " + ROUTE_TABLE_ID + " <= " + route_id + " and " + ROUTE_NUMBER +
                " ='" + route_no + "' and " + ROUTE_DIRECTION + " ='false' " + "ORDER BY " + ROUTE_TABLE_ID + " DESC LIMIT 1";

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor db_cursor = sqLiteDatabase.rawQuery(query, null);

        if (db_cursor.getCount() > 0) {

            if (db_cursor.moveToFirst()) {
                do {

                    stage_number = db_cursor.getString(0);
                } while (db_cursor.moveToNext());
            }
        }
        db_cursor.close();
        sqLiteDatabase.close();
        return stage_number;

    }

    public Cursor getAllBustops(String s) {

        SQLiteDatabase database = this.getReadableDatabase();

        String query = " Select * from " + ROUTE_TABLE + " group by " + STOP_NAME_ENG +
                " order by " + STOP_NAME_ENG + " ASC ";

        String qry = " Select * from " + ROUTE_TABLE + " where " + STOP_NAME_ENG +
                " like '" + s + "%' group by " + STOP_NAME_ENG +
                " order by " + STOP_NAME_ENG + " ASC ";


        return database.rawQuery(qry, null);

    }

    public Cursor getAllBustopMaster(String s) {

        SQLiteDatabase database = this.getReadableDatabase();

        String qry = " Select * from " + BUS_STOP_MASTER + " where " + BUS_STOP_MASTER_NAME +
                " like '" + s + "%' group by " + BUS_STOP_MASTER_NAME +
                " order by " + BUS_STOP_MASTER_NAME + " ASC ";


        return database.rawQuery(qry, null);

    }

    public Cursor getSearchResult(String source, String destination) {

        SQLiteDatabase database = this.getReadableDatabase();

        String query = " Select * from " + ROUTE_TABLE + " where " + STOP_NAME_MAR +
                " in ('" + source + "' , '" + destination + "') and " + ROUTE_DIRECTION + " = 'false' " +
                " group by " + ROUTE_NUMBER + " having count(*) > 1 ";

        return database.rawQuery(query, null);
    }

    public Cursor getSearchEnglisResult(String source, String destination) {

        SQLiteDatabase database = this.getReadableDatabase();

        String query = " Select * from " + ROUTE_TABLE + " where " + STOP_NAME_ENG +
                " in ('" + source + "' , '" + destination + "') and " + ROUTE_DIRECTION + " = 'false' " +
                " group by " + ROUTE_NUMBER + " having count(*) > 1 ";

        return database.rawQuery(query, null);
    }

    public Cursor getNullData() {

        SQLiteDatabase database = this.getReadableDatabase();

        String query = " Select DISTINCT " + STOP_NAME_ENG + " , " + STOP_NAME_MAR + " from " + ROUTE_TABLE +
                " where " + STOP_NAME_ENG + " is null";


        return database.rawQuery(query, null);
    }

    public String getNullStopnameEng(String mar_name) {

        String stage_number = "";

        String query = " select Distinct " + STOP_NAME_ENG + " from " + ROUTE_TABLE + " where " + STOP_NAME_MAR + " = '" + mar_name
                + "' and " + STOP_NAME_ENG + " is not null";

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor db_cursor = sqLiteDatabase.rawQuery(query, null);

        if (db_cursor.getCount() > 0) {

            if (db_cursor.moveToFirst()) {
                do {

                    stage_number = db_cursor.getString(0);
                } while (db_cursor.moveToNext());
            }
        }
        db_cursor.close();
        sqLiteDatabase.close();
        return stage_number;

    }

    public boolean updateData(String eng_name, String mar_name) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STOP_NAME_ENG, eng_name);
        db.update(ROUTE_TABLE, contentValues, STOP_NAME_ENG + " is null and " + STOP_NAME_MAR + " = '" + mar_name + "'", null);
        return true;
    }


    public int getStopId(String route_no, String stop_name) {

        int stop_id = 0;

        String selectQuery = "SELECT " + ROUTE_TABLE_ID + " FROM " + ROUTE_TABLE + " where " +
                ROUTE_NUMBER + " = '" + route_no + "' and " + STOP_NAME_MAR + " = '" + stop_name + "'" +
                " and " + ROUTE_DIRECTION + " = 'false' " + " ORDER BY " + ROUTE_WISE_ID + " DESC LIMIT 1 ";


        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor db_cursor = sqLiteDatabase.rawQuery(selectQuery, null);

        if (db_cursor.getCount() > 0) {

            if (db_cursor.moveToFirst()) {
                do {

                    stop_id = db_cursor.getInt(0);
                } while (db_cursor.moveToNext());
            }
        }
        db_cursor.close();
        sqLiteDatabase.close();
        return stop_id;
    }

    public String getStopnameEng(int route_id) {

        String stage_number = "";

        String query = " select stop_name_eng from route where route_wise_id = " + route_id;

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor db_cursor = sqLiteDatabase.rawQuery(query, null);

        if (db_cursor.getCount() > 0) {

            if (db_cursor.moveToFirst()) {
                do {

                    stage_number = db_cursor.getString(0);
                } while (db_cursor.moveToNext());
            }
        }
        db_cursor.close();
        sqLiteDatabase.close();
        return stage_number;

    }

    public String getStopnameMar(String route_id) {

        String stage_number = "Abc";

        String query = " select " + STOP_NAME_MAR + " from " + ROUTE_TABLE + " where " + STOP_NAME_ENG + " = '" + route_id + "'";

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor db_cursor = sqLiteDatabase.rawQuery(query, null);

        if (db_cursor.getCount() > 0) {

            if (db_cursor.moveToFirst()) {
                do {

                    stage_number = db_cursor.getString(0);
                } while (db_cursor.moveToNext());
            }
        }
        db_cursor.close();
        sqLiteDatabase.close();
        return stage_number;

    }
}
