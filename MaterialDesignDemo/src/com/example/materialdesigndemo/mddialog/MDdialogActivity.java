package com.example.materialdesigndemo.mddialog;

import com.example.materialdesigndemo.R;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MDdialogActivity extends Activity {

	MaterialDialog mMaterialDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mddialog_main);
	}

	public void init(View v) {
		mMaterialDialog = new MaterialDialog(this);
		Toast.makeText(getApplicationContext(), "Initializes successfully.",
				Toast.LENGTH_SHORT).show();
	}

	public void show(View v) {
		if (mMaterialDialog != null) {
			mMaterialDialog
					.setTitle("MaterialDialog")
					.setMessage(
							"Hi! This is a MaterialDialog. It's very easy to use, you just new and show() it "
									+ "then the beautiful AlertDialog will show automatically. It is artistic, conforms to Google Material Design."
									+ " I hope that you will like it, and enjoy it. ^ ^")
					// mMaterialDialog.setBackgroundResource(R.drawable.background);
					.setPositiveButton("OK", new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							mMaterialDialog.dismiss();
							Toast.makeText(MDdialogActivity.this, "Ok",
									Toast.LENGTH_LONG).show();
						}
					}).setNegativeButton("CANCEL", new View.OnClickListener() {
						@Override
						public void onClick(View v) {
							mMaterialDialog.dismiss();
							Toast.makeText(MDdialogActivity.this, "Cancel",
									Toast.LENGTH_LONG).show();
						}
					}).setCanceledOnTouchOutside(false)
					// You can change the message anytime.
					// mMaterialDialog.setTitle("��ʾ");
					.setOnDismissListener(
							new DialogInterface.OnDismissListener() {
								@Override
								public void onDismiss(DialogInterface dialog) {
									Toast.makeText(MDdialogActivity.this,
											"onDismiss", Toast.LENGTH_SHORT)
											.show();
								}
							}).show();
			// You can change the message anytime.
			// mMaterialDialog.setMessage("�ˣ�����һ�� MaterialDialog. ���ǳ�����ʹ�ã���ֻ�轫��ʵ������������۵ĶԻ������Զ�����ʾ�����������С�ɣ���ȫ���� Google 2014 �귢���� Material Design ���ϣ������ϲ������^ ^");
		} else {
			Toast.makeText(getApplicationContext(), "You should init firstly!",
					Toast.LENGTH_SHORT).show();
		}
	}

	static int i = 0;

	public void setView(View v) {
		switch (v.getId()) {
		case R.id.button_set_view: {
			mMaterialDialog = new MaterialDialog(this);
			View view = LayoutInflater.from(this).inflate(
					R.layout.progressbar_item, null);
			mMaterialDialog.setView(view).show();
		}
			break;
		case R.id.button_set_background: {
			mMaterialDialog = new MaterialDialog(this);
			if (mMaterialDialog != null) {
				if (i % 2 != 0) {
					mMaterialDialog
							.setBackgroundResource(R.drawable.background);
				} else {
					Resources res = getResources();
					Bitmap bmp = BitmapFactory.decodeResource(res,
							R.drawable.background2);
					BitmapDrawable bitmapDrawable = new BitmapDrawable(
							getResources(), bmp);
					mMaterialDialog.setBackground(bitmapDrawable);
				}
				mMaterialDialog.setCanceledOnTouchOutside(true).show();
				i++;
				Toast.makeText(getApplicationContext(), "Try to click again~",
						Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(getApplicationContext(),
						"You should init firstly!", Toast.LENGTH_SHORT).show();
			}
			break;
		}
		case R.id.button_set_contentView: {
			final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
					this, android.R.layout.simple_list_item_1);
			for (int j = 0; j < 38; j++) {
				arrayAdapter.add("This is item " + j);
			}

			ListView listView = new ListView(this);
			listView.setLayoutParams(new ViewGroup.LayoutParams(
					ViewGroup.LayoutParams.MATCH_PARENT,
					ViewGroup.LayoutParams.MATCH_PARENT));
			float scale = getResources().getDisplayMetrics().density;
			int dpAsPixels = (int) (8 * scale + 0.5f);
			listView.setPadding(0, dpAsPixels, 0, dpAsPixels);
			listView.setDividerHeight(0);
			listView.setAdapter(arrayAdapter);

			final MaterialDialog alert = new MaterialDialog(this).setTitle(
					"MaterialDialog").setContentView(listView);

			alert.setPositiveButton("OK", new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					alert.dismiss();
				}
			});

			alert.show();
			break;
		}
		case R.id.button_set_contentViewById: {
			final MaterialDialog alert = new MaterialDialog(this).setTitle(
					"MaterialDialog").setContentView(
					R.layout.custom_message_content);

			alert.setPositiveButton("OK", new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					alert.dismiss();
				}
			});
			alert.show();
			break;
		}
		case R.id.button_set_notitile: {
			final MaterialDialog materialDialog = new MaterialDialog(this);
			// materialDialog.setMessage("This is a dialog without title. This is a dialog without title. This is a dialog without title. This is a dialog without title. This is a dialog without title. ")
			materialDialog
					.setMessage(
							"This is a dialog without title. This is a dialog without title. This is a dialog without title. "
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ "This is a dialog without title. This is a dialog without title."
									+ " ").setPositiveButton(
							android.R.string.yes, new View.OnClickListener() {
								@Override
								public void onClick(View v) {
									materialDialog.dismiss();
								}
							});
			materialDialog.show();
		}
		}
	}

	public void buttonPress(View view) {
		// show imm
		InputMethodManager imm = (InputMethodManager) this
				.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,
				InputMethodManager.HIDE_IMPLICIT_ONLY);
	}

}
