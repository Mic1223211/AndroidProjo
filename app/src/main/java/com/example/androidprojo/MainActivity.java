package com.example.androidprojo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private TextView mTextView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.changeTextBt).setOnClickListener(this);
        findViewById(R.id.activityChangeTextBtn).setOnClickListener(this);

        mTextView = findViewById(R.id.textToBeChanged);
        mEditText = findViewById(R.id.editTextUserInput);
    }


    @Override
    public void onClick(View view) {
        final String text = mEditText.getText().toString();
        final int changeTextBtId = R.id.changeTextBt;
        final int activityChangeTextBtnId = R.id.activityChangeTextBtn;

        if(view.getId() == changeTextBtId){
            mTextView.setText(text);
        }else if (view.getId() == activityChangeTextBtnId){
            Intent intent = com.example.androidprojo.ShowTextActivity
                    .newStartIntent(this, text);
            startActivity(intent);
        }
    }
}

