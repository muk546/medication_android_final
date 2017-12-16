package com.mukul.medication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.journaldev.sqlite.R;

public class AddMedActivity extends Activity implements OnClickListener {

    private Button addTodoBtn;
    private EditText et_med;
    private EditText et_notes;
    private EditText et_dose;
    private EditText et_time;
    private EditText et_units;
    private EditText et_freq;



    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Medication");

        setContentView(R.layout.activity_add_med);

        et_med = (EditText) findViewById(R.id.et_med);
        et_notes = (EditText) findViewById(R.id.et_notes);
        et_dose = (EditText) findViewById(R.id.et_dose);
        et_time = (EditText) findViewById(R.id.et_time);
        et_units = (EditText) findViewById(R.id.et_units);
        et_freq = (EditText) findViewById(R.id.et_freq);


        addTodoBtn = (Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:

                final String name = et_med.getText().toString();
                final String desc = et_notes.getText().toString();
                final String dose = et_dose.getText().toString();
                final String time = et_time.getText().toString();
                final String units = et_units.getText().toString();
                final String frequency = et_freq.getText().toString();


                dbManager.insert(name, desc, dose, time, units, frequency);

                Intent main = new Intent(AddMedActivity.this, MedListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }

}