package com.wuxinaedu.weixin.activity;

import com.wuxinaedu.weixin.R;
import com.wuxinaedu.weixin.utils.CoreUtil;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends Activity{
	private Handler handler = new Handler(){
		public void handleMessage(android.os.Message msg) {
//			intent 这个操作很常见，封装到工具类里
//			startActivity(intent);
			CoreUtil.startActivity(WelcomeActivity.this, LoginActivity.class);
			finish();//先不写finish，演示一下
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		
		handler.sendEmptyMessageDelayed(0, 3000);
	}

}
