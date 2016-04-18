package com.wuxinaedu.weixin.activity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wuxinaedu.weixin.R;
import com.wuxinaedu.weixin.activity.core.BaseActivity;
import com.wuxinaedu.weixin.widget.MyRadioButton;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends BaseActivity {
	
	private MyRadioButton[] bottoms;
	private RadioGroup radioGroup;
	private int[] strIds = {R.string.app_name,R.string.contact,R.string.find,R.string.me};
	private PopupWindow pop;
	private Fragment[] fragments;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		bottoms = new MyRadioButton[4];
		bottoms[0] = (MyRadioButton) findViewById(R.id.wx_id);
		bottoms[1] = (MyRadioButton) findViewById(R.id.contacts_id);
		bottoms[2] = (MyRadioButton) findViewById(R.id.find_id);
		bottoms[3] = (MyRadioButton) findViewById(R.id.me_id);
		radioGroup = (RadioGroup) findViewById(R.id.rg_id);
		
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				int selector;
				switch (checkedId) {
				case R.id.wx_id:  //微信
					selector = 0;
					break;
				case R.id.contacts_id:  //联系人
					selector = 1;
					break;
				case R.id.find_id:  //发现
					selector = 2;
					break;
				case R.id.me_id:  //我的
					selector = 3;
					break;
				default:
					selector = 0;
					break;
				}
				
				select(selector);
			}

		});
		select(0);
		
//		//初始化fragment
//		fragments = new Fragment[4];
//		fragments[0] = new WxFragment();
//		fragments[1] = new ContactsFragment();
//		fragments[2] = new FindFragment();
//		fragments[3] = new MeFragment();
		
	}

	@Override
	protected int getContentView() {
		return R.layout.activity_main;
	}
	
	private void select(int selector) {
		setTitleName(strIds[selector]);
		
		switch (selector) {
		case 0:
			showRightIv(R.drawable.icon_add, new OnClickListener() {
				@Override
				public void onClick(View v) {
					showPop();
				}
			});
			break;
		case 1:
			showRightIv(R.drawable.icon_menu_addfriend, new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
			break;
		default:
			hideRigehtImage();
			break;
		}
	}

	protected void showPop() {
		//构造PopupWindow对象以及设置其内容
		if (pop == null) {
			View view =this.getLayoutInflater().inflate(R.layout.item_pop,null);
			ListView lv=(ListView)view.findViewById(R.id.liv);
			SimpleAdapter simpleAdapter = initPopAdapter();
			lv.setAdapter(simpleAdapter);
			
			lv.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					switch (position) {
					case 0:  //打开群聊界面
						toastMessage("群聊界面");
//						startActivity(new Intent(MainActivity.this,GroupActivity.class));
						break;
					case 1:  //打开添加好友界面
						toastMessage("添加好友");
//						startActivity(new Intent(MainActivity.this,AddFriendsActivity.class));
						break;
					case 2:
						toastMessage("启动相机");
						break;
					case 3:
						toastMessage("支付");
						break;

					default:
						break;
					}
					//关闭
					pop.dismiss();
				}
			});
			
			pop=new PopupWindow(view,480, ViewGroup.LayoutParams.WRAP_CONTENT,true);
			pop.setBackgroundDrawable(new BitmapDrawable());
			//设置动画
			pop.setAnimationStyle(R.style.popwin_anim_style);
		}
		
		pop.showAsDropDown(rightIv);
	}
	
	/**
	 * 初始化PopupWindow的ListView数据。
	 */
	private SimpleAdapter initPopAdapter(){
		Map<String,Object> map;
		List<Map<String,Object>> data=new ArrayList<>(); 
		map=new HashMap<>();
		map.put("image",R.drawable.icon_menu_group);
		map.put("text", "发起群聊");
		data.add(map);
		map=new HashMap<>();
		map.put("image",R.drawable.icon_menu_addfriend);
		map.put("text", "添加好友");
		data.add(map);
		map=new HashMap<>();
		map.put("image",R.drawable.icon_menu_sao);
		map.put("text", "扫一扫");
		data.add(map);
		map=new HashMap<>();
		map.put("image",R.drawable.abv);
		map.put("text", "微信支付");
		data.add(map);
		SimpleAdapter sa = new SimpleAdapter(this, data,R.layout.item_pop_item,
				new String[]{"image","text"},new int[]{R.id.image_id,R.id.tv_id});
		return sa;
	}
	
	
}




