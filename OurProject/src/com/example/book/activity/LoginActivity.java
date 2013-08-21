package com.example.book.activity;

import xmu.software.acbuwa.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.book.afinal.AjaxCallBack;
import com.example.book.afinal.AjaxParams;
import com.example.book.afinal.FinalHttp;

public class LoginActivity extends Activity implements OnClickListener{
	
	private String TAG = "LoginActivity";
	
	private Context context;
	
	private Intent intent;
	
	private Button login_btn_register,login_btn_login;
	
	private ImageButton login_ibtn_back;
	
	private EditText login_et_phone,login_et_password;
	
	private String phoneNumber,passWord;
	
	private FinalHttp finalHttp;
	
	private final String SevirceUrl="http://192.168.1.105:8080/BookSell";
	
	private String uri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		context = LoginActivity.this;
		
		init();
		
		uri = "login";
	}
	
	private void init(){

		login_btn_register = (Button)this.findViewById(R.id.login_btn_register);
		login_btn_login = (Button)this.findViewById(R.id.login_btn_login);
		login_ibtn_back = (ImageButton)this.findViewById(R.id.login_ibtn_back);
		
		login_et_phone = (EditText)this.findViewById(R.id.login_et_phone);
		login_et_password = (EditText)this.findViewById(R.id.login_et_password);
		
		login_btn_register.setOnClickListener(this);
		login_btn_login.setOnClickListener(this);
		login_ibtn_back.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.login_ibtn_back:
			intent = new Intent(context,StartActivity.class);
			startActivity(intent);
			break;
			
		case R.id.login_btn_register:
			intent = new Intent(context,RegisterActivity.class);
			startActivity(intent);
			break;

		case R.id.login_btn_login:
			phoneNumber = login_et_phone.getText().toString();
			passWord = login_et_password.getText().toString();
			
			AjaxParams params = new AjaxParams();
			params.put("phone", phoneNumber);
			params.put("password", passWord);
			
			finalHttp = new FinalHttp();
			finalHttp.post(SevirceUrl+"/"+uri, params,new AjaxCallBack<Object>() {

				@Override
				public void onFailure(Throwable t, int errorNo, String strMsg) {
					// TODO Auto-generated method stub
					super.onFailure(t, errorNo, strMsg);
					Log.d(TAG, "错误代码："+errorNo);
				}
				@Override
				public void onSuccess(Object t) {
					// TODO Auto-generated method stub
					super.onSuccess(t);
					Log.d(TAG, t.toString());
				}				
			});
			break;
		}
	}
}
