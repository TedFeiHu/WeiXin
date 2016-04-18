package com.wuxinaedu.weixin.activity.fragment;


import com.wuxinaedu.weixin.R;
import com.wuxinaedu.weixin.activity.MainActivity;
import com.wuxinaedu.weixin.utils.L;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FindFragment extends Fragment{
	
	private View view;
	private MainActivity main;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(view == null){
			L.i("-------------------------");
			view = inflater.inflate(R.layout.fragment_find, null);
			main = ((MainActivity)getActivity());
		}
		return view ;
	}
}
