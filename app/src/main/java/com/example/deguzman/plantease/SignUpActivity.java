package com.example.deguzman.plantease;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.List;

public class SignUpActivity extends AppCompatActivity {
//    private static final String URL_DATA = "http://172.20.10.3:8000/Users/?format=json";
    private static final String URL_DATA = "http://192.168.1.15:8000/Users/?format=json";
    public String username;
    public String user, pw, decrypted, a;
    public String z, x, c;

    public List<UserList> userlist;

    public static EditText email, name, password, confpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);


        Button signin = (Button) findViewById(R.id.signin);
        ImageButton signup = (ImageButton) findViewById(R.id.signup);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));

            }
        });

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                System.out.println(name);
                if(name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                    Toast.makeText(SignUpActivity.this, "All fields are required!", Toast.LENGTH_SHORT).show();
                }
                else {

//                    if(!password.getText().toString().equals(confpwd.getText().toString())) {
//
//                        Toast.makeText(SignUpActivity.this, "Password did not match!", Toast.LENGTH_SHORT).show();
//
//                    }
//                    else{
                        signpost process = new signpost();
                        process.execute();
                        startActivity(new Intent(SignUpActivity.this, MainActivity.class));

//                    }
                }
            }
        });
    }
}
