package com.example.materialdesigndemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class TIFloatActivity extends AppCompatActivity {

	TextInputLayout inputLayout1, inputLayout2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textinputlayout);
		inputLayout1 = (TextInputLayout) findViewById(R.id.textInput1);
		inputLayout1.setHint("请输入姓名:");

		inputLayout2 = (TextInputLayout) findViewById(R.id.textInput2);
		inputLayout2.setHint("请输入密码:");

		EditText editText = inputLayout1.getEditText();
		editText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (s.length() > 4) {
					inputLayout1.setErrorEnabled(true);
					inputLayout1.setError("姓名长度不能超过4个");
				} else {
					inputLayout1.setErrorEnabled(false);
				}
			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});

	}

}
