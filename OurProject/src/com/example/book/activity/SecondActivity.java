package com.example.book.activity;

import java.util.ArrayList;
import java.util.List;
import xmu.software.acbuwa.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.example.book.adapter.BuyBookAdapter;
import com.example.book.adapter.ImageAdapter;
import com.example.book.dao.GalleryFlow;
import com.example.book.entity.CommentItem;

public class SecondActivity extends Activity implements OnItemClickListener{

	private List<CommentItem> commentItems = new ArrayList<CommentItem>();

	private BuyBookAdapter allCommentAdapter;
	
	private ImageAdapter imgAdapter;

	private ListView mListView;
	
	private Intent intent;
	
	private Context context;
	
	private GalleryFlow galleryFlow;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		context = SecondActivity.this;

		Integer[] images = { R.drawable.img0001, R.drawable.img0030,
				R.drawable.img0100, R.drawable.img0130, R.drawable.img0200,
				R.drawable.img0230, R.drawable.img0330, R.drawable.img0354,
				R.drawable.a001, R.drawable.a002 };

		imgAdapter = new ImageAdapter(this, images);
		imgAdapter.createReflectedImages();

		galleryFlow = (GalleryFlow) findViewById(R.id.Gallery01);
		galleryFlow.setAdapter(imgAdapter);
		
		
		
		for (int i = 0; i < 50; i++) {
			CommentItem commentItem = new CommentItem();
			commentItem.username = "张三" + i + "号";
			commentItem.time = "8:" + i * 2;

			if (i % 3 == 0) {
				commentItem.comment = "让更多的人看到。江西6岁的小女孩丁香小慧家住上......";
				commentItem.headgraphUrl = "http://q.qlogo.cn/qqapp/222222/8921FA65ECA420A544383EE050AEB152/100";
			} else if (i % 3 == 1) {
				commentItem.comment = "面对，不一定最难过。孤独，不一定不快乐。得到，不一定能长久。失去，不一定不再拥有。不要因为寂寞而错爱，不要因为错爱而寂寞一生。——徐志摩【早安】";
				commentItem.headgraphUrl = "http://q.qlogo.cn/qqapp/222222/359EB7CFAE1D491431624EA5A6EC2EFB/100";
			} else {
				commentItem.comment = "简单的纯色衬衫，总是能衬托出男人最帅气的一面,这件很不错。";
				commentItem.headgraphUrl = "http://q.qlogo.cn/qqapp/222222/2742189F92589C79E82264478841599D/100";
			}
			commentItems.add(commentItem);
			allCommentAdapter = new BuyBookAdapter(this, commentItems);
			mListView = (ListView) this
					.findViewById(R.id.allcomment_listview_comment);
			mListView.setAdapter(allCommentAdapter);
			mListView.setOnItemClickListener(this);
			galleryFlow.setOnItemClickListener(this);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		if(arg0.getAdapter()==allCommentAdapter){
			intent = new Intent(context,OrderDetailsActivity.class);
			startActivity(intent);
		}
		else if(arg0.getAdapter()==imgAdapter){
			intent = new Intent(context,OrderDetailsActivity.class);
			startActivity(intent);
		}
	}
	
}
