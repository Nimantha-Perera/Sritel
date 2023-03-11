package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Button btnc;
    EditText code;
    CountDownTimer expired;
    TextView View;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        time();

        // Initialize UI elements
        btnc = findViewById(R.id.verify_btn);
        code = findViewById(R.id.verify_num);
        View = findViewById(R.id.dis);
        String random = getIntent().getStringExtra("rand");


        // Get the main activity's layout and start the animation on it


        // Set click listener for verify button
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredCode = code.getText().toString();
                if (enteredCode.equals(String.valueOf(random))) {
                    Toast.makeText(MainActivity2.this, "Verification Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity2.this,MainActivity4.class));
                } else {
                    Toast.makeText(MainActivity2.this, "Verification Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void time(){
        if (expired != null) {
            expired.cancel();
        }
        expired = new CountDownTimer(30000, 1000) {

            @Override
            public void onTick(long l) {
                if (View != null) {
                    View.setText("Code Expire On :" + l / 1000);
                }

            }


            public void onFinish() {
                Rnum.generateRandomNumberv();
                btnc.setEnabled(false);
                View.setText("Expired");
            }

        }.start();
    }
}