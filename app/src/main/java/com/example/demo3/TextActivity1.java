package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextActivity1 extends AppCompatActivity {
    private String[] names = new String[]{"Lion","Tiger","Monkey","Dog","Cat"};
    private int[] imgIds = new int[] {
            R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text1);
        List<Map<String,Object>> listItems = new ArrayList<>();
        for(int i=0;i<names.length;i++){
            Map<String,Object> newItem = new HashMap<>();
            newItem.put("header",imgIds[i]);
            newItem.put("name",names[i]);
            listItems.add(newItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.activity_item,new String[]{
                "header","name"
        },new int[]{
                R.id.header,R.id.name
        });
        ListView listView = findViewById(R.id.myList);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast= Toast.makeText(TextActivity1.this,names[i],Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}