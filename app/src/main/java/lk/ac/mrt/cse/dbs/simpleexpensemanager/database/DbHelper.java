package lk.ac.mrt.cse.dbs.simpleexpensemanager.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Account;
import lk.ac.mrt.cse.dbs.simpleexpensemanager.data.model.Transaction;

public class DbHelper  extends  SQLiteOpenHelper {
    private static final String name = "Bank";
    private static final int version =1;
    private static final String Table_name1 = "Account_nfo";
    private static final String Table_name2 = "log_info";

    private static final String ACCOUNT_NO="Account No";
    private static final String BANK ="Bank";
    private static final String ACCOUNT_HOLDER="Account Holder";
    private static final String INITIAL_BALANCE="initial Balance";

    private  String DATE;
    private String TYPE;
    private  String AMOUNT ;

    public DbHelper(@Nullable Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TABLE_CREATE_QUERY ="CREATE TABLE "+Table_name1+" "+
                "("
                +ACCOUNT_NO +" TEXT PRIMARY KEY,"
                +BANK +" TEXT,"
                +ACCOUNT_HOLDER+" TEXT,"
                +INITIAL_BALANCE+" TEXT,"
                +"); "
                +"CREATE TABLE "+Table_name2+" "+
                "("
                +DATE+ " DATE "
                +ACCOUNT_NO+" TEXT"
                +TYPE+ " TEXT"
                +AMOUNT+ " TEXT"
                +"); ";


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE_QUERY="DROP TABLE IF EXISTS "+ Table_name1;
        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);

    }
    public void addAccount(Account account){
        SQLiteDatabase sqLiteDatabase1=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(ACCOUNT_NO,account.getAccountNo());
        contentValues.put(BANK,account.getBankName());
        contentValues.put(ACCOUNT_HOLDER,account.getAccountHolderName());
        contentValues.put(INITIAL_BALANCE,account.getBalance());

        sqLiteDatabase1.insert(Table_name1,null,contentValues);
        sqLiteDatabase1.close();
    }

    public void addLog (Transaction transaction){
        SQLiteDatabase sqLiteDatabase2=getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put(DATE,transaction.getDate().toString());
        contentValues.put(ACCOUNT_NO,transaction.getAccountNo());
        contentValues.put(TYPE,transaction.getExpenseType().toString());
        contentValues.put(AMOUNT,transaction.getAmount());

        sqLiteDatabase2.insert(Table_name1,null,contentValues);
        sqLiteDatabase2.close();

    }
}
