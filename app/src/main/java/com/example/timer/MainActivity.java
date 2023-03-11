package com.example.timer;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import androidx.core.app.NotificationManagerCompat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;
import java.util.logging.Handler;

import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.NotificationManagerCompat;

import pl.droidsonroids.gif.GifImageView;


public class MainActivity extends AppCompatActivity {




    TextView View;
    Button btnnum;
    Button verify;
    TextView vnum;
    EditText number;
    EditText code;
    TextView reg;
    int randomNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);


        View = findViewById(R.id.view);
        reg = findViewById(R.id.regis);
        btnnum = findViewById(R.id.getcode);

        number = findViewById(R.id.number);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                startActivity(new Intent(MainActivity.this, reg.class));
            }
        });

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification","CODE",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        btnnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                //Call Void
//                generateRandomNumber();
                randomNumber = Rnum.generateRandomNumberv();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("rand", (String.valueOf(randomNumber)));
                startActivity(intent);

//                btnnum.setEnabled(false);
//                verify.setEnabled(true);
//                try {
//                    // Construct data
//                    String apiKey = "apikey=" + "NGQzNjRjMzQ1NTc5NDk0YTcwNTE3NTYyNTAzMDU5NmM";
//                    String message = "&message=" + "Your OTP "+randomNumber;
//                    String sender = "&sender=" + "Jims Autos";
//                    String numbers = "&numbers=" +number.getText().toString();
//
//                    // Send data
//                    HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
//                    String data = apiKey + numbers + message + sender;
//                    conn.setDoOutput(true);
//                    conn.setRequestMethod("POST");
//                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
//                    conn.getOutputStream().write(data.getBytes("UTF-8"));
//                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                    final StringBuffer stringBuffer = new StringBuffer();
//                    String line;
//                    while ((line = rd.readLine()) != null) {
//                        stringBuffer.append(line);
//                    }
//                    rd.close();
//                    Toast.makeText(MainActivity.this, "Code Sent Successfully", Toast.LENGTH_SHORT).show();
//
//                } catch (Exception e) {
//                    Toast.makeText(MainActivity.this, "COde sent error"+e, Toast.LENGTH_SHORT).show();
//                }
                NotificationCompat.Builder builder1 = new NotificationCompat.Builder(getApplicationContext(), "My Notification")
                        .setSmallIcon(R.drawable.ic_android_black_24dp)
                        .setContentTitle("Your Code")
                        .setContentText("Your verify code has been :" + String.valueOf(randomNumber));

                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
                notificationManager.notify(1,builder1.build());



            }
        });





    }



//    public void generateRandomNumber() {
//        randomNumber = random.nextInt(1000000);
//        // do something with randomNumber
//    }





}