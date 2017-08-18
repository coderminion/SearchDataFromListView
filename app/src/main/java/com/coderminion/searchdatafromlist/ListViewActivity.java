package com.coderminion.searchdatafromlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    EditText editText;
    ListView listView;

    String television [] = {};

    ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init Edittext and listview
        initViews();
        //Init Data
        initData();
        //Set Data
        setData();
        //init Interfaces
        initInterfaces();

    }

    private void initViews() {

        editText = (EditText)findViewById(R.id.editText);
        listView = (ListView)findViewById(R.id.listview);
    }



    private void initData() {
        //INIT Array
        television  = getResources().getStringArray(R.array.television);
    }



    private void setData() {

        List<String> strings = Arrays.asList(television);
        listAdapter = new ListAdapter(getApplicationContext(), new ArrayList<String>(strings));
        listView.setAdapter(listAdapter);
    }



    private void initInterfaces() {

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editText.getText().toString();
                listAdapter.filter(text);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              Toast.makeText(getApplicationContext(),listAdapter.getItem(i).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }



}
