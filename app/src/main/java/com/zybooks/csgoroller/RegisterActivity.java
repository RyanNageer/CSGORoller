package com.zybooks.csgoroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText usr, pwd;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        UserDAO userDAO = userDatabase.userDAO();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        usr = findViewById(R.id.username_register);
        pwd = findViewById(R.id.password_register);

        register = findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(usr.getText().toString(), pwd.getText().toString());
                if(!checkInput(user))
                    Toast.makeText(getApplicationContext(), "Ensure username and password fields are filled.", Toast.LENGTH_SHORT).show();
                else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDAO.addUser(user);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User registered successfully.", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();

                }
            }
        });

    }

    public void launchMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public Boolean checkInput(User user)   {
        return !user.getUsername().isEmpty() && !user.getPassword().isEmpty();
    }

}