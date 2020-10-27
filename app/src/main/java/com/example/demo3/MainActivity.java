package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button text1;
    public void clickText2(View view){
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setView(R.layout.activity_login);
        AlertDialog dialog = alertDialog.create();
        dialog.show();
    }
    public void clickText1(View view){
        Intent intent = new Intent(MainActivity.this,TextActivity1.class);
        startActivity(intent);
    }
    public void clickText3(View view){
        Intent intent = new Intent(MainActivity.this,TextActivity2.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickText4(View view) {
        Intent intent = new Intent(MainActivity.this,TextActivity3.class);
        startActivity(intent);
    }
}