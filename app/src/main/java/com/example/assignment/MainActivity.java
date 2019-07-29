package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText username, password;
    Button login;
    TextView textViewUsername, textViewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        username = (EditText)findViewById(R.id.Username);
        password = (EditText)findViewById(R.id.Password);

        textViewUsername = (TextView)findViewById(R.id.textView1);
        textViewPassword = (TextView)findViewById(R.id.textView2);

        login = (Button)findViewById(R.id.login);

    }

    public void RegisterPage(View view){
        Intent i = new Intent(MainActivity.this, Register.class );
        startActivity(i);
    }

    public void LoginAccount(View view){
        String UserName = username.getText().toString();
        String Password = password.getText().toString();
        if(validate()){
            User currentUser = myDb.Authenticate(new User(null, UserName, null, Password));
            if (currentUser != null) {
                Toast.makeText(getApplicationContext(),"Succesfuul Login",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
            }
            else
                Toast.makeText(getApplicationContext(),"Fail to Login, Please try again",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validate() {
        boolean valid = true;

        String UserName = username.getText().toString();
        String Password = password.getText().toString();

        if (UserName.isEmpty()) {
            textViewUsername.setText("*Please enter valid username!");
            valid = false;
        }
        else{
            textViewUsername.setText("");
        }

        if (Password.isEmpty()) {
            textViewPassword.setText("*Please enter password!");
            valid = false;
        }
        else{
            textViewPassword.setText("");
        }
        return valid;
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
