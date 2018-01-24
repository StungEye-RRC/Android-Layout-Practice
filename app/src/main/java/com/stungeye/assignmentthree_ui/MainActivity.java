package com.stungeye.assignmentthree_ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button openLinearViewButton;
    private Button openRelativeViewButton;
    private Button openWebViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openRelativeViewButton = findViewById(R.id.relativeViewButton);
        openLinearViewButton = findViewById(R.id.linearViewButton);
        openWebViewButton = findViewById(R.id.webViewButton);

        openRelativeViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityWithRelativeLayout2.class);
                startActivityForResult(intent, 0);
            }
        });

        openLinearViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityWithLinearLayout.class);
                startActivityForResult(intent, 0);
            }
        });

        openWebViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityWithWebView.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
