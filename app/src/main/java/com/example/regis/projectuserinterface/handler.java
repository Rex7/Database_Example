package com.example.regis.projectuserinterface;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class handler extends SQLiteOpenHelper

{
    public static final int database_version=1;
    public static final String DataBase_name="StudentRecord.db";
    public static final String Table_name="Student";
    public static  final String  roll_no="rollno";
    public static final String Firstname="First_name";
    public static final String Last_name="Last_name";
    public static final String Email_id="Email";
    public static final String col_phone="Phone";
    public static final String Course="Course";
    public static final String Table_Attend="attend";
    public static final String Trigger_after="after_insert";

    public handler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DataBase_name, factory, database_version);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
       db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_query = "CREATE TABLE " + Table_name + "(" +
                roll_no + " INTEGER NOT NULL, " +
                Firstname + " TEXT  NOT NULL," +
                Course  + " TEXT NOT NULL  , "+
                Last_name+ " TEXT NOT NULL , " +
                Email_id + " TEXT NOT NULL , " +
                col_phone + " TEXT NOT NULL , "+
               " PRIMARY KEY (" + roll_no + ") "+
                ");";
        db.execSQL(table_query);
        String attend="CREATE TABLE " + Table_Attend + " (\n" +
                "\t`rollno`\tINTEGER,\n" +
                "\t`1`\tINTEGER,\n" +
                "\t`2`\tINTEGER,\n" +
                "\t`3`\tINTEGER,\n" +
                "\t`4`\tINTEGER,\n" +
                "\t`5`\tINTEGER,\n" +
                "\t`6`\tINTEGER,\n" +
                "\t`7`\tINTEGER,\n" +
                "\t`8`\tINTEGER,\n" +
                "\t`9`\tINTEGER,\n" +
                "\t`10`\tINTEGER,\n" +
                "\t`11`\tINTEGER,\n" +
                "\t`12`\tINTEGER,\n" +
                "\t`13`\tINTEGER,\n" +
                "\t`14`\tINTEGER,\n" +
                "\t`15`\tINTEGER,\n" +
                "\t`16`\tINTEGER,\n" +
                "\t`17`\tINTEGER,\n" +
                "\t`18`\tINTEGER,\n" +
                "\t`19`\tINTEGER,\n" +
                "\t`20`\tINTEGER,\n" +
                "\t`21`\tINTEGER,\n" +
                "\t`22`\tINTEGER,\n" +
                "\t`23`\tINTEGER,\n" +
                "\t`24`\tINTEGER,\n" +
                "\t`25`\tINTEGER,\n" +
                "\t`26`\tINTEGER,\n" +
                "\t`27`\tINTEGER,\n" +
                "\t`28`\tINTEGER,\n" +
                "\t`29`\tINTEGER,\n" +
                "\t`30`\tINTEGER,\n" +
                "\t`31`\tINTEGER,\n" +
                "\tforeign key ("+roll_no+") references " + Table_name + " ( " + roll_no + ")\n" +
                ")";
        db.execSQL(attend);
        String trigger=" CREATE TRIGGER " + Trigger_after +
                "\n" +
                "after insert on " + Table_name+ " for each row \n" +
                "begin\n" +
                "insert into " + Table_Attend + " (rollno) values (new.rollno) ; \n" +
                "end";
        db.execSQL(trigger);
    }

    public void register(Student s)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues vs  =new ContentValues();
        vs.put(roll_no,s.getRollno());
        vs.put(Firstname,s.getFirst());
        vs.put(Last_name,s.getLast());
        vs.put(col_phone,s.getPhone());
        vs.put(Email_id,s.getEmailid());
        vs.put(Course,s.getCourse());
        db.insert(Table_name,null,vs);


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String query=" DROP TABLE IF EXISTS "+Table_name;
        String table_attendquery="DROP TABLE IF EXISTS" + Table_Attend;
        String trigger_query="DROP TRIGGER"+Trigger_after;

        db.execSQL(query);
        db.execSQL(table_attendquery);
        db.execSQL(trigger_query);
        onCreate(db);
    }
}
