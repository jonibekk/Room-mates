package com.example.jonib.rommatebeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ExpenseProperty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_property);
        this.setTitle(getIntent().getStringExtra("title"));
    }
}
