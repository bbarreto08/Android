package com.estudos.brunobarreto.testebluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.estudos.brunobarreto.testebluetooth.activitys.DiscoveredDevices;
import com.estudos.brunobarreto.testebluetooth.activitys.PairedDevices;

public class MainActivity extends AppCompatActivity {

    public static int ENABLE_BLUETOOTH = 1;
    public static int SELECT_PAIRED_DEVICE = 2;
    public static int SELECT_DISCOVERED_DEVICE = 3;

    private TextView statusMessage;
    BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusMessage = (TextView) findViewById(R.id.statusMessage);

        if (btAdapter == null) {
            statusMessage.setText("Que pena! Hardware Bluetooth não está funcionando");
        } else {
            statusMessage.setText("Ótimo! Hardware Bluetooth está funcionando");
            chekStatusBluetooth();
        }

        // É possível habilitar o dispositivo BLUETOOTH sem a permissão explicita do usuário
        //btAdapter.enable();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCod, Intent data) {
        if(requestCode == ENABLE_BLUETOOTH) {
            if(requestCode == RESULT_OK) {
                statusMessage.setText("Bluetooth ativado :D");
            }
            else {
                statusMessage.setText("Bluetooth não ativado :(");
            }
        }
        else if(requestCode == SELECT_PAIRED_DEVICE) {
            if(resultCod == RESULT_OK) {
                statusMessage.setText("Você selecionou " + data.getStringExtra("btDevName") + "\n"
                        + data.getStringExtra("btDevAddress"));
            }
            else {
                statusMessage.setText("Nenhum dispositivo selecionado :(");
            }
        }
    }

    private void chekStatusBluetooth() {
        if(!btAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, ENABLE_BLUETOOTH);
            statusMessage.setText("Solicitando ativação do Bluetooth...");
        } else {
            statusMessage.setText("Bluetooth já ativado :)");
        }
    }

    public void searchPairedDevices(View view) {
        Intent searchPairedDevicesIntent = new Intent(this, PairedDevices.class);
        startActivityForResult(searchPairedDevicesIntent, SELECT_PAIRED_DEVICE);
    }

    public void discoverDevices(View view) {
        Intent searchPairedDevicesIntent = new Intent(this, DiscoveredDevices.class);
        startActivityForResult(searchPairedDevicesIntent, SELECT_DISCOVERED_DEVICE);
    }
}
