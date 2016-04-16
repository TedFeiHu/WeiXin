package com.wuxinaedu.weixin.utils;

import android.content.Context;
import android.content.Intent;

public class CoreUtil {

	/**
	 * 启动activity
	 * @param context
	 * @param clz
	 */
	public static void startActivity(Context context, Class<?> clz){
		Intent intent = new Intent(context, clz);
		context.startActivity(intent);
	}
}
