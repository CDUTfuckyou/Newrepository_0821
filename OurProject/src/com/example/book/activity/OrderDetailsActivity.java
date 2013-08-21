package com.example.book.activity;


import xmu.software.acbuwa.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class OrderDetailsActivity extends Activity implements OnClickListener{
	
	private Button orderdetails_btn_confirm;
	
	private Intent intent;
	
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_orderdetails);
		
		context = OrderDetailsActivity.this;
		
		init();
	}
	
	private void init(){
		
		orderdetails_btn_confirm = (Button)this.findViewById(R.id.orderdetails_btn_confirm);
		
		orderdetails_btn_confirm.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.orderdetails_btn_confirm:
			intent = new Intent(context,OrderConfirmActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

}
