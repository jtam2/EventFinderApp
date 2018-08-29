package com.example.jacob.eventfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {

    private EditText userNameInput;
    private EditText passwordInput;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameInput = (EditText)findViewById(R.id.userNameInput);
        passwordInput = (EditText)findViewById(R.id.passwordInput);
        registerButton = (Button)findViewById(R.id.registerButton);
    }
}
