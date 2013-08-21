package com.example.book.activity;

import xmu.software.acbuwa.R;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.book.callback.SizeCallBackForMenu;
import com.example.book.ui.MenuHorizontalScrollView;

@SuppressWarnings("deprecation")
public class StartActivity extends ActivityGroup implements OnClickListener {
	
	private String TAG = "StartAcitivty";
	

	private MenuHorizontalScrollView scrollView;
	private LayoutInflater inflater;
	private View mainPage;
	private Button menuBtn;
	private LinearLayout ll_menu;
	private Intent intent;
	private Button menu_btn_login, menu_btn_feed_back;	
	public static TextView topbar_text;
	public static Button rightBtn;
	//创建StartAcitivty的handler
//	private Handler startActivityHandler = new Handler(){
//
//		@Override
//		public void handleMessage(Message msg) {
//			// TODO Auto-generated method stub
//			super.handleMessage(msg);
//			
//			if(msg.what==1){
//				//topbar_text.setText("首页");
//				Log.d(TAG, msg.what+"");
//				topbar_text.setText("我要买书");
//			}
//			else if(msg.what==2){
//				Log.d(TAG, msg.what+"");
//				//topbar_text.setText("流氓");
//			}
//		}					
//	};

	protected LocalActivityManager mLocalActivityManager;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		mLocalActivityManager = getLocalActivityManager();
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		inflater = LayoutInflater.from(this);
		setContentView(inflater.inflate(R.layout.menu_scroll_view, null));
		
		initView();

	}	
		
	//封装handler，方便其他Activity调用
//	public Handler returenHandler(){
//		return startActivityHandler;
//		
//	}
	
	public TextView returnTopbar_text(){
		return topbar_text;
	}

	private void initView() {
		
		scrollView = (MenuHorizontalScrollView) findViewById(R.id.scrollView);
		ll_menu = (LinearLayout) findViewById(R.id.ll_menu);
		
		mainPage = inflater.inflate(R.layout.acbuwa_page, null);
		menuBtn = (Button) mainPage.findViewById(R.id.menuBtn);
		topbar_text = (TextView) mainPage.findViewById(R.id.topbar_title);
		rightBtn = (Button) mainPage.findViewById(R.id.rightBtn);
		
		FrameLayout container = (FrameLayout) mainPage.findViewById(R.id.Container);
		container.removeAllViews();
		Intent firstIntent = new Intent(this, TabHostActivity.class);
		View view = activityToView(this, firstIntent, "tabhost");
		view.setTag("tabhost");
		container.addView(view);

		View leftView = new View(this);
		leftView.setBackgroundColor(Color.TRANSPARENT);
		final View[] children = new View[] { leftView, mainPage };
		scrollView.initViews(children, new SizeCallBackForMenu(this.menuBtn), this.ll_menu);
		this.scrollView.setMenuBtn(this.menuBtn);		
		menu_btn_login = (Button) ll_menu.findViewById(R.id.menu_btn_login);
		menu_btn_feed_back = (Button) ll_menu
				.findViewById(R.id.menu_btn_feed_back);

		menu_btn_login.setOnClickListener(this);
		menu_btn_feed_back.setOnClickListener(this);
		menuBtn.setOnClickListener(onClickListener);
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			scrollView.clickMenuBtn();
		}
	};

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.menu_btn_login:
			intent = new Intent(StartActivity.this, LoginActivity.class);
			startActivity(intent);
			break;

		case R.id.menu_btn_feed_back:
			intent = new Intent(StartActivity.this, FeedbackActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
	
	public View activityToView(Context parent, Intent intent, String tag) {
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		Window window = mLocalActivityManager.startActivity(tag, intent);
		View view = window != null ? window.getDecorView() : null;
		if (view != null) {
			view.setVisibility(View.VISIBLE);
			view.setFocusableInTouchMode(true);
			((ViewGroup) view)
					.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
		}
		return view;
	}

}
