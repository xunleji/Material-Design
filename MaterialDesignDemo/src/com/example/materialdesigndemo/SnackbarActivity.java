package com.example.materialdesigndemo;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class SnackbarActivity extends AppCompatActivity {

	CoordinatorLayout container;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.snackbar);
		container = (CoordinatorLayout) findViewById(R.id.layout);
	}

	public void createSnackbar(View v) {
		Snackbar snackbar = Snackbar.make(container, "SnackbarTest",
				Snackbar.LENGTH_LONG).setAction("Action",
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						// Snackbar.make(container, "ActionClick",
						// Snackbar.LENGTH_LONG).show();
					}
				});
		snackbar.getView().setBackgroundColor(0xfff44336);
		snackbar.show();
	}

}
