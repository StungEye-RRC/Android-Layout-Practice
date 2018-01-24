package com.stungeye.assignmentthree_ui;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityWithRelativeLayout2 extends AppCompatActivity {

    private Button toastButton;
    private Button reverseToastButton;
    private EditText reminderEditText;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_relative_layout2);

        toastButton = findViewById(R.id.toastButton);
        reverseToastButton = findViewById(R.id.reverseToastButton);
        reminderEditText = findViewById(R.id.reminderEditText);
        spinner = findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long l) {
                String selectedPlanet = (String)parent.getItemAtPosition(pos);
                Toast.makeText(ActivityWithRelativeLayout2.this, "You selected: " + selectedPlanet ,Toast.LENGTH_LONG).show();
                reminderEditText.setText(selectedPlanet);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // There will also be a spinner value selected.
            }
        });

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // QUESTION: Why does this work? What's the this of a class?
                Toast.makeText(ActivityWithRelativeLayout2.this, reminderEditText.getText(), Toast.LENGTH_LONG).show();
            }
        });

        reverseToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String reminderReversed = new StringBuffer(reminderEditText.getText()).reverse().toString();
                Toast.makeText(ActivityWithRelativeLayout2.this, reminderReversed, Toast.LENGTH_LONG).show();
            }
        });
    }
}

