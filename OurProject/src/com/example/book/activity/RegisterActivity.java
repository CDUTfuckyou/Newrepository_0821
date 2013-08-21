package com.example.book.activity;

import xmu.software.acbuwa.R;
import android.app.Activity;
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


public class RegisterActivity extends Activity implements OnClickListener{
	private String TAG = "RegisterActivity";	
	private ImageButton register_ibtn_back;
	private Button register_btn_login;
	private Button register_btn_register;
	private EditText register_et_phoneNumber;
	private EditText register_et_major;
	private EditText register_et_password;	
	private String phoneNumber,passWord,major;	
	private Intent intent;	
	private FinalHttp finalHttp;	
	private final String SevirceUrl="http://192.168.1.105:8080/BookSell";
	private String uri;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_register);
		
		init();
		
		uri = "register";
	}
	
	private void init(){
		register_ibtn_back = (ImageButton)this.findViewById(R.id.register_ibtn_back); 
		register_btn_login = (Button)this.findViewById(R.id.register_btn_login);
		register_btn_register = (Button)this.findViewById(R.id.register_btn_register);
		register_et_phoneNumber = (EditText)this.findViewById(R.id.register_et_phoneNumber);
		register_et_major = (EditText)this.findViewById(R.id.register_et_major);
		register_et_password = (EditText)this.findViewById(R.id.register_et_password);
		
		register_ibtn_back.setOnClickListener(this);
		register_btn_login.setOnClickListener(this);
		register_btn_register.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.register_ibtn_back) {
			this.finish();
		}
		else if(v.getId() == R.id.register_btn_login) {
			this.finish();
		}
		else if(v.getId() == R.id.register_btn_register) {
			phoneNumber = register_et_phoneNumber.getText().toString();		
			major = register_et_major.getText().toString();
			passWord = register_et_password.getText().toString();
			
			AjaxParams params = new AjaxParams();
			params.put("phone", phoneNumber);
			params.put("password", passWord);
			params.put("major", major);
			
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
					Log.d(TAG, major);
				}				
			});			
		}			
	}
}
