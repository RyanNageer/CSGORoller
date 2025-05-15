package com.zybooks.csgoroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Bank extends AppCompatActivity {

    long userID;
    Button earningsBtn, caseinfoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank);

        userID = getIntent().getLongExtra("userID", -1);

        earningsBtn = findViewById(R.id.Earnings);
        earningsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                EarningsFragment earningsFragment = EarningsFragment.newInstance(userID);
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, earningsFragment)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        caseinfoBtn = findViewById(R.id.CaseInfo);
        caseinfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, CaseInfoFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

    }

    public void back4(View view){
        Intent intent = new Intent(this, CaseSelection.class);
        intent.putExtra("userID", userID);
        startActivity(intent);
    }
}