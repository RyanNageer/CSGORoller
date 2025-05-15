package com.zybooks.csgoroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usr, pwd;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usr = findViewById(R.id.username_login);
        pwd = findViewById(R.id.password_login);

        login = findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(usr.getText().toString(), pwd.getText().toString());
                if(!checkInput(user))
                    Toast.makeText(getApplicationContext(), "Ensure username and password fields are filled.", Toast.LENGTH_SHORT).show();
                else {
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDAO userDAO = userDatabase.userDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User userLogin = userDAO.login(user.getUsername(), user.getPassword());
                            if(userLogin == null)   {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Incorrect user/password.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            else {
                                String numDOpened = String.valueOf(userLogin.getNumDreamsAndNightmaresOpened());
                                String numKOpened = String.valueOf(userLogin.getNumKilowattsOpened());
                                String numEOpened = String.valueOf(userLogin.getNumEsportsOpened());
                                long userID = userLogin.getId();
                                Intent intent = new Intent(LoginActivity.this, CaseSelection.class);
                                Bundle extras = new Bundle();
                                extras.putString("numDOpened", numDOpened);
                                extras.putString("numKOpened", numKOpened);
                                extras.putString("numEOpened", numEOpened);
                                extras.putLong("userID", userID);
                                intent.putExtras(extras);
                                startActivity(intent);
                            }
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