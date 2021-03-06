package com.example.materialdesigndemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

@SuppressLint("NewApi")
public class NavigationViewActivity extends AppCompatActivity {

	private DrawerLayout mDrawerLayout;
	private NavigationView mNavigationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.navigationview);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
		mNavigationView = (NavigationView) findViewById(R.id.id_nv_menu);

		Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
		setSupportActionBar(toolbar);

		mNavigationView
				.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {

					@Override
					public boolean onNavigationItemSelected(MenuItem menuItem) {
						menuItem.setChecked(true);
						mDrawerLayout.closeDrawers();
						return true;
					}
				});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.drawer_view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			mDrawerLayout.openDrawer(GravityCompat.START);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
