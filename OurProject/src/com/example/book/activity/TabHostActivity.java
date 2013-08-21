package com.example.book.activity;


import xmu.software.acbuwa.R;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TextView;




public class TabHostActivity extends TabActivity {
	/** Called when the activity is first created. */ 
	private TabHost tabHost; 
	private TextView main_tab_new_message; 
	private String[] ss = new String[]{"首页", "我要买书", "我要卖书", "设置"};
	private Intent intent; 
	
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
		
		
		//radioGroup.check(a);
		tabHost.setCurrentTab(0); 

		
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() { 
			@Override 
			public void onCheckedChanged(RadioGroup group, int checkedId) { 
				// TODO Auto-generated method stub 
				switch (checkedId) { 
					case R.id.main_tab_addMessage://最新新闻
						tabHost.setCurrentTabByTag(ss[0]); 
						break; 
					case R.id.main_tab_myExam://我的信息
						tabHost.setCurrentTabByTag(ss[1]); 
						break; 
					case R.id.main_tab_message://我的通知 
						tabHost.setCurrentTabByTag(ss[2]); 
						break; 
					case R.id.main_tab_settings://设置 
						tabHost.setCurrentTabByTag(ss[3]); 
						break; 
					default: 
					//tabHost.setCurrentTabByTag(""); 
					break; 
				} 
				
			} 
		}); 
	} 		
}
