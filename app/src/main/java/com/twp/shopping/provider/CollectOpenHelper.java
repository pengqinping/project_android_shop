package com.twp.shopping.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CollectOpenHelper extends SQLiteOpenHelper {

	protected static final String PRODUCT_DB_NAME = "productdb";
	protected static final String PRODUCT_TABLE_NAME = "tb_product";
	public static final String PARAM_ID = "_id";
	public static final String PARAM_SKUID = "_skuId";
	public static final String PARAM_WARMNAME = "_wareName";
	public static final String PARAM_WAREPRICE = "_price";
	public static final String PARAM_WARE_CONTENT = "_content";
	public static final String PARAM_WARE_IMAGEURL = "_imageUrl";
	public static final String[] PROJECTIONCOLLECT = new String[] { PARAM_ID,
			PARAM_SKUID, PARAM_WARMNAME, PARAM_WAREPRICE, PARAM_WARE_CONTENT,
			PARAM_WARE_IMAGEURL };
	
	public static final int COLUMNINDEX_ID= 0;
	public static final int COLUMNINDEX_SKUID= 1;
	public static final int COLUMNINDEX_WARMNAME= 2;
	public static final int COLUMNINDEX_WAREPRICE= 3;
	public static final int COLUMNINDEX_WARE_CONTEN= 4;
	public static final int COLUMNINDEX_WARE_IMAGEURL= 5;

	public static final String SQL = "create table " + PRODUCT_TABLE_NAME
			+ " (" + PARAM_ID + " integer primary key autoincrement not null,"
			+ PARAM_SKUID + " text not null," + PARAM_WARMNAME
			+ " text not null," + PARAM_WAREPRICE + " text,"
			+ PARAM_WARE_CONTENT + " text ," + PARAM_WARE_IMAGEURL + " text "
			+ ");";

	public CollectOpenHelper(Context context) {
		super(context, PRODUCT_DB_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
