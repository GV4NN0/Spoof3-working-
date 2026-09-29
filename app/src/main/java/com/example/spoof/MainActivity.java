package com.example.spoof;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);

        SharedPreferences sp;
        boolean active = true;
        try {
            sp = getSharedPreferences("cfg", MODE_WORLD_READABLE);
        } catch (Exception e) {
            sp = getSharedPreferences("cfg", MODE_PRIVATE);
            active = false;
        }
        final SharedPreferences prefs = sp;

        int pad = (int) (20 * getResources().getDisplayMetrics().density);
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(pad, pad * 2, pad, pad);

        TextView t1 = new TextView(this);
        t1.setText("Device to spoof");
        root.addView(t1);

        final Spinner spin = new Spinner(this);
        spin.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, Presets.names()));
        spin.setSelection(prefs.getInt("dev", 0));
        root.addView(spin);

        TextView t2 = new TextView(this);
        t2.setText("\nApps to spoof (one package per line)");
        root.addView(t2);

        final EditText et = new EditText(this);
        et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_MULTI_LINE
                | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        et.setMinLines(5);
        et.setText(prefs.getString("pkgs", "com.android.vending\ncom.google.android.gms"));
        root.addView(et);

        Button save = new Button(this);
        save.setText("Save");
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                prefs.edit()
                        .putInt("dev", spin.getSelectedItemPosition())
                        .putString("pkgs", et.getText().toString())
                        .apply();
                Toast.makeText(MainActivity.this,
                        "Saved. Force stop the target apps.", Toast.LENGTH_LONG).show();
            }
        });
        root.addView(save);

        if (!active) {
            TextView warn = new TextView(this);
            warn.setText("\nModule is not enabled in LSPosed, so settings won't apply yet.");
            root.addView(warn);
        }

        ScrollView sv = new ScrollView(this);
        sv.addView(root);
        setContentView(sv);
    }
}
