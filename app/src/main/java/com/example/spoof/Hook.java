package com.example.spoof;

import android.os.Build;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XSharedPreferences;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class Hook implements IXposedHookLoadPackage {
    private static void set(String f, String v) {
        try { XposedHelpers.setStaticObjectField(Build.class, f, v); } catch (Throwable ignored) {}
    }

    @Override
    public void handleLoadPackage(LoadPackageParam lpp) {
        if (lpp.packageName.equals("com.example.spoof")) return;

        XSharedPreferences p = new XSharedPreferences("com.example.spoof", "cfg");
        p.reload();
        String pkgs = p.getString("pkgs", "com.android.vending\ncom.google.android.gms");

        boolean hit = false;
        for (String s : pkgs.split("[,\\s]+")) {
            if (s.equals(lpp.packageName)) { hit = true; break; }
        }
        if (!hit) return;

        int i = Math.max(0, Math.min(p.getInt("dev", 0), Presets.ALL.length - 1));
        String[] d = Presets.ALL[i];
        set("MANUFACTURER", d[1]);
        set("BRAND", d[2]);
        set("MODEL", d[3]);
        set("DEVICE", d[4]);
        set("PRODUCT", d[5]);
        set("HARDWARE", d[6]);
        set("BOARD", d[7]);
        set("FINGERPRINT", d[8]);
    }
}
