package com.example.week7;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

public class PowerConnectionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //检测充电状态的改变
        int status=intent.getIntExtra(BatteryManager.EXTRA_STATUS,-1);
        boolean isCharging=status==BatteryManager.BATTERY_STATUS_CHARGING||
                status==BatteryManager.BATTERY_STATUS_FULL;
        int chargePlug=intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,-1);
        boolean usbCharge=chargePlug==BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge=chargePlug==BatteryManager.BATTERY_PLUGGED_AC;

        Log.i("PowerConnectionReceiver","isCharging:"+isCharging+";"+
                "usbCharge:" + usbCharge + ";" + "asCharge:" + acCharge);

    }
}
