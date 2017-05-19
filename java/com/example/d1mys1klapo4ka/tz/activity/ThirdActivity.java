package com.example.d1mys1klapo4ka.tz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.d1mys1klapo4ka.tz.R;

/**
 * 1. текстовое поле должно содержать email под которым зашел пользователь.
 * 2. кнопка Выйти переносит в первое активити.
 */

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{

    Button exit;

    private TextView myEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        exit = (Button)findViewById(R.id.bt_exit);
        myEmail = (TextView)findViewById(R.id.tv_your_email);

        myEmail.setText(getIntent().getStringExtra("email"));

        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (exit!=null){
            Intent intent = new Intent(ThirdActivity.this,FirstActivity.class);
            myEmail.setText(null);
            startActivity(intent);
        }
    }
}
