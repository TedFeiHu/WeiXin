package com.wuxinaedu.weixin.utils;


import java.util.ArrayList;
import java.util.List;

import com.wuxinaedu.weixin.activity.core.BaseActivity;

import android.content.Context;
import android.content.Intent;

public class CoreUtil {
	
	private static List<BaseActivity> list = new ArrayList<>();

	/**
	 * 启动activity
	 * @param context
	 * @param clz
	 */
	public static void startActivity(Context context, Class<?> clz){
		Intent intent = new Intent(context, clz);
		context.startActivity(intent);
	}
	
	
	/**
	 * 集合所有打开的activity
	 * @param fActivity
	 */
	public static void addToActivityList(BaseActivity activity){
		if(!list.contains(activity)){
			list.add(activity);
		}
	}
	
	
	/**
	 * 移除关闭的activity
	 * 在调用 finish方法的时候 同时调用这个方法。不要在onDestroy()方法中调用，因为在 遍历集合关闭时也会调用
	 */
	public static void removeActivity(BaseActivity activity){
		list.remove(activity);
	}
	
	/**
	 * 关闭activity集合
	 *//*
	public static void finishActivityList(){
		L.e("activity集合大小-----》》"+list.size());
		for (int i = 0; i < list.size(); i++) {
			L.e("被关闭Activity-----》》"+list.get(i));
			list.get(i).finish();
		}
		list.clear();
	}*/
	
	/**
	 * 退出出程序
	 * 关闭activity 并杀死进程。
	 */
	public static void exitApp(){
		for (BaseActivity activity : list) {
			activity.finish();
			L.e("exitApp:-----》》"+activity);
		}
		list.clear();
		L.e("android.os.Process.killProcess(android.os.Process.myPid());");
		android.os.Process.killProcess(android.os.Process.myPid());
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
