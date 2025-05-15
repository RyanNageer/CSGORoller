package com.zybooks.csgoroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;



public class CaseSelection extends AppCompatActivity {

    TextView numDOpenedText;
    TextView numKOpenedText;
    TextView numEOpenedText;
    TextView netWorthText;

    long userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_selection);

        userID = getIntent().getLongExtra("userID", -1);

        // Perform database operations asynchronously
        new Thread(new Runnable() {
            @Override
            public void run() {
                UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                UserDAO userDAO = userDatabase.userDAO();

                // Fetch user details from the database
                User user = userDAO.getUserById(userID);

                // Update UI components using the fetched user details
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        numDOpenedText = findViewById(R.id.numDOpened);
                        numDOpenedText.setText(String.valueOf(user.getNumDreamsAndNightmaresOpened()));

                        numKOpenedText = findViewById(R.id.numKOpened);
                        numKOpenedText.setText(String.valueOf(user.getNumKilowattsOpened()));

                        numEOpenedText = findViewById(R.id.numEOpened);
                        numEOpenedText.setText(String.valueOf(user.getNumEsportsOpened()));

                        netWorthText = findViewById(R.id.netWorth);
                        netWorthText.setText(String.valueOf(user.getNetWorth()));
                    }
                });
            }
        }).start();
    }


    public void launchNightmare(View view){
        Intent intent = new Intent(this, DreamsAndNightmares.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
    }

    public void launchKilowatt(View view){
        Intent intent = new Intent(this, Kilowatt.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
    }

    public void launchEsports(View view){
        Intent intent = new Intent(this, Esports.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
    }

    public void launchBank(View view){
        Intent intent = new Intent(this, Bank.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
    }
}