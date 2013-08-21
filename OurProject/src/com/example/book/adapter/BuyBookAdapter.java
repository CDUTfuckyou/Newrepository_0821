package com.example.book.adapter;

import java.util.List;

import xmu.software.acbuwa.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.book.afinal.FinalBitmap;
import com.example.book.entity.CommentItem;

public class BuyBookAdapter extends BaseAdapter {
	private LayoutInflater inflater; // 布局器
	
	private FinalBitmap fb;

	List<CommentItem> commentItems;
	Context context;

	public BuyBookAdapter(Context context, List<CommentItem> commentItem) {
		this.context = context;
		this.commentItems = commentItem;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return commentItems.size();
	}

	@Override
	public int getItemViewType(int position) {
		// TODO Auto-generated method stub
		return super.getItemViewType(position);
	}

	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return super.getViewTypeCount();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		fb = FinalBitmap.create(context);
		ViewHolder holder = null;
		if (convertView == null) {

			holder = new ViewHolder();

			convertView = inflater.inflate(R.layout.item_allcomment, null);
			holder.img_headgraph = (ImageView) convertView
					.findViewById(R.id.item_allcomm_headgraph);
			holder.tv_username = (TextView) convertView
					.findViewById(R.id.item_allcomm_username);
			holder.tv_time = (TextView) convertView
					.findViewById(R.id.item_allcomm_time);
			holder.tv_comment = (TextView) convertView
					.findViewById(R.id.item_allcomm_comment);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		final CommentItem commentItem = commentItems.get(position);

		holder.tv_username.setText(commentItem.username);
		holder.tv_comment.setText(commentItem.comment);
		holder.tv_time.setText(commentItem.time);
		fb.display(holder.img_headgraph, commentItem.headgraphUrl);

		return convertView;
	}
	public final class ViewHolder {

		public ImageView img_headgraph;
		public TextView tv_username;
		public TextView tv_time;
		public TextView tv_comment;
	}
}



