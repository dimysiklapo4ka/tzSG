package com.example.d1mys1klapo4ka.tz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.d1mys1klapo4ka.tz.R;
import com.example.d1mys1klapo4ka.tz.activity.helper.Helper;

/**
 * 1. пароль должен быть не менее 4-х символов.
 * email не менее 6-ти символов.
 * 2. email адреса не должны повторяться, если аккаунт с таким адресом существует
 * то повторная регистрация невозможна.
 * 3. если условия выполняются то происходит сохранение данных и переход к первому экрану.
 * если есть ошибки то показать Тост или снекбар с ошибкой.
 * 4.Email адреса хранить в памяти. Для этого использовать Singleton.
 * 5. пароли хранить в виде хешей(например MD5 http://ru.wikipedia.org/wiki/MD5), а не в явном виде!!!!!!!
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText emailRegistration;
    private EditText passwordRegistration;
    private EditText passwordConfirmation;

    Helper helper=new Helper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button register = (Button)findViewById(R.id.bt_register);
        emailRegistration = (EditText)findViewById(R.id.et_email_registration);
        passwordRegistration = (EditText)findViewById(R.id.et_password_registration);
        passwordConfirmation = (EditText)findViewById(R.id.et_password_confirmation);

        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt_register:

                if (helper.equalPassword(passwordRegistration.getText().toString(),
                        passwordConfirmation.getText().toString())) {

                    if (helper.verificationLength(emailRegistration.getText().toString(),
                            passwordRegistration.getText().toString())){

                        if (Helper.isValidEmail(emailRegistration.getText().toString())){

                            if (helper.emailConfirm(emailRegistration.getText().toString())){

                                helper.addUser(emailRegistration.getText().toString(), passwordRegistration.getText().toString());

                                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                                startActivity(intent);

                            }else {

                                Toast.makeText(SecondActivity.this, "Вы уже были зарегестрированны", Toast.LENGTH_SHORT).show();
                            }
                        }else {

                            Toast.makeText(SecondActivity.this, "Вы ввели некорректный email", Toast.LENGTH_SHORT).show();
                        }
                    }else {

                        Toast.makeText(SecondActivity.this, "Длина пароля и/или email не допустима", Toast.LENGTH_SHORT).show();
                    }
                }else {

                    Toast.makeText(SecondActivity.this, "Проверьте правильность ввода пароля", Toast.LENGTH_SHORT).show();
                }

        }
    }
}

