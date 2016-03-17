package com.example.materialdesigndemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class CoordinatorLayoutActivity extends AppCompatActivity {

	TabLayout mTabLayout;
	ViewPager mViewPager;
	private String[] mTitle = new String[5];
	private String[] mData = new String[5];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.coordinatorlayout);
		// // 给页面设置工具栏
		// final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		// setSupportActionBar(toolbar);
		// getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		//
		// // 设置工具栏标题
		// CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)
		// findViewById(R.id.collapsing_toolbar);
		// collapsingToolbar.setTitle("cheeseName");

		setContentView(R.layout.coordinatorlayout1);
		final Toolbar toolbar = (Toolbar) findViewById(R.id.third_activity_toolbar);
		setSupportActionBar(toolbar);
//		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);

		for (int i = 0; i < 5; i++) {
			mTitle[i] = "title" + i;
			mData[i] = "data" + i;
		}
		mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mTabLayout.setTabsFromPagerAdapter(pagerAdapter);
		mViewPager.setAdapter(pagerAdapter);
		mTabLayout.setupWithViewPager(mViewPager);
	}

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
			RecyclerView mRecyclerView = new RecyclerView(CoordinatorLayoutActivity.this);
			mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
	        mRecyclerView.setAdapter(new RecyclerViewAdapter(CoordinatorLayoutActivity.this));
			((ViewPager) container).addView(mRecyclerView);
			return mRecyclerView;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId()==android.R.id.home){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

}
