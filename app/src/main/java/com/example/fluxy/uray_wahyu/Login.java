package com.example.fluxy.uray_wahyu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private static EditText editText_user;
    private static EditText editText_pwd;
    private static TextView textView_attemptsCnt;
    private static Button btn_sbm;
    int attempts_counter= 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton();
    }
    public void LoginButton() {
        editText_user= (EditText)findViewById(R.id.editText_user);
        editText_pwd= (EditText) findViewById(R.id.editText_pwd);
        textView_attemptsCnt= (TextView)findViewById(R.id.textView_attemptsCnt);
        btn_sbm= (Button)findViewById(R.id.btn_sbm);
        textView_attemptsCnt.setText(Integer.toString(attempts_counter));
        btn_sbm.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(editText_user.getText().toString().equals("walkers") &&
                                editText_pwd.getText().toString().equals("31158")) {
                            Toast.makeText(Login.this, "Username and password is correct.",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent("User");
                            startActivity(intent);
                        } else {
                            Toast.makeText(Login.this, "Username and password is incorrect.",
                                    Toast.LENGTH_SHORT).show();
                            attempts_counter--;
                            textView_attemptsCnt.setText(Integer.toString(attempts_counter));
                            if(attempts_counter==0) {
                                btn_sbm.setEnabled(false);
                            }
                        }
                    }
                }
        );
    }
}