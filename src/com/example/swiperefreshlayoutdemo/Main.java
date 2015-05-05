package com.example.swiperefreshlayoutdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Main extends Activity implements SwipeRefreshLayout.OnRefreshListener {
	private SwipeRefreshLayout swipeLayout;
	private ListView listView;
	private ListViewAdapter adapter;
	private ArrayList<String> list;
	private ArrayAdapter<String> mAdapter; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
         swipeLayout.setOnRefreshListener(this);
         swipeLayout.setColorScheme(android.R.color.holo_blue_bright, android.R.color.holo_green_light,
         android.R.color.holo_orange_light, android.R.color.holo_red_light);

         list = new ArrayList<String>();
         list.add("Lina");

         listView = (ListView) findViewById(R.id.list);
//         adapter = new ListViewAdapter(this, list);
       mAdapter  = 
        		 new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_activated_1,list); 
         listView.setAdapter(mAdapter);
	}
	
	private class ListViewAdapter extends BaseAdapter{
		private Context mContext;
		private ArrayList<String> mList;
		
		public ListViewAdapter(final Context context,final ArrayList<String> list){
			this.mContext = context;
			this.mList = list;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	@Override
	public void onRefresh() {
		new Handler().postDelayed(new Runnable() {
			public void run() {
				swipeLayout.setRefreshing(false);
				list.add("ass");
				mAdapter.notifyDataSetChanged();
			}
		}, 1000);
	}
}
