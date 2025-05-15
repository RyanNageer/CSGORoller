package com.zybooks.csgoroller;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zybooks.csgoroller.R;
import com.zybooks.csgoroller.User;
import com.zybooks.csgoroller.UserDAO;
import com.zybooks.csgoroller.UserDatabase;

import java.text.DecimalFormat;
import java.util.Objects;

public class EarningsFragment extends Fragment {

    private static final String ARG_USER_ID = "userID";
    private long userID;
    private TextView netWorthAmtTxt, caseValueAmtTxt, netProfitAmtTxt;
    private User user;

    public static EarningsFragment newInstance(long userID) {
        EarningsFragment fragment = new EarningsFragment();
        Bundle args = new Bundle();
        args.putLong(ARG_USER_ID, userID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userID = getArguments().getLong(ARG_USER_ID);
        }
        // Load user details asynchronously
        new LoadUserDetailsTask().execute(userID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_earnings, container, false);
        // Initialize TextViews
        netWorthAmtTxt = rootView.findViewById(R.id.NetWorthAmt);
        caseValueAmtTxt = rootView.findViewById(R.id.CaseValueAmt);
        netProfitAmtTxt = rootView.findViewById(R.id.NetProfitAmt);
        return rootView;
    }

    private double getCaseValue() {
        if (user != null) {
            int dreamsTotal = user.getNumDreamsAndNightmaresOpened();
            int kilowattTotal = user.getNumKilowattsOpened();
            int esportsTotal = user.getNumEsportsOpened();
            double dreamsCost = (dreamsTotal * 0.89) + (2.5 * dreamsTotal);
            double kilowattCost = (kilowattTotal * 1.39) + (2.5 * kilowattTotal);
            double esportsCost = (esportsTotal * 54.54) + (2.5 * esportsTotal);
            double temp = dreamsCost + kilowattCost + esportsCost;
            DecimalFormat df = new DecimalFormat("#.##");
            String temp2 = df.format(temp);
            return Double.parseDouble(temp2);
        }
        return 0.0;
    }

    private double getNetProfit() {
        if (user != null) {
            double temp = user.getNetWorth() - getCaseValue();
            DecimalFormat df = new DecimalFormat("#.##");
            String temp2 = df.format(temp);
            return Double.parseDouble(temp2);
        }
        return 0.0;
    }

    // AsyncTask to load user details asynchronously
    private class LoadUserDetailsTask extends AsyncTask<Long, Void, User> {

        @Override
        protected User doInBackground(Long... longs) {
            Context applicationContext = requireContext().getApplicationContext();
            UserDatabase userDatabase = UserDatabase.getUserDatabase(applicationContext);
            UserDAO userDAO = userDatabase.userDAO();
            return userDAO.getUserById(longs[0]);
        }

        @Override
        protected void onPostExecute(User result) {
            super.onPostExecute(result);
            user = result;
            // Update UI with user details
            if (user != null) {
                netWorthAmtTxt.setText(String.valueOf(user.getNetWorth()));
                caseValueAmtTxt.setText(String.valueOf(getCaseValue()));
                netProfitAmtTxt.setText(String.valueOf(getNetProfit()));
            }
        }
    }
}
