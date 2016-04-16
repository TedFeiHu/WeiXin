package com.wuxinaedu.weixin.activity;

import com.wuxinaedu.weixin.R;
import com.wuxinaedu.weixin.R.layout;
import com.wuxinaedu.weixin.activity.core.BaseActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class LoginActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setTitleName("登陆");
	}

	/**
	 * 绑定视图
	 */
	@Override
	public int getContentView() {
		// TODO Auto-generated method stub
		return R.layout.activity_login;
	}
}
