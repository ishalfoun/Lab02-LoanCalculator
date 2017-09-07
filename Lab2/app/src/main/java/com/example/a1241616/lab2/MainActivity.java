package com.example.a1241616.lab2;

import android.icu.text.DecimalFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edloanAmount;
    EditText edtermLoan;
    EditText edyearlyInterestRate;

    double loanAmount;
    int termLoan;
    double yearlyInterestRate;
    TextView resultMonthlyP;
    TextView resultTotalP;
    TextView resultTotalI;
    TextView errors;
    LoanCalculator loanCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get a handle on the textfields and result fields
        edloanAmount = (EditText) findViewById(R.id.editLoanAmount);
        edtermLoan = (EditText) findViewById(R.id.editLoanTerm);
        edyearlyInterestRate = (EditText) findViewById(R.id.editInterestRate);
        resultMonthlyP = (TextView) findViewById(R.id.resultMonthly);
        resultTotalP = (TextView) findViewById(R.id.resultTotalPayment);
        resultTotalI = (TextView) findViewById(R.id.resultTotalInterest);
        errors = (TextView) findViewById(R.id.errors);

    }

    public void onCalculate (View v)
    {

        try {
            loanAmount = Double.parseDouble(edloanAmount.getText().toString());
            termLoan = Integer.parseInt(edtermLoan.getText().toString());
            yearlyInterestRate = Double.parseDouble(edyearlyInterestRate.getText().toString());


        loanCalculator = new LoanCalculator(loanAmount, termLoan, yearlyInterestRate);

        // do calculations
        resultMonthlyP.setText(""+loanCalculator.getMonthlyPayment());
        resultTotalP.setText(""+loanCalculator.getTotalCostOfLoan());
        resultTotalI.setText(""+loanCalculator.getTotalInterest());
        }
        catch (NumberFormatException nfe) {
            errors.setText(R.string.InvalidError);
        }
    }

    public void onClear (View v)
    {
        errors.setText(" ");
        edloanAmount.setText("");
        edtermLoan.setText("");
        edyearlyInterestRate.setText("");
        resultMonthlyP.setText("");
        resultTotalP.setText("");
        resultTotalI.setText("");
    }


}

