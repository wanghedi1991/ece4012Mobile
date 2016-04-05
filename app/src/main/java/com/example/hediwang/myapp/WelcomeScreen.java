package com.example.hediwang.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        Button reportBlast = (Button) findViewById(R.id.report_blast);
        Button estimateSource = (Button) findViewById(R.id.estimate_source);
        Button survey = (Button) findViewById(R.id.take_survey);
        Button multiImage = (Button) findViewById(R.id.multi_image);
        reportBlast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
        estimateSource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
        survey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeScreen.this, SurveyActivity.class);
                startActivity(intent);
            }
        });
        multiImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeScreen.this, TempMultiImageActicity.class);
                startActivity(intent);
            }
        });
    }
}
