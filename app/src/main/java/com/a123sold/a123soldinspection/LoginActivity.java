package com.a123sold.a123soldinspection;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.a123sold.a123soldinspection.Helpers.Config;
import com.a123sold.a123soldinspection.Helpers.JsonRequest;

import org.json.JSONException;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username;
    EditText password;
    Button login;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
    }

    private void initialize() {
        sharedpreferences = getSharedPreferences(Config.localUserDB, Context.MODE_PRIVATE);
        String name = sharedpreferences.getString("userId", null);
        String agegroup = sharedpreferences.getString("authToken",null);
        try{if(!name.equals(null) && !agegroup.equals(null))
        {
            Intent i=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);
            finish();
        }}catch (Exception e){}
        username = (EditText) findViewById(R.id.editTextusername);
        password = (EditText) findViewById(R.id.editTextpassword);
        login= (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==login){
            JsonRequest request=new JsonRequest(this.getApplicationContext(),this);
            try {
                request.LoginResponse(Config.BASE_URL+"/api/123sold/inspection/login", username.getText().toString(), password.getText().toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
