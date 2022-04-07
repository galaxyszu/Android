package com.example.week7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

public class BatteryLevelReceiver extends Activity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PowerConnectionReceiver powerConnectionReceiver=new PowerConnectionReceiver();
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Context context = null;
        Intent batteryStatus = registerReceiver(powerConnectionReceiver, ifilter);
        powerConnectionReceiver.onReceive(context,batteryStatus);
        //判断当前电量
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        float batteryPct = level / (float)scale;
        Log.d("BatteryLevelReceiver", "电量：" + batteryPct);
        if (batteryPct <= 0.2) {
            Log.d("BatteryLevelReceiver", "电量较低！");
        }
        if (batteryPct > 0.2) {
            Log.d("BatteryLevelReceiver", "电量充足！");
        }
    }
}
