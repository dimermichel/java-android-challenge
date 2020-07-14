package com.michelmaia.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LowBatteryBroadcastReceiver lowBatteryBroadcastReceiver = new LowBatteryBroadcastReceiver();
    private Button buttonSendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSendData = findViewById(R.id.buttonSendData);
        buttonSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Call new Activity to the Activity Stack
                Intent intent = new Intent(getApplicationContext(), Tela2Activity.class);
                // Transfer Data
                intent.putExtra("name", "Michel Maia");
                intent.putExtra("year", 2020);
                startActivity(intent);
            }
        });

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Subscribe to the Low Battery Check
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        registerReceiver(lowBatteryBroadcastReceiver, filter);

        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(lowBatteryBroadcastReceiver);
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "onDestroy");
    }
}