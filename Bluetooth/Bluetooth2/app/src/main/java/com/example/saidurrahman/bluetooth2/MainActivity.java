package com.example.saidurrahman.bluetooth2;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    CheckBox cb_Enable, cb_Visible;
    Button btn_Scan;
    TextView tv_Btnname;
    ListView lv;

    int enable1 = 0;

    private BluetoothAdapter BA1;
    private Set<BluetoothDevice> pairedDevices1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb_Enable = findViewById(R.id.cbEnable);
        cb_Visible = findViewById(R.id.cbVisible);
        btn_Scan = findViewById(R.id.btnScan);
        tv_Btnname = findViewById(R.id.tv_btnName);
        lv = findViewById(R.id.listView);

        tv_Btnname.setText(getLocalBluetoothName1());
        BA1 = BluetoothAdapter.getDefaultAdapter();

        if (BA1 == null) {
            Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_SHORT).show();
            finish();
        }

        if (BA1.isEnabled()) {
            cb_Enable.setChecked(true);
        }

        cb_Enable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    BA1.disable();
                    Toast.makeText(MainActivity.this, "Bluetooth turned off", Toast.LENGTH_SHORT).show();
                } else {
                    enable1 = 1;
                    Intent intentOn1 = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intentOn1,0);
                    Toast.makeText(MainActivity.this, "Bluetooth turned on", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cb_Visible.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked && enable1==1) {
                    Intent getVisible1 = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(getVisible1, 1);
                    Toast.makeText(MainActivity.this, "Visible for 2 minutes", Toast.LENGTH_SHORT).show();
                }
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Bluetooth not enabled", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_Scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list1();
            }
        });

    }

    private void list1() {
        pairedDevices1 = BA1.getBondedDevices();

        ArrayList l1 = new ArrayList();

        for (BluetoothDevice bt1 : pairedDevices1) {
            l1.add(bt1.getName());
        }

        Toast.makeText(this, "Showing devices", Toast.LENGTH_SHORT).show();
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, l1);
        lv.setAdapter(adapter1);

    }

    public String getLocalBluetoothName1() {
        if (BA1 == null) {
            BA1 = BluetoothAdapter.getDefaultAdapter();
        }
        String name1 = BA1.getName();
        if (name1 == null) {
            name1 = BA1.getAddress();
        }
        return name1;
    }

}
