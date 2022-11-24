package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button btn_log;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.et_editText);
        password = findViewById(R.id.Edit_text);
        btn_log = findViewById(R.id.button);


        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (username.getText().toString().isEmpty() && password.getText().toString().isEmpty()) {
                    btn_log.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.gray));
                } else {
                    btn_log.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.orange));
                }

            }
        });
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();

                    // Выполняем переход на другой экран:
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Неправильный логин и пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}





















