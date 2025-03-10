package com.example.healthcareapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btn= findViewById(R.id.create);
        btn.setBackground(ContextCompat.getDrawable(this, R.drawable.rounded_button));
        AlertDialog.Builder ad= new AlertDialog.Builder(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad.setTitle("Create Account");
                ad.setMessage("Are you sure?");
                    ad.setPositiveButton("Yes, Proceed", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i= new Intent(MainActivity.this, CreateActivity.class);
                            startActivity(i);
                            Toast.makeText(MainActivity.this, "Yes, Processed", Toast.LENGTH_SHORT).show();
                        }
                    });
                ad.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
                    }
                });
                ad.show();
            }
        });

        TextView signin= findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this, Signin.class);
                startActivity(i);
            }
        });

        VideoView vd= findViewById(R.id.videoview);
        Uri videourl= Uri.parse("android.resource://"+getPackageName()+ "/" +R.raw.bg);
        vd.setVideoURI(videourl);
        vd.setOnPreparedListener(mp -> {
            mp.setLooping(true);
            mp.setVolume(0,0);
        });
        vd.start();

    }
}