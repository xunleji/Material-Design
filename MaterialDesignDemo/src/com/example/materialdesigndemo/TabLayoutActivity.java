package com.example.materialdesigndemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.design.widget.TabLayout.TabLayoutOnPageChangeListener;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class TabLayoutActivity extends AppCompatActivity {

	TabLayout mTabLayout;
	ViewPager mViewPager;
	private String[] mTitle = new String[4];
	private String[] mData = new String[4];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tablayout);
		for (int i = 0; i < 4; i++) {
			mTitle[i] = "title" + i;
			mData[i] = "data" + i;
		}
		mTabLayout = (TabLayout) findViewById(R.id.tl);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
//		mTabLayout.setOnTabSelectedListener(ontabselect);
		mTabLayout.setTabsFromPagerAdapter(pagerAdapter);
//		TabLayoutOnPageChangeListener tlonpageChange = new TabLayoutOnPageChangeListener(
//				mTabLayout);
//		mViewPager.addOnPageChangeListener(tlonpageChange);
		mViewPager.setAdapter(pagerAdapter);
		//addOnPageChangeListenerºÍsetOnTabSelectedListenerµÄ·â×°¡£
		mTabLayout.setupWithViewPager(mViewPager);
	}

	private OnTabSelectedListener ontabselect = new OnTabSelectedListener() {

		@Override
		public void onTabUnselected(Tab arg0) {

		}

		@Override
		public void onTabSelected(Tab arg0) {
			// TODO Auto-generated method stub
			mViewPager.setCurrentItem(arg0.getPosition());
		}

		@Override
		public void onTabReselected(Tab arg0) {
			// TODO Auto-generated method stub

		}
	};

	private PagerAdapter pagerAdapter = new PagerAdapter() {

		@Override
		public CharSequence getPageTitle(int position) {
			return mTitle[position];
		}

		@Override
		public int getCount() {
			return mData.length;
		}

		@Override
		public Object instantiateItem(View container, int position) {
			TextView tv = new TextView(TabLayoutActivity.this);
			tv.setTextSize(30.f);
			tv.setText(mData[position]);
			((ViewPager) container).addView(tv);
			return tv;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView((View) object);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

	};

}
