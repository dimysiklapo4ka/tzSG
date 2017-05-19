package com.example.d1mys1klapo4ka.tz.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.d1mys1klapo4ka.tz.R;
import com.example.d1mys1klapo4ka.tz.activity.helper.Helper;
import com.example.d1mys1klapo4ka.tz.activity.helper.MyCustomMD5;

/**
 * 1. при нажатии кнопки Регистрация переход на второе активити
 * 2. по нажатию кнопки Войти проверяются введенные данные во втором активити
 * если да то переход на третье активити.
 * если нет выводим Тост или снекбак с текстом "Неверный логин и/или пароль".
 * */
public class FirstActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText email,password;

    Helper helper=new Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button come = (Button) findViewById(R.id.bt_come);
        Button registration = (Button) findViewById(R.id.bt_registration);
        email = (EditText)findViewById(R.id.et_email);
        password = (EditText)findViewById(R.id.et_password);

        come.setOnClickListener(this);
        registration.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()){

            case R.id.bt_come:

                if (helper.userValid(email.getText().toString(), password.getText().toString())){

                    intent = new Intent(FirstActivity.this, ThirdActivity.class);
                    intent.putExtra("email",email.getText().toString());
                    startActivity(intent);

                }else {

                    Toast.makeText(FirstActivity.this, "Неверный логин и/или пароль", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.bt_registration:

                intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
                break;

        }
    }
}
