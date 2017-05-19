package com.example.d1mys1klapo4ka.tz.activity.helper;

import android.content.Context;
import android.text.TextUtils;

import com.example.d1mys1klapo4ka.tz.activity.settings.HelperSP;

/**
 * 1. Выполнить добавление нового пользователя.
 * 2. Поверять на ввод в поля одинаковые пароли.
 * 3. Проверка на длину email и пароля email не меньше 6-ти, пароль не меньше 4-х.
 * 4. Бонусное задание - выполнить проверку на ввод email(т.е корректного email).
 * 5. Проверка email на повторный ввод (если есть в базе показывать ошибку).
 * 6. проверка что ключ и значение совпадают со значениями в базе.
 */

public class Helper{

    private HelperSP helperSP = HelperSP.initialization();

    public Helper(Context context){
        helperSP.init(context);
    }
    //Добавление данных
    public void addUser(String email, String password){

        helperSP.setUser(email, MyCustomMD5.md5Custom(password) );
    }

    //Проверка ввода одинаковых паролей
    public boolean equalPassword(String password, String passwordConfirm){

        return MyCustomMD5.md5Custom(password).equals(MyCustomMD5.md5Custom(passwordConfirm));
    }

    //Валидатор минимальной длины пароля и email
    public boolean verificationLength(String email, String password){

        return  (email.length() > 5 && password.length() > 3);
    }

    //Валидация email
    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    //Проверка email на повторный ввод
    public boolean emailConfirm(String email) {

        if (helperSP.settingSearch(email)) {

            return false;
        }

        return true;
    }

    //проверка что ключ и значение совпадают с введеными на первой странице
    public boolean userValid(String email, String password){

        return MyCustomMD5.md5Custom(password).equals(helperSP.getUser(email));

    }
}
