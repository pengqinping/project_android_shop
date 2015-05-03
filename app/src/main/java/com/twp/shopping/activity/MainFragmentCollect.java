/*
 * 版       权:  Royal.k.peng@gmail.com, All rights reserved
 * 作       者:  Royal
 * 座 右  铭:  Never give up, adhere to in the end.
 */
package com.twp.shopping.activity;

import java.util.Iterator;
import java.util.Set;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.twp.frame.util.Logger;
import com.twp.shopping.R;
import com.twp.shopping.activity.MainTabActivity.ViewPagerSelectedListener;
import com.twp.shopping.adapter.CollectListViewAdapter;
import com.twp.shopping.provider.CollectOpenHelper;
import com.twp.shopping.provider.ProviderCollect;
import com.twp.shopping.util.Constants;

/**
 * 
 * @author Royal
 * @Email Royal.k.peng@gmail.com
 */
public class MainFragmentCollect extends BaseFragment implements
		ViewPagerSelectedListener {
	private static final String TAG = "MainFragmentCollect";
	private static final int TOKEN_QUERY_COLLECT = 1;
	private static final int TOKEN_DELETE_ = 2;
	private ListView listViewCollect;
	private TextView tvNodata;
	private CollectListViewAdapter mCollectAdapter;
	private static final int MSG_QUERY = 1;
	private BackgroundQueryCollect mBackkgroundHandler;
	private MultiChoiceModeListenerCollect mChoiceModel;

	public static MainFragmentCollect newInstance() {
		MainFragmentCollect home = new MainFragmentCollect();
		Bundle arg = new Bundle();
		home.setArguments(arg);
		return home;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public void onResume() {
		Logger.i(TAG, ">>>> onResume");
		super.onResume();
	}

	@Override
	public void onStop() {
		Logger.i(TAG, ">>>> onStop");
		super.onStop();
	}

	@Override
	public void onStart() {
		super.onStart();
		queryCollectCursor();
	}

	private void queryCollectCursor() {
		if (null != mBackkgroundHandler) {
			mBackkgroundHandler.startQuery(TOKEN_QUERY_COLLECT, null,
					ProviderCollect.CONTENT_URI,
					CollectOpenHelper.PROJECTIONCOLLECT, null, null, null);
		}

	}

	@Override
	public void onPause() {
		Logger.i(TAG, ">>>> onPause");
		super.onPause();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		mActivity.unRegisterViewPagerListener(Constants.FRAGMENT_IDENTIFY[2]);
	}

	@Override
	public View onChileCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_collect, null);
		mActivity.registerViewPagerListener(Constants.FRAGMENT_IDENTIFY[2],
				this);
		mBackkgroundHandler = new BackgroundQueryCollect(getActivity()
				.getContentResolver());
		initView(view);
		Logger.i(TAG, ">>>>>>  oncreateView  <<<<<");
		return view;
	}

	private void initView(View view) {
		mChoiceModel = new MultiChoiceModeListenerCollect();
		listViewCollect = (ListView) view.findViewById(R.id.listViewCollect);
		tvNodata = (TextView) view.findViewById(R.id.tvNodata);
		mCollectAdapter = new CollectListViewAdapter(getActivity());
		listViewCollect.setAdapter(mCollectAdapter);
		listViewCollect
				.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> parent,
							View view, int position, long id) {
						listViewCollect.startActionMode(mChoiceModel);
						return true;
					}
				});
		listViewCollect.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				//判断是否处于actioModel模式下面
				if (mCollectAdapter.isActionModeStarted()) {
					int value = mCollectAdapter.getItemStatu(position);
					value = value == 1 ? 0 : 1;
					mCollectAdapter.setItemStatu(position, value);
					mCollectAdapter.notifyDataSetChanged();
					if (mCollectAdapter.getSelectedItem().size() >= 1) {
						mChoiceModel.setDeleteEnable();
					} else {
						mChoiceModel.setDeleteDisable();
					}
					mChoiceModel.updateSeletedText(mCollectAdapter
							.getSeletedCount());
				} else {

					String skuId = mCollectAdapter.getCursor().getString(
							CollectOpenHelper.COLUMNINDEX_SKUID);
					int skuID = Integer.parseInt(skuId);
					String wareName = mCollectAdapter.getCursor().getString(
							CollectOpenHelper.COLUMNINDEX_WARMNAME);
					Logger.i(TAG, "collect click position = " + position);
					Intent intent = new Intent(mActivity,
							WareDetailActivity.class);
					intent.putExtra("skuId", skuID);
					intent.putExtra("Title", wareName);
					startActivity(intent);
				}
			}
		});
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		Logger.i(TAG, ">>>>>>  onCreateOptionsMenu  <<<<<");
		inflater.inflate(R.menu.collect, menu);
	}

	@Override
	public void onDestroyOptionsMenu() {
		super.onDestroyOptionsMenu();
		Logger.i(TAG, ">>>>>>  onDestroyOptionsMenu  <<<<<");
		if (null != mChoiceModel) {
			mChoiceModel.finshActionMode();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.collect_delete:
			Logger.i(TAG, ">>> delete model <<<");
			if (null != listViewCollect) {
				listViewCollect.startActionMode(mChoiceModel);
			}
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onNetWorkSettingActivityResult(int requestCode, int resultCode,
			Intent data) {

	}

	@Override
	protected void handleUIMessage(Message msg) {

	}

	private class BackgroundQueryCollect extends AsyncQueryHandler {

		public BackgroundQueryCollect(ContentResolver cr) {

			super(cr);
		}

		@Override
		protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
			super.onQueryComplete(token, cookie, cursor);
			if (token == TOKEN_QUERY_COLLECT) {
				Logger.i(TAG, "query complete !");
				int count = cursor.getCount();
				if (0 == count) {
					showListView(false);
					return;
				}
				showListView(true);
				for (int i = 0; i < count; i++) {
					mCollectAdapter.setItemStatu(i, 0);
				}
				mCollectAdapter.changeCursor(cursor);
			} else if (token == TOKEN_DELETE_) {
				Logger.i(TAG, "delete complete !");
				mChoiceModel.finshActionMode();

			}
		}

		private void showListView(boolean b) {
			if (null != listViewCollect && null != tvNodata) {
				listViewCollect.setVisibility(b ? View.VISIBLE : View.GONE);
				tvNodata.setVisibility(b ? View.GONE : View.VISIBLE);
			}
		}

	}

	private class MultiChoiceModeListenerCollect implements
			MultiChoiceModeListener, ActionMode.Callback {
		private ActionMode actionMode;
		private MenuItem mDelete;
		private TextView mShowSelectedItem;

		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			MenuInflater inflater = mode.getMenuInflater();
			inflater.inflate(R.menu.collect_item, menu);
			mDelete = menu.findItem(R.id.delete);
			mCollectAdapter.setActionModeStarted(true);
			listViewCollect.setLongClickable(false);
			actionMode = mode;
			View layout = LayoutInflater.from(getActivity()).inflate(
					R.layout.action_model_collect, null);
			mShowSelectedItem = (TextView) layout
					.findViewById(R.id.actionModelTitle);
			actionMode.setCustomView(layout);
			return true;
		}

		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			return false;
		}

		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			if (R.id.selectAll == item.getItemId()) {
				int countOfAdapter = mCollectAdapter.getCount();
				String title = item.getTitle().toString();
				String deleteAll = getActivity().getResources().getString(
						R.string.selectAll);
				if (title.equals(deleteAll)) {
					for (int i = 0; i < countOfAdapter; i++) {
						mCollectAdapter.setItemStatu(i, 1);
					}
					setDeleteEnable();
					item.setTitle(R.string.disSelectAll);
				} else {
					for (int i = 0; i < countOfAdapter; i++) {
						mCollectAdapter.setItemStatu(i, 0);
					}
					setDeleteDisable();
					item.setTitle(R.string.selectAll);
				}
				updateSeletedText(mCollectAdapter.getSeletedCount());
			} else if (R.id.delete == item.getItemId()) {
				AlertDialog.Builder mbuilder = new Builder(getActivity());
				mbuilder.setTitle("删除提示!");
				mbuilder.setIcon(android.R.drawable.ic_dialog_alert);
				mbuilder.setMessage("有 "
						+ mCollectAdapter.getSelectedItem().size()
						+ " 条数据将会被删除，你确定吗?");
				mbuilder.setPositiveButton("确定", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						Set<Integer> itemIdSet = mCollectAdapter
								.getSelectedItem();
						for (Iterator iterator = itemIdSet.iterator(); iterator
								.hasNext();) {
							Integer position = (Integer) iterator.next();
							Cursor cursor = mCollectAdapter.getCursor();
							cursor.moveToPosition(position);
							int count = cursor.getCount();
							Logger.i(TAG, "count = " + count + " , position = "
									+ position);
							if (count > 0) {
								String skuId = cursor
										.getString(CollectOpenHelper.COLUMNINDEX_SKUID);
								String selection = CollectOpenHelper.PARAM_SKUID
										+ " = ?";
								String[] selectionArgs = new String[] { skuId };
								mBackkgroundHandler.startDelete(TOKEN_DELETE_,
										null, ProviderCollect.CONTENT_URI,
										selection, selectionArgs);
								//删除之后更新状态
								mCollectAdapter.setItemStatu(position, 0);
							}
						}
						//重新查询一便刷新
						queryCollectCursor();
						//关闭选择模式
						mChoiceModel.finshActionMode();

					}
				});
				mbuilder.setNegativeButton("取消", null);
				mbuilder.create().show();

			}
			return true;
		}

		@Override
		public void onDestroyActionMode(ActionMode mode) {

			//设置适配器模式不是在actionMode 模式下
			mCollectAdapter.setActionModeStarted(false);
			listViewCollect.setLongClickable(true);
			//清除选中状态
			int countOfAdapter = mCollectAdapter.getCount();
			for (int i = 0; i < countOfAdapter; i++) {
				mCollectAdapter.setItemStatu(i, 0);
			}
			actionMode = null;

		}

		public void setDeleteDisable() {
			mDelete.setEnabled(false);
		}

		public void setDeleteEnable() {
			mDelete.setEnabled(true);
		}

		public void updateSeletedText(int seletedItems) {
			int seletedItem = mCollectAdapter.getSeletedCount();
			String countSeleted = getResources().getString(
					R.string.seletedCount, seletedItem);
			mShowSelectedItem.setText(countSeleted);
		}

		public void finshActionMode() {
			if (null != actionMode) {
				actionMode.finish();
			}
		}

		@Override
		public void onItemCheckedStateChanged(ActionMode mode, int position,
				long id, boolean checked) {
			Logger.i(TAG, "onItemCheckedStateChanged ");
		}

	}

	@Override
	public int getActionTitle() {
		return R.string.tab_collect;
	}

	@Override
	public void onPageSelected(int arg0) {

	}

}