package com.example.meinefirebasesqllite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.meinefirebasesqllite.model.User;

public class MainActivity extends AppCompatActivity {

    private AppCompatEditText userName;
    private AppCompatEditText userPass;
    private AppCompatButton registerButton;
    private String temporaryPassword;
    private String temporaryUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindingWidgetToLayout();
        setUpListener();
    }

    private void setUpListener() {
        TextWatcher passTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
temporaryPassword = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        TextWatcher userNametextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                temporaryUsername = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        userName.addTextChangedListener(userNametextWatcher);
        userPass.addTextChangedListener(passTextWatcher);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movingToDash(createUser());
            }
        });


    }

    private void movingToDash(User user) {
        Intent intent = new Intent(getApplicationContext(),DashActivity.class);
        intent.putExtra("userdetails",user);
        startActivity(intent);
    }

    private User createUser() {
        User user = new User();
        user.getLogin().setUsername(temporaryUsername);
        user.getLogin().setPassword(temporaryPassword);

        return user;
    }

    private void bindingWidgetToLayout() {
        registerButton = findViewById(R.id.button_add);
        userName = findViewById(R.id.edit_username);
        userPass = findViewById(R.id.edit_pass);
        temporaryPassword = "";
    }
}