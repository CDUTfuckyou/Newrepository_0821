package com.example.book.activity;

import xmu.software.acbuwa.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends Activity{
	
	private TextView topbar_title;
		
	private LayoutInflater inflater;
	
	private View topbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		inflater = LayoutInflater.from(this);
		topbar = inflater.inflate(R.layout.acbuwa_topbar, null);	
		topbar_title = (TextView)topbar.findViewById(R.id.topbar_title);
		topbar_title.setText("123");		
	}
}
