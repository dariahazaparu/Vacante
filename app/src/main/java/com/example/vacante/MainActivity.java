package com.example.vacante;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button signin = (Button)findViewById(R.id.signin);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(signin, "alpha", 0, 1).setDuration(2000);
        objectAnimator.setTarget(signin);
        objectAnimator.start();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignInActivity.class));
                //finish();
            }
        });

        Button captureImage = (Button)findViewById(R.id.captureimage);

//        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(captureImage, "alpha", 0, 1).setDuration(2000);
//        objectAnimator.setTarget(captureImage);
//        objectAnimator.start();

        captureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CameraActivity.class));
                //finish();
            }
        });

        Button animation = (Button)findViewById(R.id.animation);

        animation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MotionLayoutActivity.class));
                //finish();
            }
        });

//        if(savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .setReorderingAllowed(true)
//                    .add(R.id.dest_fragment_container, DestinationFragment.class, null)
//                    .commit();
//        }



        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.plane);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.plane){
                    startActivity(new Intent(getApplicationContext(), DestinationActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                }
                return item.getItemId() == R.id.login;
            }
        });

    }
}