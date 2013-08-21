package com.example.book.activity;


import xmu.software.acbuwa.R;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TextView;

public class TabHostActivity extends TabActivity {
	/** Called when the activity is first created. */ 
	private TabHost tabHost; 
	private TextView main_tab_new_message; 
	private String[] ss = new String[]{"首页", "我要买书", "我要卖书", "交易记录"};
	private Intent intent; 
	
//	private Handler startActivityHandler;
	
//	private StartActivity startActivity;
	
	public static int topbar_rightBtn_tag=0;
	
	@Override 
	public void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
		setContentView(R.layout.activity_navigation); 
				
		main_tab_new_message=(TextView) findViewById(R.id.main_tab_new_message); 
		main_tab_new_message.setVisibility(View.VISIBLE); 
		main_tab_new_message.setText("10"); 
		tabHost = this.getTabHost(); 
		TabHost.TabSpec spec; 
		
		
		intent=new Intent().setClass(this, FirstActivity.class); 
		spec=tabHost.newTabSpec(ss[0]).setIndicator(ss[0]).setContent(intent); 
		tabHost.addTab(spec); 
		
		intent=new Intent().setClass(this,SecondActivity.class); 
		spec=tabHost.newTabSpec(ss[1]).setIndicator(ss[1]).setContent(intent); 
		tabHost.addTab(spec); 
		
		intent=new Intent().setClass(this, ThirdActivity.class); 
		spec=tabHost.newTabSpec(ss[2]).setIndicator(ss[2]).setContent(intent); 
		tabHost.addTab(spec); 
		
		intent=new Intent().setClass(this, FourthActivity.class); 
		spec=tabHost.newTabSpec(ss[3]).setIndicator(ss[3]).setContent(intent); 
		tabHost.addTab(spec); 
	
		RadioGroup radioGroup=(RadioGroup) this.findViewById(R.id.main_tab_group);

		tabHost.setCurrentTab(0); 

		
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() { 
			@Override 
			public void onCheckedChanged(RadioGroup group, int checkedId) { 
				// TODO Auto-generated method stub
				
//				startActivity = new StartActivity();
//				startActivityHandler = startActivity.returenHandler();
				
				switch (checkedId) { 
					case R.id.main_tab_addMessage:
						tabHost.setCurrentTabByTag(ss[0]); 
						//startActivityHandler.sendEmptyMessage(0);
						StartActivity.topbar_text.setText("首页");
						StartActivity.rightBtn.setBackgroundResource(R.drawable.icon_email);
						topbar_rightBtn_tag=0;
						break; 
					case R.id.main_tab_myExam:
						StartActivity.topbar_text.setText("我要买书");
						StartActivity.rightBtn.setBackgroundResource(R.drawable.icon_search);
						tabHost.setCurrentTabByTag(ss[1]); 
						topbar_rightBtn_tag=1;
						break; 
					case R.id.main_tab_message: 
						StartActivity.topbar_text.setText("我要卖书");
						tabHost.setCurrentTabByTag(ss[2]); 
						break; 
					case R.id.main_tab_settings: 
						StartActivity.topbar_text.setText("交易记录");
						tabHost.setCurrentTabByTag(ss[3]); 
						break; 
					default: 
					
					break; 
				} 
				
			} 
		}); 
	}
	
}
