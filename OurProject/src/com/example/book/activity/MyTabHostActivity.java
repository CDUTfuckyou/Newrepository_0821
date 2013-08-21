package com.example.book.activity;

import xmu.software.acbuwa.R;
import android.app.Activity;
import android.app.LocalActivityManager;
import android.os.Bundle;
import android.view.Window;
import android.widget.TabHost;

public class MyTabHostActivity extends Activity {
	
    @SuppressWarnings("deprecation")
	LocalActivityManager mlam;

    @SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_navigation);
        mlam = new LocalActivityManager(this, false);
        mlam.dispatchCreate(savedInstanceState);
        TabHost th = (TabHost) findViewById(android.R.id.tabhost);
        th.setup(mlam);
        
    }

    @Override
    protected void onResume(){
        super.onResume();
        mlam.dispatchResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mlam.dispatchPause(isFinishing());
    }

}