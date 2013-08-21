package com.example.book.activity;

import xmu.software.acbuwa.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class FirstActivity extends Activity {
	
	private String TAG = "FirstActivity";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);	
			
		StartActivity.rightBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(TabHostActivity.topbar_rightBtn_tag==0){
					Log.d(TAG,"首页点击");
				}
				else if(TabHostActivity.topbar_rightBtn_tag==1){
					Log.d(TAG, "我要买书点击");
				}
			}
		});
	}
}
