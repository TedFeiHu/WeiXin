package com.wuxinaedu.weixin.activity;

import com.wuxinaedu.weixin.R;
import com.wuxinaedu.weixin.activity.core.BaseActivity;
import com.wuxinaedu.weixin.bean.Contacts;
import com.wuxinaedu.weixin.utils.Constant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ChatActivity extends BaseActivity implements OnClickListener {
	@Override
	protected int getContentView() {
		return R.layout.activity_chat;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final Intent intent = getIntent();
		Contacts contacts = (Contacts) intent.getSerializableExtra(Constant.GET_SERIALIZABLE);
		setTitleName(contacts.getName());
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
