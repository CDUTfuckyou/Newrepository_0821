package com.example.book.activity;

import xmu.software.acbuwa.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class OrderConfirmActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_orderconfirm);
	}

}
