package com.stungeye.assignmentthree_ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityWithRelativeLayout2 extends AppCompatActivity {

    private Button toastButton;
    private Button reverseToastButton;
    private EditText reminderEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_relative_layout2);

        toastButton = findViewById(R.id.toastButton);
        reverseToastButton = findViewById(R.id.reverseToastButton);
        reminderEditText = findViewById(R.id.reminderEditText);

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // QUESTION: Why does this work? What's the the this of a class?
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

