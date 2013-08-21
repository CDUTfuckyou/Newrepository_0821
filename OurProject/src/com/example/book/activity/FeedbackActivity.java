package com.example.book.activity;

import xmu.software.acbuwa.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FeedbackActivity extends Activity {

	private Spinner feedback_spinner_connectionmethod;

	private Spinner feedback_spinner_classification;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);

		feedback_spinner_connectionmethod = (Spinner) this
				.findViewById(R.id.feedback_spinner_connectionmethod);
		String[] conntctionMethod = new String[] { "手机", "QQ", "邮箱", "飞信",
				"旺旺", "MSN", "其它" };
		ArrayAdapter<String> connectionAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, conntctionMethod);
		feedback_spinner_connectionmethod.setAdapter(connectionAdapter);

		
		feedback_spinner_classification = (Spinner) this
				.findViewById(R.id.feedback_spinner_classification);
		String[] classiFication = new String[] { "默认", "产品安装", "产品使用", "功能建议",
				"Bug反馈", "机型支持" };
		ArrayAdapter<String> classiFicationAdapter = new ArrayAdapter<String>(
				this, android.R.layout.simple_spinner_dropdown_item,
				classiFication);
		feedback_spinner_classification.setAdapter(classiFicationAdapter);
	}

}
