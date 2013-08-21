package com.example.book.activity;

import xmu.software.acbuwa.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ThirdActivity extends Activity{
	
	private ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
			
		lv = (ListView)this.findViewById(R.id.listView1);
		String n[]={"xx","aa","xx","aa","xx","aa","xx","aa","xx","aa","xx","aa","xx","aa","xx","aa","xx","aa"};
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,n);
		lv.setAdapter(aa);
	}
}
