package com.example.materialdesigndemo;

import com.example.materialdesigndemo.mddialog.MDdialogActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SampleActivity extends ListActivity {

	private String str[] = {"Dialog¶Ô»°¿ò","CollapsingToolbarLayout","CollapsingToolbarLayout+TabLayout",
			"NavigationView+DrawerLayout","TabLayout","TextInputLayout","Snackbar","CollapsingToolbarLayout",
			"Toolbar"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, str);
		setListAdapter(adapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent();
		if (position == 0) {
			intent.setClass(this, MDdialogActivity.class);
		} else if (position == 1) {
			intent.setClass(this, CoordinatorLayoutActivity1.class);
		}else if (position == 2) {
			intent.setClass(this, CoordinatorLayoutActivity.class);
		}else if (position == 3) {
			intent.setClass(this, NavigationViewActivity.class);
		}else if (position == 4) {
			intent.setClass(this, TabLayoutActivity.class);
		}else if (position == 5) {
			intent.setClass(this, TIFloatActivity.class);
		}else if (position == 6) {
			intent.setClass(this, SnackbarActivity.class);
		}else if (position == 7) {
			intent.setClass(this, DetailActivity.class);
		}else if (position == 8) {
			intent.setClass(this, MainActivity.class);
		}
		startActivity(intent);
	}

}
