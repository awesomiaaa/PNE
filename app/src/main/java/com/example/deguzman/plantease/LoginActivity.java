package com.example.deguzman.plantease;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.deguzman.plantease.MainActivity;
import com.example.deguzman.plantease.R;
import com.example.deguzman.plantease.SignUpActivity;
import com.example.deguzman.plantease.UserList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText email,password;
    CheckBox checkBox;
    ImageButton signin;
    Button signup;
    private static final String URL_DATA = "http://172.20.10.2:8000/Users/?format=json";
    public String username;
    public String user, pw, decrypted, a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        checkBox = (CheckBox)findViewById(R.id.checkbox);

        signin =(ImageButton)findViewById(R.id.signin);

        signup = (Button) findViewById(R.id.signup);

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"Sign In Button Clicked",Toast.LENGTH_LONG).show();
//                Intent i = new Intent(MainActivity.this, HomeActivity.class);
//                startActivity(i);
                if(email.getText().toString().equals(user) & password.getText().toString().equals(pw)){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else{
                    Toast.makeText(LoginActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(i);
            }
        });

        loadUrlData();
    }

    private void loadUrlData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                progressDialog.dismiss();

                try {

                    JSONObject jsonObject = new JSONObject(response);


                    JSONArray array = jsonObject.getJSONArray("results");

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject jo = array.getJSONObject(i);
                        UserList userlist = new UserList(jo.getString("name"),
                                jo.getString("email"),
                                jo.getString("password"));


                        user = jo.getString("email");
                        pw = jo.getString("password");


                        System.out.println(user + pw);
                    }



                } catch (JSONException e) {

                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(LoginActivity.this, "Error" + error.toString(), Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}