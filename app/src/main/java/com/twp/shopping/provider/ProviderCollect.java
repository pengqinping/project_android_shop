package com.twp.shopping.provider;

import com.twp.frame.util.EmptyUtil;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class ProviderCollect extends ContentProvider {

	private static final String TAG = ProviderCollect.class.getName();

	public static final String AUTOHORITY = "com.twp.shopping";
	public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.com.twp.shopping";
	public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.com.twp.shopping";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTOHORITY
			+ "/" + CollectOpenHelper.PRODUCT_TABLE_NAME);
	// 所以记录操作
	private static final int ITEM_ALL = 1;
	// 当条记录操作
	private static final int ITEM_ID = 2;

	private CollectOpenHelper mCollectOpenHelper;

	private static final UriMatcher sMatcher;

	static {
		sMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sMatcher.addURI(AUTOHORITY, CollectOpenHelper.PRODUCT_TABLE_NAME,
				ITEM_ALL);
		sMatcher.addURI(AUTOHORITY,
				CollectOpenHelper.PRODUCT_TABLE_NAME + "/#", ITEM_ID);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		SQLiteDatabase db = mCollectOpenHelper.getWritableDatabase();
		int count = 0;
		switch (sMatcher.match(uri)) {
		case ITEM_ALL:
			count = db.delete(CollectOpenHelper.PRODUCT_TABLE_NAME, selection,
					selectionArgs);
			break;
		case ITEM_ID:

			String id = uri.getPathSegments().get(1);

			count = db.delete(
					CollectOpenHelper.PRODUCT_TABLE_NAME,
					CollectOpenHelper.PARAM_ID
							+ "="
							+ id
							+ (!EmptyUtil.isStringEmpty(selection) ? "AND("
									+ selection + ')' : ""), selectionArgs);

			break;
		default:
			throw new IllegalArgumentException("Unknown URI" + uri);

		}
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}

	@Override
	public String getType(Uri uri) {
		switch (sMatcher.match(uri)) {
		case ITEM_ALL:
			return CONTENT_TYPE;
		case ITEM_ID:
			return CONTENT_ITEM_TYPE;
		default:
			throw new IllegalArgumentException("unkown this uri '" + uri + "'.");
		}
	}

	/**
	 * @exception IllegalArgumentException
	 *                () Uri不匹配
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db = mCollectOpenHelper.getWritableDatabase();
		long raw = 0;
		if (sMatcher.match(uri) == ITEM_ALL)
			throw new IllegalArgumentException("Unknown URI" + uri);

		//查询skuID是否已经存在，如果存在则去更新
		//String skuId = (String)values.get(CollectOpenHelper.PARAM_SKUID);

		raw = db.insert(CollectOpenHelper.PRODUCT_TABLE_NAME,
				CollectOpenHelper.PARAM_ID, values);
		if (raw > 0) {

			Uri noteUri = ContentUris.withAppendedId(uri, raw);

			getContext().getContentResolver().notifyChange(noteUri, null);

			return noteUri;

		}
		return null;
	}

	@Override
	public boolean onCreate() {
		this.mCollectOpenHelper = new CollectOpenHelper(this.getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteDatabase db = mCollectOpenHelper.getReadableDatabase();

		Cursor cursor;

		switch (sMatcher.match(uri))

		{

		case ITEM_ALL:
			cursor = db.query(CollectOpenHelper.PRODUCT_TABLE_NAME, projection,
					selection, selectionArgs, null, null, sortOrder);
			break;

		case ITEM_ID:

			String id = uri.getPathSegments().get(1);

			cursor = db.query(
					CollectOpenHelper.PRODUCT_TABLE_NAME,
					projection,
					CollectOpenHelper.PARAM_ID
							+ "="
							+ id
							+ (!EmptyUtil.isStringEmpty(selection) ? " and ("
									+ selection + ')' : ""), selectionArgs,
					null, null, sortOrder);
			break;

		default:

			// 如果传进来的Uri不是我们需要的类型
			throw new IllegalArgumentException("this is Unknown Uri：" + uri);
		}

		return cursor;

	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		SQLiteDatabase db = mCollectOpenHelper.getWritableDatabase();// 创建一个可读的数据库

		int count;

		switch (sMatcher.match(uri)) {
		case ITEM_ALL:
			count = db.update(CollectOpenHelper.PRODUCT_TABLE_NAME, values,
					selection, selectionArgs);
			break;
		case ITEM_ID:
			String id = uri.getPathSegments().get(1);// 获得id
			count = db.update(
					CollectOpenHelper.PRODUCT_TABLE_NAME,
					values,
					CollectOpenHelper.PARAM_ID
							+ "="
							+ id
							+ (!EmptyUtil.isStringEmpty(selection) ? " and ("
									+ selection + ')' : ""), selectionArgs);

			break;
		default:
			// 如果传进来的Uri不是我们需要的类型
			throw new IllegalArgumentException("this is Unknown Uri：" + uri);
		}

		getContext().getContentResolver().notifyChange(uri, null);

		return count;

	}

}
