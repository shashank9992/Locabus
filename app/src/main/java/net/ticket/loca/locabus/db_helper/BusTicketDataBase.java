package net.ticket.loca.locabus.db_helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import net.ticket.loca.locabus.models.TicketDetails;
import net.ticket.loca.locabus.models.transactions.ContactInfo;
import net.ticket.loca.locabus.models.transactions.HoldRequest;
import net.ticket.loca.locabus.models.transactions.Passengers;


import java.util.ArrayList;

public class BusTicketDataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "bus_database";

    private static final String TICKET_TABLE = "bus_ticket";
    private static final String TICKET_INFO = "ticket_info";
    private static final String CONTACTINFO = "ContactInfo";
    private static final String PASSENGERS = "Passengers";

    private static final String _ID = "id";

    private static final String TICKET_ID = "ticket_id";
    private static final String HOLDING_ID = "holding_id";
    private static final String TICKET_PNR = "ticket_pnr";
    private static final String TICKETBOOK_ID = "ticket_booking_id";
    private static final String TRACK_ID = "track_id";
    private static final String CANCEL_STATUS = "isCancel";
    private static final String ONHOLD = "onhold";

    private static final String FROMCITYID = "FromCityId";
    private static final String TOCITYID = "ToCityId";
    private static final String JOURNEYDATE = "JourneyDate";
    private static final String BUSID = "BusId";
    private static final String PICKUPID = "PickUpID";
    private static final String DROPOFFID = "DropOffID";
    private static final String BASEFARE = "base_fare";
    private static final String FROMCITYNAME = "FromCityName";
    private static final String TOCITYNAME = "ToCityName";
    private static final String BUSNAME = "BusName";
    private static final String BUSTYPE = "BusType";

    private static final String PICKUPADD = "PickUpAdd";
    private static final String PICKUPTIME = "PickUpTime";
    private static final String DROPOFFADD = "DropOffAdd";
    private static final String DROPOFFTIME = "DropOffTime";


    //contact_info
    private static final String EMAIL = "Email";
    private static final String MOBILE = "Mobile";

    //Pssanger details
    private static final String NAME = "Name";
    private static final String AGE = "Age";
    private static final String GENDER = "Gender";
    private static final String SEATNO = "SeatNo";
    private static final String FARE = "Fare";
    private static final String SEATTYPEID = "SeatTypeId";
    private static final String ISACSEAT = "IsAcSeat";


    public BusTicketDataBase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TICKET_TABLE = "CREATE TABLE " + TICKET_TABLE + "(" + TICKET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HOLDING_ID + " TEXT ," + TICKET_PNR + " TEXT ," + TICKETBOOK_ID + " TEXT ," + TRACK_ID + " TEXT," + CANCEL_STATUS + " INTEGER,"+ ONHOLD + " INTEGER)";

        String CREATE_TICKET_INFO_TABLE = "CREATE TABLE " + TICKET_INFO + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TICKET_ID + " LONG ," +
                FROMCITYID + " INTEGER ," + TOCITYID + " INTEGER ," + JOURNEYDATE + " TEXT ," + BUSID + " INTEGER ," + PICKUPID + " TEXT ," +
                DROPOFFID + " TEXT ," + BASEFARE + " DOUBLE ," + FROMCITYNAME + " TEXT ," + TOCITYNAME + " TEXT ," + BUSNAME + " TEXT ," +
                PICKUPADD + " TEXT ," + PICKUPTIME + " TEXT ," + DROPOFFADD + " TEXT ," + DROPOFFTIME + " TEXT ," + BUSTYPE + " TEXT )";

        String CREATE_CONTACT_INFO_TABLE = "CREATE TABLE " + CONTACTINFO + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TICKET_ID + " LONG ," +
                EMAIL + " TEXT ," + MOBILE + " TEXT )";

        String CREATE_PASSENGERS_TABLE = "CREATE TABLE " + PASSENGERS + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TICKET_ID + " LONG ," +
                NAME + " TEXT ," + AGE + " INTEGER ," + GENDER + " TEXT ," + SEATNO + " TEXT ," + FARE + " DOUBLE ," +
                SEATTYPEID + " INTEGER ," + ISACSEAT + " TEXT )";

        sqLiteDatabase.execSQL(CREATE_TICKET_TABLE);
        sqLiteDatabase.execSQL(CREATE_TICKET_INFO_TABLE);
        sqLiteDatabase.execSQL(CREATE_CONTACT_INFO_TABLE);
        sqLiteDatabase.execSQL(CREATE_PASSENGERS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TICKET_TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TICKET_INFO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CONTACTINFO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PASSENGERS);
        onCreate(sqLiteDatabase);
    }

    public void onDeleteItems(int ticket_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(" delete from " + TICKET_TABLE + " WHERE " + TICKET_ID + " = " + ticket_id);
        db.execSQL(" delete from " + TICKET_INFO + " WHERE " + TICKET_ID + " = " + ticket_id);
        db.execSQL(" delete from " + CONTACTINFO + " WHERE " + TICKET_ID + " = " + ticket_id);
        db.execSQL(" delete from " + PASSENGERS + " WHERE " + TICKET_ID + " = " + ticket_id);
        db.close();
    }

    public String getDbVersion() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return "" + sqLiteDatabase.getVersion();
    }


    public long addTicket(String holding_id, String ticket_pnr, String ticket_book_id, String track_id, int cancel_status,int onhold) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HOLDING_ID, holding_id);
        contentValues.put(TICKET_PNR, ticket_pnr);
        contentValues.put(TICKETBOOK_ID, ticket_book_id);
        contentValues.put(TRACK_ID, track_id);
        contentValues.put(CANCEL_STATUS, cancel_status);
        contentValues.put(ONHOLD, onhold);
        return db.insert(TICKET_TABLE, null, contentValues);
    }

    public long updateTicket(long ticket_id,String holding_id, String ticket_pnr, String ticket_book_id, String track_id, int cancel_status,int onhold) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(HOLDING_ID, holding_id);
        contentValues.put(TICKET_PNR, ticket_pnr);
        contentValues.put(TICKETBOOK_ID, ticket_book_id);
        contentValues.put(TRACK_ID, track_id);
        contentValues.put(CANCEL_STATUS, cancel_status);
        contentValues.put(ONHOLD, onhold);

        return db.update(TICKET_TABLE, contentValues,TICKET_ID+" = "+ticket_id,null);
    }

    public void addTicketInfo(long ticket_id, HoldRequest dataItem) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TICKET_ID, ticket_id);
        contentValues.put(FROMCITYID, dataItem.getFromCityId());
        contentValues.put(TOCITYID, dataItem.getToCityId());
        contentValues.put(JOURNEYDATE, dataItem.getJourneyDate());
        contentValues.put(BUSID, dataItem.getBusId());
        contentValues.put(PICKUPID, dataItem.getPickUpID());
        contentValues.put(DROPOFFID, dataItem.getDropOffID());
        contentValues.put(BASEFARE, dataItem.getFare());
        contentValues.put(FROMCITYNAME, dataItem.getFromCityName());
        contentValues.put(TOCITYNAME, dataItem.getToCityName());
        contentValues.put(BUSNAME, dataItem.getBusName());
        contentValues.put(BUSTYPE, dataItem.getBusType());

        contentValues.put(PICKUPADD, dataItem.getPickUpAdd());
        contentValues.put(PICKUPTIME, dataItem.getPickUpTime());
        contentValues.put(DROPOFFADD, dataItem.getDropOffAdd());
        contentValues.put(DROPOFFTIME, dataItem.getDropOffTime());

        addContactInfo(ticket_id,dataItem.getContactInfo());
        for(Passengers passanger : dataItem.getPassengers()){
            addPassanger(ticket_id,passanger);
        }
        db.insert(TICKET_INFO, null, contentValues);
    }

    private void addContactInfo(long ticket_id, ContactInfo info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TICKET_ID, ticket_id);
        contentValues.put(EMAIL, info.getEmail());
        contentValues.put(MOBILE, info.getMobile());
        db.insert(CONTACTINFO, null, contentValues);
    }

    private void addPassanger(long ticket_id, Passengers passenger) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TICKET_ID, ticket_id);
        contentValues.put(NAME, passenger.getName());
        contentValues.put(AGE, passenger.getAge());
        contentValues.put(GENDER, passenger.getGender());
        contentValues.put(SEATNO, passenger.getSeatNo());
        contentValues.put(FARE, passenger.getFare());
        contentValues.put(SEATTYPEID, passenger.getSeatTypeId());
        if(passenger.isAcSeat()){
            contentValues.put(ISACSEAT, 1);
        }else{
            contentValues.put(ISACSEAT, 0);
        }
        db.insert(PASSENGERS, null, contentValues);
    }

    public ArrayList<TicketDetails> getAllTicketsList() {
        ArrayList<TicketDetails> mlist = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        String query = " Select * from " + TICKET_TABLE ;

        Cursor cursor = database.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    if(cursor.getInt(cursor.getColumnIndex(ONHOLD)) == 0){
                    TicketDetails ticket = new TicketDetails();
                    ticket.setTicket_id(cursor.getInt(cursor.getColumnIndex(TICKET_ID)));
                    ticket.setHolding_id(cursor.getString(cursor.getColumnIndex(HOLDING_ID)));
                    ticket.setTicket_pnr(cursor.getString(cursor.getColumnIndex(TICKET_PNR)));
                    ticket.setTicket_booking_id(cursor.getString(cursor.getColumnIndex(TICKETBOOK_ID)));
                    ticket.setTrack_id(cursor.getString(cursor.getColumnIndex(TRACK_ID)));
                    ticket.setIsCancel(cursor.getInt(cursor.getColumnIndex(CANCEL_STATUS)));
                    ticket.setHold(cursor.getInt(cursor.getColumnIndex(ONHOLD)));
                    ticket.setHoldItems(getHoldingModel(cursor.getInt(cursor.getColumnIndex(TICKET_ID))));
                    mlist.add(ticket);
                    }
                } while (cursor.moveToNext());
            }
        }

        return mlist;
    }

    private HoldRequest getHoldingModel(int ticket_id) {
        HoldRequest request = new HoldRequest();
        SQLiteDatabase database = this.getReadableDatabase();
        String query = " Select * from " + TICKET_INFO + " WHERE " + TICKET_ID + " = " + ticket_id;

        Cursor cursor = database.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    request.setFromCityId(cursor.getInt(cursor.getColumnIndex(FROMCITYID)));
                    request.setToCityId(cursor.getInt(cursor.getColumnIndex(TOCITYID)));
                    request.setJourneyDate(cursor.getString(cursor.getColumnIndex(JOURNEYDATE)));
                    request.setBusId(cursor.getInt(cursor.getColumnIndex(BUSID)));
                    request.setPickUpID(cursor.getString(cursor.getColumnIndex(PICKUPID)));
                    request.setDropOffID(cursor.getString(cursor.getColumnIndex(DROPOFFID)));
                    request.setFare(cursor.getDouble(cursor.getColumnIndex(BASEFARE)));
                    request.setFromCityName(cursor.getString(cursor.getColumnIndex(FROMCITYNAME)));
                    request.setToCityName(cursor.getString(cursor.getColumnIndex(TOCITYNAME)));
                    request.setBusName(cursor.getString(cursor.getColumnIndex(BUSNAME)));
                    request.setBusType(cursor.getString(cursor.getColumnIndex(BUSTYPE)));
                    request.setPickUpAdd(cursor.getString(cursor.getColumnIndex(PICKUPADD)));
                    request.setPickUpTime(cursor.getString(cursor.getColumnIndex(PICKUPTIME)));
                    request.setDropOffAdd(cursor.getString(cursor.getColumnIndex(DROPOFFADD)));
                    request.setDropOffTime(cursor.getString(cursor.getColumnIndex(DROPOFFTIME)));
                    request.setContactInfo(getContactInfo(ticket_id));
                    request.setPassengers(getPassanger_list(ticket_id));
                } while (cursor.moveToNext());
            }
        }

        return request;
    }

    private ArrayList<Passengers> getPassanger_list(int ticket_id) {
        ArrayList<Passengers> mlist = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        String query = " Select * from " + PASSENGERS + " WHERE " + TICKET_ID + " = " + ticket_id;

        Cursor cursor = database.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Passengers passnger = new Passengers();
                    passnger.setName(cursor.getString(cursor.getColumnIndex(NAME)));
                    passnger.setAge(cursor.getInt(cursor.getColumnIndex(AGE)));
                    passnger.setGender(cursor.getString(cursor.getColumnIndex(GENDER)));
                    passnger.setSeatNo(cursor.getString(cursor.getColumnIndex(SEATNO)));
                    passnger.setFare(cursor.getDouble(cursor.getColumnIndex(FARE)));
                    passnger.setSeatTypeId(cursor.getInt(cursor.getColumnIndex(SEATTYPEID)));
                    mlist.add(passnger);
                } while (cursor.moveToNext());
            }
        }

        return mlist;
    }

    private ContactInfo getContactInfo(int ticket_id) {
        ContactInfo request = new ContactInfo();
        SQLiteDatabase database = this.getReadableDatabase();
        String query = " Select * from " + CONTACTINFO + " WHERE " + TICKET_ID + " = " + ticket_id;

        Cursor cursor = database.rawQuery(query, null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    request.setCustomerName(cursor.getString(cursor.getColumnIndex(EMAIL)));
                    request.setEmail(cursor.getString(cursor.getColumnIndex(EMAIL)));
                    request.setPhone(cursor.getString(cursor.getColumnIndex(MOBILE)));
                    request.setMobile(cursor.getString(cursor.getColumnIndex(MOBILE)));
                } while (cursor.moveToNext());
            }
        }
        return request;
    }


}
