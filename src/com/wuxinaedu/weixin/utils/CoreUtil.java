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
	
	
	/**public static boolean isEmpty(String str)
	 * 判断字符串是否为空。无视空格
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str){
		if(str == null || str.trim().length()==0){
			return true;
		}else{
			return false;
		}
	}
}
